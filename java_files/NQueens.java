
/*  ```python
        def solve_n_queens(n):
            def is_safe(board, row, col):
                for i in range(row):
                    if board[i] == col or \
                        board[i] - i == col - row or \
                        board[i] + i == col + row:
                        return False
                return True

            def solve(row, board, solutions):
                if row == n:
                    solutions.append(board[:])
                    return
                for col in range(n):
                    if is_safe(board, row, col):
                        board[row] = col
                        solve(row + 1, board, solutions)
                        board[row] = -1  # Backtrack

            solutions = []
            solve(0, [-1] * n, solutions)
            return solutions
        ```
 */
import java.util.*;

public class NQueens {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<String>> solutions = solveNQueens(n);
        if (solutions.isEmpty()) {
            System.out.println("No solution");
        } else {
            for (List<String> sol : solutions) {
                for (String row : sol) {
                    System.out.println(row);
                }
                System.out.println();
            }
        }
    }

    private static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');
        backtrack(res, board, 0, n, new boolean[n], 
            new boolean[2 * n], new boolean[2 * n]);
        return res;
    }

    private static void backtrack(List<List<String>> res, char[][] board, int row, 
        int n, boolean[] cols, boolean[] d1, boolean[] d2) {
        if (row == n) {
            List<String> sol = new ArrayList<>();
            for (char[] r : board) sol.add(new String(r));
            res.add(sol);
            return;
        }
        for (int col = 0; col < n; col++) {
            //id1 = main diagonal  id2 = anti diagonal
            /* col =0 row =0 n=4 therefore 0-0+4 =4  */
            int id1 = col - row + n, id2 = col + row;
            if (cols[col] || d1[id1] || d2[id2]) continue;
            board[row][col] = 'Q';
            cols[col] = d1[id1] = d2[id2] = true;
            backtrack(res, board, row + 1, n, cols, d1, d2);
            board[row][col] = '.';
            cols[col] = d1[id1] = d2[id2] = false;
        }
    }
}
/* Detailed step-by-step explanation of the provided N-Queens code:
    1. Imports and Class Declaration
        ```java
        import java.util.*;

        public class NQueens {
        ```
        - `import java.util.*;`  
           imports all utility classes 
           (like `Scanner`, `List`, `ArrayList`, etc.).
        - The class `NQueens` contains the main logic.

    2. Main Method
        ```java
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            List<List<String>> solutions = solveNQueens(n);
            if (solutions.isEmpty()) {
                System.out.println("No solution");
            } else {
                for (List<String> sol : solutions) {
                    for (String row : sol) {
                        System.out.println(row);
                    }
                    System.out.println();
                }
            }
        }
        ```
        - Reads an integer `n` 
          (the size of the chessboard and number of queens).
        - Calls `solveNQueens(n)` 
          to get all valid solutions.
        - If no solution exists, 
          prints "No solution".
        - Otherwise, 
          prints each solution (each as a list of strings, one per row).

    3. Solving N-Queens
        ```java
        private static List<List<String>> solveNQueens(int n) {
            List<List<String>> res = new ArrayList<>();
            char[][] board = new char[n][n];
            for (char[] row : board) Arrays.fill(row, '.');
            backtrack(res, board, 0, n, new boolean[n], new boolean[2 * n], new boolean[2 * n]);
            return res;
        }
        ```
        - Initializes the result list `res`.
        - Creates an `n x n` board filled with `'.'` (empty cells).
        - Calls `backtrack` to fill the board row by row.
        - Uses three boolean arrays to track columns and diagonals:
        - `cols`: columns with queens.
        - `d1`: "main" diagonals (top-left to bottom-right).
        - `d2`: "anti" diagonals (top-right to bottom-left).

    4. Backtracking Function
        ```java
        private static void backtrack(List<List<String>> res, char[][] board, int row, int n, boolean[] cols, boolean[] d1, boolean[] d2) {
            if (row == n) {
                List<String> sol = new ArrayList<>();
                for (char[] r : board) sol.add(new String(r));
                res.add(sol);
                return;
            }
            for (int col = 0; col < n; col++) {
                int id1 = col - row + n, id2 = col + row;
                if (cols[col] || d1[id1] || d2[id2]) continue;
                board[row][col] = 'Q';
                cols[col] = d1[id1] = d2[id2] = true;
                backtrack(res, board, row + 1, n, cols, d1, d2);
                board[row][col] = '.';
                cols[col] = d1[id1] = d2[id2] = false;
            }
        }
        ```
        - Base Case: If `row == n`, a valid solution is found. 
          Convert the board to a list of strings and add to results.
        - For Each Column: Try placing a queen 
          in each column of the current row.
        - Diagonal Indexing:
            - `id1 = col - row + n` for main diagonals 
            (offset by `n` to avoid negative indices).
            - `id2 = col + row` for anti-diagonals.
        - Safety Check: If the column or 
          either diagonal is already occupied, 
          skip.
        - Place Queen: 
          Mark the board and tracking arrays.
        - Recursive Call: Move to the next row.
        - Backtrack: Remove the queen and 
          reset tracking arrays (undo the move).
 */
