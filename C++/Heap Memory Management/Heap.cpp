#include <iostream>
using namespace std;

int SIZE = 2000;
void check_tag(string);
//Node of free list
typedef struct free_list_tag
{
    struct free_list_tag* next;//Pointer to next node
    struct free_list_tag* prev;//Pointer to prev node
    int size;//Size of node
    int start;//Starting point of node
}free_list;

//Node of allocated list
typedef struct allocate_tag
{
    struct allocate_tag* next;//Pointer to next node
    struct allocate_tag* prev;//Pointer to previous node
    int size;//Size of node
    int start;//Starting point of node
    string tag;//Labelling node
}alloc_list;

//Head of Freelist and allocated list
free_list* Free;
alloc_list* alloc;

void allocate()
{
    int n;//To keep track of size to be allocated
    string tag;//Labelling block
    cout << "Enter size you want to allocate\n";
    cin >> n;
    cout << "Enter name for allocated block\n";
    cin >> tag;
    check_tag(tag);
    free_list* ptr = Free;
    while (ptr && ptr->size < n)
    {
        ptr = ptr->next;
    }
    //If we reach end of list but can't find suitable free block
    if (ptr == NULL)
    {
        cout << "\n!!MEMORY CAN'T BE ALLOCATED!!\n\n";
    }
    else
    {
        //Making changes to ptr through which memory is to be allocated
        //And accordingly creating new temp node to insert in list

        //If size of free block is greater than required size
        if (ptr->size - n > 0)
        {
            free_list* temp = new free_list;
            //Initializing start point of new Node
            temp->start = ptr->start + n;
            temp->next = temp->prev = NULL;
            //Condition when memory is allocated from head node itself
            if (ptr == Free)
            {
                temp->next = Free->next;
                Free = temp;
            }
            else
            {
                (ptr->prev)->next = temp;
                temp->next = ptr->next;
                temp->prev = ptr->prev;
                if(ptr->next)
                    ptr->next->prev = temp;
            }
            temp->size = ptr->size - n;
        }
        //If size of free block equals required size
        else
        {
            if (ptr->prev)
            {
                ptr->prev->next = ptr->next;
                if(ptr->next)
                    ptr->next->prev = ptr->prev;
            }
            else
            {
                Free = ptr->next;
                if(Free)
                Free->prev = NULL;
            }
            
        }

        //Allocating block and adding node in allocated list

        //Declaring and Initializing Node that we want to add in list
        alloc_list* alloc_1 = new alloc_list;
        alloc_1->next = alloc_1->prev = NULL;
        alloc_1->size = n;
        alloc_1->tag = tag;
        alloc_1->start = ptr->start;
        free(ptr);
        //Case when allocated node is first one
        if (alloc == NULL)
            alloc = alloc_1;
        else
        {
            //Allocating node at proper place
            alloc_list* temps = alloc;
            //Finding the position where to allocate
            while (temps->next && temps->start < alloc_1->start)
            {
                temps = temps->next;
            }
            //When node is to be allocated at first position itself
            if (temps == alloc && temps->start > alloc_1->start)
            {
                alloc_1->next = temps;
                temps->prev = alloc_1;
                alloc = alloc_1;
            }
            //Condition when node to allocate is at last position
            else if (temps->next == NULL && temps->start < alloc_1->start)
            {
                temps->next = alloc_1;
                alloc_1->prev = temps;
                alloc_1->next = NULL;
            }
            //When Node is to be inserted in between
            else
            {
                (temps->prev)->next = alloc_1;
                alloc_1->prev = temps->prev;
                alloc_1->next = temps;
                temps->prev = alloc_1;
            }
        }
        //Allocation details
        cout << "Allocated from index: " << alloc_1->start << " to " << alloc_1->start + alloc_1->size <<  '\n';
        cout << "--------------------------------------------------------------------------------------\n\n";
    }
}

//Function to merge adjacent free blocks
void merge(free_list* fptr)
{
    //Case if previous node exists and is adjacent
    if (fptr->prev)
    {
        if (fptr->prev->start + fptr->prev->size == fptr->start)
        {
            //Changing size of previous node
            fptr->prev->size = fptr->prev->size + fptr->size;
            //Changing links
            fptr->prev->next = fptr->next;
            if(fptr->next)
                fptr->next->prev = fptr->prev;
            free_list* temp = fptr;
            fptr = fptr->prev;
            free(temp);
        }
    }
    //Case if next node exists and is adjacent
    if (fptr->next)
    {

        if (fptr->start + fptr->size == fptr->next->start)
        {
            //Changing size of current node
            fptr->size += fptr->next->size;
            //Changing links
            fptr->next = fptr->next->next;
            if(fptr->next)
                fptr->next->prev = fptr;
        }
    }
}
//Function to deallocate memory
void deallocate(string tag)
{
    alloc_list* ptr = alloc;
    //Finding node with given tag
    while (ptr && ptr->tag != tag)
    {
        ptr = ptr->next;
    }
    //Condition if given tag doesn't exist
    if (ptr == NULL)
    {
        cout << "Not found\n";
    }
    else
    {
        //Freelist node that is to be inserted in freelist
        free_list* fptr = new free_list;
        fptr->next = fptr->prev = NULL;
        fptr->size = ptr->size;
        fptr->start = ptr->start;
        //If deallocated memory is first node itself
        if (ptr == alloc)
            alloc = ptr->next;
        //Else changing links properly
        else
        {
            ptr->prev->next = ptr->next;
            if (ptr->next)
                ptr->next->prev = ptr->prev;
        }
        //Searching for proper position to insert freelist node
        free_list* temp = Free;
        //If list is NULL, initialize it
        if (Free == NULL)
        {
            Free = fptr;
        }
        else
        {
            while (temp && temp->next && temp->start < fptr->start)
            {
                temp = temp->next;
            }
            //Case when freelist node is to be inserted at end
            if (temp && temp->next == NULL && temp->start < fptr->start)
            {
                temp->next = fptr;
                fptr->prev = temp;
            }
            else
            {
                //When freelist node is to be inserted at start
                if (temp && temp == Free)
                {
                    fptr->next = temp;
                    temp->prev = fptr;
                    Free = fptr;
                }
                //When freelist node is to be inserted in between
                else if (temp)
                {
                    fptr->prev = temp->prev;
                    temp->prev->next = fptr;
                    temp->prev = fptr;
                    fptr->next = temp;
                }

            }
        }
        //Merging continguous free blocks
        merge(fptr);
    }
    cout << "--------------------------------------------------------------------------------------\n\n";
}

void check_tag(string s)
{
    int flag = 1;
    alloc_list* ptr = alloc;
    while (ptr && flag)
    {
        if (ptr->tag == s)
        {
            cout << "...........................................................................\n";
            cout << "\n!!Memory location with same tag found!!\nHence deallocating previous one\n";
            deallocate(s);
            flag = 0;
        }
        ptr = ptr->next;
    }
}

//Printing allocated list
void print_allocated()
{
    alloc_list* ptr = alloc;
    while(ptr)
    {
        cout << ptr->start << " to " << ptr->start + ptr->size << '\n';
        ptr = ptr->next;
    }
}
//Printing free list
void print_free()
{
    free_list* ptr = Free;
    while (ptr)
    {
        cout << ptr->start << " to " << ptr->start + ptr->size << '\n';
        ptr = ptr->next;
    }
}

int main()
{
    int opt;//To keep track of choices of user

    //Initializing head node of Free list
    Free = new free_list;
    Free->next = Free->prev = NULL;
    Free->size = SIZE;
    Free->start = 0;
    //Initializing allocated list
    alloc = NULL;
    cout << "Memory allocation using First Fit strategy with memory of 2000 units available\n\n";
    cout << "Points to consider:\n1.Take care that memory asked for allocation is in integer format\n";
    cout << "2.If you initialize any other block with existing tag name, previous block will be deallocated\n\n";
    char ch = 'Y';//To keep track of whether user wants to continue
    while (ch == 'Y' || ch == 'y')
    {
        cout << "1.Allocate Memory\n2.Deallocate Memory\n";
        cout << "Enter 1 or 2\n";
        cin >> opt;
        cout << "-------------------------------------------------------------------------------------\n\n";
        switch (opt)
        {
        case 1:allocate();
            break;
        case 2:
        {string tag;
        cout << "Enter tag of block you want to delete\n";
        cin >> tag;
        deallocate(tag);
        break;
        }
        default:cout << "Wrong option entered\n";
        }
        cout << "Current condition\n";
        cout << "Allocated list\n";
        print_allocated();
        cout << '\n';
        cout << "Free list\n";
        print_free();
        cout << '\n';  
        cout << "**************************************************************************************\n\n";
        cout << "If you want to continue enter 'Y' else 'N'\n";
        cin >> ch;
    }
    cout << "______________________________________________________________________________________\n\n";
    cout << "Thank You!!\n";
    cout << "______________________________________________________________________________________\n\n";
}

