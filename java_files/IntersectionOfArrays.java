import java.util.*;
public class IntersectionOfArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //System.out.println("Enter first array size");
        int n=scanner.nextInt();
        scanner.nextLine();
        String secondLine = scanner.nextLine();
       // System.out.println("Enter second array size");
        int m = scanner.nextInt();
        scanner.nextLine();
        String fourthLine = scanner.nextLine();
        List<Integer> firstList = new ArrayList<>(n);
        Set<Integer> set = new HashSet<>();
        for(String e : secondLine.trim().split(" ")){
            firstList.add(Integer.parseInt(e));
            set.add(Integer.parseInt(e));
        }
         List<Integer> secondList = new ArrayList<>(m);
        Set<Integer> set2 = new HashSet<>();
        for(String e : fourthLine.trim().split(" ")){
            secondList.add(Integer.parseInt(e));
            if(set.contains(Integer.parseInt(e))){
                set2.add(Integer.parseInt(e));
            }
        }
        for(int num : set2){
            System.out.print(num+" ");
        }
    }
}
