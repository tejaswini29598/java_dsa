import java.util.*;
public class TowersOfHanoi {
    /* 
     function toh(n,a,c,b):
    if(n == 1) 
        move n a->c 
        return 
    toh(n-1,a,b,c)
    move n a->c  
    toh(n-1,b,c,a)
     */
    // Recursive function to solve Towers of Hanoi
    /*If you remove static from the toh function, it becomes an instance method.
To call a non-static (instance) method, you need to create an object of the class first.
*/
    public static void toh(int n, char a, char c, char b) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + a + " to " + c);
            return;
        }
        toh(n - 1, a, b, c); // Move n-1 disks from source to auxiliary
        System.out.println("Move disk " + n + " from " + a + " to " + c); // Move nth disk to destination
        toh(n - 1, b, c, a); // Move n-1 disks from auxiliary to destination
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of disks to perform:");
        int n = scanner.nextInt(); // Number of disks
        toh(n, 'A', 'C', 'B'); // A = source, C = destination, B = auxiliary
        scanner.close();
    }
}