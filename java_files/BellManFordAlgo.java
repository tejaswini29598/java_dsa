import java.util.*;

public class BellManFordAlgo {
    static class Edge {
        int u, v, w;
        Edge(int u, int v, int w) { //In Java, you cannot define a class like Edge with fields and pass arguments directly at object creation time without using a constructor
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        Edge[] edges = new Edge[M];
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            int w = sc.nextInt();
            edges[i] = new Edge(u, v, w);
        }
        System.out.println(hasNegativeCycle(N, edges) ? "YES" : "NO");
    }

    static boolean hasNegativeCycle(int N, Edge[] edges) {
        int[] dist = new int[N];
        Arrays.fill(dist, 0); // Try from all nodes, so start with 0 for all

        for (int i = 0; i < N - 1; i++) {
            for (Edge e : edges) {
                if (dist[e.v] > dist[e.u] + e.w) {
                    dist[e.v] = dist[e.u] + e.w;
                }
            }
        }

        for (Edge e : edges) {
            if (dist[e.v] > dist[e.u] + e.w) {
                return true;
            }
        }
        return false;
    }
}