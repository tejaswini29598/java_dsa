import java.util.*;
public class DividingArray {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n=scanner.nextInt();
        int[] arr=new int[n];
         System.out.println("Enter the array elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt(); // Read array elements
        }
         Arrays.sort(arr);
         System.out.println("Sorted array: " + Arrays.toString(arr));
         //now divide the array into 2 parts from taking x and y as input
        System.out.print("Enter x: ");
        int x = scanner.nextInt();
        System.out.print("Enter y: ");
        int y = scanner.nextInt();
         if (x < 0 || y > n) {
            System.out.println("Invalid indices for dividing the array.");
        } else {
            System.out.print("First part: ");
            for (int i = x; i < y; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();

            // Second part: arr[y] to arr[n-1]
            System.out.print("Second part: ");
            for (int i = y; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
        /*sort the array
         p=arr[y]-arr[y-1]-1;
         print(p)
        */
        int p= arr[y] - arr[y - 1] - 1;
        System.out.println("The value of p is: " + p);
        scanner.close();
    }
}}
