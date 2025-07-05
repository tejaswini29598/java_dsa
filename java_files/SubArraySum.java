import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public  class SubArraySum {

    static int longestSubarray(int[] arr, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        int res = 0;
        int prefSum = 0;

        for (int i = 0; i < arr.length; ++i) {
            prefSum += arr[i];
            if (prefSum == k) 
                res = i + 1;
            else if (mp.containsKey(prefSum - k)) 
                res = Math.max(res, i - mp.get(prefSum - k));
            if (!mp.containsKey(prefSum))
                mp.put(prefSum, i);
        }

        return res;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
    System.out.println("Enter array values:");
    String line = scanner.nextLine();
    String[] tokens = line.trim().split("[,\\s]+"); // Split by comma or whitespace

    int n = tokens.length;
    int[] arr = new int[n];
    for(int i = 0; i < n; i++){
        arr[i] = Integer.parseInt(tokens[i]);
    }

    System.out.println("Enter target:");
    int target = scanner.nextInt();

    System.out.println(longestSubarray(arr, target));
    }
} 
