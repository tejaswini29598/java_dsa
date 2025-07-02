import java.util.*;
public class CombinationSum {
    public static int combination(int[] arr, int n, int t) {
    if (t == 0) return 1;      
    if (n == 0) return 0;      

    if (arr[n - 1] <= t) {
        return combination(arr, n, t - arr[n - 1]) + combination(arr, n - 1, t);
    } else {
        return combination(arr, n - 1, t);
    }
}
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter array size");
        int n = scanner.nextInt();
        System.out.println("Enter target sum");
        int t = scanner.nextInt();
        System.out.println("Enter array elements");
        int[] arr =new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i] = scanner.nextInt();
        }
        if(arr[n-1]<=t)
        System.out.println(combination(arr, n, t));
        else System.out.println("No combination found");
    }
}
