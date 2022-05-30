#include<windows.h>
#include<conio.h>
#include"Library.h"



class Faculty_Portal:public Faculty{
	private:
		string write, ID, password;
		int age;
		string name, cnic, phone_no, fatherName, gmail, address, gender, latest_qualification, post, campuss;
	public:
		node *root5;
		int try1;
		Faculty_Portal()
		{
			root5 = NULL;
			try1 = 1;
		}
		
		int guest_login()
		{
			cout<<"\n\n\n\n\t\t\t\t\t\t............."<<endl;
			cout<<"\t\t\t\t\t\t|  Login    |"<<endl;
			cout<<"\t\t\t\t\t\t............."<<endl;
			cout<<"\n\n\t Enter as a Guest ::-"<<endl;
			cout<<"\n\t\t You know login id & password y/n "<<endl;
			cin >> write;
			if(write == "n")
			{
				cout<<"\n\t ID :- guest , password :- 123 "<<endl;
				goto l;
			}
			if(write == "y")
			{
				cout<<"\n\t Well good !!! "<<endl;
				l:
				while(try1 <= 3)
				{
					cout<<"\n\t Enter Login id ::- "<<endl;
					cin >> ID;
					cout<<"\n\t Enter login password ::- "<<endl;
					cin >> password;	
					if(ID == "guest" && password == "123")
					{
						system("cls");
						cout<<"\n\n\n You accessed the system "<<endl;
						break;		
					}
					else
					{
						cout<<"\n\n\t Wrong Information \n\n\t No of attempts remain : "<< 3-try1 <<endl;
						if(try1 == 3)
						{
							cout<<"\n\n\n\n\t\t You terminated from system in few seconds "<<endl;
							exit(0);
						}
					}
					try1++;
				}
				
			}
			
		}
		void print_Department_Available()
		{
			cout<<"There are three departments available in university "<<endl;
			cout<<"1: Computer Science "<<endl;
			cout<<"2: Electrical "<<endl;
		}
		void print_Requirements_job()
		{
			cout<<"Here are the requirements for job form "<<endl;
			cout<<"Bio :- \n\n Name \n  Father Name \n Cnic No \n Phone Nuber \n Address etc"<<endl;
			cout<<"Not attach CV but TCS us main headquatar of University "<<endl;
		}
		
		void print_options()
		{
			cout<<"Here are the operation for faculty ::-  "<<endl;
			cout<<"Select any options ::- "<<endl;
			cout<<"1: Names of departemnts in university "<<endl;
			cout<<"2: Check requirements for apply job in university "<<endl;
			cout<<"3: Check new vocancies in university "<<endl;
			cout<<"4: Apply for JOB Here "<<endl;
			cout<<"5: Go back "<<endl;
		}
		void print_vocancies()
		{
			cout<<"\n\t Vocancies are available in following department "<<endl;
			cout<<"\n\t Computer Science "<<endl;
		}
		
		void apply_JOb()
		{
			cout<<"Enter ID of person ::- "<<endl;
			cin >> id;
			cout<<"Enter NAME of person ::- "<<endl;
			cin >> name;
			cout<<"Enter FATHER NAME of person ::- "<<endl;
			cin >>  fatherName;
			cout<<"Enter CNIC of person ::- "<<endl;
			cin >> cnic;
			cout<<"Enter GENDER of person ::- "<<endl;
			cin >> gender;
			cout<<"Enter PHONE NUMBER of person ::- "<<endl;
			cin >> phone_no;
			cout<<"Enter POST / RANK of person ::- "<<endl;
			cin >> post;
			cout<<"Enter GMAIL of person ::- "<<endl;
			cin >> gmail;
			cout<<"Enter LATEST QUALIFICATION of person ::- "<<endl;
			cin >> latest_qualification;
			cout<<"Enter AGE of person ::- "<<endl;
			cin >> age;
			cout<<"Enter ADDRESS of person ::- "<<endl;
			cin >> address;
			cout<<"Enter CAMPUS of person ::- "<<endl;
			cin >> campuss;
			// function call 
			root5 = insertion_Faculty(root5,id,name,fatherName,cnic,gender,phone_no,post,gmail,latest_qualification,age,address,campuss," ");
			
		}
		void Print_JOb_Data(node *temp)
		{
			// inorder
			if(temp->left != NULL)
			{
				Print_JOb_Data(temp->left);	
			}
			cout<< temp->id <<"   " << temp->name << "   "<< temp->fatherName <<"   "<< temp->cnic <<"  "<< temp->gender <<"  "
			<< temp->phone_no <<"   "<< temp->post <<"   "<< temp->gmail <<"  "<<temp->latest_qualification<<"   "<< temp->age <<"  "<<temp->address <<
			"   "<<temp->campuss <<"    "<<endl;
			if(temp->right != NULL)
			{
				Print_JOb_Data(temp->right);
			}
		}
		////////
		int admin_login()
		{
			cout<<"\n\n\n\n\t\t\t\t\t\t............."<<endl;
			cout<<"\t\t\t\t\t\t|  Login    |"<<endl;
			cout<<"\t\t\t\t\t\t............."<<endl;
			cout<<"\n\n\t Enter as a admin ::-"<<endl;
			cout<<"\n\t You know login id & password y/n \t"<<endl;
			cin >> write;
			if(write == "n")
			{
				cout<<"\n ID :- admin , password :- 123 "<<endl;
				goto ab;
			}
			if(write == "y")
			{
				cout<<"\n\t Well good !!! "<<endl;
				ab:
				while(try1 <= 3)
				{
					cout<<"\n\t Enter Login id ::- "<<endl;
					cin >> ID;
					cout<<"\n\t Enter login password ::- "<<endl;
					cin >> password;	
					if(ID == "admin" && password == "123")
					{
						system("cls");
						cout<<"\n\n\n You accessed the system "<<endl;
						break;		
					}
					else
					{
						cout<<"\n\n\t Wrong Information \n\n\t No of attempts remain : "<< 3-try1 <<endl;
						if(try1 == 3)
						{
							cout<<"\n\n\n\n\t\t You terminated from system in few seconds "<<endl;
							exit(0);
						}
					}
					try1++;
				}
			}
			
		}
	
		
};

