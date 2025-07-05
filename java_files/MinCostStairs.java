import java.util.*;
public class MinCostStairs {
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
       int[] dp = new int[n];

        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        return Math.min(dp[n - 1], dp[n - 2]);
        
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
       // int n=scanner.nextInt();
     scanner.nextLine();
     int[] array = new int[n];
     for (int i = 0; i < array.length; i++) {
         array[i] =scanner.nextInt();
     }
     System.out.print(minCostClimbingStairs(array));
    }
}

