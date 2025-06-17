import java.util.Scanner;

public class MNPrimeNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input the range
        System.out.print("Enter the starting number (m): ");
        int m = sc.nextInt();

        System.out.print("Enter the ending number (n): ");
        int n = sc.nextInt();

        System.out.println("\nPrime numbers between " + m + " and " + n + " are:");

        for (int i = m; i <= n; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }

    // Method to check if a number is prime
    public static boolean isPrime(int num) {
        if (num <= 1)
            return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }

        return true;
    }
}

