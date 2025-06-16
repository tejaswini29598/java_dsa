/*public class HallowSquare {
    public static void main(String[] args){
        int n = 5;
        for(int i =1 ; i <= n; i++){
            for(int j=1; j<=n;j++)
            if((i==1 || j==n ||i==1 || j==n))
            System.out.print("*");
           else
            System.out.print(" ");
        System.out.println();
        }
    }
}
*/
import java.util.*;
public class HollowSquare {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the size");
            int size=scanner.nextInt();
            for (int i = 1; i <= size; i++) {
                for (int j = 1; j <= size; j++) {
                    if (i == 1 || i == size || j == 1 || j == size) {
                        System.out.print("*");
                    } else {
                        System.out.print(" "); 
                    }
                }
                System.out.println();
            }
        }
    }
}