import java.util.*;

public class SudokuSolver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] board = new char[9][9];
        for (int i = 0; i < 9; i++) {
            String[] line = sc.nextLine().trim().split("\\s+");
            for (int j = 0; j < 9; j++) {
                board[i][j] = line[j].charAt(0);
            }
        }
        solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j]);
                if (j < 8) System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static boolean solveSudoku(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, row, col, c)) {
                            board[row][col] = c;
                            if (solveSudoku(board)) return true;
                            board[row][col] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c) return false; // Row check to find if the row contains the same character or digit
            if (board[i][col] == c) return false; //column check 
            if (board[3*(row/3)+i/3][3*(col/3)+i%3] == c) return false;
            // i/3 = 000 111 222  i%3 012 012 012...
        }
        return true;
    }
}
/* Step-by-step explanation of your Sudoku solver code:
    1. Imports and Class Declaration
        ```java
        import java.util.*;

        public class SudokuSolver {
        ```
        - Imports all classes from `java.util` (only `Scanner` is used).
        - Declares the `SudokuSolver` class.

    2. Main Method: Input and Output
        ```java
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            char[][] board = new char[9][9];
            for (int i = 0; i < 9; i++) {
                String[] line = sc.nextLine().trim().split("\\s+");
                for (int j = 0; j < 9; j++) {
                    board[i][j] = line[j].charAt(0);
                }
            }
            solveSudoku(board);
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(board[i][j]);
                    if (j < 8) System.out.print(" ");
                }
                System.out.println();
            }
        }
        ```
        - Reads a 9x9 Sudoku board from standard input, one line at a time.
        - Each line is split by whitespace, and 
          each cell is stored as a `char` 
          (e.g., `'5'`, `'.'` for empty).
        - Calls `solveSudoku(board)` to solve the puzzle.
        - Prints the solved board, formatting with spaces between numbers.

        Gotcha: Input must be 9 lines, 
                each with 9 space-separated characters.

    3. Sudoku Solver (Backtracking)
        ```java
        public static boolean solveSudoku(char[][] board) {
            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 9; col++) {
                    if (board[row][col] == '.') {
                        for (char c = '1'; c <= '9'; c++) {
                            if (isValid(board, row, col, c)) {
                                board[row][col] = c;
                                if (solveSudoku(board)) return true;
                                board[row][col] = '.';
                            }
                        }
                        return false;
                    }
                }
            }
            return true;
        }
        ```
        - Loops through each cell.
        - If an empty cell (`'.'`) is found:
        - Tries all digits `'1'` to `'9'`.
        - If `isValid` returns true, 
          places the digit and recursively tries to solve the rest.
        - If recursion fails, resets the cell to `'.'` (backtracks).
        - If all cells are filled, returns `true` (solved).

        Gotcha: Returns `false` if no valid digit can be placed, 
                triggering backtracking.

    4. Validation Function
        ```java
        private static boolean isValid(char[][] board, int row, int col, char c) {
            for (int i = 0; i < 9; i++) {
                if (board[row][i] == c) return false; // Row check
                if (board[i][col] == c) return false; // Column check
                if (board[3*(row/3)+i/3][3*(col/3)+i%3] == c) return false; // 3x3 box check
            }
            return true;
        }
        ```
        - Checks if placing `c` at `(row, col)` is valid:
        - Not already in the same row.
        - Not already in the same column.
        - Not already in the same 3x3 subgrid.

        Gotcha: The 3x3 box calculation is a common source of confusion:
        - `3*(row/3)` and `3*(col/3)` find the top-left corner of the box (sub-grid).
        - `i/3` and `i%3` iterate over the 3x3 box.
 */