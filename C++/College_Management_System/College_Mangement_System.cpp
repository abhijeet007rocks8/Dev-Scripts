#include<iostream>
#include<vector>
#include<stdio.h>
#include<cstring>
#include<fstream>
#include<algorithm>
using namespace std;
class student
{
public:
    long int reg;
    char name[80],branch[50];
    void input()
    {
        cout<<"\n Enter name: ";
        gets(name);
        cout<<"\n Enter roll no: ";
        cin>>reg;
        fflush(stdin);
        cout<<"\n Enter Branch: ";
        gets(branch);
    }
    void display()
    {
        system("CLS");
        cout<<"\t\tDisplay Records";
        cout<<"\n";
        cout<<"\n Name - "<<name;
        cout<<"\n Reg no. - "<<reg;
        cout<<"\n Branch - "<<branch;
        cout<<"\n";
        system("PAUSE");
        system("CLS");
    }
    bool operator == (student a)
    {
        if(reg==a.reg)
            return true;
        else
            return false;
    }
};
vector <student>v;
int search_reg(long int reg,int &i);
void get_file()
{
    student x;
    int i=0;
    fstream f;
    f.open("College.txt",ios::in);
    if(f)
    {
        f.read((char *) &x,sizeof(class student));
        while(!f.eof())
        {
            v.push_back(x);
            f.read((char *) &x,sizeof(class student));
        }
    }
    else
        ;
    f.close();
}
void bubblesort()
{
    int i,j;
    student x;
    for(i=0; i<v.size(); i++)
        for(j=0; j<v.size()-i-1; j++)
            if(v[j].reg>v[j+1].reg)
            {
                x=v[j];
                v[j]=v[j+1];
                v[j+1]=x;
            }
}
void insert_new()
{
    char ch='y';
    int ta;
    while(ch=='y')
    {
        fflush(stdin);
        student x;
        x.input();
        if(search_reg(x.reg,ta)==0)
            v.push_back(x);
        else
            cout<<"\nTHE REGISTRATION NO. ALREADY EXIST!!!\nCANNOT ADD";
        cout<<"\n Press [Y] to enter more: ";
        cin>>ch;
        fflush(stdin);
    }
}
void write_file()
{
    bubblesort();
    fstream f;
    f.open("College.txt",ios::out);
    for(int i=0; i<v.size(); i++)
    {
        student x=v[i];
        f.write((char *) &x,sizeof(class student));
    }
    f.close();
}
int search_reg(long int reg,int &i)
{
    int ta=0;
    for(i=0; i<v.size(); i++)
        if(v[i].reg==reg)
        {
            ta=1;
            break;
        }
    return ta;
}
int search_name(char name[],vector<int> &vi)
{
    int i,ta=0;
    for(i=0; i<v.size(); i++)
        if(strcmp(v[i].name,name)==0)
        {
            ta=1;
            vi.push_back(i);
        }
    return ta;
}
int search_branch(char branch[],vector<int> &vj)
{
    int i,ta=0;
    for(i=0; i<v.size(); i++)
        if(strcmp(v[i].branch,branch)==0)
        {
            ta=1;
            vj.push_back(i);
        }
    return ta;
}
void search_and_show()
{
    int ch,i,ta=0;
    char name[80],branch[50];
    vector <int>vi;
    vector <int>vj;
    long int reg;
poi:
    cout<<"\n1.Press to search reg no."
        <<"\n2.Press to search name"
        <<"\n3.Press to search branch";
    cin>>ch;
    switch(ch)
    {
    case 1:
        cout<<"\nEnter reg no.: ";
        cin>>reg;
        if(search_reg(reg,i)==1)
            v[i].display();
        else
            cout<<"\nRecord NOT FOUND!!!";
        break;
    case 2:
        cout<<"\nEnter name: ";
        fflush(stdin);
        gets(name);
        if(search_name(name,vi)==1)
        {
            for(int j=0; j<vi.size(); j++)
                v[vi[j]].display();
        }
        else
            cout<<"\nRecord NOT FOUND!!!";
        break;
    case 3:
        cout<<"\nEnter branch: ";
        fflush(stdin);
        gets(branch);
        if(search_branch(branch,vj)==1)
        {
            for(int j=0; j<vj.size(); j++)
                v[vj[j]].display();
        }
        else
            cout<<"\nRecord NOT FOUND!!!";
        break;
    default:
        cout<<"\nWrong CHOICE!!!";
        goto poi;
    }
}
void show()
{
    int i;
    for(i=0; i<v.size(); i++)
        v[i].display();
}
void delete_data()
{
    int i,j;
    long int reg;
    vector <student>::iterator p=v.begin();
    cout<<"\nEnter Reg. no.: ";
    cin>>reg;
    if(search_reg(reg,i)==1)
    {
        student x=v[i];
        cout<<"\nThe following data is being deleted";
        x.display();
        p+=i;
        v.erase(p,p+1);
    }
}
void edit_data()
{
    int i,j;
    long int reg;
    vector <student>vi;
    cout<<"\nEnter Reg. no.: ";
    cin>>reg;
    if(search_reg(reg,i)==1)
    {
        cout<<"\nEnter new data:";
        fflush(stdin);
        v[i].input();
    }
}
int main()
{
    int i=1;
    get_file();
    while(i)
    {
        system("CLS");
        cout<<"\t\t\t-----------------------------------------\n";
        cout<<"\t\t\t   Simple College Management System\n";
        cout<<"\t\t\t-----------------------------------------\n";
        cout<<"\n\t\t\tEnter <1> to Add new student"
            <<"\n\t\t\tEnter <2> to Display all student"
            <<"\n\t\t\tEnter <3> to Remove student"
            <<"\n\t\t\tEnter <4> to Edit student"
            <<"\n\t\t\tEnter <5> to Search student"
            <<"\n\t\t\tEnter <0> to Exit\n";
        cout<<"\n\n\t\t\tEnter Your Choice:";
        cin>>i;
        switch(i)
        {
        case 1 :
            insert_new();
            break;
        case 2 :
            show();
            break;
        case 3 :
            delete_data();
            break;
        case 4 :
            edit_data();
            break;
        case 5 :
            search_and_show();
            break;
        case 0 :
            write_file();
            break;
        default :
            cout<<"\nWRONG CHOICE!!!\nTRY AGAIN";
        }
    }
    return 0;
}
