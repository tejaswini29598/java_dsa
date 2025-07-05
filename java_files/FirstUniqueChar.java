import java.util.*;
public class FirstUniqueChar {
    // Function to find the index of the first unique character in a string
    private static int findFirst(String str){
        Map<Character,Integer> dict = new HashMap<>(); // Map to store character counts

        // Count the frequency of each character in the string
        for(int i=0; i<str.length(); i++){
            int count = dict.computeIfAbsent(str.charAt(i), e -> 0) + 1; // Get current count and add 1
            dict.put(str.charAt(i), count); // Update the count in the map
        }

        // Find the first character with count 1 (unique)
        for(int i=0; i<str.length(); i++){
            if(dict.get(str.charAt(i)) == 1){ // If character occurs only once
                return i; // Return its index
            }
        }
        return -1; // If no unique character found, return -1
        /* for the testcase aabb we can get -1 because the char 'a' is written immediately after 'a' */
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner for user input
        String word = scanner.nextLine(); // Read input string
        System.out.println(findFirst(word)); // Print index of first unique character
    }
}