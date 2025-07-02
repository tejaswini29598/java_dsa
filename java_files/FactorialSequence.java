import java.util.Scanner;

public class FactorialSequence {
    public static int fact(int n){
        if(n<=1) return n;
       // int a=1;
        return n * fact(n-1);
    }
    public static void main(String[] args){
        Scanner scanner =new Scanner(System.in);
        System.out.println("Enter n value");
        int n = scanner.nextInt();
        System.out.println(fact(n));
    } 
}
