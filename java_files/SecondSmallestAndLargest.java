//Find 2nd smallest/biggest digit in a number
import java.util.Arrays;
import java.util.Scanner;
public class SecondSmallestAndLargest {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter the elements: ");
        int numberOfElements = scanner.nextInt();
        int[] arr = new int[numberOfElements];
        for(int i=0;i<numberOfElements;i++){
            arr[i]=scanner.nextInt();
        }
        Arrays.sort(arr);
        System.out.println("Sorted array:"+ Arrays.toString(arr));
        System.out.println("The second smallest element is: " + arr[1]);
        System.out.println("The second largest element is: " + arr[numberOfElements - 2]);
        scanner.close();
        
    }
}