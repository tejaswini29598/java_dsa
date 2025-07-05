import java.util.*;

public class LongestSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n =scanner.nextInt();
        scanner.nextLine();
        List<Integer> arr =new ArrayList<>();
        String secondLine = scanner.nextLine();
        for(String numStr : secondLine.trim().split(" ")){
            arr.add(Integer.parseInt(numStr));
        }
        System.out.print(findLength(arr));
    }
    private static int findLength(List<Integer> arr){
        //set is used for unique elements so we can get 
         Set<Integer> set = new HashSet<>(arr.size());
         for(int num :arr){
            set.add(num);
         }
         int max =0;
         for(int num : arr){
            //num is not starting seq
            if(set.contains(num-1)){
              continue;
            }
            int seed = num;
            int length =1;
            while(set.contains(seed+1)){
                set.remove(seed);
                seed++; // travel in sequence
                length++;
            }
            //check length with max
            if(length > max) {
                max = length; 
            }
         }
         return max;
    }
}
