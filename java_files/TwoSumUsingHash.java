import java.util.*;

public class TwoSumUsingHash {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n= scanner.nextInt();
        scanner.nextLine();
        String secondLine = scanner.nextLine();
        List<Integer> arr = new ArrayList<>();
        for(String numStr : secondLine.trim().split(" ")){
            arr.add(Integer.parseInt(numStr));
        }
        int target = scanner.nextInt();
        Map<Integer,Integer> pairs = new HashMap<Integer,Integer>(n);
        for(int i=0;i<arr.size();i++){
            int diff = target - arr.get(i);
            if(pairs.containsKey(diff)){
                System.out.println(pairs.get(diff)+" "+i);
               // break;
            }
            pairs.put(arr.get(i),i);
        }
        scanner.close();

    }
}
