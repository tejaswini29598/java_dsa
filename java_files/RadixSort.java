import java.util.*;

 class RadixSorting{
    private void radixSort(List<Integer> arr, int N,int place){
  Map<Integer, List<Integer>> dict = new TreeMap<>();
  for(int e : arr){
     int digit  = e/ place % 10;
     if(!dict.containsKey(digit)){
           dict.put(digit,new ArrayList<>());
     }
     dict.get(digit).add(0);
  }
  int i =0;
  for(List<Integer> group : dict.values()){
     for(int e : group){
        arr.set(i,e);
        i++;
      }
    }
  }
  void sort(List<Integer> arr,int N){

  }
}
public class RadixSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the elements");
        int n=scanner.nextInt();
        String secondLine = scanner.nextLine();
        List<Integer> arr = new ArrayList<>();
        for (String s : secondLine.trim().split(" ")) {
            arr.add(Integer.parseInt(s));
        }
        RadixSorting sorting = new RadixSorting();
        sorting.sort(arr,arr.size());
        for(int i=0;i<arr.size();i++){
            
        }
    }
}
