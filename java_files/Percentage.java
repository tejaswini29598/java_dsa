import java.util.*;
public class Percentage {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
       /*     System.out.println("Enter marks:");
            int inputNumber=scanner.nextInt();
            int inputNumber1=scanner.nextInt();
            int inputNumber2=scanner.nextInt();
            int average = (inputNumber + inputNumber1 +inputNumber2) / 3;
            System.out.println("Average "+average);
            if(average>=0 average<=59){
                System.out.println("FAIL");
            }
            else if(average<=80){
                System.out.println("Second class");
            }
            else if(average<=95){
                System.out.println("First class");
            }
            else if(average<=100){
                System.out.println("Outstanding");
            }
            else{
                System.out.println("Invalid");
            }
        }
    }
    */
     for (int student = 1; student <= 10; student++) {
            System.out.println("Enter marks for Student " + student + ":");
            System.out.print("Subject 1: ");
            int mark1 = scanner.nextInt();
            System.out.print("Subject 2: ");
            int mark2 = scanner.nextInt();
            System.out.print("Subject 3: ");
            int mark3 = scanner.nextInt();

            double average = (mark1 + mark2 + mark3) / 3.0;
            System.out.println("Average marks: " + average);

            if (average >= 90) {
                System.out.println("Excellent!");
            } else if (average >= 75) {
                System.out.println("Very Good!");
            } else if (average >= 60) {
                System.out.println("Good");
            } else if (average >= 40) {
                System.out.println("Pass");
            } else {
                System.out.println("Fail");
            }
        }
    }}
}
