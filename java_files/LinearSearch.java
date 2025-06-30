import java.util.*;
public class LinearSearch{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter the array size");
            int n = scanner.nextInt();
            int[] array = new int[n];
            System.out.println("Enter elements");
            for (int i = 0; i < array.length; i++) {
                array[i] = scanner.nextInt();
            }
            System.out.print("Enter element to search");
            int x = scanner.nextInt();
            int result = linearSearch(array, x);
            System.out.println(result);
        } finally {
            scanner.close();
        }
    }

    public static int linearSearch(int[] array, int x) {
        for(int i=0;i<array.length;i++){
            if(array[i]==x){
                return i;
            }
        }
        return -1;
    }
}
