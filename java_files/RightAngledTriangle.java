//program to print Right angled TRiangle of N lines.
import java.util.Scanner;
public class RightAngledTriangle {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the number of lines");
            int n = scanner.nextInt();
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    if (j == 1 || j == i || i == n || i == 1) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }

    }
}
