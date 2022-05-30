///////////////////<<<<<< LIBRARY DEPARTMENT  & Recycle Bin >>>>>>>>///////////
///////////////////<<<<<< LIBRARY DEPARTMENT  & Recycle Bin >>>>>>>>///////////
#include"Faculty.h"
#include<fstream>

struct bnode{
	bnode *next;
	int id, age;
	string name, cnic, phone_no, fatherName, gmail, address, gender, latest_qualification, post, status, campuss;
};

class Library:public Faculty{
	public:
		int id, age, counter;
		string name, fatherName, cnic, gender, phone_No, post, gmail, l_qua, address, campuss, status;
		node *root3;
		bnode *head, *temp5, *temp6;
		int tem;
		string tem1;
		Library()
		{
			root3 = NULL;
			head = temp5 = temp6 = NULL;
			tem = counter = 0;
		}

		////////////////// Linked lIst ...................

		void insertion_List(int id, string name, string fatherName, string cnic, string gender, string phone_NO, string post, string gmail,  string l_qua,  int age, string address, string campuss, string status)
		{
			if(head == NULL)
			{
				head = new bnode();
				head->id = id;
				head->fatherName = fatherName;
				head->age = age;
				head->address = address;
				head->campuss = campuss;
				head->gender = gender;
				head->latest_qualification = l_qua;
				head->phone_no = phone_NO;
				head->post = post;
				head->status = status;
				head->name = name;
				head->cnic = cnic;
				head->gmail = gmail;
				//
				head->next = NULL;
				temp6 = head;
			}
			else
			{
				cout<<"welcome sir "<<endl;
				temp5 = new bnode();
				temp5->id = id;
				temp5->fatherName = fatherName;
				temp5->age = age;
				temp5->address = address;
				temp5->campuss = campuss;
				temp5->gender = gender;
				temp5->latest_qualification = l_qua;
				temp5->phone_no = phone_No;
				temp5->post = post;
				temp5->status = status;
				temp5->name = name;
				temp5->cnic = cnic;
				temp5->gmail = gmail;
				//
				for(temp6=head; temp6->next != NULL; temp6=temp6->next)
				{ }
				temp6->next = temp5;
			}
		}
		
		// get latest data
		void get_latest_data()
		{
			for(temp5=head; temp5 != NULL; temp5=temp5->next)
			{
				if(temp5->next == NULL)
				{
					cout<< temp5->id <<"  "<<temp5->name << "  "<<temp5->fatherName << "   "<<temp5->cnic <<"   "<< temp5->gender<<"  "<<
					temp5->phone_no<<"   "<< temp5->post<<"   "<< temp5->gmail << "   "<< temp5->latest_qualification <<"   "<< temp5->address<<"  "<<
					temp5->campuss<<"    "<< temp5->status <<endl;
				}
			}
		}
		
		// print function for linked List
		void print_linked_list()
		{
			for(temp5=head; temp5 != NULL; temp5=temp5->next)
			{
				cout<< temp5->id <<"  "<<temp5->name << "  "<<temp5->fatherName << "   "<<temp5->cnic <<"   "<< temp5->gender<<"  "<<
				temp5->phone_no<<"   "<< temp5->post<<"   "<< temp5->gmail << "   "<< temp5->latest_qualification <<"   "<< temp5->address<<"  "<<
				temp5->campuss<<"    "<< temp5->status <<endl;
			}
			return;
		}


		//............... search file & and save data on file.txt
		int search_file(node *temp, int id)
		{
			if(temp->left != NULL)
			{
				search_file(temp->left, id);
			}
			if(temp->right != NULL)
			{
				search_file(temp->right,id);
			}
			if(temp->id == id)
			{
				counter++;
				ofstream myfile;
				myfile.open("delete.txt",ios::out | ios::app);
				if(myfile.is_open())
				{
					cout<<"Open "<<endl;
					myfile << temp->id <<',';
					myfile << temp->name<<',';
					myfile << temp->fatherName<<',';
					myfile << temp->cnic <<',';
					myfile << temp->gender<<',';
					myfile << temp->phone_no<<',';
					myfile << temp->post<<',';
					myfile << temp->gmail<<',';
					myfile << temp->latest_qualification<<',';
					myfile << temp->age<<',';
					myfile << temp->address<<',';
					myfile << temp->campuss<<',';
					myfile << temp->status<<"\n"<<endl;
					cout<<"\n Data saved in backup "<<endl;
					myfile.close();
				}
				else
				{
					cout<<"\n\n File not open"<<endl;
				}
			}
			// for counter value save in separate file
			ofstream countfile;
			countfile.open("CountValue.txt");
			if(countfile.is_open())
			{
				cout<<"File count is open "<<endl;
				countfile << counter;	
			}
			else
			{
				cout<<"File count is not open "<<endl;	
			} 
			countfile.close();
		}

		//......... Read data from file
		int recover_data()
		{
			ifstream countfile;
			countfile.open("CountValue.txt");
			if(countfile.is_open())
			{
				cout<<"Again count file open "<<endl;
				countfile >> counter;
			}
			ifstream getfile;
			getfile.open("delete.txt",ios::in);
			if(getfile.is_open())
			{
				cout<<"Recover file is open "<<endl;
				//int i=0;
				string null;
				for(int i=0; i < counter; i++)
				{
					cout<<"Data read "<<endl;
					getfile >> id;
					getline(getfile,null,',');
					getline(getfile, name,',');
					getline(getfile, fatherName,',');
					getline(getfile, cnic,',');
					getline(getfile,null,',');
					getline(getfile, gender,',');
					getline(getfile, phone_No,',');
					getline(getfile, post,',');
					getline(getfile, gmail,',');
					getline(getfile, l_qua,',');
					getfile >> age;
					getline(getfile,null,',');
					getline(getfile, address,',');
					getline(getfile, campuss,',');
					getline(getfile, status,'\n');
					// LinkedList function call
					cout<<"hello "<< i <<"  completed "<<endl;
					insertion_List(id, name, fatherName, cnic, gender, phone_No, post, gmail, l_qua, age, address, campuss, status);
					//i++;
				}
			}
			else
			{
				cout<<"Recover file is not open "<<endl;
			}
		}


};
