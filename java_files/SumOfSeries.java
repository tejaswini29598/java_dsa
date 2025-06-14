//find sum of the series 1-n+n2-n3...n terms 0<=n<=9 ,1 <=m<=25 or n+n2+n3...n-1 terms
import java.util.*;
public class SumOfSeries {
   public static void main(String[] args) {
       try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the number of terms");
            int inputNumber =scanner.nextInt();
            int numberOfTerms=0; int m=1;
            int sum=0;
            for(int i=1;i<=inputNumber;i++){
                if(i%2==0){
                    m*=i;
                }else{
                    m/=i;
                }
                sum+=m;
            }
            System.out.println("The sum of the series is: " + sum);
        }
        /*  from trainer
    public class SeriesSum {
	private int termValue;
	private int numberOfTerms;
	private long sumOfSeries;
	
	public void findSumOfSeries() {
		for(int i = 1; i <= numberOfTerms; i++) {
			sumOfSeries = sumOfSeries + (long) (Math.pow(termValue, i-1) * Math.pow(-1, i-1)); 
		}
	}
	
	public static void main(String[] args) {
		SeriesSum obj = new SeriesSum();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the term value: ");
		obj.termValue = scanner.nextInt();
		System.out.print("Enter number of terms of the series : ");
		obj.numberOfTerms = scanner.nextInt();
		if( (obj.termValue >= 0 && obj.termValue <= 5) && (obj.numberOfTerms >= 1 && obj.numberOfTerms <= 25) ) {
			obj.findSumOfSeries();
			System.out.println("Sum of the series is " + obj.sumOfSeries);
		}
		scanner.close();			
	}
} */

      }   }

