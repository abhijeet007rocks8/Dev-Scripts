import java.io.IOException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IOException {
        registration obj1 = new registration();
        login obj2 = new login();
        Scanner sc = new Scanner(System.in);
        System.out.println("-----------------------------------------------------");
        System.out.println("Welcome to Registration and Login System");
        System.out.println("-----------------------------------------------------");
        System.out.println("Are you our existing Customer ?");
        System.out.println("Enter L to login");
        System.out.println("-----------------------------------------------------");
        System.out.println("Are you new here ?");
        System.out.println("Enter R to register yourself");
        System.out.println("-----------------------------------------------------");
        char choice = sc.nextLine().charAt(0);
        if(choice == 'L' || choice == 'l'){
            login.main();
        }
        else if(choice == 'R' || choice == 'r'){
            registration.main();

        }
        else {
            System.out.println("Wrong choice!");
        }

    }
}
