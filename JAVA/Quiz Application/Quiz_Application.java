
import java.io.IOException;
import java.util.*;

class Quiz_Application {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------------------------------------");
        System.out.println("------------------Quiz Application----------------");
        System.out.println("--------------------------------------------------");
        System.out.println("A question will be displayed along with 4 options");
        System.out.println("Choose the correct option to score a point");
        Thread.sleep(3000);
        int score = 0;
            System.out.println("Question No. 1 Coming Up!");
            Thread.sleep(2000);
            System.out.println("Grand Central Terminal, Park Avenue, New York is the world's :");
            System.out.println(" A. largest railway station\n B. highest railway station\n C. longest railway station\n D. None of the above\",");
            System.out.println("Select an option:");
            char ch = sc.next().charAt(0);
            if(ch == 'A' || ch =='a') {
                System.out.println("That's Correct!");
                System.out.println();
                score++;
            }
            else{
                    System.out.println("Oops! That's wrong");
                    System.out.println("Correct Answer : A. largest railway station");
                }

            System.out.println("----------------------------------------------");
            System.out.println("Current Score: "+score);
            System.out.println("----------------------------------------------");
            System.out.println("Question No. 2 Coming Up!");
            Thread.sleep(2000);
            System.out.println("Entomology is the science that studies :");
            System.out.println(" A. Behavior of human beings\n B. Insects\n C. The origin and history of technical and scientific terms\n D. The formation of rocks");
            System.out.println("Select an option:");
            ch = sc.next().charAt(0);
            if(ch == 'B' || ch =='b') {
                System.out.println("That's Correct!");
                System.out.println();
                score++;
            }
            else{
                System.out.println("Oops! That's wrong");
                System.out.println("Correct Answer : B.	Insects");
            }
            System.out.println("----------------------------------------------");
            System.out.println("Current Score: "+score);
            System.out.println("----------------------------------------------");
            System.out.println("Question No. 3 Coming Up!");
            Thread.sleep(2000);
            System.out.println("For which of the following disciplines is Nobel Prize awarded?");
            System.out.println(" A. Physics and Chemistry\n B. Physiology or Medicine\n C. Literature, Peace and Economics\n D. All of the above");
            System.out.println("Select an option:");
            ch = sc.next().charAt(0);
            if(ch == 'D' || ch =='d') {
                System.out.println("That's Correct!");
                System.out.println();
                score++;
            }
            else{
                System.out.println("Oops! That's wrong");
                System.out.println("Correct Answer :  D. All of the above");
            }
            System.out.println("----------------------------------------------");
            System.out.println("Current Score: "+score);
            System.out.println("----------------------------------------------");
            System.out.println("Question No. 4 Coming Up!");
            Thread.sleep(2000);
            System.out.println("Hitler party which came into power in 1933 is known as :");
            System.out.println(" A. Labour Party\n B. Nazi Party\n C. Ku-Klux-Klan\n D. Democratic Party");
            System.out.println("Select an option:");
            ch = sc.next().charAt(0);
            if(ch == 'B' || ch =='b') {
                System.out.println("That's Correct!");
                System.out.println();
                score++;
            }
            else{
                System.out.println("Oops! That's wrong");
                System.out.println("Correct Answer :  B. Nazi Party");
            }
            System.out.println("----------------------------------------------");
            System.out.println("Current Score: "+score);
            System.out.println("----------------------------------------------");
            System.out.println("Question No. 5 Coming Up!");
            Thread.sleep(2000);
            System.out.println("Who is the father of Geometry?");
            System.out.println(" A.Aristotle\n B. Euclid\n C. Pythagoras\n D. Kepler");
            System.out.println("Select an option:");
            ch = sc.next().charAt(0);
            if(ch == 'B' || ch =='b') {
                System.out.println("That's Correct!");
                System.out.println();
                score++;
            }
            else{
                System.out.println("Oops! That's wrong");
                System.out.println("Correct Answer :  B. Euclid");
            }
        System.out.println("----------------------------------------------");
        System.out.println("Final Score : "+score);
        System.out.println("----------------------------------------------");
        }

    }









