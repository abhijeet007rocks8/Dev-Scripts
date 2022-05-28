package College;

import java.util.Scanner;

/**
 *
 * @author Ankit
 */
public class StudentRecordLinkedList {
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
 
        //Creating HumanResourceOffice Object.
    	StudentRecordManagement hr = new StudentRecordManagement();
 
        Record record = new Record();
        //Hard Coded record on the program. 
        //it serves as the initial Employee record:
        //Using mutators to had code the data.
        record.setIdNumber(6862);
        record.setContactNumber(911);
        record.setName("Ankit");
        // Call add record, to add static data/(Hard Coded Data) to linked List. 
        hr.add(record);
 
        //Creating Scanner Object.
        Scanner input = new Scanner(System.in);
 
        //Creating Option Integer Variable.
        int option = 0;
        //Do - While loop
        do {
            menu();
            option = input.nextInt();
 
            switch (option) {
                case 1:
                    System.out.print("What is the Student id Number ? ");
                    int idNumber = input.nextInt();
                    System.out.print("What is the Student contact Number ? ");
                    int contactNumber = input.nextInt();
                    input.nextLine();
                    System.out.print("What is the Student Name ? ");
                    String name = input.nextLine();
                    // Create record object and pass constructor parameters.
                    record = new Record(name, idNumber, contactNumber);
                    // Call add record
                    hr.add(record);
                    System.out.println(record.toString());
                    break;
                case 2:
                    System.out.print("What is the Student id number ? ");
                    int rId = input.nextInt();
                    // invoke remove/delete record
                    hr.delete(rId);
                    break;
                case 3:
                    System.out.print("What is the Student id number? ");
                    int rIdNo = input.nextInt();
                    hr.update(rIdNo, input);
                    break;
 
                case 4:
                    System.out.print("What is the Student id ? ");
                    int bookId = input.nextInt();
 
                    if (!hr.find(bookId)) {
                        System.out.println("Student id does not exist\n");
                    }
 
                    break;
                case 5:
                    hr.display();
                    break;
                case 9:
                    System.out.println("\nThank you for using the program. Goodbye!\n");
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nInvalid input\n");
                    break;
 
            }
        } while (option != 9);
    }
 
    /**
     * Menu - Static menu for displaying options.
     */
    public static void menu() {
        System.out.println("MENU");
        System.out.println("1: Add Student");
        System.out.println("2: Delete Student");
        System.out.println("3: Update Student");
        System.out.println("4: Search Student");
        System.out.println("5: Display Students");
        System.out.println("9: Exit program");
        System.out.print("Enter your selection : ");
    }
 
}