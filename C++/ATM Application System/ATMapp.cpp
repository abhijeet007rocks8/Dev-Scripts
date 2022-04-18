#include<iostream>

#include<conio.h>

using namespace std;

int main()
{

    double balance , deposit , withdraw;

    int option;

    balance=300; 

    do{

    

	cout<<"\n\t***************MENU***************";

	cout<<"\n\t*                                *";

	cout<<"\n\t*      1. Check Balance          *";

	cout<<"\n\t*      2. Deposit                *";

	cout<<"\n\t*      3. Withdraw               *";

	cout<<"\n\t*      4. Transfer               *";

	cout<<"\n\t*      5. Exit                   *";

	cout<<"\n\t*                                *";

	cout<<"\n\t**********************************";

	cout<<"\n\t Please Choose an Option: ";

	cin>>option;

	switch(option)

	{

		case 1:

			cout<<"\n\tYour Balance is: Rs."<<balance<<endl;

			break;

		case 2:

			cout<<"\n\tAmount You Want to deposit: Rs.";

			cin>>deposit;

			balance += deposit; 

			cout<<"\n\t Your Current Balance : Rs."<<balance<<endl;

			break;

		case 3:

			cout<<"\n\tEnter Withdraw Amount: Rs.";

               cin>>withdraw;

			if(balance<withdraw)

			   cout<<"\n\tYou do not have enough money "<<endl;

			else

			balance -= withdraw; 

			cout<<"\n\t Your Current Balance : Rs."<<balance<<endl;

			break;

		case 4:

			cout<<"\n\t This Service is Not Available!!!"<<endl;

			break;

		default:

			if(option !=5)

			cout<<"\n\t Invalid Option Please Try Again"<<endl;

			break;

			

			}

	

}while(option !=5);

system("pause");

	

	return 0;

	getch();

}


