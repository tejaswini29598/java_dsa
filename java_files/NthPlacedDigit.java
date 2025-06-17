//Find nth placed digit in a number
import java.util.Scanner;
public class NthPlacedDigit {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        System.out.println("Enter a number:");
        int number = scanner.nextInt();
        System.out.println("Enter the position of the digit");
        int position = scanner.nextInt();
        int digit = findNthPlacedDigit(number, position);
        if (digit != -1) {
            System.out.println("The digit at position " + position + " is: " + digit);
        } else {
            System.out.println("Position out of bounds.");
        }
        scanner.close();
    }
    public static int findNthPlacedDigit(int number, int position) {
        number = Math.abs(number);
        for (int i = 1; i < position; i++) {
            if (number == 0) {
                return -1; 
            }
            number /= 10;
        }
        if (number == 0) {
            return -1;
        }
        return number % 10;
    }
}
