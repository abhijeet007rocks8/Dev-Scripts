import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class registration {
    public static void main() throws IOException {
        Scanner sc = new Scanner(System.in);
        File emails = new File("email.txt");
        FileWriter myWriter = new FileWriter("email.txt", true);
        File passwords = new File("password.txt");
        FileWriter Writer = new FileWriter("password.txt", true);
        System.out.println("-----------------------------------------------------");
        System.out.println("Welcome New User!");
        System.out.println("-----------------------------------------------------");
        System.out.println("Let's get you set up...");
        System.out.println("Enter your Email");
        String email = sc.nextLine();
        System.out.println("Enter your Password");
        String password = sc.nextLine();
        System.out.println("Re Enter your Password");
        String password_confirm = sc.nextLine();
        while (!password.equals(password_confirm)) {
            System.out.println("Password does not match. Try again");
            System.out.println("Enter your Password");
            password = sc.nextLine();
            System.out.println("Re Enter your Password");
            password_confirm = sc.nextLine();


        }
        System.out.println("-----------------------------------------------------");
        System.out.println("Saving credentials");
        System.out.println("-----------------------------------------------------");
        System.out.println("You can now login with your new credentials!");

        myWriter.write(email);
        myWriter.write("\n");
        Writer.write(password);
        Writer.write("\n");


        myWriter.close();
        Writer.close();

        System.exit(30);
        }
    }

