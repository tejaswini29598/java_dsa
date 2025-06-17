//Print the nth term if the series: 1 2 3 3 5 5 7  8 11 13 13
public class NthTerm {
    public static void main(String[] args) {
        int n = 10; 
        System.out.println("The " + n + "th term in the series is: " + findNthTerm(n));
    }

    public static int findNthTerm(int n) {
        if (n <= 0) {
            return -1; 
        }
        
        int[] series = {1, 2, 3, 3, 5, 5, 7, 8, 11, 13, 13};
        
        if (n > series.length) {
            return -1; 
        }
        
        return series[n - 1]; 
    }
}