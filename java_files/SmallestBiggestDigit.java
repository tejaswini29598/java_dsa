//Find smallest/biggest digit in a number
import java.util.*;
public class SmallestBiggestDigit {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter a number:");
        int number = scanner.nextInt();
        int smallest = 9;
        int biggest = 0;
        while (number > 0) {
            int digit = number % 10;
            if (digit < smallest) {
                smallest = digit;
            }
            if (digit > biggest) {
                biggest = digit;
            }
            number /= 10;
        }
        System.out.println("Smallest digit: " + smallest);
        System.out.println("Biggest digit: " + biggest);
    }
}
