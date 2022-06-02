package studentdatabaseapp;
import java.util.Scanner;

public class Student {
  private String firstName;
  private String lastName;
  private int semester;
  private String paymentID;
  private String courses = null;
  private int tuitionBalance = 500;
  private static int costOfCourse = 600;
  private static int id = 1000;


  public Student(){    //Constructor: prompt user to enter student's name and semester
int x = 1;    //For do while loop
 do{    //Do while loop, so process will repeat if user input wrong input
try{    //Exception handling start
    Scanner in = new Scanner(System.in);
    System.out.print("Enter student first name: ");
    this.firstName = in.nextLine();

    System.out.print("Enter student last name: ");
    this.lastName = in.nextLine();

    System.out.println("----------------------------------------");
    System.out.print("1 - Semester 1\n2 - Semester 2\n3 - Semester 3\n4 - Semester 4\n5 - Semester 5\nEnter your semester: ");
    this.semester = in.nextInt();   

    System.out.println("----------------------------------------");
    setStudentID();

    x=2;    //When user input all the right input, the do while loop stop

}
catch(Exception e){    //Catch statement when error happened
   System.out.println("\n\tOops! Wrong input. PleaseTry Again\n");
}
}while(x==1);    //Restart the process if user input the wrong input
}

       //Constructor: Generate an receipt ID
       private void setStudentID() {
       // Semester level + ID
       id++;
       this.paymentID = semester + "" + id;
       }

  //Enroll in courses
  public void enroll() {
      do {
         System.out.print("Enter course to enroll (Q to quit when finish.): ");
         Scanner in = new Scanner(System.in);
         String course = in.nextLine();
         if (!course.equals("q")) {
         courses = courses + "\n " + course;
         tuitionBalance = tuitionBalance + costOfCourse;
         }
    else {
         break;
         }
         } while (1 != 0);
   System.out.println("----------------------------------------");
   System.out.println("\n");
   System.out.println("*****************************************");
}

   //Display total amount to pay
   public void totalpay(){
   int totPayment = 0;
   totPayment = tuitionBalance - 500;
   System.out.println("Total payment for the courses is: RM" + totPayment);
   System.out.println("*****************************************");
   }

        // View balance
        public void viewBalance(){
        System.out.println("Your current account balance: RM" + tuitionBalance);
        }

  // Pay tuition
  public void payTuition() {

int x = 1;
do{

     try{    //Exception handling start
         viewBalance();    //To show balance in account
         System.out.print("Enter your payment: RM");
         Scanner in = new Scanner(System.in);
         int payment = in.nextInt();
         tuitionBalance = tuitionBalance - payment;
         System.out.print("\n");
         System.out.println("----------------------------------------");
         System.out.println("Thank you for your payment of RM" + payment);
         viewBalance();

         x=2;    //When user input all the right input, the do while loop stop
         }
         catch(Exception e){    //Catch statement when error happened
                            System.out.println("\n\tOops! Wrong input. PleaseTry Again\n");
                           }
}while(x==1);
}

  // Show status
  public String toString(){
   return "Name: " + firstName + " " + lastName +
          "\nSemester: " + semester +
          "\nReceipt ID: " + paymentID +
          "\nCourses Enrolled:" + courses +
          "\nBalance: RM" + tuitionBalance +
          "\n----------------------------------------";
          }
}



