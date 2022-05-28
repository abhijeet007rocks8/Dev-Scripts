import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class login {
    public static void main() throws IOException {
        Scanner sc = new Scanner(System.in);
        int count1 = 0;
        int count2 = 0;
        File emails = new File("email.txt");
        File passwords = new File("password.txt");
        Scanner email_check = new Scanner(emails);
        Scanner password_check = new Scanner(passwords);
        System.out.println("-----------------------------------------------------");
        System.out.println("Welcome User! Login with your credentials");
        System.out.println("-----------------------------------------------------");
        System.out.println("Enter your email id");
        String email = sc.nextLine();
        System.out.println("-----------------------------------------------------");
        System.out.println("Enter your password");
        String password = sc.nextLine();
        System.out.println("-----------------------------------------------------");
        System.out.println("Verifying Credentials");
        System.out.println("-----------------------------------------------------");

        while (email_check.hasNextLine()) {
            String data1 = email_check.nextLine();
            if(data1.equals(email))
                count1 = 1;
        }
        while (password_check.hasNextLine()) {
            String data2 = password_check.nextLine();
            if(data2.equals(password))
                count2 = 1;
        }
        if((count1 == 1)&&(count2 == 1)){
            System.out.println("-----------------------------------------------------");
            System.out.println("Login Successfully!");
            System.out.println("-----------------------------------------------------");
        }
        else {
            System.out.println("User does not exist!");
            System.out.println("Would you like to register ?");
            System.out.println("Enter R to register and Q to quit");
            char choice = sc.nextLine().charAt(0);
            if(choice == 'R' || choice == 'r'){
                registration.main();
            }
            else if(choice == 'Q' || choice == 'q'){
                System.out.println("Thank you! Quiting");

            }
            else {
                System.out.println("Wrong choice!");
            }
        }
        }
    }
