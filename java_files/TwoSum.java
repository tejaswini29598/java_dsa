import java.util.*;
public class TwoSum{
    public int[] twoSum(int[] nums, int target) {
        int n =nums.length;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(nums[i] + nums[j] == target)
                {
                    return new int[] { i , j};
                }
            }
        }
        return new int[] {};
    }
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         System.out.println("Enter size");
        int n = scanner.nextInt();
        System.out.println("Enter target");
        int target =scanner.nextInt();
          System.out.println("Enter elements");
        int[] nums =new int[n];
        for(int i=0;i<nums.length;i++){
            nums[i]=scanner.nextInt();
        }
        TwoSum t = new TwoSum();
        int[] result = t.twoSum(nums, target);
        System.out.println(Arrays.toString(result)); // Print array contents
        scanner.close();
    }
}