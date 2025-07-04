/*peek():
 Returns the smallest element (for a min-heap) or the largest element (for a max-heap) without removing it from the heap.
 poll()
 Returns and removes the smallest (min-heap) or largest (max-heap) element from the heap.
 peek() → look at the top element
poll() → remove and return the top element
 */
import java.util.*;
public class MinHeap{
    private List<Integer> arr = new ArrayList<>();
    public MinHeap(){
        arr = new ArrayList<>();
    }
    public void offer(int val){
         arr.add(val); //inserting value to the array
         heapifyUp(arr.size()-1); //increasing the array(dynamically)

    }
    public int peek(){
     return arr.get(0);
    }
    public int poll(){
        int result = peek();
        swap(0,arr.size()-1);
        arr.remove(arr.size()-1);
        heapifyDown(0);
        return result;
    }
    public void buildHeap(List<Integer> newArr){
        arr = newArr;
        for(int i=arr.size()/2 -1; i >=0;i--){
            heapifyDown(i);
        }
    }
   private void swap(int i,int j){
    int temp = arr.get(i);
    arr.set(i,arr.get(j));
    arr.set(j,temp);
   }
    public void heapifyDown(int nodeIndex){
   int minIndex = nodeIndex;
   int leftIndex = 2* nodeIndex +1;
   int rightIndex = 2*nodeIndex +2;
   if(leftIndex <arr.size() && arr.get(leftIndex) < arr.get(minIndex)){
      minIndex = leftIndex;
   }
   if(rightIndex < arr.size() && arr.get(rightIndex) < arr.get(minIndex)) {
            minIndex = rightIndex;
        }
    
    if(minIndex != nodeIndex){
      swap(minIndex,nodeIndex);
      heapifyDown(minIndex);
    }
}
    public void heapifyUp(int nodeIndex){
       int parentIndex = (nodeIndex -1)/2;
       if(arr.get(nodeIndex)<arr.get(parentIndex)){
        swap(parentIndex,nodeIndex);
        heapifyUp(parentIndex);
       }
    }
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        MinHeap heap = new MinHeap();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            if (line.startsWith("insert")) {
                int val = Integer.parseInt(line.split(" ")[1]);
                heap.offer(val);
            } else if (line.startsWith("extractMin")) {
                try {
                    System.out.println(heap.poll());
                } catch (NoSuchElementException e) {
                    // Optionally handle empty heap
                }
            } else if (line.startsWith("heapify")) {
                String[] parts = line.split(" ");
                int k = Integer.parseInt(parts[1]);
                List<Integer> arr = new ArrayList<>(k);
                for (int j = 0; j < k; j++) {
                    arr.set(j, Integer.parseInt(parts[2 + j]));
                }
                heap.buildHeap(arr);
            }
        /*PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(5);
        minHeap.offer(3);
        minHeap.offer(8);  
        System.out.println("minheap:"+minHeap);
        System.out.println("peeked element:"+minHeap.peek());
        System.out.println("for poll:"+minHeap.poll());
       System.out.println ("inserted 2:"+minHeap.offer(2));
       System.out.println("poll:"+minHeap.poll());
        System.out.println("another poll function:"+minHeap.poll());
    */

    }
}
}


    