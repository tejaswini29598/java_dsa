import java.io.*;
import java.util.*;

public class ShortestPathDijkstra {
    static class Edge {
        int to;
        long weight;
        Edge(int to, long weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nms = br.readLine().split(" ");
        int n = Integer.parseInt(nms[0]);  // number of vertices
        int m = Integer.parseInt(nms[1]);  // number of edges  
        int s = Integer.parseInt(nms[2]) - 1;  // source vertex (0-indexed)

        List<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String[] uvw = br.readLine().split(" ");
            int u = Integer.parseInt(uvw[0]) - 1;// source vertex (0-indexed)
            int v = Integer.parseInt(uvw[1]) - 1;  // destination vertex (0-indexed)
            long w = Long.parseLong(uvw[2]);       // edge weight
            graph[u].add(new Edge(v, w)); 
            //adding edges to the graph of vertex with its weights
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[s] = 0; //always the source node is '0'
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.add(new long[]{0, s});

        while (!pq.isEmpty()) {
    long[] curr = pq.poll();
    long d = curr[0];      // current distance
    int u = (int) curr[1]; // current vertex
    
    if (d > dist[u]) continue; // Skip if outdated
    
    for (Edge e : graph[u]) {
        if (dist[e.to] > dist[u] + e.weight) {
            dist[e.to] = dist[u] + e.weight;
            pq.add(new long[]{dist[e.to], e.to});
        }
    }
}

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i > 0) sb.append(" ");
            sb.append(dist[i] == Long.MAX_VALUE ? -1 : dist[i]);
        }
        System.out.println(sb);
    }
}