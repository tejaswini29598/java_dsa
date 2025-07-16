//Java Solution: DFS using recursion
/* 
import java.util.*;

public class FindPathInUndirectedGraph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int start = sc.nextInt();
        int end = sc.nextInt();
        boolean[] visited = new boolean[n];
        System.out.println(dfs(adj, visited, start, end) ? "Yes" : "No");
    }

    private static boolean dfs(List<List<Integer>> adj, boolean[] visited, int curr, int target) {
        if (curr == target) return true;
        visited[curr] = true;
        for (int neighbor : adj.get(curr)) {
            if (!visited[neighbor]) {
                if (dfs(adj, visited, neighbor, target)) return true;
            }
        }
        return false;
    }
}
*/

/*Java Solution : BFS using queue

import java.util.*;

public class FindPathInUndirectedGraphBFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int start = sc.nextInt();
        int end = sc.nextInt();
        System.out.println(bfs(adj, n, start, end) ? "Yes" : "No");
    }

    private static boolean bfs(List<List<Integer>> adj, int n, int start, int end) {
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (node == end) return true;
            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
        return false;
    }
}

---

Java Solution: DFS using stack (no recursion)

import java.util.*;

public class FindPathInUndirectedGraphDFSIterative {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int start = sc.nextInt();
        int end = sc.nextInt();
        System.out.println(dfsIterative(adj, n, start, end) ? "Yes" : "No");
    }

    private static boolean dfsIterative(List<List<Integer>> adj, int n, int start, int end) {
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (node == end) return true;
            if (!visited[node]) {
                visited[node] = true;
                for (int neighbor : adj.get(node)) {
                    if (!visited[neighbor]) {
                        stack.push(neighbor);
                    }
                }
            }
        }
        return false;
    }
}
    */
import java.util.*;

public class FindPathInUndirectedGraph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt(); // Number of nodes
        int m = sc.nextInt(); // Number of edges

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            //representing an undirected edge between nodes u and v.
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        //representing the nodes between which you need to determine if a path exists.
        int start = sc.nextInt();
        int end = sc.nextInt();

        boolean[] visited = new boolean[n];
        List<Integer> path = new ArrayList<>();

        if (dfs(adj, visited, start, end, path)) {
            System.out.println(path);
        } else {
            System.out.println("[]");
        }
    }

    private static boolean dfs(List<List<Integer>> adj, boolean[] visited, int curr, int target, List<Integer> path) {
        visited[curr] = true;
        path.add(curr);

        if (curr == target) return true;

        for (int neighbor : adj.get(curr)) {
            if (!visited[neighbor]) {
                if (dfs(adj, visited, neighbor, target, path)) return true;
            }
        }

        path.remove(path.size() - 1); // Backtrack
        return false;
    }
}
