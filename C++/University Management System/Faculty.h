/////////////// <<<<<<<<<<<<<<<<    Faculty Department Code Here   >>>>>>>>>>>>>>>>>>>/////////////
#include<iomanip>
#include<iostream>
#include<string.h>
#include<conio.h>
using namespace std;

struct node{
	int id, age;
	string name,cnic, phone_no, fatherName, gmail, address, gender, latest_qualification, post, status, campuss;
	node *right, *left, *next;
	int height;
};

class Faculty{
	private:
		
	public:
		node *temp, *temp1, *temp2, *temp3;
		node *root, *root1, *root2;
		string new_name, new_phone_no, new_post, new_gmail, new_latest_qualification, new_address,  new_status;
		int new_age;
		int id;
		
	Faculty()
	{
		id,  new_age = 0;
		root = root1 = root2 = temp = temp1 = temp2 = temp3 = NULL;
		//cout<<"Hello form faculty "<<endl;
	}
	
	///////////////////<<<<<   Max & Height AVL CODE START HERE >>>>>>>> /////////////////////////
	int max_Faculty(int a, int b)
	{
		if(a > b)
		{
			return a;
		}
		else
		{
			return b;
		}
	}
	
	int height_Faculty(node *temp)
	{
		if(temp == NULL)
		{
			return 0;
		}
		
		int lh = height_Faculty(temp->left);
		int rh = height_Faculty(temp->right);
		
		if(lh > rh)
		{
			return lh+1;
		}
		else
		{
			return rh+1;
		}
	}
	///////////////////<<<<<   All Rotations AVL CODE START HERE >>>>>>>> /////////////////////////
	
	struct node *left_rotation_Faculty(node *temp2)
	{
		temp1 = temp2->right;
		temp2->right = temp1->left;
		temp1->left = temp2;
		
		temp2->height = max_Faculty(height_Faculty(temp2->left), height_Faculty(temp2->right)) + 1;
		temp1->height = max_Faculty(height_Faculty(temp1->left), height_Faculty(temp1->right)) + 1;
		
		return temp1;
	}
	
	struct node *right_rotation_Faculty(node *temp2)
	{
		temp1 = temp2->left;
		temp2->left = temp1->right;
		temp1->right = temp2;
		
		temp2->height = max_Faculty(height_Faculty(temp2->left), height_Faculty(temp2->right)) +1;
		temp1->height = max_Faculty(height_Faculty(temp1->left), height_Faculty(temp1->right)) +1;
		
		return temp1;
	}
	
	struct node *right_left_rotation_Faculty(node *temp3)
	{
		temp3->right = right_rotation_Faculty(temp3->right);
		return left_rotation_Faculty(temp3);
	}
	
	struct node *left_right_rotation_Faculty(node *temp3)
	{
		temp3->left = left_rotation_Faculty(temp3->left);
		return right_rotation_Faculty(temp3);
	}
	
	///////////////////<<<<<   Insertion AVL CODE START HERE >>>>>>>> /////////////////////////
	
	///////////////////<<<<<<<<  FACULTY OF COMPUTER SCIENCE DEPARTMENT >>>>>>>>>>>>>//////////////
	
	// Add new person function 
	struct node *insertion_Faculty(node *temp, int id, string name, string fname, string cnic, string gen, string phone, string post, string gmail,  string l_qua,  int age, string address, string campuss, string status)
	{
		if(temp == NULL)
		{
			temp = new node();
			temp->id = id;
			temp->name = name;
			temp->fatherName = fname;
			temp->cnic = cnic;
			temp->gender = gen;
			temp->phone_no = phone;
			temp->post = post;
			temp->gmail = gmail;
			temp->latest_qualification = l_qua;
			temp->age = age;
			temp->address = address;
			temp->campuss = campuss;
			temp->status = status;
			//
			temp->left = temp->right = NULL;
			temp->height = 0;
		}
		if(id < temp->id)
		{
			temp->left = insertion_Faculty(temp->left, id ,name , fname, cnic, gen, phone, post, gmail, l_qua, age, address, campuss, status);
			
			if(height_Faculty(temp->left) - height_Faculty(temp->right) == 2)
			{
				if(id < temp->left->id)
				{
					temp = right_rotation_Faculty(temp);
				}
				else
				{
					temp = left_right_rotation_Faculty(temp);
				}
			}
		}
		if(id > temp->id)
		{  
			temp->right = insertion_Faculty(temp->right, id, name, fname, cnic, gen, phone, post, gmail, l_qua, age, address, campuss, status);
			
			if(height_Faculty(temp->right) - height_Faculty(temp->left) == 2)
			{
				if(id > temp->right->id)
				{
					temp = left_rotation_Faculty(temp);
				}
				else
				{
					temp = right_left_rotation_Faculty(temp);
				}
			}
		}
		temp->height = max_Faculty(height_Faculty(temp->left), height_Faculty(temp->right)) +1 ;
		return temp;
	}
	
	///////////////////<<<<<   Deletion AVL CODE START HERE >>>>>>>> /////////////////////////
	
	// Delete person
	struct node *min_Faculty(node *temp)
	{
		if(temp == NULL)
		{
			return 0;	
		}	
		if(temp->left == NULL)
		{
			return temp;
		}
		else
		{
			min_Faculty(temp->left);
		}
		
	}	
	struct node *balance_Faculty(node *temp)
	{
		if(temp == NULL)
		{
			cout<<"No rotation is found "<<endl;
		}
		if( height_Faculty(temp->left) - height_Faculty(temp->right) > 1)
		{
			if(height_Faculty(temp->left->left) >= height_Faculty(temp->left->right))
			{ 
				temp = right_rotation_Faculty(temp);
			}
			else
			{ 
				temp =left_right_rotation_Faculty(temp);		
			}
		}
		else if( height_Faculty(temp->right) - height_Faculty(temp->left) > 1)
		{   
			
			if(height_Faculty(temp->right->right) >= height_Faculty(temp->right->left))
			{
				temp =left_rotation_Faculty(temp);
			}
			else
			{
				temp =right_left_rotation_Faculty(temp);
			}
		}
		temp->height = max_Faculty(height_Faculty(temp->left), height_Faculty(temp->right)) + 1;
		return temp;
	}
	
	struct node *deletion_Faculty(node *temp, int id)
	{
		if(temp == NULL)
		{
			cout<<"The value is not found "<<endl;
		}
		else if(id < temp->id)
		{  
			temp->left = deletion_Faculty(temp->left, id);
		}
		else if(id > temp->id)
		{
			temp->right = deletion_Faculty(temp->right, id);
		}
		else if(temp->left && temp->right)
		{
			node *tempcell = min_Faculty(temp->right);
			//
			temp->id = tempcell->id;
			temp->name = tempcell->name;
			temp->fatherName = tempcell->fatherName;
			temp->address = tempcell->address;
			temp->age = tempcell->age;
			temp->campuss = tempcell->campuss;
			temp->cnic = tempcell->cnic;
			temp->gender = tempcell->gender;
			temp->gmail = tempcell->gmail;
			temp->latest_qualification = tempcell->latest_qualification;
			temp->phone_no = tempcell->phone_no;
			temp->post = tempcell->post;
			temp->status = tempcell->status;
			//
			temp->right = deletion_Faculty(temp->right, temp->id);
		}
		else
		{
			node *tempcell = temp;
			if(temp->left == NULL)
			{ 
				temp = temp->right;
			}
			else if(temp->right == NULL)
			{
				temp = temp->left;
			}
			delete tempcell;
		}
		if(temp != NULL)
		{
			temp = balance_Faculty(temp);	
		}
		return temp;
	}
	
	/////////<<<<<<< Search function and print information about it >>>>>///////////
	void search_function(node *temp, int id)
	{
		static int flag = 0;
		if(temp->left != NULL)
		{
			search_function(temp->left, id);
		}
		if(temp->id == id)
		{
			cout<<"\n\n "<<endl;
			cout<<"ID 	                  : "<< temp->id <<endl;
			cout<<"NAME                   : "<< temp->name <<endl;
			cout<<"FATHERNAME             : "<< temp->fatherName <<endl;
			cout<<"Adhar ID               : "<< temp->cnic <<endl;
			cout<<"GENDER                 : "<< temp->gender <<endl;
			cout<<"PHONE NO               : "<< temp->phone_no <<endl;
			cout<<"POST / RANK            : "<< temp->post <<endl;
			cout<<"GAMAL                  : "<< temp->gmail <<endl;
			cout<<"LATEST QUALIFIACTION   : "<<temp->latest_qualification<<endl;
			cout<<"AGE                    : "<< temp->age <<endl;
			cout<<"ADDRESS                : "<<temp->address <<endl;
			cout<<"CAMPUS                 : "<<temp->campuss <<endl;
			cout<<"STATUS                 : "<<temp->status <<endl;
			cout<<"<<...........................................................>>"<<endl;
			flag = 1;
		}
		if(temp->right != NULL)
		{
			search_function(temp->right, id);
		}
		if(flag == 1)
		{
			cout<<"found "<<endl;
		}
		else if(flag == 0)
		{
			cout<<"NOt found "<<endl;
		}
	}
	////////////<<<<<<<<<< Update Information all functions >>>>>>>>>>>//////////////////
	// option :-1	
	void change_name(node *temp, int id, string new_name)
	{
		if(temp->left != NULL)
		{
			change_name(temp->left, id, new_name);
		}
		if(temp->right != NULL)
		{
			change_name(temp->right, id, new_name);
		}
		if(temp->id == id)
		{
			temp->name = new_name;
			cout<<"Your Name is updated...... "<<endl;
		}
	}
	// option :-2
	void change_phone_no(node *temp, int id, string new_phone_no)
	{
		if(temp->left != NULL)
		{
			change_phone_no(temp->left, id, new_phone_no);
		}
		if(temp->right != NULL)
		{
			change_phone_no(temp->right, id, new_phone_no);
		}
		if(temp->id == id)
		{
			temp->phone_no = new_phone_no;
			cout<<"Your Phone number is updated..... "<<endl;
		}
	}
	// option :-3
	void change_post(node *temp, int id, string new_post)
	{
		if(temp->left != NULL)
		{
			change_post(temp->left, id, new_post);
		}
		if(temp->right != NULL)
		{
			change_post(temp->right, id, new_post);
		}
		if(temp->id == id)
		{
			temp->post = new_post;
			cout<<"Your POST / RANK is updated..... "<<endl;
		}
	}
	// option :-4
	void change_gmail(node *temp, int id, string new_gmail)
	{
		if(temp->left != NULL)
		{
			change_gmail(temp->left, id, new_gmail);
		}
		if(temp->right != NULL)
		{
			change_gmail(temp->right, id, new_gmail);
		}
		if(temp->id == id)
		{
			temp->gmail = new_gmail;
			cout<<"Your GMAIL is updated..... "<<endl;
		}
	}
	// option :-5
	void change_qualification(node *temp, int id, string new_latest_qualification)
	{
		if(temp->left != NULL)
		{
			change_qualification(temp->left, id, new_latest_qualification);
		}
		if(temp->right != NULL)
		{
			change_qualification(temp->right, id, new_latest_qualification);
		}
		if(temp->id == id)
		{
			temp->latest_qualification = new_latest_qualification;
			cout<<"Your QUALIFICATION is updated..... "<<endl;
		}
	}
	// option :-6
	void change_age(node *temp, int id, int new_age)
	{
		if(temp->left != NULL)
		{
			change_age(temp->left, id, new_age);
		}
		if(temp->right != NULL)
		{
			change_age(temp->right, id, new_age);
		}
		if(temp->id == id)
		{
			temp->age = new_age;
			cout<<"Your AGE is updated..... "<<endl;
		}
	}
	// option :-7
	void change_address(node *temp, int id, string new_address)
	{
		if(temp->left != NULL)
		{
			change_address(temp->left, id, new_address);
		}
		if(temp->right != NULL)
		{
			change_address(temp->right, id, new_address);
		}
		if(temp->id == id)
		{
			temp->address = new_address;
			cout<<"Your ADDRESS is updated..... "<<endl;
		}
	}
	// option 8
	void change_status(node *temp, int id, string new_status)
	{
		if(temp->left != NULL)
		{
			change_status(temp->left, id, new_status);
		}
		if(temp->right != NULL)
		{
			change_status(temp->right, id, new_status);
		}
		if(temp->id == id)
		{
			temp->status = new_status;
			cout<<"Your STATUS is updated..... "<<endl;
		}
	}
	void options()
	{
		cout<<"Press relevant buttons to perform tasks "<<endl;
		cout<<"1: Update Name "<<endl;
		cout<<"2: Phone NUmber "<<endl;
		cout<<"3: Post / Rank "<<endl;
		cout<<"4: Gmail "<<endl;
		cout<<"5: Latest Qualification "<<endl;
		cout<<"6: Age "<<endl;
		cout<<"7: Address "<<endl;
		cout<<"8: Print all data after update "<<endl;
		cout<<"9: Update status "<<endl;
		cout<<"Press any key to exit the options.......... "<<endl;
	}
	void options_information (node *temp)
	{
		char ch;
		while(1)
		{
			options();
			ch = getch();
			switch(ch)
			{
				case '1':
					cout<<"Enter id of person for update the NAME of person ::- "<<endl;
					cin >> id;
					cout<<"Enter new NAME of person ::- "<<endl;		
					cin >> new_name;
					change_name(temp, id, new_name);
					break;
				case '2':
					cout<<"Enter id of person for update the PHONE NAUMBER of person ::- "<<endl;
					cin >>  id;
					cout<<"Enter new POST / RANK ::- "<<endl;
					cin >> new_phone_no;
					change_phone_no(temp, id, new_phone_no);
					break;
				case '3':
					cout<<"Enter id of person for update the POST / RANK of person ::- "<<endl;
					cin >> id;
					cout<<"Enter new POST / RANK ::-  "<<endl;
					cin >> new_post;
					change_post(temp, id, new_post);
					break;
				case '4':
					cout<<"Enter id of person for update the GMAIL of person ::- "<<endl;
					cin >> id;
					cout<<"Enter the new GAMIL ::- "<<endl;
					cin >> new_gmail;
					change_gmail( temp, id, new_gmail);
					break;
				case '5':
					cout<<"Enter id of person for update the LATEST QUALIFICATION of person ::- "<<endl;
					cin >> id;
					cout<<"Enter the new LATEST QUALIFICATION ::- "<<endl;
					cin >> new_latest_qualification;
					change_qualification(root, id, new_latest_qualification);
					break;
				case '6':
					cout<<"Enter id of person for update the AGE of person ::- "<<endl;
					cin >> id;
					cout<<"Enter the new AGE ::- "<<endl;
					cin >> new_age;
					change_age(temp, id, new_age);
					break;
				case '7':
					cout<<"Enter id of person for update the ADDRESS of person ::- "<<endl;
					cin >> id;
					cout<<"Enter the new ADDRESS ::-  "<<endl;
					cin >> new_address;
					change_address(temp, id, new_address);
					break;
				case '8':
					cout<<"After the update data print all information .. "<<endl;
					in_order(temp);
					break;
				case '9':
					cout<<"Enter id of person for update the status of person "<<endl;
					cin >> id;
					cout<<"Enter NEW STATUS "<<endl;
					cin >> new_status;
					change_status(temp, id, new_status);
				default:
					exit(0);
					break;
			}
		}
	}
	///////////////<<<<<<<<<<<<<<   Print order >>>>>>>>>>>>>>>>>>>//////////////////
	// pre-Order function 
	void pre_order(node *temp)
	{
		cout<< temp->id <<"   " << temp->name << "   "<<endl;
		if(temp->left != NULL)
		{
			pre_order(temp->left);
		}
		if(temp->right != NULL)
		{
			pre_order(temp->right);
		}
		cout<<endl;
		
	}
	// In_order function 
	void in_order(node *temp)
	{
		if(temp->left != NULL)
		{
			in_order(temp->left);
		}
		cout<<"\n\n "<<endl;
		cout<<"ID 	                  : "<< temp->id <<endl;
		cout<<"NAME                   : "<< temp->name <<endl;
		cout<<"FATHERNAME             : "<< temp->fatherName <<endl;
		cout<<"Adhar ID               : "<< temp->cnic <<endl;
		cout<<"GENDER                 : "<< temp->gender <<endl;
		cout<<"PHONE NO               : "<< temp->phone_no <<endl;
		cout<<"POST / RANK            : "<< temp->post <<endl;
		cout<<"GAMAL                  : "<< temp->gmail <<endl;
		cout<<"LATEST QUALIFIACTION   : "<<temp->latest_qualification<<endl;
		cout<<"AGE                    : "<< temp->age <<endl;
		cout<<"ADDRESS                : "<<temp->address <<endl;
		cout<<"CAMPUS                 : "<<temp->campuss <<endl;
		cout<<"STATUS                 : "<<temp->status <<endl;
		cout<<"<<...........................................................>>"<<endl;
		if(temp->right != NULL)
		{
			in_order(temp->right);
		}
	}
	
	////////////////////////////////////// CODE FOR EE DEPARTMENT FACULTY /////////////////////////////////////
	
	struct node *insertion_Faculty_EE(node *temp, int id,string name, string fname, string cnic, string gen, string phone, string post, string gmail, string l_qua, int age, string address, string campuss, string status)
	{
		if(temp == NULL)
		{
			temp = new node();
			temp->id = id;
			temp->name = name;
			temp->fatherName = fname;
			temp->cnic = cnic;
			temp->gender = gen;
			temp->phone_no = phone;
			temp->post = post;
			temp->gmail = gmail;
			temp->latest_qualification = l_qua;
			temp->age = age;			
			temp->address = address;
			temp->campuss = campuss;
			temp->status = status;
  			//
			temp->left = temp->right = NULL;
			temp->height = 0;
		}
		if(id < temp->id)
		{
			temp->left = insertion_Faculty_EE(temp->left, id,name, fname, cnic, gen, phone, post, gmail, l_qua, age, address, campuss, status);
			
			if(height_Faculty(temp->left) - height_Faculty(temp->right) == 2)
			{
				if(id < temp->left->id)
				{
					temp = right_rotation_Faculty(temp);
				}
				else
				{
					temp = left_right_rotation_Faculty(temp);
				}
			}
		}
		if(id > temp->id)
		{  
			temp->right = insertion_Faculty_EE(temp->right,id,name,fname,cnic, gen, phone, post, gmail, l_qua, age, address,campuss,status);
			
			if(height_Faculty(temp->right) - height_Faculty(temp->left) == 2)
			{
				if(id > temp->right->id)
				{
					temp = left_rotation_Faculty(temp);
				}
				else
				{
					temp = right_left_rotation_Faculty(temp);
				}
			}
		}
		temp->height = max_Faculty(height_Faculty(temp->left), height_Faculty(temp->right)) +1 ;
		return temp;
	}
	
	////////////////////////////////////// CODE FOR HUMANITIES DEPARTMENT FACULTY /////////////////////////////////////
	
	struct node *insertion_Faculty_Humanities(node *temp, int id,string name, string fname,string cnic, string gen, string phone, string post, string gmail,  string l_qua,  int age, string address, string campuss, string status)
	{
		if(temp == NULL)
		{
			temp = new node();
			temp->id = id;
			temp->name = name;
			temp->fatherName = fname;
			temp->cnic = cnic;
			temp->gender = gen;
			temp->phone_no = phone;
			temp->post = post;
			temp->gmail = gmail;
			temp->latest_qualification = l_qua;
			temp->age = age;		
			temp->address = address;
			temp->campuss = campuss;
			temp->status = status;
			//  
			temp->left = temp->right = NULL;
			temp->height = 0;
		}
		if(id < temp->id)
		{
			temp->left = insertion_Faculty_Humanities(temp->left,id,name,fname,cnic,gen,phone,post,gmail,l_qua,age,address,campuss, status);
			
			if(height_Faculty(temp->left) - height_Faculty(temp->right) == 2)
			{
				if(id < temp->left->id)
				{
					temp = right_rotation_Faculty(temp);
				}
				else
				{
					temp = left_right_rotation_Faculty(temp);
				}
			}
		}
		if(id > temp->id)
		{  
			temp->right = insertion_Faculty_Humanities(temp->right, id,name,fname,cnic,gen,phone,post,gmail,l_qua,age,address, campuss, status);
			
			if(height_Faculty(temp->right) - height_Faculty(temp->left) == 2)
			{
				if(id > temp->right->id)
				{
					temp = left_rotation_Faculty(temp);
				}
				else
				{
					temp = right_left_rotation_Faculty(temp);
				}
			}
		}
		temp->height = max_Faculty(height_Faculty(temp->left), height_Faculty(temp->right)) +1 ;
		return temp;
	}
	
};									// ............... END .............. 
