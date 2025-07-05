import java.util.*;
/* We cant directly reverse the order of the sorted array
 * for the we have declared it as arraylist and we can use Collections.sort(arrayname,Collections.reverseOrder())
 */
public class GreedyCoins {
    public static int greedyChange(List<Integer> array, int target){
        Collections.sort(array,Collections.reverseOrder());
        int count=0;
        for(int coin : array){
            while(target - coin>=0){
                count++;
                target-=coin;
            }
        }
        
        return count;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n value");
        int n=scanner.nextInt();
        System.out.println("Enter target");
        int m=scanner.nextInt();
        //scanner.nextLine();
        System.out.println("Enter values");
        List<Integer> array =new ArrayList<>(n);
        for(int i=0;i<n;i++){
            array.add(scanner.nextInt());
        }
        int result = greedyChange(array, m);
        System.out.println(result);
        }
    }

