import java.util.*;
public class knapsack {
    // 0/1 Knapsack recursive solution
    public static int knapsackRec(int[] values, int[] weights, int n, int capacity) {
        if (n == 0 || capacity == 0) return 0;
        if (weights[n - 1] > capacity)
            return knapsackRec(values, weights, n - 1, capacity);
        else
            return Math.max(
                values[n - 1] + knapsackRec(values, weights, n - 1, capacity - weights[n - 1]),
                knapsackRec(values, weights, n - 1, capacity)
            );
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();         // Number of items
        int capacity = scanner.nextInt();  // Knapsack capacity

        int[] values = new int[n];
        int[] weights = new int[n];

        // Read values
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
        }
        // Read weights
        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
        }

        int result = knapsackRec(values, weights, n, capacity);
        System.out.println(result);
        scanner.close();
    }
}