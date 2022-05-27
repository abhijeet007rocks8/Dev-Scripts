//Importing files
import java.io.FileWriter;
import java.io.IOException;

//Class User_Info
class User_Info extends Registration_Login {
    //Variable Money
    int money;

    //Constructor to create file username.txt and to write initial values in it
    User_Info(String name, String username, String password, String number,String transaction,String FilePath) {
        super(name, username, password, number);
        this.money = 0;
        try {
            FileWriter fwrite = new FileWriter(FilePath + this.getUsername() + ".txt",true);
            fwrite.write(this.money + "\r\n" + this.getName() + "\r\n" + this.getUsername() + "\r\n"+ this.getPassword() + "\r\n" + this.getNumber() + "\r\n"+transaction+"\r\n");
            fwrite.close();
            // System.out.println("Content is successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("Unexpected error occurred");
            e.printStackTrace();
        }
    }

    //Message that will be shown on successful registration
    void message() {
        System.out.println("USER REGISTERED SUCCESFULLY !");
    }
}