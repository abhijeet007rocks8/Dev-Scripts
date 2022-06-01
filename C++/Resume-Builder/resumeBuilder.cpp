#include <iostream>
#include <fstream>
#include <algorithm>
#include <string>

using namespace std;

int main()
{
    system("cls");
    cout << "\n\n\t\t\t\tWelcome\n\t\t\tGet your Resume here !!\n\n";
    ofstream resumefile;
    resumefile.open("genResume.txt");
    if (resumefile)
    {
        string temp;
        cout << "Enter Your Name : ";
        getline(cin, temp);
        transform(temp.begin(), temp.end(), temp.begin(), ::toupper);
        resumefile << temp <<"\n";

        cout<<"Enter Your Address : ";
        getline(cin,temp);
        resumefile<<temp<<"\n";

        cout<<"Enter Mobile Number : ";
        getline(cin,temp);
        resumefile<<temp<<"\n";

        cout<<"Enter Your Email : ";
        getline(cin,temp);
        resumefile<<temp<<"\n";

        cout<<"\n";
        resumefile<<"\nOBJECTIVE\n";
        cout<<"Enter Your Objective : ";
        getline(cin,temp);
        resumefile<<temp<<"\n";

        cout<<"\n";
        resumefile<<"\nSUMMARY OF SKILLS\n";
        cout<<"Enter Your Skills Summary(in one paragraph) : ";
        getline(cin,temp);
        resumefile<<temp<<"\n";

        cout<<"\n";
        resumefile<<"\nWORK EXPERIENCE\n";
        cout<<"Work Experience details -\n";
        cout<<"Enter Job Title, Company, Duration (all seperated by comas): ";
        getline(cin,temp);
        resumefile<<temp<<"\n";
        cout<<"Enter Job Description : ";
        getline(cin,temp);
        resumefile<<temp<<"\n";

        cout<<"\n";
        resumefile<<"\nEDUCATION\n";
        cout<<"Education Details -\n";
        cout<<"Enter School/College Name, City, State, Session-Duration (all seperated by comas) : ";
        getline(cin,temp);
        resumefile<<temp<<"\n";

        cout<<"\n";
        resumefile<<"\nVOLUNTEER EXPERIENCE\n";
        cout<<"Enter Your Volunteer Experience (in a single paragraph) : ";
        getline(cin,temp);
        resumefile<<temp<<"\n";

        cout<<"\n";
        resumefile<<"\nPROJECTS\n";
        cout<<"Enter Your Projects (in a single paragraph seperated by ',' or '||') : ";
        getline(cin,temp);
        resumefile<<temp<<"\n";

        cout<<"\n";
        resumefile<<"\nACHIEVEMENTS\n";
        cout<<"Enter Your Achievements (in a single paragraph seperated by ',' or '||') : ";
        getline(cin,temp);
        resumefile<<temp<<"\n";

        // resumefile << "end of file here";
        cout << "File written ....\n";
    }
    else
    {
        cout << "File not opened...\n";
    }
    resumefile.close();
    return 0;
}