#include<iostream>
using namespace std;

struct dnode{
	int id;
	string name, gmail, post, gender, cnic;
	dnode *next;
};

class list{
	public:
		dnode *head1, *temp2, *head2, *head3, *temp8, *temp9, *dtemp;
		int id, temp;
		string name,cnic, gender, post, gmail, temp1;
	list()
	{
		head1 = head2 = temp8 = temp9 = head3= temp2 = dtemp = NULL;
		temp = 0;
	}	
	
	void bubble_sort1()
	{
		for(temp2=head1; temp2 != NULL; temp2=temp2->next)
		{
			for(temp8=temp2->next; temp8 != NULL; temp8=temp8->next)
			{
				if(temp2->id > temp8->id)
				{
					temp = temp2->id;
					temp2->id = temp8->id;
					temp8->id = temp;
					//
					temp1 = temp2->cnic;
					temp2->cnic = temp8->cnic;
					temp8->cnic = temp1;
					//
					temp1 = temp2->gender;
					temp2->gender = temp8->gender;
					temp8->gender = temp1;
					//
					temp1 =temp2->name;
					temp2->name = temp8->name;
					temp8->name = temp1;
					//
					temp1 = temp2->post;
					temp2->post = temp8->post;
					temp8->post = temp1;	
				}
			}
		}
	}
	//
	void bubble_sort2()
	{
		for(temp2=head2; temp2 != NULL; temp2=temp2->next)
		{
			for(temp8=temp2->next; temp8 != NULL; temp8=temp8->next)
			{
				if(temp2->id > temp8->id)
				{
					temp = temp2->id;
					temp2->id = temp8->id;
					temp8->id = temp;
					//
					temp1 = temp2->cnic;
					temp2->cnic = temp8->cnic;
					temp8->cnic = temp1;
					//
					temp1 = temp2->gender;
					temp2->gender = temp8->gender;
					temp8->gender = temp1;
					//
					temp1 =temp2->name;
					temp2->name = temp8->name;
					temp8->name = temp1;
					//
					temp1 = temp2->post;
					temp2->post = temp8->post;
					temp8->post = temp1;	
				}
			}
		}
	}
	////
	void bubble_sort3()
	{
		for(temp2=head3; temp2 != NULL; temp2=temp2->next)
		{
			for(temp8=temp2->next; temp8 != NULL; temp8=temp8->next)
			{
				if(temp2->id > temp8->id)
				{
					temp = temp2->id;
					temp2->id = temp8->id;
					temp8->id = temp;
					//
					temp1 = temp2->cnic;
					temp2->cnic = temp8->cnic;
					temp8->cnic = temp1;
					//
					temp1 = temp2->gender;
					temp2->gender = temp8->gender;
					temp8->gender = temp1;
					//
					temp1 =temp2->name;
					temp2->name = temp8->name;
					temp8->name = temp1;
					//
					temp1 = temp2->post;
					temp2->post = temp8->post;
					temp8->post = temp1;	
				}
			}
		}
	}
	// insertion for board of governers
	void insertion_List1(int id, string name, string cnic, string gender,string post, string gmail)
		{
			if(head1 == NULL)
			{
				head1 = new dnode();
				head1->id = id;
				head1->gender = gender;
				head1->post = post;
				head1->name = name;
				head1->cnic = cnic;
				head1->gmail = gmail;
				//
				head1->next = NULL;
				temp8 = head1;
			}
			else
			{
				temp9 = new dnode();
				temp9->id = id;
				temp9->gender = gender;
				temp9->post = post;
				temp9->name = name;
				temp9->cnic = cnic;
				temp9->gmail = gmail;
				//
				for(temp8=head1; temp8->next != NULL; temp8=temp8->next)
				{ }
				temp8->next = temp9;
			}
		}
		/////
		/////// insertion for board of trustees
		void insertion_List2(int id, string name, string cnic, string gender,string post, string gmail)
		{
			if(head2 == NULL)
			{
				head2 = new dnode();
				head2->id = id;
				head2->gender = gender;
				head2->post = post;
				head2->name = name;
				head2->cnic = cnic;
				head2->gmail = gmail;
				//
				head2->next = NULL;
			}
			else
			{
				temp9 = new dnode();
				temp9->id = id;
				temp9->gender = gender;
				temp9->post = post;
				temp9->name = name;
				temp9->cnic = cnic;
				temp9->gmail = gmail;
				//
				for(temp8=head2; temp8->next != NULL; temp8=temp8->next)
				{ }
				temp8->next = temp9;
			}
		}
		
		//////// officers of university
		
		void insertion_List3(int id, string name, string cnic, string gender,string post, string gmail)
		{
			if(head3 == NULL)
			{
				head3 = new dnode();
				head3->id = id;
				head3->gender = gender;
				head3->post = post;
				head3->name = name;
				head3->cnic = cnic;
				head3->gmail = gmail;
				//
				head3->next = NULL;
			}
			else
			{
				temp9 = new dnode();
				temp9->id = id;
				temp9->gender = gender;
				temp9->post = post;
				temp9->name = name;
				temp9->cnic = cnic;
				temp9->gmail = gmail;
				//
				for(temp8=head3; temp8->next != NULL; temp8=temp8->next)
				{ }
				temp8->next = temp9;
			}
		}
		/////////  Deletion functionns
		void Delete1(int id)
		{
			for(temp2=head1; temp2!=NULL;temp2=temp2->next)
		    {
		        if(temp2->id==id)
		        {
		            if(temp2==head1)                             
		            {
		            	dtemp=head1;
		                head1=head1->next;
		                delete dtemp;
		                return;
		            }                                        
		            else
		            {
		                for(temp2=head1; temp2!=NULL;temp2=temp2->next)
		            	{
		                    if(temp2->next->id==id)
		                    {
				                dtemp= temp2->next;
		                        temp2->next=dtemp->next;
		                        delete dtemp;
		                        dtemp=NULL;
		                        return;
		                    }
		        		}
		        	}
		        }
		    }
		                                                                
		}
		/////
		void Delete2(int id)
		{
			for(temp2=head2; temp2!=NULL;temp2=temp2->next)
		    {
		        if(temp2->id==id)
		        {
		            if(temp2==head2)                             
		            {
		            	dtemp=head2;
		                head2=head2->next;
		                delete dtemp;
		                return;
		            }                                        
		            else
		            {
		                for(temp2=head2; temp2!=NULL;temp2=temp2->next)
		            	{
		                    if(temp2->next->id==id)
		                    {
				                dtemp= temp2->next;
		                        temp2->next=dtemp->next;
		                        delete dtemp;
		                        dtemp=NULL;
		                        return;
		                    }
		        		}
		        	}
		        }
		    }                                                              
		}
		/////
		void Delete3(int id)
		{
			for(temp2=head3; temp2!=NULL;temp2=temp2->next)
		    {
		        if(temp2->id==id)
		        {
		            if(temp2==head3)                             
		            {
		            	dtemp=head3;
		                head3=head3->next;
		                delete dtemp;
		                return;
		            }                                        
		            else
		            {
		                for(temp2=head3; temp2!=NULL;temp2=temp2->next)
		            	{
		                    if(temp2->next->id==id)
		                    {
				                dtemp= temp2->next;
		                        temp2->next=dtemp->next;
		                        delete dtemp;
		                        dtemp=NULL;
		                        return;
		                    }
		        		}
		        	}
		        }
		    }
		                                                                
		}
		////// insert functions
		void options1()
		{
			cout <<"Enter id :- "<<endl;
			cin >> id;
			cout << "Enter name :-"<<endl;
			cin >> name;
			cout << "Enter Adhar ID :- "<<endl;
			cin >> cnic;
			cout<<"Enter gender :- "<<endl;
			cin >> gender;
			cout<<"Enter post :- "<<endl;
			cin >> post;
			cout<<"Enter gmail :- "<<endl;
			cin >> gmail;
			insertion_List1(id,name,cnic,gender,post,gmail);
		}
		//
		void options2()
		{
			cout <<"Enter id :- "<<endl;
			cin >> id;
			cout << "Enter name :-"<<endl;
			cin >> name;
			cout << "Enter Adhar ID :- "<<endl;
			cin >> cnic;
			cout<<"Enter gender :- "<<endl;
			cin >> gender;
			cout<<"Enter post :- "<<endl;
			cin >> post;
			cout<<"Enter gmail :- "<<endl;
			cin >> gmail;
			insertion_List2(id,name,cnic,gender,post,gmail);
		}
		//
		void options3()
		{
			cout <<"Enter id :- "<<endl;
			cin >> id;
			cout << "Enter name :-"<<endl;
			cin >> name;
			cout << "Enter Adhar ID :- "<<endl;
			cin >> cnic;
			cout<<"Enter gender :- "<<endl;
			cin >> gender;
			cout<<"Enter post :- "<<endl;
			cin >> post;
			cout<<"Enter gmail :- "<<endl;
			cin >> gmail;
			insertion_List3(id,name,cnic,gender,post,gmail);
		}
		
		/// print functions
		
		void print1()
		{
			bubble_sort1();
			for(temp8=head1; temp8 != NULL; temp8=temp8->next)
			{
				cout<<"\n\n "<<endl;
				cout<<"ID      : "<<temp8->id <<endl;
				cout<<"NAME    : "<<temp8->name <<endl;
				cout<<"Adhar ID    : "<<temp8->cnic<<endl;
				cout<<"GENDER  : "<<temp8->gender<<endl;
				cout<<"GMAIL   : "<<temp8->gmail<<endl;
				cout<<"POST    : "<<temp8->post<<endl;
				cout<<"<<................................................>>"<<endl;
			}
		}
		//////
		void print2()
		{
			bubble_sort2();
			for(temp8=head2; temp8 != NULL; temp8=temp8->next)
			{
				cout<<"\n\n "<<endl;
				cout<<"ID      : "<<temp8->id <<endl;
				cout<<"NAME    : "<<temp8->name <<endl;
				cout<<"Adhar ID    : "<<temp8->cnic<<endl;
				cout<<"GENDER  : "<<temp8->gender<<endl;
				cout<<"GMAIL   : "<<temp8->gmail<<endl;
				cout<<"POST    : "<<temp8->post<<endl;
				cout<<"<<................................................>>"<<endl;
			}
		}
		/////
		void print3()
		{
			bubble_sort3();
			for(temp8=head3; temp8 != NULL; temp8=temp8->next)
			{
				cout<<"\n\n "<<endl;
				cout<<"ID      : "<<temp8->id <<endl;
				cout<<"NAME    : "<<temp8->name <<endl;
				cout<<"Adhar ID    : "<<temp8->cnic<<endl;
				cout<<"GENDER  : "<<temp8->gender<<endl;
				cout<<"GMAIL   : "<<temp8->gmail<<endl;
				cout<<"POST    : "<<temp8->post<<endl;
				cout<<"<<................................................>>"<<endl;
			}
		}
			
};

