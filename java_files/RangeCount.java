import java.io.*;
import java.util.*;

public class RangeCount {
    static class SegmentTree {
        int n;
        ArrayList<Integer>[] tree;

        SegmentTree(int[] arr) {
            n = arr.length;
            tree = new ArrayList[4 * n];
            build(1, 0, n - 1, arr);
        }

        void build(int node, int l, int r, int[] arr) {
            tree[node] = new ArrayList<>();
            if (l == r) {
                tree[node].add(arr[l]);
                return;
            }
            int mid = (l + r) / 2;
            build(2 * node, l, mid, arr);
            build(2 * node + 1, mid + 1, r, arr);
            tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
        }

        ArrayList<Integer> merge(ArrayList<Integer> a, ArrayList<Integer> b) {
            ArrayList<Integer> res = new ArrayList<>(a.size() + b.size());
            int i = 0, j = 0;
            while (i < a.size() && j < b.size()) {
                if (a.get(i) <= b.get(j)) res.add(a.get(i++));
                else res.add(b.get(j++));
            }
            while (i < a.size()) res.add(a.get(i++));
            while (j < b.size()) res.add(b.get(j++));
            return res;
        }

        void update(int idx, int val) {
            update(1, 0, n - 1, idx, val);
        }

        void update(int node, int l, int r, int idx, int val) {
            if (l == r) {
                tree[node].set(0, val);
                return;
            }
            int mid = (l + r) / 2;
            if (idx <= mid) update(2 * node, l, mid, idx, val);
            else update(2 * node + 1, mid + 1, r, idx, val);
            tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
        }

        int query(int ql, int qr, int x) {
            return query(1, 0, n - 1, ql, qr, x);
        }

        int query(int node, int l, int r, int ql, int qr, int x) {
            if (r < ql || l > qr) return 0;
            if (ql <= l && r <= qr) {
                // Find first element > x
                ArrayList<Integer> arr = tree[node];
                int lo = 0, hi = arr.size();
                while (lo < hi) {
                    int mid = (lo + hi) / 2;
                    if (arr.get(mid) <= x) lo = mid + 1;
                    else hi = mid;
                }
                return arr.size() - lo;
            }
            int mid = (l + r) / 2;
            return query(2 * node, l, mid, ql, qr, x) + query(2 * node + 1, mid + 1, r, ql, qr, x);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nq = br.readLine().split(" ");
        int n = Integer.parseInt(nq[0]);
        int q = Integer.parseInt(nq[1]);
        int[] arr = new int[n];
        String[] arrStr = br.readLine().split(" ");
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(arrStr[i]);
        SegmentTree st = new SegmentTree(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            String[] parts = br.readLine().split(" ");
            if (parts[0].equals("1")) {
                int idx = Integer.parseInt(parts[1]);
                int val = Integer.parseInt(parts[2]);
                st.update(idx, val);
            } else {
                int l = Integer.parseInt(parts[1]);
                int r = Integer.parseInt(parts[2]);
                int x = Integer.parseInt(parts[3]);
                sb.append(st.query(l, r, x)).append('\n');
            }
        }
        System.out.print(sb);
    }
}