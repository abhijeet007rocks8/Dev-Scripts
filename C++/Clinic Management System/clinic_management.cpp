#include<iostream>
#include<ctime>
#include<cstdlib>
#include<fstream>
using namespace std;
struct node
{
    char fname[20];
    char sname[20];
    char address[200];
    char contact[10];
    char cnic[100];
    int age;
    char gender[8];
    char blood_gp[5];
    char disease_past[50];
    int id;
    char symptom[500];
    char diagnosis[500];
    char medicine[500];
    char addmission[30];
    struct node *next;
    bool diagnose;
};
struct node *head,*lastptr;
bool check=true;
int arr[20]= {0},i=0;
bool check_id(int ch)
{
    for(int a=0; a<i; a++)
    {
        if(ch==arr[a])
        {
            return true;
        }
    }
    return false;
};
class doctor
{
public:

    void add()
    {


        node *p;

        p=new node;

        p->diagnose=false;
        cout<<"enter Patient ID"<<endl;

        cin>>p->id;

        cout<<"enter Patient First name"<<endl;

        cin>>p->fname;
        cout<<"enter Patient Last name"<<endl;

        cin>>p->sname;

        cout<<"enter Patient Age"<<endl;

        cin>>p->age;

        cout<<"enter Patient Gender"<<endl;

        cin>>p->gender;

        cout<<"enter Patient Blood Group"<<endl;

        cin>>p->blood_gp;

        cout<<"enter Patient Contact "<<endl;

        cin>>p->contact;

        fflush(stdin);

        cout<<"enter Patient CNIC"<<endl;

        cin.getline(p->cnic,100);

        fflush(stdin);

        cout<<"enter Patient Address"<<endl;

        cin.getline(p->address,1000);


        p->next=NULL;

        arr[i]=p->id;


        i++;

        if(check)

        {

            head=p;

            lastptr=p;

            check=false;

        }

        else

        {
            lastptr->next=p;
            lastptr=p;
        }

    }
    void show()
    {
        int n;
        node *current=NULL,*prev=NULL;
        prev=head;
        current=head;
        int ch;
        cout<<"enter Patient ID"<<endl;
        cin>>ch;
        if(check_id(ch))
        {
            while(current->id!=ch)
            {
                prev=current;
                current=current->next;
            }
            cout<<"enter Patient First name"<<endl;
            cout<<current->fname<<endl;
            cout<<"enter Patient Last name"<<endl;
            cout<<current->sname<<endl;
            cout<<"enter Patient ID"<<endl;
            cout<<current->id<<endl;
            cout<<"enter Patient Age"<<endl;
            cout<<current->age<<endl;
            cout<<"enter Patient Gender"<<endl;
            cout<<current->gender<<endl;
            cout<<"enter Patient Blood Group"<<endl;
            cout<<current->blood_gp<<endl;
            cout<<"enter Patient Contact "<<endl;
            cout<<current->contact<<endl;
            cout<<"CNIC number"<<endl;
            cout<<current->cnic<<endl;
            cout<<"enter Patient Address"<<endl;
            cout<<current->address<<endl;
            cout<<"*********************************"<<endl;
            if(current->diagnose)
            {
                cout<<"Enter Symptoms"<<endl;
                cout<<current->symptom<<endl;
                cout<<"Enter Diagnosis"<<endl;
                cout<<current->diagnosis<<endl;
                cout<<"Enter Medicines"<<endl;
                cout<<current->medicine<<endl;
                cout<<"Admit Required to Hospital?"<<endl;
                cout<<current->addmission<<endl;
            }
        }
        else
        {
            cout<<"ID not present"<<endl;
        }
    }
    void diagnosis()
    {
        int n;
        node *p=NULL,*prev=NULL;
        p=new node;
        prev=head;
        p=head;
        int ch;
        cout<<"enter Patient ID"<<endl;
        cin>>ch;
        if(check_id(ch))
        {
            while(p->id!=ch )
            {
                prev=p;
                p=p->next;
            }
            p->diagnose=true;
            cout<<"Enter Symptoms"<<endl;
            cin>>p->symptom;
            cout<<"Enter Diagnosis"<<endl;
            cin>>p->diagnosis;
            cout<<"Enter Medicines"<<endl;
            cin>>p->medicine;
            cout<<"Admit Required to Hospital?"<<endl;
            cin>>p->addmission;

        }

        else
            cout<<"ID is not Registered\n";

    }
    void deleteList()
    {
        int counter=0;
        node *current=NULL,*prev=NULL;
        //current =new node;
        prev=head;
        current=head;
        int ch;
        cout<<"Enter the ID: ";
        cin>>ch;
        if(check_id(ch))
        {
            //     temp=head;
            while(current->id!=ch)
            {
                prev=current;
                current=current->next;
            }
            prev->next=current->next;
            free(current);


        }

        else
            cout<<"ID not present"<<endl;
        for(int a=0; a<i; a++)
        {
            if(arr[a]==ch)
            {
                for (int j=a; j<i; j++)
                {
                    arr[j]=arr[j+1];
                }
                i--;
            }
        }
        cout<<"SUCCESSFULLY DELETED ALL NODES OF LINKED LIST\n";

    }
    void update_menu()
    {
        cout<<"enter 1 Patient First name"<<endl;
        cout<<"enter 2 Patient Last name"<<endl;
        cout<<"enter 3 Patient ID"<<endl;
        cout<<"enter 4 Patient Age"<<endl;
        cout<<"enter 5 Patient Gender"<<endl;
        cout<<"enter 6 Patient Blood Group"<<endl;
        cout<<"enter 7 Patient Contact "<<endl;
        cout<<"enter 8 patient CNIC"<<endl;
        cout<<"enter 9 Patient Address"<<endl;
        cout<<"*********************************"<<endl;
        cout<<"Enter 10 Symptoms"<<endl;
        cout<<"Enter 11 Diagnosis"<<endl;
        cout<<"Enter 12 Medicines"<<endl;
        cout<<"Admit 13 Required to Hospital?"<<endl;
    }
    void update_data()
    {
        node *current=NULL,*prev=NULL;
        current=head;
        prev=head;
        int id,ch;
        cout<<"enter ID"<<endl;
        cin>>id;
        if(check_id(id))
        {
            while(current->id!=id)
            {
                prev=current;
                current=current->next;
            }
            update_menu();
            cout<<"choose number"<<endl;
            cin>>ch;
            if(ch==1)
            {
                cout<<"enter first name"<<endl;
                cin>>current->fname;
            }

            else if(ch==2)
            {
                cout<<"enter second name"<<endl;
                cin>>current->sname;
            }
            else if(ch==3)
            {
                cout<<"enter ID"<<endl;
                cin>>current->id;
            }
            else if(ch==4)
            {
                cout<<"enter age"<<endl;
                cin>>current->age;
            }
            else if(ch==5)
            {
                cout<<"enter gender"<<endl;
                cin>>current->gender;
            }
            else if(ch==6)
            {
                cout<<"enter blood group"<<endl;
                cin>>current->blood_gp;
            }
            else if(ch==7)
            {
                cout<<"enter contact"<<endl;
                cin>>current->contact;
            }
            else if(ch==8)
            {
                cout<<"enter CNIC"<<endl;
                cin>>current->cnic;
            }
            else if(ch==9)
            {
                cout<<"enter address"<<endl;
                cin>>current->address;
            }
            else if(ch==10)
            {
                cout<<"Enter 10 Symptoms"<<endl;
                cin>>current->symptom;
            }
            else if(ch==11)
            {
                cout<<"Enter 11 Diagnosis"<<endl;
                cin>>current->diagnosis;
            }
            else if(ch==12)
            {
                cout<<"Enter 12 Medicines"<<endl;
                cin>>current->medicine;
            }
            else if(ch==13)
            {
                cout<<"Admit 13 Required to Hospital?"<<endl;
                cin>>current->addmission;
            }
        }
        else
            cout<<"ID not present"<<endl;
    }
    int storeData();
    int viewAllrecord();

};
int doctor::storeData()
{

    ofstream fout;
    fout.open("Patient_details.txt",ios::app);
    ///It takes two argument as first the address where actually data is present so in our case our data present in the coller object
    fout.write((char*)this,sizeof(*this));
    fout.close();
    return(1);

}
int doctor::viewAllrecord()
{
    ifstream fin;
    fin.open("Patient_details.txt",ios::in);
    if(!fin)
    {
        cout<<"File not found";
    }
    else
    {
        fin.read((char*)this,sizeof(*this));
        while(!fin.eof())
        {
            show();
            fin.read((char*)this,sizeof(*this));
        }
        fin.close();
    }
}

void dis()
{
    cout<<"1 Add New Patient Record "<<endl;
    cout<<"2 Add Patient prescription "<<endl;
    cout<<"3 Full History of the Patient"<<endl;
    cout<<"4 delete Patient Record"<<endl;
    cout<<"5 update Patient Record"<<endl;
    cout<<"6 write into Record"<<endl;
    cout<<"7 view the Record"<<endl;
}
void menu()
{
    cout<<"press 1 to doctor menu"<<endl;
    cout<<"press 2 to patients menu"<<endl;
    cout<<"press 3 to pharmacist menu"<<endl;
}

int main()
{
    struct node* head=NULL;
    doctor u;
    int i=0;
    do
    {
        dis();
        cin>>i;
        if(i==1)
            u.add();
        else if(i==2)
            u.diagnosis();
        else if(i==3)
            u.show();
        else if(i==4)
            u.deleteList();
        else if(i==5)
            u.update_data();
        else if(i==6)
            u.storeData();
        else if(i==7)
            u.viewAllrecord();
    }
    while(1);

    return 0;
}
