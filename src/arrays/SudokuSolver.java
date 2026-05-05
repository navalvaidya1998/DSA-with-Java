package arrays;

public class SudokuSolver {

    /* Day 8 - Sudoku Solver
    * 🔹 Approach: Backtracking (with pruning)
    * ----------------------------------------------
    * Idea:
    * - Try filling each empty cell with numbers from 1 to 9
    * - At every step, check if placing a number is valid
    * - If valid → move forward
    * - If not → try next number (backtrack if needed)
    *
    * How it works:
    * - Traverse the board row by row
    *
    * - For each empty cell ('.'):
    *     → Try numbers from '1' to '9'
    *     → For each number:
    *         1. Check if it is valid in:
    *              - Current row
    *              - Current column
    *              - 3x3 subgrid
    *         2. If valid:
    *              → Place the number
    *              → Call recursion for next cells
    *         3. If recursion fails:
    *              → Backtrack (reset cell to '.')
    *
    * - If no number fits → return false
    *
    * - Base case:
    *     → If all cells are filled → return true
    *
    * Time Complexity:
    * - Exponential (in worst case ~ 9^(n*n))
    *
    * Space Complexity:
    * - O(1) (in-place) + recursion stack
    *
    * Why this works:
    * - Invalid paths are discarded early (pruning)
    * - Much faster than pure brute force
    */
    public static void sudokuSolverBackTrack(char[][] board) {
    fill(board);
    }
    private static boolean fill(char[][] board) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') {
                    for (char num = '1'; num <= '9'; num++) {
                        if (canPlace(board, r, c, num)) {
                            board[r][c] = num;
                            if (fill(board)) return true;
                            board[r][c] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean canPlace(char[][] board, int r, int c, char num) {
        for (int i = 0; i < 9; i++) {
            if (board[r][i] == num) return false;
            if (board[i][c] == num) return false;
            int boxRow = 3 * (r / 3) + i / 3;
            int boxCol = 3 * (c / 3) + i % 3;
            if (board[boxRow][boxCol] == num) return false;
        }
        return true;
    }

    /* Day 8 - Sudoku Solver
    * 🔹 Approach: Backtracking + Optimization (Using extra space)
    * ----------------------------------------------
    * Idea:
    * - Same backtracking approach, but optimize validity checks
    * - Instead of scanning row/col/box every time,
    *   we store used numbers in boolean arrays
    *
    * How it works:
    * - Maintain 3 arrays:
    *     → rowUsed[9][9]
    *     → colUsed[9][9]
    *     → boxUsed[9][9]
    *
    * - Pre-fill these arrays using initial board values
    *
    * - Traverse the board:
    *
    * - For each empty cell ('.'):
    *     → Compute box index
    *     → Try numbers from 1 to 9
    *
    *     → For each number:
    *         1. Check:
    *              - rowUsed[row][num]
    *              - colUsed[col][num]
    *              - boxUsed[box][num]
    *         2. If all false:
    *              → Place number
    *              → Mark all as true
    *              → Recurse
    *         3. If fails:
    *              → Backtrack (unmark + reset)
    *
    * - Base case:
    *     → If board is filled → return true
    *
    * Time Complexity:
    * - Still exponential, but much faster in practice
    *
    * Space Complexity:
    * - O(1) (fixed size arrays) + recursion stack
    *
    * Why this is better:
    * - Validity check becomes O(1) instead of O(9)
    * - Reduces repeated work significantly
    * - Preferred in interviews for optimization
    */

    static boolean[][] rowUsed = new boolean[9][9];
    static boolean[][] colUsed = new boolean[9][9];
    static boolean[][] boxUsed = new boolean[9][9];
    public static void sudokuSolverOptimal(char[][] board) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] != '.') {
                    int num = board[r][c] - '1';
                    int box = (r / 3) * 3 + (c / 3);
                    rowUsed[r][num] = true;
                    colUsed[c][num] = true;
                    boxUsed[box][num] = true;
                }
            }
        }
        fill1(board);
    }
    private static boolean fill1(char[][] board) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') {
                    int box = (r / 3) * 3 + (c / 3);
                    for (int num = 0; num < 9; num++) {
                        if (!rowUsed[r][num] && !colUsed[c][num] && !boxUsed[box][num]) {
                            board[r][c] = (char) (num + '1');
                            rowUsed[r][num] = true;
                            colUsed[c][num] = true;
                            boxUsed[box][num] = true;
                            if (fill1(board)) return true;
                            board[r][c] = '.';
                            rowUsed[r][num] = false;
                            colUsed[c][num] = false;
                            boxUsed[box][num] = false;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}
