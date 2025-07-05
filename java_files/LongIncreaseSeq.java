
import java.util.Scanner;

public class LongIncreaseSeq {
    private static int seq(int n,int[] array){
        if(n<=1) return n;
        int[] arr =new int[n];
        int max=1;
       // int count=0;
        for(int i=0;i<n;i++){
            arr[i]=1;
            for(int j=0;j<i;j++){
           if(array[j]>array[i]){
              arr[i]=Math.max(arr[i],arr[j]+1);
           }
        }
        max = Math.max(max,arr[i]);
        }
        return max;
    }
    public static void main(String[] args){
     Scanner scanner = new Scanner(System.in);
     int n=scanner.nextInt();
     scanner.nextLine();
     int[] array = new int[n];
     for (int i = 0; i < array.length; i++) {
         array[i] =scanner.nextInt();
     }
     System.out.print(seq(n,array));
    }
}
