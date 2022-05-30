#include"Options.h"
#include<stdlib.h>
#include<windows.h>
#include"Admin.h"
#include"higherPost.h"

int main(){

	system("color 0b");
	
	Faculty_Portal l;
	Library t;
	Admin a;
	list w;
	
	// Declaration of variables
	int id, age, n, press, enter, enter1;
	string name, cnic, phone_no, fatherName, gmail, address, gender, latest_qualification, post, status, campuss;
	int process = 0;
	/*  PRE-declaration of data and function call  */
	
	// CS department Faculty
	t.root = t.insertion_Faculty(t.root, 1001, "omer", "osman", "17300", "Male", "0300-0000001", "HOD", "osma@nu.edu.pk", "PHD", 50, "Hyatabad","PWR","Active");
	t.root = t.insertion_Faculty(t.root, 1002, "Nauman", "NIL", "17301", "Male", "0301-5267432", "Assitant Professor", "nauman@nu.edu.pk", "POST_DOC",48, "hyatabad","PWR", "Active");
	t.root = t.insertion_Faculty(t.root, 1003, "Fazlebasit", "NIL", "17302", "Male", "0322-3084357", "Assistant Professor", "fazlebasit@nue.du.pk", "MS", 48, "Hyatabad", "PWR", "Active");
	t.root = t.insertion_Faculty(t.root, 1004, "Waqas", "NIL", "17303", "Male", "0340-1234567", "Associate Professor", "waqas@nu.edu.pk", "MS", 35, "hyatabad","PWR", "Active");
	// EE department Faculty
	t.root1 = t.insertion_Faculty_EE(t.root1,2001,"Sheikh", "Saijid", "5202", "Male", "0342-1238567", "HOD & Professsor", "sajid@nu.edu.pk", "PHD", 45, "Model  town Lahore", "LHR", "Active");
	t.root1 = t.insertion_Faculty_EE(t.root1,2002,"Amjad", "Husnian", "5203", "Male",   "0300-5671234","Professor", "hussian@nu.edu.pk", "PHD", 55, "Faisal town Lahore","LHR", "Active");
	t.root1 = t.insertion_Faculty_EE(t.root1,2003,"saiman","Zafar", "5204","Female", "0301-1234789","Professor", "saiman@nu.edu.pk", "PHD", 40, "Sanda lahore", "LHR","Leave");
	t.root1 = t.insertion_Faculty_EE(t.root1, 2004,"Hamza", "Yousaf", "5206","Male","0313-0000567","lab Engineer","hamza@nu.edu.pk","BS-CS", 30, "iqbal Town Lahore","LHR", "Active");
	// Humanities Department Faculty
	t.root2 = t.insertion_Faculty_Humanities(t.root2, 3001, "sumaria", "Ali", "6202", "Female", "0300-5269434","HOD", "sumaria@nu.edu.pk", "PHD", 45, "Lahore", "LHR", "Active");
	t.root2 = t.insertion_Faculty_Humanities(t.root2, 3002, "Suman", "Shahid", "6203", "Female", "0322-5267448","Associate Professor","suman@nu.edu.pk","PHD", 40, "Lahore", "LHR", "Leave");
	// for Library staff
	t.root3 = t.insertion_Faculty(t.root3, 6001, "Hammad", "Waseem", "17301", "Male", "0308-5733828", "Manager", "Hammmad@nu.edu.pk", "MS", 40, "haytabad, PWR", "pwr", "Active");
	// for admin staff
	a.root6 = a.insertion_Faculty(a.root6,7001,"Danish","shafiq","17301","male","0308-5733898","Manager","danish@nu.edu.pk","CS",21,"LHR","pwr","Active");
	// for board of governers
	w.insertion_List1(11, "Dr. Ayub Alvi", "17302", "male", "Rector-Chairman", "Ayub@nu.edu.pk");
	w.insertion_List1(10, "Mr. Ahmad farooq", "35707", "male", "Members","ahmad@nu.edu.pk");
	// for board of trustees
	w.insertion_List2(20, "Arshad","35202", "male","members", "arshad@nu.edu.pk");
	// for officers of university
	w.insertion_List3(30,"Wasim Sajjad","17301","male", "members","wasim@nu.edu.pk");
	// Styling front page
	cout<<"\n \n \n \n \n \n "<<endl;
	cout<<"\t \t \t \t ..............................................."<<endl;
	cout<<"\t \t \t \t | WELCOME TO THE UNIVERSITY MANAGEMENT SYSTEM |"<<endl;
	cout<<"\t \t \t \t ..............................................."<<endl;
	cout<<"\n \n \n \t \t \t\t Press 1 any key to continue......"<<endl;
	cin >> enter;
	cout<<"\n\n\n\t\t\t\t Loading ";
	for(process=0;process<25;process++)
  	{
    	Sleep(100);
    	cout <<".";
  	}

	system("cls");
	char ch;
	while(1)
	{
		x:		// for label of goto statement
		cout<<"\n \n \n \n \n \n "<<endl;
		cout<<"\t \t\t  ............................"<<endl;
		cout<<"\t \t\t  | WELCOME TO THE MAIN LIST |"<<endl;
		cout<<"\t \t\t  ............................"<<endl;
		Get_Front_Side_Options();
		ch = getch();		// get data from main_front_side
		switch(ch)
		{	// 1 case start
			case '1':
				cout<<"You enter the information of Faculty "<<endl;
				system("cls");
				l.admin_login();
				system("cls");
				char ch1;
				while(1)
				{
					y:		// for label of goto statement
					// Get 3 options :- CS, EE, Humanities
					Get_Faculty_Options();
					ch1 = getch();
					switch(ch1)
					{	// 2 case start
						case '1':
							system("cls");
							cout<<"\n\n Here are the functions for CS Department "<<endl;
							char ch2;
							while(1)
							{
								// get functions for CS
								Get_Faculty_Function_Options();
								ch2 = getch();
								switch(ch2)
								{	// 3 case start
									case '1':
										cout<<"\n\n\n\t Welcome in ADD NEW PERSON function "<<endl;
										cout<<"\n\t Enter the no. of person you want to enter in CS department ::- "<<endl;
										cin >> n;
										for(int i=1; i <= n; i++)
										{
											cout<<"\n Enter ID of person ::- "<<endl;
											cin >> id;
											cout<<"\n Enter NAME of person ::- "<<endl;
											cin >> name;
											cout<<"\n Enter FATHER NAME of person ::- "<<endl;
											cin >>  fatherName;
											cout<<"\n Enter Adhar ID of person ::- "<<endl;
											cin >> cnic;
											cout<<"\n Enter GENDER of person ::- "<<endl;
											cin >> gender;
											cout<<"\n Enter PHONE NUMBER of person ::- "<<endl;
											cin >> phone_no;
											cout<<"\n Enter POST / RANK of person ::- "<<endl;
											cin >> post;
											cout<<"\n Enter GMAIL of person ::- "<<endl;
											cin >> gmail;
											cout<<"\n Enter LATEST QUALIFICATION of person ::- "<<endl;
											cin >> latest_qualification;
											cout<<"\n Enter AGE of person ::- "<<endl;
											cin >> age;
											cout<<"\n Enter ADDRESS of person ::- "<<endl;
											cin >> address;
											cout<<"\nEnter CAMPUS of person ::- "<<endl;
											cin >> campuss;
											cout<<"\n Enter CURRENT STATUS of person ::- "<<endl;
											cin >> status;
											// function call
											t.root = t.insertion_Faculty(t.root,id,name,fatherName,cnic,gender,phone_no,post,gmail,latest_qualification,age,address,campuss,status);
											cout<<"\n\tInsetion   "<< i <<" completed ....."<<endl;
										}
										break;
									case '2':
										cout<<"\n\t Welcome in Search any person and print data of his / her "<<endl;
										cout<<"\n Enter the id of person for search "<<endl;
										cin >> id;
										t.search_function(t.root, id);
										break;
									case '3':
										cout<<"\n Welcome in DELETE A person "<<endl;
										cout<<"\n Deletion function call "<<endl;
										cout<<"\n Enter id of person for delete "<<endl;
										cin >> id;
										// file handling data save
										t.search_file(t.root,id);
										//
										t.root = t.deletion_Faculty(t.root, id);
										cout<<"\n After delete print function call "<<endl;
										t.in_order(t.root);
										break;
									case '4':
										cout<<"\n Welcome in update information "<<endl;
										t.options_information(t.root);
										break;
									case '5':
										cout<<"\n Welcome in Print all data "<<endl;
										t.in_order(t.root);
										break;
									case '6':
										system("cls");
										goto y;
										break;
								// 3 case end
								}
							}
							break;
						case '2':
							system("cls");
							cout<<"\n\n\t Here are the functions for EE department "<<endl;
							char ch3;
							while(1)
							{
								// get functions for EE
								Get_Faculty_Function_Options();
								ch3 = getch();
								switch(ch3)
								{	// 3 case start
									case '1':
										cout<<"\n\t Welcome in ADD NEW PERSON function "<<endl;
										cout<<"\nEnter the no. of person you want to enter in EE department ::- "<<endl;
										cin >> n;
										for(int i=1; i <= n; i++)
										{
											cout<<"\n Enter ID of person ::- "<<endl;
											cin >> id;
											cout<<"\n Enter NAME of person ::- "<<endl;
											cin >> name;
											cout<<"\n Enter FATHER NAME of person ::- "<<endl;
											cin >>  fatherName;
											cout<<"\n Enter Adhar ID of person ::- "<<endl;
											cin >> cnic;
											cout<<"\n Enter GENDER of person ::- "<<endl;
											cin >> gender;
											cout<<"\n Enter PHONE NUMBER of person ::- "<<endl;
											cin >> phone_no;
											cout<<"\n Enter POST / RANK of person ::- "<<endl;
											cin >> post;
											cout<<"\n Enter GMAIL of person ::- "<<endl;
											cin >> gmail;
											cout<<"\n Enter LATEST QUALIFICATION of person ::- "<<endl;
											cin >> latest_qualification;
											cout<<"\n Enter AGE of person ::- "<<endl;
											cin >> age;
											cout<<"\n Enter ADDRESS of person ::- "<<endl;
											cin >> address;
											cout<<"\n Enter CAMPUS of person ::- "<<endl;
											cin >> campuss;
											cout<<"\n Enter CURRENT STATUS of person ::- "<<endl;
											cin >> status;
											// function call
											t.root1 = t.insertion_Faculty_EE(t.root1,id,name,fatherName,cnic,gender,phone_no,post,gmail,latest_qualification,age,address,campuss,status);
											cout<<"\n\t Insetion   "<< i <<" completed ....."<<endl;
										}
										break;
									case '2':
										cout<<"\n\t Welcome in Search any person and print data of his / her "<<endl;
										cout<<"\n Enter the id of person for search "<<endl;
										cin >> id;
										t.search_function(t.root1, id);
										break;
									case '3':
										cout<<"\n Welcome in DELETE A person "<<endl;
										cout<<"\n Deletion function call "<<endl;
										cout<<"\n Enter id of person for delete "<<endl;
										cin >> id;
										// file handling data save
										t.search_file(t.root1,id);
										//
										t.root1 = t.deletion_Faculty(t.root1, id);
										cout<<"\n After delete print function call "<<endl;
										t.in_order(t.root1);
										break;
									case '4':
										cout<<"\n Welcome in update information "<<endl;
										t.options_information(t.root1);
										break;
									case '5':
										cout<<"\n Welcome in Print all data "<<endl;
										t.in_order(t.root1);
										break;
									case '6':
										system("cls");
										goto y;
										break;
								// 3 case end
								}
							}
							break;

						case '3':
							system("cls");
							cout<<"\n \t \tHere are the information of HUMANITIES department "<<endl;
							char ch4;
							while(1)
							{
								// get functions for Humanities
								Get_Faculty_Function_Options();
								ch4 = getch();
								switch(ch4)
								{	// 3 case start
									case '1':
										cout<<"\n Welcome in ADD NEW PERSON function "<<endl;
										cout<<"\n Enter the no. of person you want to enter in CS department ::- "<<endl;
										cin >> n;
										for(int i=1; i <= n; i++)
										{
											cout<<"\nEnter ID of person ::- "<<endl;
											cin >> id;
											cout<<"\nEnter NAME of person ::- "<<endl;
											cin >> name;
											cout<<"\nEnter FATHER NAME of person ::- "<<endl;
											cin >>  fatherName;
											cout<<"\nEnter Adhar ID of person ::- "<<endl;
											cin >> cnic;
											cout<<"\nEnter GENDER of person ::- "<<endl;
											cin >> gender;
											cout<<"\nEnter PHONE NUMBER of person ::- "<<endl;
											cin >> phone_no;
											cout<<"\nEnter POST / RANK of person ::- "<<endl;
											cin >> post;
											cout<<"\nEnter GMAIL of person ::- "<<endl;
											cin >> gmail;
											cout<<"\nEnter LATEST QUALIFICATION of person ::- "<<endl;
											cin >> latest_qualification;
											cout<<"\nEnter AGE of person ::- "<<endl;
											cin >> age;
											cout<<"\nEnter ADDRESS of person ::- "<<endl;
											cin >> address;
											cout<<"\nEnter CAMPUS of person ::- "<<endl;
											cin >> campuss;
											cout<<"\nEnter CURRENT STATUS of person ::- "<<endl;
											cin >> status;
											// function call
											t.root2 = t.insertion_Faculty_Humanities(t.root2,id,name,fatherName,cnic,gender,phone_no,post,gmail,latest_qualification,age,address,campuss,status);
											cout<<"\n\t Insetion   "<< i <<" completed ....."<<endl;
										}
										break;
									case '2':
										cout<<"\nWelcome in Search any person and print data of his / her "<<endl;
										cout<<"\nEnter the id of person for search "<<endl;
										cin >> id;
										t.search_function(t.root2, id);
										break;
									case '3':
										cout<<"\nWelcome in DELETE A person "<<endl;
										cout<<"\nDeletion function call "<<endl;
										cout<<"\nEnter id of person for delete "<<endl;
										cin >> id;
										// file handling data save
										t.search_file(t.root2,id);
										//
										t.root2 = t.deletion_Faculty(t.root2, id);
										cout<<"\nAfter delete print function call "<<endl;
										t.in_order(t.root2);
										break;
									case '4':
										cout<<"\nWelcome in update information "<<endl;
										t.options_information(t.root2);
										break;
									case '5':
										cout<<"\nWelcome in Print all data "<<endl;
										t.in_order(t.root2);
										break;
									case '6':
										system("cls");
										goto y;
										break;
								// 3 case end
								}
							}
							break;
						// end of faculty
						case '4':
							system("cls");
							goto x;
							break;

					// 2 case end
					}
				}
			// else check katam

				break;
				// end of all faculty record
			case '2':
				system("cls");
				l.admin_login();
				system("cls");
				print_Library();
				char ch5;
				while(1)
				{
					cout<<"\n \n \n You enter the information of Library "<<endl;
					Get_Faculty_Function_Options();
					ch5 = getch();
					switch(ch5)
					{
						case '1':
							cout<<"\nWelcome in ADD NEW PERSON function "<<endl;
							cout<<"\nEnter the no. of person you want to enter in LIBRARY ::- "<<endl;
							cin >> n;
							for(int i=1; i <= n; i++)
							{
								cout<<"\nEnter ID of person ::- "<<endl;
								cin >> id;
								cout<<"\nEnter NAME of person ::- "<<endl;
								cin >> name;
								cout<<"\nEnter FATHER NAME of person ::- "<<endl;
								cin >>  fatherName;
								cout<<"\nEnter Adhar ID of person ::- "<<endl;
								cin >> cnic;
								cout<<"\nEnter GENDER of person ::- "<<endl;
								cin >> gender;
								cout<<"\nEnter PHONE NUMBER of person ::- "<<endl;
								cin >> phone_no;
								cout<<"\nEnter POST / RANK of person ::- "<<endl;
								cin >> post;
								cout<<"\nEnter GMAIL of person ::- "<<endl;
								cin >> gmail;
								cout<<"\nEnter LATEST QUALIFICATION of person ::- "<<endl;
								cin >> latest_qualification;
								cout<<"\nEnter AGE of person ::- "<<endl;
								cin >> age;
								cout<<"\nEnter ADDRESS of person ::- "<<endl;
								cin >> address;
								cout<<"\nEnter CAMPUS of person ::- "<<endl;
								cin >> campuss;
								cout<<"\nEnter CURRENT STATUS of person ::- "<<endl;
								cin >> status;
								// function call
								t.root3 = t.insertion_Faculty(t.root3,id,name,fatherName,cnic,gender,phone_no,post,gmail,latest_qualification,age,address,campuss,status);
								cout<<"\n\tInsetion   "<< i <<" completed ....."<<endl;
							}
							break;
						case '2':
							cout<<"\nWelcome in Search any person and print data of his / her "<<endl;
							cout<<"\nEnter the id of person for search "<<endl;
							cin >> id;
							t.search_function(t.root3, id);
							break;
						case '3':
							cout<<"\nWelcome in DELETE A person "<<endl;
							cout<<"\nDeletion function call "<<endl;
							cout<<"\nEnter id of person for delete "<<endl;
							cin >> id;
							// file handling data save
							t.search_file(t.root3,id);
							//
							t.root3 = t.deletion_Faculty(t.root3, id);
							cout<<"\nAfter delete print function call "<<endl;
							t.in_order(t.root3);
							break;
						case '4':
							cout<<"\nWelcome in update information "<<endl;
							t.options_information(t.root3);
							break;
						case '5':
							cout<<"\nWelcome in Print all data "<<endl;
							t.in_order(t.root3);
							break;
						case '6':
							system("cls");
							goto x;
							break;
					// end of Library for case 2
					}
				}

			case '3':
				system("cls");
				l.admin_login();
				system("cls");
				cout<<"\n\n\t\t You enter to admin department ::- "<<endl;
				while(1)
				{
					char ch50;
					Get_Faculty_Function_Options();
					ch50 = getch();
					switch(ch50)
					{
						case '1':
						cout<<"\nWelcome in ADD NEW PERSON function "<<endl;
						cout<<"\nEnter the no. of person you want to enter in ADMIN ::- "<<endl;
						cin >> n;
						for(int i=1; i <= n; i++)
						{
							cout<<"\nEnter ID of person ::- "<<endl;
							cin >> id;
							cout<<"\nEnter NAME of person ::- "<<endl;
							cin >> name;
							cout<<"\nEnter FATHER NAME of person ::- "<<endl;
							cin >>  fatherName;
							cout<<"\nEnter Adhar ID of person ::- "<<endl;
							cin >> cnic;
							cout<<"\nEnter GENDER of person ::- "<<endl;
							cin >> gender;
							cout<<"\nEnter PHONE NUMBER of person ::- "<<endl;
							cin >> phone_no;
							cout<<"\nEnter POST / RANK of person ::- "<<endl;
							cin >> post;
							cout<<"\nEnter GMAIL of person ::- "<<endl;
							cin >> gmail;
							cout<<"\nEnter LATEST QUALIFICATION of person ::- "<<endl;
							cin >> latest_qualification;
							cout<<"\nEnter AGE of person ::- "<<endl;
							cin >> age;
							cout<<"\nEnter ADDRESS of person ::- "<<endl;
							cin >> address;
							cout<<"\nEnter CAMPUS of person ::- "<<endl;
							cin >> campuss;
							cout<<"\nEnter CURRENT STATUS of person ::- "<<endl;
							cin >> status;
							// function call
							a.root6 = a.insertion_Faculty(a.root6,id,name,fatherName,cnic,gender,phone_no,post,gmail,latest_qualification,age,address,campuss,status);
							cout<<"\n\tInsetion   "<< i <<" completed ....."<<endl;
							}
							break;
						case '2':
							cout<<"\nWelcome in Search any person and print data of his / her "<<endl;
							cout<<"\nEnter the id of person for search "<<endl;
							cin >> id;
							a.search_function(a.root6, id);
							break;
						case '3':
							cout<<"\nWelcome in DELETE A person "<<endl;
							cout<<"\nDeletion function call "<<endl;
							cout<<"\nEnter id of person for delete "<<endl;
							cin >> id;
							// file handling data save
							a.search_file(a.root6,id);
							//
							a.root6 = a.deletion_Faculty(a.root6, id);
							cout<<"\nAfter delete print function call "<<endl;
							a.in_order(a.root6);
							break;
						case '4':
							cout<<"\nWelcome in update information "<<endl;
							a.options_information(a.root6);
							break;
						case '5':
							cout<<"\nWelcome in Print all data "<<endl;
							a.in_order(a.root6);
							break;
						case '6':
							system("cls");
							goto x;
							break;
					}
				}
				break;

			case '4':
				system("cls");
				cout<<"\nYou enter the job portal "<<endl;
				cout<<"\n\n\n\n\t\t\t\t\t\t............."<<endl;
				cout<<"\t\t\t\t\t\t|  Login    |"<<endl;
				cout<<"\t\t\t\t\t\t............."<<endl;
				z:
				cout<<"\nPress any options for login "<<endl;
				cout<<"\n\t 1: Guest \t \t 2: Admin \t \t 3:Go to back"<<endl;
				cin >> press;
				system("cls");
				if(press == 1)
				{
					l.guest_login();
					// case for header file Faculty_portal.h
					while(1)
					{
						char ch23;
						l.print_options();
						ch23 = getch();
						switch(ch23)
						{
							case '1':
								system("cls");
								l.print_Department_Available();
								break;
							case '2':
								system("cls");
								l.print_Requirements_job();
								break;
							case '3':
								system("cls");
								l.print_vocancies();
								break;
							case '4':
								system("cls");
								l.apply_JOb();
								cout<<"\nThanks, You sucessfully submitted your job application form "<<endl;
								break;
							case '5':
								goto z;
								break;
						}
					}

				}
				if(press == 2)
				{
					cout<<"\nWelcome into Admin Login "<<endl;
					l.admin_login();
					system("cls");
					char ch13;
					while(1)
					{
						Job_admin();
						ch13 = getch();
						switch(ch13)
						{
							case '1':
								cout<<"\nYou want to see the data of filled Job Applications form "<<endl;
								l.Print_JOb_Data(l.root5);
								break;
							case '2':
								goto z;
								break;
						}
					}


				}
				if(press == 3)
				{
					goto x;
					break;
				}

			case '5':
				system("cls");
				l.admin_login();
				system("cls");
				cout<<"\n\t You enter in Recycle Bin ::-"<<endl;
				a:
				cout<<"\n\t 1:Press for only RECOVER DATA "<<endl;
				cout<<"\n\t 2:Press for only PRINT RECOVER DATA "<<endl;
				cout<<"\n\t 3:Press for get the latest delete data "<<endl;
				cout<<"\n\t 4:Press for go back main list "<<endl;
				cin >> enter1;
				if(enter1 == 1)
				{
					cout<<"Recover Data working ....."<<endl;
					//Sleep(2000);
					t.recover_data();
					cout<<"You sucessfully RECOVERED data "<<endl;
					goto a;
				}
				if(enter1 == 2)
				{
					system("cls");
					t.print_linked_list();
					goto a;
				}
				if(enter1 == 3)
				{
					//system("cls");
					t.get_latest_data();
					goto a;
				}
				if(enter1 == 4)
				{
					goto x;
				}
				break;
			case '6':
				system("cls");
				char ch100;
				la:
				while(1)
				{
					Higher_Post();
					ch100 = getch();
					switch(ch100)
					{
						case '1':
							system("cls");
							char ch101;
							while(1)
							{
								higher_Post_functions();
								ch101 = getch();
								switch(ch101)
								{
									cout<<"\n\n\tYou enter the information :: board of governers "<<endl;
									case '1':
										system("cls");
										// add new person
										cout<<"Enter data of person "<<endl;
										w.options1();
										break;
									case '2':
										// delete person
										cout<<"Enter id for deletion "<<endl;
										cin >> id;
										w.Delete1(id);
										cout<<"After deletions "<<endl;
										break;
									case '3':
										// print all data
										w.print1();
										break;
									case '5':
										goto la;
										break;
								}
							}
							break;
						case '2':
							system("cls");
							char ch102;
							while(1)
							{
								higher_Post_functions();
								ch102 = getch();
								switch(ch102)
								{
									cout<<"\n\n\tYou enter the information :: board of trustees "<<endl;
									case '1':
										system("cls");
										// add new person
										w.options1();
										cout<<"Enter data of person "<<endl;
										break;
									case '2':
										// delete person
										cout<<"Enter id for deletion "<<endl;
										cin >> id;
										w.Delete2(id);
										break;
									case '3':
										// print all data
										w.print2();
										break;
									case '5':
										goto la;
										break;
								}
							}
							break;
						case '3':
							system("cls");
							char ch103;
							while(1)
							{
								higher_Post_functions();
								ch103 = getch();
								switch(ch103)
								{
									cout<<"\n\n\tYou enter the information :: officers of university "<<endl;
									case '1':
										system("cls");
										// add new person
										cout<<"Enter data for new person "<<endl;
										w.options3();
										break;
									case '2':
										// delete person
										cout<<"Enter id for deletion "<<endl;
										cin >> id;
										w.Delete3(id);
										break;
									case '3':
										// print all data
										w.print3();
										break;
									case '5':
										goto la;
										break;
								}
							}
							break;
						case '4':
							goto x;
							break;
					}
					// end of cases
				}
				break;
			default:
				system("cls");
				cout<<"\n\n\n\n\t\t\ Thanks for using our software  "<<endl;
				cout<<"\n\n\n\n\t\t You terminated from system in few seconds ";
				for(process=0;process<20;process++)
  				{
    				Sleep(100);
    				cout <<".";
  				}
				exit(0);
				break;
		// end of case 1
		}
	}


	return 0;
}
