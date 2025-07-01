import java.util.*;
public class SubsetSum {
    public static boolean subset(int[] arr,int n,int s){
         if(s==0) return true;
         if(n==0) return false;
        // if(arr[n-1]>s) 
            //return subset(arr, n-1, s);
        return subset(arr,n-1,s) || subset(arr, n - 1, s - arr[n - 1]);
        /* subset(arr, n-1, s)
→ This checks if it is possible to get the sum s without including the current element (arr[n-1]).

subset(arr, n-1, s - arr[n-1])
→ This checks if it is possible to get the sum s by including the current element (arr[n-1]).
If you include it, you reduce the target sum by arr[n-1].

The || (logical OR) means:
If either is true (possible to get the sum with or without the current element), the function returns true. */
        }
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n");
        int n = scanner.nextInt();
        System.out.println("Enter s");
        int s =scanner.nextInt();
        System.out.println("Enter array elements:");
        int[] arr = new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i] = scanner.nextInt();
        }
        if(subset(arr,n,s)){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }
}
