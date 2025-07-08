import java.util.*;
public class MaxPathSum{
public  static int[] values;
    static List<Integer>[] tree;
    static int maxSum = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        values = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            values[i] = sc.nextInt();
        }
        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) tree[i] = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            tree[u].add(v);
            tree[v].add(u);
        }
        dfs(1, -1);
        System.out.println(maxSum);
    }

    // Returns the maximum path sum starting from node u downwards
    static int dfs(int u, int parent) {
        int max1 = 0, max2 = 0; // Top two max child contributions
        for (int v : tree[u]) {
            if (v == parent) continue;
            int childSum = dfs(v, u);
            if (childSum > max1) {
                max2 = max1;
                max1 = childSum;
            } else if (childSum > max2) {
                max2 = childSum;
            }
        }
        // Path through this node (could be just this node, or this node + up to two children)
        int currSum = values[u] + max1 + max2;
        maxSum = Math.max(maxSum, currSum);
        // Return the max path sum starting from this node and going down one branch
        return Math.max(0, values[u] + max1);
    } 
}
