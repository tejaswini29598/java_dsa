import java.lang.*;
import java.util.*;
public class Partition {
    private int size;
    private int[] array;
    public Partition() {

    }

    public Partition(int size, int[] array) {
        this.size = size;
        this.array = array;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public int[] getArray() {
        return array;
    }
    public void setArray(int[] array) {
        this.array = array;
    }
    public static void main(String[] args) {
        Partition obj =new Partition();
        Scanner scanner =new Scanner(System.in);
        System.out.println("enter the size of the array");
        obj.size =scanner.nextInt();
        obj.array =new int[obj.size];
        System.out.println("Enter"+obj.size+"numbers of the array");
        for(int i=0;i<obj.size;i++){
            obj.array[i] = scanner.nextInt();
        }
        System.out.println("The input array is\n"+Arrays.toString(obj.array));
}
}