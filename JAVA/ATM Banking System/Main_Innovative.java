//Imports
import java.io.BufferedReader;
import java.io.Console;
import java.util.Date;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

//Class that contains main and to replace string in file
public class Main_Innovative {
    // Main class
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);

        String FilePath = "./";

        boolean b = true;
        // Menu for register,login and to exit
        while (b) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            System.out.println("\n-----WELCOME TO ATM-----");
            System.out.println("1. Register New User");
            System.out.println("2. Login for existing user");
            System.out.println("3. Exit Program");
            System.out.print("Enter Choice : ");
            // int choice = sc.nextInt();
            int choice = 3;
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
            }
            // System.out.println();
            brea: {
                // Register with name,username, password, phone and check if account already
                // exist
                if (choice == 1) {

                    System.out.println("Enter Name : ");
                    sc.nextLine();
                    String name = sc.nextLine();

                    System.out.println("Enter Username : ");
                    String username = sc.nextLine();

                    File file = new File(FilePath + username + ".txt");
                    if (file.exists()) {
                        System.out.println("Username Already Taken !");
                        System.out.println("\nPress enter to continue");
                        try {
                            System.in.read();
                        } catch (Exception e) {
                        }
                        break brea;
                    }

                    // System.out.println("Enter Password : ");
                    // String password=sc.nextLine();
                    Console console = System.console();
                    if (console == null) {
                        System.out.println("Couldn't get Console instance");
                        System.exit(0);
                    }
                    char[] passwordArray = console
                            .readPassword("Enter your secret password: (It won't show due to security reasons) \n");
                    String password = new String(passwordArray);
                    // System.out.println(password);
                    System.out.println("Password Length : " + password.length() + ".");

                    System.out.println("Enter Phone Number : ");
                    String number = sc.nextLine();

                    User_Info reg = new User_Info(name, username, password, number, "TRANSACTION:0", FilePath);
                    reg.message();

                    System.out.println("\nPress enter to continue");
                    try {
                        System.in.read();
                    } catch (Exception e) {
                    }

                }
                // Login with username and password
                else if (choice == 2) {
                    System.out.println();
                    System.out.println("Enter Username : ");
                    sc.nextLine();
                    String username = sc.nextLine();

                    Console console = System.console();
                    if (console == null) {
                        System.out.println("Couldn't get Console instance");
                        System.exit(0);
                    }
                    char[] passwordArray = console
                            .readPassword("Enter your secret password: (It won't show due to security reasons) \n");
                    String password = new String(passwordArray);

                    boolean bool = true;

                    File file = new File(FilePath + username + ".txt");
                    // If login successful
                    if (file.exists()) {
                        try {
                            // Take file data in variables
                            Scanner dataReader = new Scanner(file);
                            String money = dataReader.nextLine();
                            int login_money = Integer.parseInt(money);
                            String login_name = dataReader.nextLine();
                            String login_username = dataReader.nextLine();
                            String login_password = dataReader.nextLine();
                            String number = dataReader.nextLine();
                            String login_transaction = dataReader.nextLine();
                            if (username.equals(login_username) && password.equals(login_password)) {

                                // -----------------------------------------------------------------

                                boolean bo = true;
                                // Menu for logged in customers
                                while (bo) {
                                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                                    System.out.println("Welcome " + login_name + " !");
                                    System.out.println("\n**** OPERATIONS ****");
                                    System.out.println("1. Deposit Money");
                                    System.out.println("2. Withdraw Money");
                                    System.out.println("3. View Details/Balance");
                                    System.out.println("4. View Transaction History");
                                    System.out.println("5. Transfer to other account");
                                    System.out.println("6. Logout ");
                                    System.out.print("Enter Choice : ");
                                    int choice2 = sc.nextInt();
                                    System.out.println();

                                    // Deposit Method
                                    if (choice2 == 1) {
                                        System.out.println("Enter Amount to Deposit : (Limit : 50,000)");
                                        int amount = sc.nextInt();
                                        // Validation
                                        if (amount < 0 || amount > 50000) {
                                            System.out.println("Enter correct amount !");
                                            System.out.println("\nPress enter to continue");
                                            try {
                                                System.in.read();
                                            } catch (Exception e) {
                                            }
                                        } else {
                                            try {
                                                // Open file, Replace original amount with updated with time also
                                                FileWriter f0 = new FileWriter(FilePath + username + ".txt", true);
                                                String old_money = Integer.toString(login_money);
                                                login_money += amount;
                                                int temp = amount;
                                                String to_be_deposited = Integer.toString(login_money);
                                                modifyFile(FilePath + username
                                                        + ".txt", old_money, to_be_deposited);

                                                SimpleDateFormat formatter = new SimpleDateFormat(
                                                        "dd/MM/yyyy HH:mm:ss");
                                                Date date = new Date();
                                                f0.write("Rs.(+" + temp + ") :: " + formatter.format(date)
                                                        + " :: Self Deposit " + "\n");

                                                login_transaction = "TRANSACTION:1";
                                                modifyFile(FilePath + username + ".txt", "TRANSACTION:0",
                                                        "TRANSACTION:1");

                                                System.out.println("Rs. " + temp + " Deposited !");

                                                System.out.println("\nPress enter to continue");
                                                try {
                                                    System.in.read();
                                                } catch (Exception e) {
                                                }

                                                f0.close();
                                            } catch (IOException e) {
                                                System.out.println("User Data not found !");
                                                e.printStackTrace();
                                            }
                                        }
                                    }
                                    // Withdraw method
                                    else if (choice2 == 2) {
                                        System.out.println(
                                                "Enter Amount to Withdraw : (Limit : 0 to " + login_money + ")");
                                        int amount_withdraw = sc.nextInt();
                                        // Validation
                                        if (amount_withdraw < 0 || amount_withdraw > login_money) {
                                            System.out.println("Enter correct amount !");
                                            System.out.println("\nPress enter to continue");
                                            try {
                                                System.in.read();
                                            } catch (Exception e) {
                                            }
                                        } else {
                                            try {
                                                // Open file, Replace original amount with updated with time also
                                                FileWriter f0 = new FileWriter(FilePath + username + ".txt", true);
                                                String old_money = Integer.toString(login_money);
                                                login_money -= amount_withdraw;
                                                int temp1 = amount_withdraw;
                                                String to_be_withdrawed = Integer.toString(login_money);
                                                modifyFile(FilePath + username + ".txt", old_money, to_be_withdrawed);

                                                SimpleDateFormat formatter = new SimpleDateFormat(
                                                        "dd/MM/yyyy HH:mm:ss");
                                                Date date = new Date();
                                                f0.write("Rs.(-" + temp1 + ") :: " + formatter.format(date)
                                                        + " :: Self Withdraw" + "\n");

                                                login_transaction = "TRANSACTION:1";
                                                modifyFile(FilePath + username + ".txt", "TRANSACTION:0",
                                                        "TRANSACTION:1");

                                                System.out.println("Rs. " + temp1 + " Withdrawed !");

                                                System.out.println("\nPress enter to continue");
                                                try {
                                                    System.in.read();
                                                } catch (Exception e) {
                                                }

                                                f0.close();
                                            } catch (IOException e) {
                                                System.out.println("User Data not found !");
                                                e.printStackTrace();
                                            }
                                        }
                                    }
                                    // Shwo all details from variables that we stored file contents
                                    else if (choice2 == 3) {
                                        System.out.println("\nDetails :");
                                        System.out.println("1. Name      : " + login_name);
                                        System.out.println("2. Username  : " + login_username);
                                        System.out.printf("3. Password  : ");
                                        for (int i = 0; i < login_password.length(); i++) {
                                            System.out.printf("*");
                                        }
                                        System.out.println();
                                        System.out.println("4. Phone No. : " + number);
                                        System.out.println("5. Balance   : " + login_money + " Rs.");

                                        System.out.println("\nPress enter to continue");
                                        try {
                                            System.in.read();
                                        } catch (Exception e) {
                                        }
                                    }
                                    // Transaction history (Show only if TRANSACTION:1 is there, Don't show if
                                    // TRANSACTION:0 is there in file variable)
                                    else if (choice2 == 4) {
                                        try {
                                            File f1 = new File(FilePath + username + ".txt");
                                            dataReader = new Scanner(f1);
                                            System.out.println("Transaction History : ");
                                            String temp = "TRANSACTION:0";
                                            if (login_transaction.equals(temp)) {
                                                System.out.println("No Transaction History is there !");
                                                System.out.println("\nPress enter to continue");
                                                try {
                                                    System.in.read();
                                                } catch (Exception e) {
                                                }
                                            } else {
                                                for (int j = 0; j < 6; j++) {
                                                    dataReader.nextLine();
                                                }
                                                while (dataReader.hasNextLine()) {
                                                    String fileData = dataReader.nextLine();
                                                    System.out.println(fileData);
                                                }
                                                System.out.println("\nPress enter to continue");
                                                try {
                                                    System.in.read();
                                                } catch (Exception e) {
                                                }
                                            }
                                            dataReader.close();
                                        } catch (FileNotFoundException exception) {
                                            System.out.println("Unexcpected error occurred!");
                                            exception.printStackTrace();
                                            System.out.println("\nPress enter to continue");
                                            try {
                                                System.in.read();
                                            } catch (Exception e) {
                                            }
                                        }
                                    }
                                    // Transfer to other account with username and update amount and transaction
                                    // history in both user account
                                    else if (choice2 == 5) {
                                        System.out.println();
                                        System.out.println("Enter Username of other account: ");
                                        sc.nextLine();
                                        String username_to_transfer = sc.nextLine();

                                        File file_to_transfer = new File(FilePath + username_to_transfer + ".txt");
                                        if (file_to_transfer.exists()) {
                                            dataReader = new Scanner(file_to_transfer);
                                            Scanner dataReader2 = new Scanner(file_to_transfer);
                                            String money_old = dataReader2.nextLine();
                                            String name_transfer = dataReader2.nextLine();
                                            int money_old_user = Integer.parseInt(money_old);
                                            System.out.println(
                                                    "Enter Amount to Transfer : (Limit : 0 to " + login_money + ")");
                                            int amount_transfer_update = sc.nextInt();

                                            if (amount_transfer_update <= 0 || amount_transfer_update > login_money) {
                                                System.out.println("Enter correct amount !");
                                                System.out.println("\nPress enter to continue");
                                                try {
                                                    System.in.read();
                                                } catch (Exception e) {
                                                }
                                            } else {
                                                String to_upd = Integer.toString(login_money);
                                                login_money -= amount_transfer_update;
                                                String to_upd2 = Integer.toString(login_money);
                                                modifyFile(FilePath + username + ".txt", to_upd, to_upd2);

                                                String to_update = Integer.toString(money_old_user);
                                                money_old_user += amount_transfer_update;
                                                String to_update_2 = Integer.toString(money_old_user);
                                                modifyFile(FilePath + username_to_transfer + ".txt", to_update,
                                                        to_update_2);
                                                modifyFile(FilePath + username_to_transfer + ".txt", "TRANSACTION:0",
                                                        "TRANSACTION:1");
                                                try {
                                                    FileWriter f11 = new FileWriter(
                                                            FilePath + username_to_transfer + ".txt", true);
                                                    SimpleDateFormat formatter = new SimpleDateFormat(
                                                            "dd/MM/yyyy HH:mm:ss");
                                                    Date date = new Date();
                                                    f11.write("Rs.(+" + amount_transfer_update + ") :: "
                                                            + formatter.format(date) + " :: Transferred from "
                                                            + username + " (" + login_name + ")\n");
                                                    f11.close();

                                                    FileWriter f12 = new FileWriter(FilePath + username + ".txt", true);
                                                    SimpleDateFormat formatter2 = new SimpleDateFormat(
                                                            "dd/MM/yyyy HH:mm:ss");
                                                    Date date2 = new Date();
                                                    f12.write("Rs.(-" + amount_transfer_update + ") :: "
                                                            + formatter2.format(date2) + " :: Transferred to "
                                                            + username_to_transfer + " (" + name_transfer + ")\n");
                                                    f12.close();

                                                    System.out.println("Rs.(" + amount_transfer_update
                                                            + ") Transferred to " + username_to_transfer + " ( "
                                                            + name_transfer + " )");
                                                    System.out.println("\nPress enter to continue");
                                                    try {
                                                        System.in.read();
                                                    } catch (Exception e) {
                                                    }

                                                } catch (IOException e) {
                                                    System.out.println("User Data not found !");
                                                    e.printStackTrace();
                                                }
                                            }

                                            dataReader2.close();
                                        } else {
                                            System.out.println("USER DON'T EXISTS !");
                                            System.out.println("\nPress enter to continue");
                                            try {
                                                System.in.read();
                                            } catch (Exception e) {
                                            }
                                        }
                                    } else {
                                        break brea;
                                    }
                                }
                                sc.close();

                                // -------------------------------------------------------------------

                                bool = false;
                                break brea;
                            }

                            dataReader.close();
                        } catch (FileNotFoundException e) {
                            System.out.println("File not found !");
                            e.printStackTrace();
                            System.out.println("\nPress enter to continue");
                            try {
                                System.in.read();
                            } catch (Exception f) {
                            }
                        }
                    } else {
                        System.out.println("User not registered!");
                        System.out.println("\nPress enter to continue");
                        try {
                            System.in.read();
                        } catch (Exception e) {
                        }
                    }

                    if (bool) {
                        System.out.println("Username or Password Incorrect !\nPlease Try Again");
                        System.out.println("\nPress enter to continue");
                        try {
                            System.in.read();
                        } catch (Exception e) {
                        }
                        break brea;
                    }
                } else if (choice == 3) {
                    System.out.println("\n***** Thank you for using ATM *****");
                    System.out.println("\nPress enter to continue");
                    try {
                        System.in.read();
                    } catch (Exception e) {
                    }
                    sc.close();
                    b = false;
                } else {
                    System.out.println("Enter correct number input !");
                    System.out.println("\nPress enter to continue");
                    try {
                        System.in.read();
                    } catch (Exception e) {
                    }
                }
            }
            System.out.println();
        }
    }

    // Replacing string in file function (static)
    static void modifyFile(String filePath, String oldString, String newString) {
        // File fileToBeModified = new File(filePath);
        String oldContent = "";
        BufferedReader reader = null;
        // FileWriter writer = null;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            // Reading all the lines of input text file into oldContent
            String line = reader.readLine();
            while (line != null) {
                oldContent = oldContent + line + System.lineSeparator();

                line = reader.readLine();
            }
            // Replacing oldString with newString in the oldContent
            String newContent = oldContent.replaceFirst(oldString, newString);

            // Rewriting the input text file with newContent
            new FileWriter(filePath, false).close();
            FileWriter writer = new FileWriter(filePath);
            writer.write(newContent);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // Closing the resources
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}