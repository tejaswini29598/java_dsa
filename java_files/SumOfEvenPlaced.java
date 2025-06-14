/*find sum of even placed digits of a number
9128735=12(1+8+3)
91827364=10(1+2+3+4) */
import java.util.*;
public class SumOfEvenPlaced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number");
        int inputNumber = scanner.nextInt();
        int sum = 0;
        int position = 1;
        while (inputNumber != 0) {
            int digit = inputNumber % 10;
            if (position % 2 == 0) {
                sum += digit;
            }
            inputNumber /= 10;
            position++;
        }
        System.out.println("The sum of even placed digits is: " + sum);
        scanner.close();
    }
}
