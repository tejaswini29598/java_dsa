public class XInsideSquare {
    public static void main(String[] args) {
        int n = 5;
        for (int j = 0; j < n; j++) {
            System.out.print("*");
        }
        System.out.println();

        for (int i = 1; i < n - 1; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0 || j == n - 1 || j == i || j == n - i - 1)
                    System.out.print("*");
                else if (j == i || j == n - i - 1) 
                    System.out.print("@");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
        for (int j = 0; j < n; j++) {
            System.out.print("*");
        }
        System.out.println();
    }
}