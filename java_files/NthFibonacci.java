 import java.util.Scanner;

public class NthFibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: Nth term
        System.out.print("Enter the value of N: ");
        int n = sc.nextInt();

        int first = 1, second = 2, next = 0;

        if (n == 1) {
            System.out.println("The " + n + "th Fibonacci term is: " + first);
        } else if (n == 2) {
            System.out.println("The " + n + "th Fibonacci term is: " + second);
        } else {
            for (int i = 3; i <= n; i++) {
                next = first + second;
                first = second;
                second = next;
            }
            System.out.println("The " + n + "th Fibonacci term is: " + next);
        }
    }

 
    
}
