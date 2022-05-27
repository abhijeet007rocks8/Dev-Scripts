#include<iostream>  
#include<stdio.h>
#include<fstream>
#include<stdlib.h>
#include<string.h>
// #include<process>
using namespace std;

class canteen
{  private:
	 int prodno;                               //product number
	 float price;                            //price of product
	 char name[80];                              //product name
   public:
	 void getdata();
	 void showdata();
	 canteen()                 //constructor of a class canteen
	 {    prodno=0;
	      price=0;
	      strcpy(name,"null");
	 }
	 int returnprodno()
	 {   return prodno;
	 }
	 float returnprice()
	 {   return price;
	 }
	 char*returnname()
	 {   return name;
	 }
};
class customer
{
    private:
      char cname[80];                            //customer name
      long phno;                                  //phone number
    public:
      customer()                 //constructor of class customer
      {
	 strcpy(cname,"null");
	 phno=0;
      }
      void getcustomerinfo();
      void showcustomerinfo();
};
fstream f;	                   //global declaration of stream file(canteen.txt)
fstream k;                        //global declaration of stream file(customer.txt)
canteen c;       //global declaration of class object of canteen
customer t;     //global declaration of class object of customer
void canteen::getdata()
{
    cout<<"-------KINDLY ENTER THE DETAILS OF PRODUCT YOU WANT TO ADD-----"<<endl;
    cout<<"ENTER PRODUCT NUMBER: ";
    cin>>prodno;
    cout<<"ENTER THE NAME OF PRODUCT: ";
    gets(name);
    cout<<"ENTER THE PRICE OF PRODUCT(in rupees): ";
    cin>>price;
    cout<<"---------------------------------------------------------------"<<endl;
}
void canteen::showdata()
{
    cout<<"PRODUCT NUMBER: "<<prodno<<endl;
    cout<<"PRODUCT NAME: ";  puts(name);
    cout<<"PRICE OF PRODUCT: "<<price<<endl;
}
void customer::getcustomerinfo()
{
    cout<<"KINDLY ENTER YOUR PERSONAL INFORMATION BEFORE WE PROCEED FOR TAKING YOUR ORDER"<<endl;
    cout<<"ENTER YOUR NAME: ";
    gets(cname);
    cout<<"ENTER YOUR PHONE NUMBER: ";
    cin>>phno;
}
void customer::showcustomerinfo()
{
    cout<<"NAME OF CUSTOMER: "; puts(cname);
    cout<<"PHONE NUMBER OF CUSTOMER: "<<phno<<endl;
}
void writecustomer()        //function to input customer details
{
     // clrscr();
     k.open("customer.txt",ios::app|ios::out);
     t.getcustomerinfo();
     k.write((char*)&t,sizeof(t));
     k.seekg(0);
     k.close();
}
void displcustomer() //fuction to display customer informations
{
     // clrscr();
     cout<<"-------------------LIST OF ALL CUSTOMERS----------------------"<<endl;
     k.open("customer.txt",ios::in);
     k.seekg(0);
     while(!k.eof())
     {
	  k.read((char*)&t,sizeof(t));
	  t.showcustomerinfo();
	   cout<<"-------------------------------------------------------"<<endl;
     }
     k.close();
}
void writeprod()              //fuction to input product details
{
     // clrscr();
     f.open("canteen.txt",ios::app|ios::out);
     c.getdata();
     f.write((char*)&c,sizeof(c));
     f.seekg(0);
     f.close();
     cout<<"\n\nThe products has been added "<<endl;
}
void dispallprod()     //fuction to display all product details
{
     // clrscr();
     cout<<"DISPLAY ALL PRODUCT DETAILS "<<endl;
     cout<<"________________________________________________________"<<endl;
     f.open("canteen.txt",ios::in);
     f.seekg(0);
     while(f.read((char*)&c,sizeof(c)))
     {
	   c.showdata();
	   cout<<"--------------------------------------------------------"<<endl;
     }
     f.close();
}
void displayprod(int p) //fuction to display particular product details
{
     // clrscr();
     int flag=0;
     cout<<"DISPLAY OF DESIRED PRODUCT DETAILS "<<endl;
     f.open("canteen.txt",ios::in);
     f.seekg(0);
     while(f.read((char*)&c,sizeof(c)))
     {
	   if(c.returnprodno()==p)
	   {
	       c.showdata();
	       flag=1;
	       cout<<"--------------------------------------------------------"<<endl;
	   }
     }
     if(flag==0)
     cout<<"PRODUCT DETAILS NOT FOUND"<<endl;
     f.close();
}
void showmenu()             //fuction to display menu of canteen
{
	  cout<<"================ CANTEEN MENU ============================="<<endl;
	  cout<<"PRODUCT    NAME OF   PRICE"<<endl;
	  cout<<"NUMBER     PRODUCT        "<<endl;
	  cout<<"______________________________________________"<<endl;
	  f.open("canteen.txt",ios::in);
	  f.seekg(0);
	  while(!f.eof())
	  {
	     f.read((char*)&c,sizeof(c));
	    {
		cout<<c.returnprodno()<<"   "<<c.returnname()<<"   "<<c.returnprice()<<endl;
	    }
	  }
	  f.close();
}
void deletedata( )     //fuction to delete details of particular product
{
     // clrscr();
     int a,flag=0;
     fstream g;
     cout<<"ENTER THE PRODUCT NUMBER TO BE DELETED: ";
     cin>>a;
     f.open("canteen.txt",ios::in|ios::out);
     g.open("tempfile.txt",ios::out);
     f.seekg(0);
     g.seekg(0);
     while(!f.eof())
     {
	    f.read((char*)&c,sizeof(c));
	    if(c.returnprodno()!=a)
	    {    g.write((char*)&c,sizeof(c));
	    }
	    else
	    flag=1;
     }
     f.close();
     g.close();
     remove("canteen.txt");
     rename("tempfile.txt","canteen.txt");
     if(flag==1)
     cout<<"THE REQUIRED RECORD IS DELETED SUCCESSFULLY"<<endl;
     if(flag==0)
     cout<<"THE REQUIRED RECORD COULD NOT BE FOUND"<<endl;
}
void modifydata() //function to modify details of particular product
{
     // clrscr();
     int a,flag=0;
     fstream g;
     cout<<"ENTER THE PRODUCT NUMBER TO BE MODIFIED: ";
     cin>>a;
     f.open("canteen.txt",ios::in|ios::out);
     g.open("tempfile.txt",ios::out);
     f.seekg(0);
     g.seekg(0);
     while(!f.eof())
     {
	    f.read((char*)&c,sizeof(c));
	    if(c.returnprodno()!=a)
	    {    g.write((char*)&c,sizeof(c));
	    }
	    else
	    flag=1;
     }
     f.close();
     g.close();
     remove("canteen.txt");
     rename("tempfile.txt","canteen.txt");
     if(flag==1)
     {   c.getdata();
	 cout<<"RECORD MODIFIED SUCCESSFULLY "<<endl;
     }

     if(flag==0)
     cout<<"RECORD COULD NOT BE FOUND"<<endl;
}
void placeorder()                      //function to place order
{
     // clrscr();
     int qty,total=0,pno;
     cout<<"=================================================================="<<endl;
     cout<<"===================KINDLY PLACE YOUR ORDER========================"<<endl;
     cout<<"=================================================================="<<endl;
	 cout<<"ENTER THE PRODUCT NUMBER TO CHOOSE: ";
	 cin>>pno;
	 cout<<"ENTER THE QUANTITY: ";
	 cin>>qty;
     cout<<"==================================================================="<<endl;
     cout<<"                                 BILL                              "<<endl;
     f.open("canteen.txt",ios::in);
     while(f.read((char*)&c,sizeof(c)))
	    {
		   if(c.returnprodno()==pno)
		   {    total=c.returnprice()*qty;
			cout<<"> PRODUCT NUMBER: "<<pno<<endl;
			cout<<"> NAME OF PRODUCT: "<<c.returnname()<<endl;
			cout<<"> QUANTITY: "<<qty<<endl;
			cout<<"> PRICE OF EACH PRODUCT: "<<c.returnprice()<<endl;
		   }
	    }
     cout<<"--------------------------------------------------------------------"<<endl;
     cout<<"  GRAND TOTAL----------> "<<total<<endl;
     cout<<"--------------------------------------------------------------------"<<endl;
     cout<<"                       Thank you for placing order                "<<endl;
     cout<<endl;
     cout<<"====================================================================="<<endl;
     f.close();
}
void mainmenu()         //function to display administrator menu
{
     // clrscr();
     int choice,x;
     cout<<"|----------------------WELCOME TO THE MAIN MENU---------------------|"<<endl;
     cout<<"|   1) TO ADD PRODUCT LIST                                      |"<<endl;
     cout<<"|   2) TO VIEW PARTICULAR PRODUCT DETAILS                           |"<<endl;
     cout<<"|   3) TO VIEW ALL PRODUCT DETAILS                                  |"<<endl;
     cout<<"|   4) TO MODIFY THE PRODUCT DETAILS                                |"<<endl;
     cout<<"|   5) TO DELETE THE PRODUCT DETAILS                                |"<<endl;
     cout<<"|   6) TO VIEW CANTEEN'S MENU                                       |"<<endl;
     cout<<"|   7) TO EXIT FROM MAIN MENU                                       |"<<endl;
     cout<<"|-------------------------------------------------------------------|"<<endl;
     cout<<"ENTER YOUR CHOICE(1-7): ";
     cin>>choice;
     switch(choice)
     {
	    case 1:
		   writeprod();
		   break;
	    case 2:
		   // clrscr();
		   cout<<"ENTER THE PRODUCT NUMBER VIEW: ";
		   cin>>x;
		   displayprod(x);
		   break;
	    case 3:
		   dispallprod();
		   break;
	    case 4:
		   modifydata();
		   break;
	    case 5:
		   deletedata();
		   break;
	    case 6:
		   showmenu();
		   break;
	    case 7:break;
	    default:
		   cout<<"CHOICE NOT FOUND"<<endl;
     }
}
/*----------------------DECLARATION OF MAIN----------------------*/
int main()
{
     // clrscr();
     int choice;
     char choice2;
     cout<<"                       WELCOME TO ABC CANTEEN               "<<endl;
     cout<<"|----------------------------------------------------------|"<<endl;
     do
     {
	 cout<<"|   1) TO VIEW MAIN MENU                                   |"<<endl;
	 cout<<"|   2) TO PLACE AN ORDER				   |"<<endl;
	 cout<<"|   3) TO VIEW ALL CUSTOMER DETAILS                       |"<<endl;
	 cout<<"|   4) TO EXIT                                             |"<<endl;
	 cout<<"|----------------------------------------------------------|"<<endl;
	 cout<<"ENTER YOUR CHOICE: ";
	 cin>>choice;
	 switch(choice)
	 {      case 1:mainmenu();
		   break;
		case 2:writecustomer();
		       placeorder();
		   break;
		case 3:displcustomer();
		   break;
		case 4:exit(0);
		default:
		cout<<"INVALID CHOICE "<<endl;
	  }
	  cout<<"DO WANT TO CONTINUE(y/n): ";
	  cin>>choice2;
	  // clrscr();
     }
     while(choice2=='y'||choice2=='Y');
     // getch();

     return 0;
}
/*--------------------------END OF PROGRAM-----------------------*/
