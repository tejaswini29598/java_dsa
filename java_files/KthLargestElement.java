import java.util.*;

public class KthLargestElement {
    //private List<Integer> arr = new ArrayList<>();
    private static int findMax(List<Integer> arr, int k){
        PriorityQueue<Integer> heap = new PriorityQueue<>(); // minheap
        for(int i=0;i<k;i++){
            heap.offer(arr.get(i));
        }
        for(int i=k;i<arr.size();i++){
            if(arr.get(i)>heap.peek()){
                heap.poll();
                heap.offer(arr.get(i));
            }
        }

      return heap.peek() ;
    }
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine();
        String secondLine = scanner.nextLine();
        List<Integer> arr = new ArrayList<>(n);
        for(String e : secondLine.trim().split(" ")){
            arr.add(Integer.parseInt(e));
        }
        System.out.print(findMax(arr,k));
    }
}
