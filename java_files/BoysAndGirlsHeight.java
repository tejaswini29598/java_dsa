import java.util.*;
public class BoysAndGirlsHeight {
    public static void readT(Scanner scanner) {
        int t = scanner.nextInt();
        for (int idx = 0; idx < t; idx++) {
            int n = scanner.nextInt();
            int[] b = new int[n];
            int[] g = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {
                g[i] = scanner.nextInt();
            }
            Arrays.sort(b);
            System.out.println("Sorted array: " + Arrays.toString(b));
            Arrays.sort(g);
            System.out.println("Sorted array: " + Arrays.toString(g));
            boolean possible = true;
            for (int i = 1; i < n-1 ; i++) {
                if (b[i] < g[i - 1] || g[i] < b[i - 1]) {
                    System.out.println("NO");
                    possible = false;
                    break;
                }
            }
            if (possible) {
                System.out.println("YES");
            }
            int[] r = new int[b.length + g.length];
            System.arraycopy(b, 0, r, 0, b.length);
            System.arraycopy(g, 0, r, b.length, g.length);
        }
    }

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        readT(scanner);
        
    }
}
