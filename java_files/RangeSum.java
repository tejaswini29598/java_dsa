import java.util.*;
import java.io.*;

public class RangeSum {
    static class SegmentTree {
        long[] tree;
        int n;

        SegmentTree(int[] arr) {
            n = arr.length;
            tree = new long[4 * n];
            build(arr, 1, 0, n - 1);
        }

        void build(int[] arr, int node, int l, int r) {
            if (l == r) {
                tree[node] = arr[l];
            } else {
                int mid = (l + r) / 2;
                build(arr, 2 * node, l, mid);
                build(arr, 2 * node + 1, mid + 1, r);
                tree[node] = tree[2 * node] + tree[2 * node + 1];
            }
        }

        void update(int idx, int val) {
            update(1, 0, n - 1, idx, val);
        }

        void update(int node, int l, int r, int idx, int val) {
            if (l == r) {
                tree[node] = val;
            } else {
                int mid = (l + r) / 2;
                if (idx <= mid) update(2 * node, l, mid, idx, val);
                else update(2 * node + 1, mid + 1, r, idx, val);
                tree[node] = tree[2 * node] + tree[2 * node + 1];
            }
        }

        long query(int ql, int qr) {
            return query(1, 0, n - 1, ql, qr);
        }

        long query(int node, int l, int r, int ql, int qr) {
            if (qr < l || r < ql) return 0;
            if (ql <= l && r <= qr) return tree[node];
            int mid = (l + r) / 2;
            return query(2 * node, l, mid, ql, qr) + query(2 * node + 1, mid + 1, r, ql, qr);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        SegmentTree seg = new SegmentTree(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            if (type == 1) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                seg.update(x, y);
            } else {
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                sb.append(seg.query(l, r)).append('\n');
            }
        }
        System.out.print(sb);
    }
}