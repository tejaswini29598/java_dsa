//find sum of odd digits of a number 2345=8(3+5)
/* in python 45/7= 6.428571428571429 45//7 = 6 */
import java.util.*;
public class SumOfOddDigits {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        System.out.println("Enter a number");
        int inputNumber = scanner.nextInt();
        int sum=0;
        while(inputNumber != 0) {
            int remainderDigit = inputNumber % 10;
            if(remainderDigit % 2 != 0) {
                sum += remainderDigit;
            }
            inputNumber /= 10;
        }
        System.out.println("The sum of odd digits is: " + sum);
        scanner.close();
    }
}
