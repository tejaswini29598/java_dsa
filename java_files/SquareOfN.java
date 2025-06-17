//Write a program to print Square of N lines.
import java.util.*;
public class SquareOfN {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the size of the square");
        int size=scanner.nextInt();
        for(int i=1;i<=size;i++){
            for(int j=1;j<=size;j++){
                System.out.print("* ");
            }
            System.out.println(); 
        }
        scanner.close();
    }
}
