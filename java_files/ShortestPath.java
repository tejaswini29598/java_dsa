import java.util.*;

public class ShortestPath {
    static int m, n, q;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read number of edges (m), number of nodes (n), and number of queries (q)
        m = scanner.nextInt();
        n = scanner.nextInt();
        q = scanner.nextInt();

        // Initialize adjacency list for n nodes (1-based indexing)
        List<List<Integer>> adj = new ArrayList<>();
        //Uses `n+1` lists to allow 1-based indexing 
         // (nodes numbered from 1 to n).
        for (int i = 0; i <= n; i++)
         adj.add(new ArrayList<>());

        // Read m edges
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            /* Reads `m` edges.
        - For each edge, adds both directions (undirected graph).
         */
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Process q queries
        /*For each query, reads source (`s`) and destination (`d`).
        - Calls `bfs` to compute the shortest path and 
          prints the result. */
        for (int i = 0; i < q; i++) {
            int s = scanner.nextInt();
            int d = scanner.nextInt();
            System.out.println(bfs(adj, n, s, d));
        }
        scanner.close();
    }

    // BFS to find shortest path from s to d
    private static int bfs(List<List<Integer>> adj, int n, int s, int d) {
        /* `visited` array tracks visited nodes.
            - `queue` stores pairs: 
              `[node, distance_from_source]`.
            - Starts BFS from `s` with distance 0. */
        if (s == d) return 0;
        boolean[] visited = new boolean[n + 1];
        Queue<int[]> queue = new LinkedList<>();
        /*used to insert a specified element into the queue. This method attempts to add the element without violating any capacity restrictions of the queue */
        queue.offer(new int[]{s, 0});
        visited[s] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll(); //queue.poll () used to retrieve and remove the head (front) element of the queue.
            int node = curr[0], dist = curr[1];
            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    if (neighbor == d) return dist + 1;
                    visited[neighbor] = true;
                    queue.offer(new int[]{neighbor, dist + 1});
                }
            }
        }
        return -1; // No path found
    }
}