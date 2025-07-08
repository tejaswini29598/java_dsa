import java.util.Arrays;
import java.util.Scanner;

public class TravelSalesman {
    static int N; // number of cities
    static int[][] dist; // distance 
    static int[][] dp; //every city result
    static final int INF = 1_000_000_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dist = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                dist[i][j] = sc.nextInt();

        int size = 1 << N;
        dp = new int[N][size];
        for (int[] row : dp) Arrays.fill(row, -1);

        System.out.println(tsp(0, 1));
    }
   
    static int tsp(int pos, int mask) {
        // Base case: all cities visited
        if (mask == (1 << N) - 1)
            return dist[pos][0];
         // Memoization: return if already computed
        if (dp[pos][mask] != -1)
            return dp[pos][mask];
        // Try all unvisited cities
        int ans = INF;
        for (int city = 0; city < N; city++) {
            if ((mask & (1 << city)) == 0) { //Checking if the city is included or not
                //using dfs -beacause we are calling function again
                                                            //checking if the city is included or not
                                                          //      ⬇️
                ans = Math.min(ans, dist[pos][city] + tsp(city, mask | (1 << city)));
            }
        }
        return dp[pos][mask] = ans;
    }
}

/* 
 * Bitmask Representation:
Each bit in mask represents whether a city has been visited.

Mask (Decimal)	Mask (Binary)	Cities Visited
1	0001	City 0
3	0011	Cities 0, 1
5	0101	Cities 0, 2
7	0111	Cities 0, 1, 2
15	1111	All 4 cities
Key Bitwise Operations:
1. Check if city is visited:

(mask & (1 << city)) == 0  // Returns true if city NOT visited
2. Mark city as visited:

mask | (1 << city)  // Sets the bit for 'city' to 1
Example: If mask = 5 (binary: 0101) and we visit city 1:

(1 << 1) = 2 (binary: 0010)
5 | 2 = 7 (binary: 0111)
Now cities 0, 1, and 2 are marked as visited
Detailed Example Trace
Input:
4 cities with distance matrix:
    0  1  2  3
0 [ 0 10 15 20]
1 [10  0 35 25]
2 [15 35  0 30]
3 [20 25 30  0]
Initial Call: tsp(0, 1)
Step 1: tsp(0, 1)

pos = 0, mask = 1 (binary: 0001, only city 0 visited)

Not all cities visited, not memoized

Try visiting cities 1, 2, 3:

City 1: 10 + tsp(1, 3) where mask=3 (binary: 0011)
City 2: 15 + tsp(2, 5) where mask=5 (binary: 0101)
City 3: 20 + tsp(3, 9) where mask=9 (binary: 1001)
Step 2: tsp(1, 3)

pos = 1, mask = 3 (cities 0,1 visited)

Try visiting cities 2, 3:

City 2: 35 + tsp(2, 7) where mask=7 (binary: 0111)
City 3: 25 + tsp(3, 11) where mask=11 (binary: 1011)
Step 3: Continue recursion...

Keep exploring until all cities visited
Base case returns distance back to city 0
Memoization prevents recalculating same states
Final Result:
Optimal path: 0 → 1 → 3 → 2 → 0
Total distance: 10 + 25 + 30 + 15 = 80

Algorithm Complexity Analysis
Time Complexity: O(N² × 2^N)
2^N states: Each city can be visited or not (2^N possible masks)
N positions: For each mask, we can be at any of N cities
N transitions: For each state, we try visiting all N cities
Total: N × 2^N × N = N² × 2^N
Space Complexity: O(N × 2^N)
DP table: N × 2^N entries
Recursion stack: At most N levels deep
Key Advantages of This Approach
Efficient State Representation: Bitmasking compactly represents visited cities
Memoization: Prevents redundant calculations of subproblems
Optimal Substructure: Solution to TSP can be built from solutions to smaller subproblems
Handles Constraints: Works well for N ≤ 16 (typical TSP constraint)
Why Bitmasking?
Traditional approaches would require exponential time without efficient state representation. Bitmasking allows us to:

Represent any subset of cities in a single integer
Quickly check if a city is visited using bitwise AND
Efficiently add cities to visited set using bitwise OR
Use the bitmask directly as an index for memoization
This makes the TSP solution both elegant and efficient for the given cons
 */