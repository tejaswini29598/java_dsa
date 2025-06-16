//Find sum of 1st and last digits in a number
import  java.util.*;
public class SumOfFirstLast {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        System.out.println("Enter a number:");
        int number = scanner.nextInt();
        int firstDigit = 0;
        int lastDigit = number % 10;
        while (number > 0) {
            firstDigit = number % 10;
            number /= 10;
        }
        int sum = firstDigit + lastDigit;
        System.out.println("Sum of first and last digits: " + sum);
    }
}
