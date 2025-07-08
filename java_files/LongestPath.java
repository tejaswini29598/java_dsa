import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LongestPath {
    static List<List<Integer>> tree; // Adjacency list to represent the tree
    static int diameter = 0; // Stores the maximum diameter found

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Number of nodes in the tree

        tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) // Initialize adjacency list for each node (1-based indexing)
            tree.add(new ArrayList<>());

        for (int i = 0; i < n - 1; i++) { // Read n-1 edges
            int u = sc.nextInt();
            int v = sc.nextInt();
            tree.get(u).add(v); // Add edge u-v
            tree.get(v).add(u); // Add edge v-u (undirected)
        }

        dfs(1, -1); // Start DFS from node 1, with no parent (-1) is root
        System.out.println(diameter); // Print the diameter of the tree
    }

    // DFS function returns the depth of the subtree rooted at 'node'
    static int dfs(int node, int parent) {
        int max1 = 0, max2 = 0; // Store the two largest depths among children
        for (int child : tree.get(node)) {
            if (child == parent) continue; // Skip the parent node to avoid cycles
            int d = dfs(child, node) + 1; // Depth from this child
            if (d > max1) { // Update max1 and max2 if needed
                max2 = max1;
                max1 = d;
            } else if (d > max2) {
                max2 = d;
            } 
        }
        diameter = Math.max(diameter, max1 + max2); // Update diameter if a longer path is found
        return max1; // Return the largest depth to parent call
    }
}