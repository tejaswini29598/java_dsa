import java.util.*;

public class PermutationOfString {
    public static void permute(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans); 
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i); // Pick one character
            String ros = str.substring(0, i) + str.substring(i + 1); // Remaining string
            permute(ros, ans + ch); // Recurse
        }
    }

    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = scanner.nextLine();
        permute(s, ""); // Call permutation function
        scanner.close();
    }
}

/* import java.util.*;

public class PermutationsOfString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        List<String> result = new ArrayList<>();
        boolean[] used = new boolean[s.length()];
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        backtrack(chars, new StringBuilder(), used, result);
        for (String perm : result) {
            System.out.println(perm);
        }
    }

    private static void backtrack(char[] chars, StringBuilder path, boolean[] used, List<String> result) {
        if (path.length() == chars.length) {
            result.add(path.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (used[i]) continue;
            if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) continue;
            used[i] = true;
            path.append(chars[i]);
            backtrack(chars, path, used, result);
            path.deleteCharAt(path.length() - 1);
            used[i] = false;
        }
    }
}
 */