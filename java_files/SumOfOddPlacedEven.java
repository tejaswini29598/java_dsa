//Find sum of Odd placed Even Digits in a number. 
import java.util.*;
public class SumOfOddPlacedEven {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter a number:");
        int number = scanner.nextInt();
        int sum = 0;
        int position = 1; 
        while (number > 0) {
            int digit = number % 10;
            if (position % 2 != 0 && digit % 2 == 0) { 
                sum += digit; 
            }
            number /= 10;
            position++;
        }
        System.out.println("Sum of odd placed even digits: " + sum);
    }
}
