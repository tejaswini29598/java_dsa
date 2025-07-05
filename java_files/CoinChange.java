import java.util.*;
public class CoinChange {
    public static int change(int[] coins,int target){
        int max =target+1;
        int[] dp=new int[target+1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for(int i=1;i<=target;i++){
            for(int coin : coins){ //coins : 1 2 5
                if(i-coin >=0){
                    dp[i] = Math.min(dp[i],dp[i-coin]+1);
                }
            }
        }
        return dp[target]>target? -1:dp[target];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n value");
        int n=scanner.nextInt();
        System.out.println("Enter target");
        int m=scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter values");
        int[] array =new int[n];
        for(int i=0;i<array.length;i++){
            array[i]=scanner.nextInt();
        }
        System.out.print(change(array,m));
        }
}
/*
 * n = 3
target = 11
coins = [1, 2, 5]
Initialization:
max = target + 1 = 12
dp = new int[target+1] → dp[0...11]
Arrays.fill(dp, max) → All values set to 12
dp[0] = 0 (0 coins needed to make 0)
Main Logic:
For each amount i from 1 to 11, and for each coin:

i = 1
coin = 1: 1-1=0 >=0 → dp[1] = min(12, dp[0]+1) = min(12, 1) = 1
coin = 2: 1-2<0 → skip
coin = 5: 1-5<0 → skip
i = 2
coin = 1: 2-1=1 >=0 → dp[2] = min(12, dp[1]+1) = min(12, 2) = 2
coin = 2: 2-2=0 >=0 → dp[2] = min(2, dp[0]+1) = min(2, 1) = 1
coin = 5: 2-5<0 → skip
i = 3
coin = 1: 3-1=2 >=0 → dp[3] = min(12, dp[2]+1) = min(12, 2) = 2
coin = 2: 3-2=1 >=0 → dp[3] = min(2, dp[1]+1) = min(2, 2) = 2
coin = 5: 3-5<0 → skip
i = 4
coin = 1: dp[4] = min(12, dp[3]+1) = min(12, 3) = 3
coin = 2: dp[4] = min(3, dp[2]+1) = min(3, 2) = 2
coin = 5: skip
i = 5
coin = 1: dp[5] = min(12, dp[4]+1) = min(12, 3) = 3
coin = 2: dp[5] = min(3, dp[3]+1) = min(3, 3) = 3
coin = 5: dp[5] = min(3, dp[0]+1) = min(3, 1) = 1
Continue up to i = 11...
Final dp array:
After all iterations, dp will look like:

dp[11] = 3 (minimum coins to make 11)
Return value:
If dp[target] > target, return -1 (not possible)
Else, return dp[target]
For this example, output is 3 (11 = 5 + 5 + 1).

Summary of logic:
For each amount up to target, try every coin.
Update dp[i] to the minimum coins needed.
Use dp[i-coin] + 1 to represent using one more coin.
The answer is in dp[target].
 */