import java.util.Scanner;

class BMI_Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double weight, height = 0.0;
        double bmi = 0.0;
        System.out.println("--------------------------------------------------");
        System.out.println("----------------Body Mass Calculator--------------");
        System.out.println("--------------------------------------------------");
        System.out.println("Choose your desired measurement system: ");
        System.out.println("1. Weight in kilograms and Height in meters");
        System.out.println("2. Weight in pounds and Height in inches");
        System.out.println("Enter you choice....");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:             // case to calculate BMI in Kilograms and Meter
                System.out.println("Enter your Weight in Kilograms (Kgs) : ");
                weight = sc.nextDouble();
                System.out.println("Enter your Height in meters (m) : ");
                height = sc.nextDouble();
                bmi = (weight / (height * height));
                break;

            case 2:               // case to calculate BMI in Pounds and Inches
                System.out.println("Enter your Weight in Pounds (lbs) : ");
                weight = sc.nextDouble();
                System.out.println("Enter your Height in inches (in) : ");
                height = sc.nextDouble();
                bmi = 703 * (weight / (height * height));
                break;

            default:
                System.out.println("Oops! Wrong choice");
        }
        System.out.println("--------------------------------------------------");
        System.out.print("Your BMI according to your height and weight is : ");
        System.out.printf("%.2f%n", bmi);
        if(bmi<16){       // Further description about user's BMI
            System.out.println("You are Severely Underweight, so you may need to put on some weight.");
        }
        else if((16<=bmi)&&(bmi<=18.4)){
            System.out.println("You are Underweight");
        }
        else if((18.5<=bmi)&&(bmi<=24.9)){
            System.out.println("You are Normal, you are at a healthy weight for your height.");
        }
        else if((25<=bmi)&&(bmi<=29.9)){
            System.out.println("You are Overweight, you may be advised to lose some weight.");
        }
        else if((30<=bmi)&&(bmi<=34.9)){
            System.out.println("You are Moderately Obese, you may be advised to lose some weight.");
        }
        else if((35<=bmi)&&(bmi<=39.9)){
            System.out.println("You are Severely Obese, you are advised to lose some weight.");
        }
        else{
            System.out.println("You are Morbidly Obese, your health may be at risk if you do not lose weight.");
        }
        System.out.println("--------------------------------------------------");

    }
}



