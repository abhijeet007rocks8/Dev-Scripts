import java.util.Scanner;

class Temp_Converter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------------------------------------");
        System.out.println("---------------Temperature Converter--------------");
        System.out.println("--------------------------------------------------");
        System.out.println("Enter Temperature followed by its unit");
        System.out.println("For Celsius : 23C");
        System.out.println("For Fahrenheit : 120F");
        System.out.println("For Kelvin : 273K");
        String temp = sc.nextLine();
        char unit = temp.charAt(temp.length()-1);
        unit = Character.toUpperCase(unit);
        int choice = 0;
        double converted_temp = 0;
        if(Character.isLetter(unit)){
            if((unit=='C')||(unit=='F')||(unit=='K')){
                String value = temp.substring(0,temp.length()-1);
                double temp_value = Double.parseDouble(value);
                if(unit=='C'){
                    System.out.println("The entered temperature is in Celsius");
                    System.out.println("Enter 1 to convert Celsius to Fahrenheit");
                    System.out.println("Enter 2 to convert Celsius to Kelvin");
                    choice = sc.nextInt();
                    switch (choice){
                        case 1: converted_temp = (temp_value*1.8)+32;
                                System.out.println("Temperature in Fahrenheit is : ");
                                System.out.printf("%.2f%n", converted_temp);
                                break;
                        case 2: converted_temp = temp_value + 273;
                                System.out.println("Temperature in Kelvin is : ");
                                System.out.printf("%.2f%n", converted_temp);
                                break;
                        default:
                            System.out.println("Invalid choice");
                    }
                }
                if(unit=='F'){
                    System.out.println("The entered temperature is in Fahrenheit");
                    System.out.println("Enter 1 to convert Fahrenheit to Celsius");
                    System.out.println("Enter 2 to convert Fahrenheit to Kelvin");
                    choice = sc.nextInt();
                    switch (choice){
                        case 1: converted_temp = (temp_value-32)*.556;
                                System.out.println("Temperature in Celsius is : ");
                                System.out.printf("%.2f%n", converted_temp);
                                break;
                        case 2: converted_temp = (temp_value-32)*.556;
                                converted_temp = converted_temp + 273;
                                System.out.println("Temperature in Kelvin is : ");
                                System.out.printf("%.2f%n", converted_temp);
                                break;
                        default:
                            System.out.println("Invalid choice");
                    }
                }
                if(unit=='K'){
                    System.out.println("The entered temperature is in Kelvin");
                    System.out.println("Enter 1 to convert Kelvin to Fahrenheit");
                    System.out.println("Enter 2 to convert Kelvin to Celsius");
                    choice = sc.nextInt();
                    switch (choice){
                        case 1: converted_temp = temp_value - 273;
                                converted_temp = (converted_temp*1.8)+32;
                                System.out.println("Temperature in Fahrenheit is : ");
                                System.out.printf("%.2f%n", converted_temp);
                                break;
                        case 2: converted_temp = temp_value-273;
                                System.out.println("Temperature in Celsius is : ");
                                System.out.printf("%.2f%n", converted_temp);
                                break;
                        default:
                            System.out.println("Invalid choice");
                    }
                }
            }
            else {
                System.out.println("Wrong unit used!");
            }

        }
        else {
            System.out.println("Unit not defined!");
        }


    }
}




