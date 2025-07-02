import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        dfs(0, 0, n, "", ans);
        return ans;
    }

    private void dfs(int left, int right, int n, String current, List<String> ans) {
        // Pruning: invalid state
        if (left > n || right > n || right > left) return;

        // Valid complete string
        if (left == n && right == n) {
            ans.add(current);
            return;
        }

        // Try adding '('
        dfs(left + 1, right, n, current + "(", ans);

        // Try adding ')'
        dfs(left, right + 1, n, current + ")", ans);
    }

    // Test the method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number to generate parenthesis");
        int n = scanner.nextInt();
        GenerateParenthesis sol = new GenerateParenthesis();
        List<String> result = sol.generateParenthesis(n);
        for (String s : result) {
            System.out.println(s);
        }
    }
}
 