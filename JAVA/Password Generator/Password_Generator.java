import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

class Password_Generator {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------------------------------------");
        System.out.println("-----------------Password Generator----------------");
        System.out.println("--------------------------------------------------");
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String number = "1234567890";
        String special_chr = "~`!@#$%^&*()_-+={[}]|:;'<,>.?/";
        StringBuilder password = new StringBuilder();
        File pass = new File("password.txt");
        if(!pass.exists()) {
            pass.createNewFile();
        }
        FileWriter fileWritter = new FileWriter(pass.getName(),true);
        BufferedWriter bw = new BufferedWriter(fileWritter);
        System.out.println("Enter the length of the password required");
        int n = sc.nextInt();
        System.out.println("Enter '1' to enable special characters  and '0' to disable them");
        int choice = sc.nextInt();
        int temp = 0;
        int count = 0;
        switch (choice) {
            case 1:
                for (int i = 0; i < n; i++) {
                    int s = (int) ((Math.random() * 4) + 1);

                    if (s == 1) {
                        temp = (int) ((Math.random() * 25) + 1);
                        password.append(upper.charAt(temp));
                    }
                    if (s == 2) {
                        temp = (int) ((Math.random() * 25) + 1);
                        password.append(lower.charAt(temp));
                    }
                    if (s == 3) {
                        temp = (int) ((Math.random() * 9) + 1);
                        password.append(number.charAt(temp));
                    }
                    if (s == 4) {
                        temp = (int) ((Math.random() * 29) + 1);
                        password.append(special_chr.charAt(temp));
                    }

                }
                break;

            case 0:
                for (int i = 0; i < n; i++) {
                    int s = (int) ((Math.random() * 3) + 1);

                    if (s == 1) {
                        temp = (int) ((Math.random() * 25) + 1);
                        password.append(upper.charAt(temp));
                    }
                    if (s == 2) {
                        temp = (int) ((Math.random() * 25) + 1);
                        password.append(lower.charAt(temp));
                    }
                    if (s == 3) {
                        temp = (int) ((Math.random() * 9) + 1);
                        password.append(number.charAt(temp));
                    }

                }
                break;
            default:
                System.out.println("Wrong input!");
                count = 1;

        }
        if (count == 0) {
            System.out.println("-----------------------------------------------------");
            System.out.println("Password Generated : " + password);
            System.out.println("-----------------------------------------------------");
            System.out.println("Do you want to save this password? Y/N");
            sc.nextLine();
            char ch = sc.nextLine().charAt(0);
            if(ch == 'Y' || ch =='y'){
                System.out.println("Enter some phrase to later recognize this password. eg : facebook password");
                String passphrase = sc.nextLine();
                bw.write(passphrase+":  "+ String.valueOf(password));
                bw.write('\n');
                System.out.println("Password successfully saved into password.txt");
                bw.close();
            }


        }
    }

    }









