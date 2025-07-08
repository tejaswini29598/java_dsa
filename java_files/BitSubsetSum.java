import java.util.*;
public class BitSubsetSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int k=scanner.nextInt();
        List<Integer> array = new ArrayList<>();
        for(int i=0;i<n;i++){
            array.add(scanner.nextInt());
        }
        int maskCount=1<<n;
        int count=0;
        for(int mask=0;mask<maskCount;mask++){
            int sum=0;
            for(int bit=0;bit <n;bit++){
                if((mask&(1<<bit))!=0){
                sum+=array.get(bit);
                }
            }
            if(sum==k){
                count++;
            }
        }
        System.out.println(count);
    }
}
