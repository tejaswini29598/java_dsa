//tabulation approach(Bottom-up)
/* in this we start solving from '0'th term of n
 * In tabulation (bottom-up dynamic programming), you do NOT use recursion.
Instead, you use loops to fill up a table (usually an array) from the base cases up to the desired value.
 */
import java.util.*;
public class ClimbingStairs {
    public static int stepWays(int n){
        if(n <= 2) return n; // 1 stair: 1 way, 2 stairs: 2 ways
        int prev = 2;  // ways to reach (n-1)th stair
        int prev2 = 1; // ways to reach (n-2)th stair
        int current = 0;
        for(int i = 3; i <= n; i++){
            current = prev + prev2; // sum of previous two
            prev2 = prev;
            prev = current;
        }
        return current;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n value:");
        int n = scanner.nextInt();
        System.out.println("No of ways:");
        System.out.print(stepWays(n)); //bottom-up
        scanner.close();
    }
}
/* 
 *private staic int findCount(int n){
   int[] table = new int[n+1];
   table[1]=1;
   table[2]=2;
   for(int i=3;i<=n;i++){
    table[i] = table[i-1]+table[i-2];
    }
    return table[n];
   }
 */

/* 
Using memorization
in this we start solving from 'n';
To use the memoization (top-down) approach for the Climbing Stairs problem, you use recursion and store results of subproblems in an array (or map) to avoid recomputation
  import java.util.*;
public class ClimbingStairs {
    // Helper function for memorization
    public static int steps(int n, int[] memo) {
        if (n <= 2) return n; // Base cases
        if (memo[n] != -1) return memo[n]; // Return  result if available
        memo[n] = steps(n - 1, memo) + steps(n - 2, memo); // Store result
        return memo[n];
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n value:");
        int n = scanner.nextInt();
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1); // Initialize memo array with -1
        System.out.println("output:");
        System.out.print(steps(n, memo));
        scanner.close();
    }
}
 */