import java.io.*;
import java.util.*;

public class Fenwick {
    static class FenwickTree {
        long[] tree;
        int n;

        FenwickTree(int size) {
            n = size;
            tree = new long[n + 2];
        }

        void add(int idx, long delta) {
            while (idx <= n) {
                tree[idx] += delta;
                idx += idx & -idx;
            }
        }

        long sum(int idx) {
            long res = 0;
            while (idx > 0) {
                res += tree[idx];
                idx -= idx & -idx;
            }
            return res;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        long[] arr = new long[N + 1];
        FenwickTree ft = new FenwickTree(N);

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            ft.add(i, arr[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            if (type == 1) {
                int x = Integer.parseInt(st.nextToken());
                long y = Long.parseLong(st.nextToken());
              long delta = y - arr[x];
              arr[x] = y;
                ft.add(x,delta);
            } else if (type == 2) {
                int x = Integer.parseInt(st.nextToken());
                sb.append(ft.sum(x)).append('\n');
            }
        }
        System.out.print(sb);
    }
}
