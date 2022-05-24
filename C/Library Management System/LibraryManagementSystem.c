#include<stdio.h>
#include<string.h>

struct library
{
    int bookno;
    char bname[50];
    char author[30];
    int quantity;
    int price;
};
struct library lib;
FILE *fp;

int add_book()
{
     //clrscr();
     printf("\t\t\tADD BOOK DETAILS\n");
     fp=fopen("libraryfile.txt","ab");
     printf("Enter book number: ");
     scanf("%d",&lib.bookno);
     printf("Enter the book name: ");
     scanf("%s",lib.bname);
     printf("Enter the author: ");
     scanf("%s",lib.author);
     printf("Enter the quantity of this book: ");
     scanf("%d",&lib.quantity);
     printf("Enter the price of the book: ");
     scanf("%d",&lib.price);
     fwrite(&lib,sizeof(lib),1,fp);
     fclose(fp);

     return 0;
}
int show_book()
{
     //clrscr();
     printf("\t\t\tALL BOOK DETAILS\n");
     fp=fopen("libraryfile.txt","rb");
     fseek(fp,0,SEEK_SET);
     if(fp==NULL)
     {
	 printf("ERROR opening file!!!\n");
     }
     else
     {
	 while(fread(&lib,sizeof(lib),1,fp)>0)
	 {
	    fread(&lib,sizeof(lib),1,fp);
	    printf("Book number: %d\n",lib.bookno);
	    printf("Name of the book: %s\n",lib.bname);
	    printf("Name of the author: %s\n",lib.author);
	    printf("No. of books: %d\n",lib.quantity);
	    printf("Price of book: %d\n\n",lib.price);
	 }
     }
     fclose(fp);

     return 0;
}
int total_book()
{
     //clrscr();
     int bno=0;
     printf("\t\t\tTOTAL NUMBER OF BOOKS\n");
     fp=fopen("libraryfile.txt","rb");
     fseek(fp,0,SEEK_SET);
     if(fp==NULL)
     {
	 printf("ERROR opening file!!!\n");
     }
     else
     {
	 while(fread(&lib,sizeof(lib),1,fp)>0)
	 {
	     bno+=lib.quantity;
	     if(feof(fp))
		 break;
	 }
	 printf("Total number of books: %d\n\n",bno);
     }
     fclose(fp);

     return 0;
}
int main()
{
      //clrscr();
      int choice;

      while(1)
      {
	    printf("\t\t\t\t\tLIBRARY MANAGEMENT SYSTEM\n");
	    printf("Enter 1 to enter new book details\n ");
	    printf("Enter 2 to view all book details\n");
	    printf("Enter 3 to view total number of books\n");
	    printf("Press any other key to exit\n\n");
	    printf("Enter your choice: ");
	    scanf("%d",&choice);
	    if(choice==1)
		 add_book();
	    else if(choice==2)
		 show_book();
	    else if(choice==3)
		 total_book();
	    else
            break;
		 //exit(0);
      }
      //getch();

      return 0;
} 