//String Rotation in java
import java.lang.*;
import java.util.*;

public class StringRotation {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the original string:");
        String word1 = scanner.nextLine();
        System.out.println("Enter the string to check for rotation:");
        String word2 = scanner.nextLine(); // for rotated string

        if(word1.length() != word2.length()){
            System.out.println("Not a rotation");
        } else {
            String temp = word1 + word1;
            if(temp.contains(word2)){ // Check if word2 is a rotation of word1
                System.out.println(word2 + " is a rotation of " + word1);
            } else {
                System.out.println(word2 + " is NOT a rotation of " + word1);
            }
        }
        scanner.close();
    }
}