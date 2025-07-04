/*peek():
 Returns the smallest element (for a min-heap) or the largest element (for a max-heap) without removing it from the heap.
 poll()
 Returns and removes the smallest (min-heap) or largest (max-heap) element from the heap.
 peek() → look at the top element
poll() → remove and return the top element
 */
import java.util.Collections;
import java.util.PriorityQueue;
public class MaxHeap {
    public static void main(String[] args) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.offer(25);
        maxHeap.offer(11);
        maxHeap.offer(37);
        System.out.println(maxHeap);
        System.out.println(maxHeap.peek());
        System.out.println(maxHeap.poll());
    }
}
