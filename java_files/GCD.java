import java.io.*;

public class GCD {
    static int[] arr, seg;
    static int n;

    static int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    static void build(int node, int l, int r) {
        if (l == r) {
            seg[node] = arr[l];
        } else {
            int m = (l + r) / 2;
            build(2 * node, l, m);
            build(2 * node + 1, m + 1, r);
            seg[node] = gcd(seg[2 * node], seg[2 * node + 1]);
        }
    }

    static void update(int node, int l, int r, int idx, int val) {
        if (l == r) {
            seg[node] = val;
        } else {
            int m = (l + r) / 2;
            if (idx <= m)
                update(2 * node, l, m, idx, val);
            else
                update(2 * node + 1, m + 1, r, idx, val);
            seg[node] = gcd(seg[2 * node], seg[2 * node + 1]);
        }
    }

    static int query(int node, int l, int r, int ql, int qr) {
        if (qr < l || r < ql)
            return 0;
        if (ql <= l && r <= qr)
            return seg[node];
        int m = (l + r) / 2;
        int left = query(2 * node, l, m, ql, qr);
        int right = query(2 * node + 1, m + 1, r, ql, qr);
        if (left == 0) return right;
        if (right == 0) return left;
        return gcd(left, right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nq = br.readLine().split(" ");
        n = Integer.parseInt(nq[0]);
        int q = Integer.parseInt(nq[1]);
        arr = new int[n];
        seg = new int[4 * n];
        String[] a = br.readLine().split(" ");
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(a[i]);
        build(1, 0, n - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            String[] parts = br.readLine().split(" ");
            int type = Integer.parseInt(parts[0]);
            if (type == 1) {
                int idx = Integer.parseInt(parts[1]);
                int val = Integer.parseInt(parts[2]);
                update(1, 0, n - 1, idx, val);
            } else {
                int l = Integer.parseInt(parts[1]);
                int r = Integer.parseInt(parts[2]);
                sb.append(query(1, 0, n - 1, l, r)).append('\n');
            }
        }
        System.out.print(sb);
    }
}