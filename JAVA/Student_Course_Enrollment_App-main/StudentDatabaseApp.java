import studentdatabaseapp.Student;
import studentdatabaseapp.ConsOverload;
import studentdatabaseapp.overriding;

import java.util.Scanner;

public class StudentDatabaseApp {

  public static void main (String[]args) {

          //String class
	char welcome[]={'W','e','l','c','o','m','e'}; 
	  //converting char array welcome[] to string welStrng
          //this will print welcome
	String welStrng = new String(welcome); 
	System.out.println("\t\t" + welStrng);
    
      // ConsOverload file
    ConsOverload a = new ConsOverload("\t\tStudent");
    ConsOverload b = new ConsOverload();
    a.printName();
    b.printName();

          // overriding file
	overriding ov = new overriding();
	ov.myMethod();

  // Ask how many new student we want to add
  System.out.print("Enter number of new students to enroll: ");
  Scanner in = new Scanner(System.in);
  int numOfStudents = in.nextInt();
  Student[] students = new Student[numOfStudents];

  // Create n number of new students
  for (int n = 0; n < numOfStudents; n++) {
   students[n] = new Student();
   students[n].enroll();
   students[n].totalpay();
   students[n].payTuition();
      System.out.println(students[n].toString());
}
}
}