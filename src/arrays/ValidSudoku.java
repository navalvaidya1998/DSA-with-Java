package arrays;
public class ValidSudoku {
    /*Day 7 - Valid Sudoku 
    🔹 Approach 1: Brute Force (Validation by Scanning)
    * ----------------------------------------------
    * Idea:
    * - Traverse each cell of the 9x9 board
    * - For every filled cell, validate:
    *     → its row
    *     → its column
    *     → its 3x3 sub-box
    *
    * Key Logic:
    * - Loop through each cell (i, j):
    *     → If cell is '.', skip it
    *     → Otherwise, check:
    *         1. Same number should not appear in the row
    *         2. Same number should not appear in the column
    *         3. Same number should not appear in the 3x3 box
    *
    * - If any violation is found:
    *     → Return false immediately
    *
    * - If all cells are valid:
    *     → Return true
    *
    * Time Complexity: O(n^3)
    *  - For each cell (n^2), we scan row + column + box (≈3n)
    *  - Total ≈ O(9 * 9 * 9) → constant but conceptually cubic
    *
    * Space Complexity: O(1)
    *  - No extra data structures used
    *
    * Advantage:
    * - Simple and intuitive approach
    * - Easy to implement and debug
    *
    * Disadvantage:
    * - Repeated checks for rows, columns, and boxes
    * - Less efficient compared to optimized approaches (HashSet / boolean array)
    */
    public static boolean isValidSudokuBruteForce(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return false;
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch == '.') continue;
                if (ch < '1' || ch > '9') return false;
                if (!isValid(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean isValid(char[][] board, int row, int col) {
        char num = board[row][col];
        for (int j = 0; j < 9; j++) {
            if (j != col && board[row][j] == num) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (i != row && board[i][col] == num) {
                return false;
            }
        }
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if ((i != row || j != col) && board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    /* 🔹 Approach 2: Optimal (Using HashSet / Boolean Tracking)
    * ----------------------------------------------
    * Idea:
    * - Instead of re-checking rows, columns, and boxes again and again,
    *   we store already seen numbers while traversing the board once
    *
    * Key Logic:
    * - Maintain 3 data structures:
    *     → rows[9]   → track numbers in each row
    *     → cols[9]   → track numbers in each column
    *     → boxes[9]  → track numbers in each 3x3 sub-box
    *
    * - Loop through each cell (i, j):
    *     → If cell is '.', skip it
    *     → Compute box index:
    *         boxIndex = (i / 3) * 3 + (j / 3)
    *
    *     → If number already exists in:
    *         rows[i] OR cols[j] OR boxes[boxIndex]
    *         → Return false (duplicate found)
    *
    *     → Otherwise:
    *         Add number to corresponding row, column, and box
    *
    * - If traversal completes without duplicates:
    *     → Return true
    *
    * Time Complexity: O(n^2)
    *  - Single pass over the board (9x9)
    *
    * Space Complexity: O(n^2)
    *  - Using extra storage for tracking (constant size 9x9)
    *
    * Advantage:
    * - Avoids repeated scanning → more efficient
    * - Clean and structured approach
    * - Preferred in interviews
    *
    * Disadvantage:
    * - Uses extra space compared to brute force
    */

    public static boolean isValidSudokuOptimal(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch == '.') continue;
                int num = ch - '1'; 
                int boxIndex = (i / 3) * 3 + (j / 3);
                if (rows[i][num] || cols[j][num] || boxes[boxIndex][num]) {
                    return false;
                }
                rows[i][num] = true;
                cols[j][num] = true;
                boxes[boxIndex][num] = true;
            }
        }
        return true;
    }
}