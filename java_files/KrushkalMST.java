import java.util.*;
import java.io.*;

public class KrushkalMST {
    static class Edge implements Comparable<Edge> {
        int u, v;
        long w;
        Edge(int u, int v, long w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
        public int compareTo(Edge other) {
            return Long.compare(this.w, other.w);
        }
    }

    static class DSU {
        int[] parent, rank;
        DSU(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];
            for (int i = 1; i <= n; i++) parent[i] = i;
        }
        int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }
        boolean union(int x, int y) {
            int xr = find(x), yr = find(y);
            if (xr == yr) return false;
            if (rank[xr] < rank[yr]) parent[xr] = yr;
            else if (rank[xr] > rank[yr]) parent[yr] = xr;
            else {
                parent[yr] = xr;
                rank[xr]++;
            }
            return true;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        Edge[] edges = new Edge[m];
        for (int i = 0; i < m; i++) {
            String[] uvw = br.readLine().split(" ");
            int u = Integer.parseInt(uvw[0]);
            int v = Integer.parseInt(uvw[1]);
            long w = Long.parseLong(uvw[2]);
            edges[i] = new Edge(u, v, w);
        }
        Arrays.sort(edges);
        DSU dsu = new DSU(n);
        long total = 0;
        int count = 0;
        for (Edge e : edges) {
            if (dsu.union(e.u, e.v)) {
                total += e.w;
                count++;
                if (count == n - 1) break;
            }
        }
        System.out.println(total);
    }
}