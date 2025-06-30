import java.util.*;
public class BubbleSort {
    public static void bubbleSort(int[] array){
        boolean sorted = true; //assume the input array is sorted
        for(int i = 0; i < array.length - 1; i++){ //here 20-1=19 ,therefore i<18
           // for(int j = 0; j < array.length - i - 1; j++)
           for(int j = 0; j < array.length - i - 1; j++){
                if(array[j] < array[j + 1]){
                    swap(array, j, j + 1);
                    sorted = false;
                }
            }
            if(sorted)
                break;
        }
    }
    public static void swap(int[] array, int a, int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("Enter array size");
    int n = scanner.nextInt();
    
    int[] array = new int[n];
    System.out.println("Enter " + n + " elements:");
    for (int i = 0; i < n; i++) {
        array[i] = scanner.nextInt();
    }
    bubbleSort(array); // Sort in descending order

    System.out.println("Sorted array (descending):");
    for (int i = 0; i < array.length; i++) {
        System.out.print(array[i] + " ");
    }
}

}
