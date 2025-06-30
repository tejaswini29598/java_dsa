import java.util.*;

public class KarprekarConstant{
  /*   public static int Karprekar(int num){
        int[] inputNumber = new int[4];
        System.out.println("Enter a 4-digit number:");
        for (int i = 0; i < 4; i++) {
            inputNumber[i] = scanner.nextInt(); // Read array elements
        }
        Arrays.sort(inputNumber);
        String a = Arrays.toString(inputNumber);
        System.out.println("Array in increasing order:"+Arrays.toString(inputNumber));
        for (int i = inputNumber.length - 1; i >= 0; i--) {
            System.out.print(inputNumber[i]);
        }
        // Convert int[] to Integer[] for reverse sorting
        Integer[] inputNumberDesc = Arrays.stream(inputNumber).boxed().toArray(Integer[]::new);
        Arrays.sort(inputNumberDesc, Collections.reverseOrder());
        String b = Arrays.toString(inputNumberDesc);
        while (true) {
            int ascendingNumber = Integer.parseInt(a);
            int descendingNumber = Integer.parseInt(b);
            int difference = descendingNumber - ascendingNumber;
            System.out.println("Difference: " + difference);
        }
    }*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a 4-digit number:");
        int num = scanner.nextInt();
        
        int count = 0;
        while (num != 6174) {
            String inputNum = String.format("%04d", num); // Ensure 4 digits
            char[] numArray = inputNum.toCharArray();
            Arrays.sort(numArray); // ascending order
            String ascStr = new String(numArray);
            StringBuilder sb = new StringBuilder(ascStr);
            sb.reverse();
            String descStr = sb.toString();

            int small = Integer.parseInt(ascStr);
            System.out.println("Ascending order: " + ascStr);
            int big = Integer.parseInt(descStr);
            System.out.println("Descending order: " + descStr);
            num = big - small;
            System.out.println("Difference:"+num);
            count++;
        }

        System.out.println("The number is Kaprekar's constant (6174), reached in " + count );
    }
}
