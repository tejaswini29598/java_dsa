import java.util.*;

public class Prims {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] graph = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                graph[i][j] = sc.nextInt();

        boolean[] inMST = new boolean[N];
        int[] key = new int[N];
        int[] parent = new int[N];
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < N - 1; count++) {
            int u = -1, min = Integer.MAX_VALUE;
            for (int v = 0; v < N; v++) {
                if (!inMST[v] && key[v] < min) {
                    min = key[v];
                    u = v;
                }
            }
            inMST[u] = true;
            for (int v = 0; v < N; v++) {
                if (graph[u][v] != 0 && !inMST[v] && graph[u][v] < key[v]) {
                    key[v] = graph[u][v];
                    parent[v] = u;
                }
            }
        }

        for (int i = 1; i < N; i++) {
            int u = parent[i] + 1;
            int v = i + 1;
            int w = graph[parent[i]][i];
            System.out.println(u + " " + v + " " + w);
        }
    }
}