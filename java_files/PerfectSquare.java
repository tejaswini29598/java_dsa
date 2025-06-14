import java.util.*;
public class PerfectSquare {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);//System.out and System.err
        System.out.print("Enter input number: ");
        int inputNumber=scanner.nextInt();
        int n1=(int)Math.sqrt(inputNumber);
        int result=n1*n1;
        if(result==inputNumber)
        {
            System.out.println("Perfect Square");
        }
        else
        {
            System.out.println("Not a Perfect Square");
        }
         scanner.close();
    }
}