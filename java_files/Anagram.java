/* 
 Sample Input:
6
eat
tea
tan
ate
nat
bat

Sample Output:
eat tea ate
tan nat
bat

Explanation:
"eat", "tea", and "ate" are anagrams of each other. "tan" and "nat" are anagrams. "bat" has no anagrams in the list.
 */
import java.util.*;
public class Anagram {
     public static boolean findAnagram(String s1,String s2){
        if(s1.length()!=s2.length()) return false;
        char[] a =s1.toCharArray();
        char[] b = s2.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a,b);  
     }
     public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n =scanner.nextInt();
        scanner.nextLine();
        List<String> words = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            words.add(scanner.nextLine().trim());
        }
    }

}

