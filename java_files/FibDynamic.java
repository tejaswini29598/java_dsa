/* fibnocci series using tabulition(loops)  in dynamic programming
 * in this we start solving from '0'th term of n
 */
/*import java.util.*;
public class FibDynamic {
    private static int fib(int n){
       int[] table = new int[n];
       if(n==0) return 0;
       table[0] = 1;
       table[1]=1;
       for(int i=2;i<n;i++){
        table[i] = table[i-1]+table[i-2];
       }
        return table[n-1];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
       System.out.print(fib(n));
    }
}
*/

 /* using memorization (recursion)
  * in this we start solving from 'n';
  */
  import java.util.*;
public class FibDynamic {
    private static int fib(int n,int[] memo){
        if (n <= 1) return n; // Base cases: fib(0)=0, fib(1)=1
        if (memo[n] != -1) return memo[n]; // Return  result if available
        memo[n] = fib(n - 1, memo) + fib(n - 2, memo); // Store result in memo
        return memo[n];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       int n = scanner.nextInt();
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1); // Initialize memo array with -1
        System.out.print(fib(n, memo));
    }
}
 