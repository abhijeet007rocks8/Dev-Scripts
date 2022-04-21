import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class QuizApplication {
    public static void main(String[] args) throws IOException, InterruptedException {
        String questions[] = new String[6];
        String answers[] = new String[6];
        String options[] = new String[6];
        Integer[] intArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        List<Integer> intList = Arrays.asList(intArray);
        Collections.shuffle(intList);
        intList.toArray(intArray);
        File ques = new File("ques.txt");
        File ans = new File("ans.txt");
        File opt = new File("options.txt");
        for(int i=0;i<6;i++){
            int rand = intArray[i];
            String quest = Files.readAllLines(Paths.get("ques.txt")).get(rand);
            questions[i] = quest;
            String answ = Files.readAllLines(Paths.get("ans.txt")).get(rand);
            answers[i] = answ;
            String opti = Files.readAllLines(Paths.get("options.txt")).get(rand);
            options[i] = opti;


        }
        Scanner sc = new Scanner(System.in);
        int score = 0;
        int flip = 0;
        System.out.println("----------------------------------------------------");
        System.out.println("------------------Quiz Application------------------");
        System.out.println("----------------------------------------------------");
        Thread.sleep(3000);
        System.out.println("There will be five questions");
        System.out.println("Select the correct option to score a point");
        System.out.println("Answering the question correctly will fetch 1 point");
        System.out.println("Good Luck!");
        Thread.sleep(5000);
        for(int j=0;j<5;j++){
            System.out.println("--------------------------------------------------");
            System.out.println("Question No. "+(j+1)+" Coming up...");
            Thread.sleep(3000);
            System.out.println(questions[j]);
            System.out.println("Take your time...");
            Thread.sleep(2000);
            System.out.println("Here are your options :");
            System.out.println(options[j]);
            System.out.println("Select an option...(case is ignored)");
            if(flip == 0) {
                System.out.println("-------------------------------");
                System.out.println("Can't figure it out? ");
                System.out.println("You can flip the question : )");
                System.out.println("Note : Can be used only ONCE ");
                System.out.println("Enter F to flip the question or select an option");
                System.out.println("-------------------------------");
            }
            char ch = sc.nextLine().charAt(0);
            if(ch == 'F'){
                Thread.sleep(1000);
                System.out.println("Wise decision indeed!");
                flip = 1;
                Thread.sleep(2000);
                System.out.println("Here is your new question");
                System.out.println(questions[5]);
                System.out.println("Take your time...");
                Thread.sleep(2000);
                System.out.println("Here are your options :");
                System.out.println(options[5]);
                System.out.println("Select an option...(case is ignored)");
                ch = sc.nextLine().charAt(0);
                if (Character.toString(ch).toUpperCase().equals(answers[5])) {
                    System.out.println("That's right! Good job...");
                    score++;
                }
                else {
                    System.out.println("Oops! That's incorrect");
                    System.out.println("Answer is Option " + answers[5]);
                    System.out.println("Better luck next time...");
                }
            }
            else {
                if (Character.toString(ch).toUpperCase().equals(answers[j])) {
                    System.out.println("That's right! Good job...");
                    score++;
                } else {
                    System.out.println("Oops! That's incorrect");
                    System.out.println("Answer is Option " + answers[j]);
                    System.out.println("Better luck next time...");
                }
            }
            System.out.println("------------------------------------------------------");
        }
        System.out.println("Hope you had fun!");
        System.out.println("------------------------------------------------------");
        System.out.println("Your Score : "+score);
        System.out.println("------------------------------------------------------");

    }
}
