import java.util.*;
public class UniquePaths {
    // Function to calculate unique paths in an n x m grid
    public static int findPath(int n, int m) {
        int[][] dp = new int[n][m];
        // Fill the first row and first column with 1s
        for (int i = 0; i < n; i++) dp[i][0] = 1;
        for (int j = 0; j < m; j++) dp[0][j] = 1;
        // Fill the rest of the dp table
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[n-1][m-1];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        System.out.println(findPath(n, m));
    }
}