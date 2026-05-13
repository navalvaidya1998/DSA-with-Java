package arrays;
import java.util.*;
public class NQueens {

    /* Day 13 - N Queens
    *
    * 🔹 Approach 1: Brute Force (Check Entire Board)
    * ----------------------------------------------
    * Idea:
    * - Place queens row by row
    * - For each position, check if it is safe
    *
    * How it works:
    * - For every cell:
    *     → Check column
    *     → Check upper-left diagonal
    *     → Check upper-right diagonal
    *
    * - If safe:
    *     → Place queen and recurse
    *
    * - Backtrack after exploring
    *
    * Time Complexity:
    * - O(n! * n)
    *
    * Space Complexity:
    * - O(n^2)
    *
    * Why this is not optimal:
    * - Repeated scanning of board
    */
    public static List<List<String>> nQueensBruteforce(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        backtrack(0, board, result);
        return result;
    }
    private static void backtrack(int row, char[][] board, List<List<String>> result) {
        if (row == board.length) {
            result.add(construct(board));
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                backtrack(row + 1, board, result);
                board[row][col] = '.';
            }
        }
    }
    private static boolean isSafe(char[][] board, int row, int col) {
        int n = board.length;
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }
    private static List<String> construct(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] row : board) {
            list.add(new String(row));
        }
        return list;
    }

    /* Day 13 - N Queens
    *
    * 🔹 Approach 2: Optimal (Backtracking + Hashing)
    * ----------------------------------------------
    * Idea:
    * - Use arrays to track attacked columns and diagonals
    * - Avoid scanning the board repeatedly
    *
    * How it works:
    * - Maintain:
    *     → cols[] for column tracking
    *     → diag1[] for left diagonals
    *     → diag2[] for right diagonals
    *
    * - For each position:
    *     → Check in O(1) if safe
    *
    * - If safe:
    *     → Place queen
    *     → Mark arrays
    *     → Recurse
    *
    * - Backtrack:
    *     → Remove queen
    *     → Unmark arrays
    *
    * Time Complexity:
    * - O(n!)
    *
    * Space Complexity:
    * - O(n^2)
    *
    * Why this is optimal:
    * - Eliminates repeated board scanning
    * - Fast constant-time safety checks
    */
    public static List<List<String>> nQueensOptimal(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n];
        boolean[] diag2 = new boolean[2 * n]; 
        backtrack(0, board, result, cols, diag1, diag2);
        return result;
    }
    private static void backtrack(int row, char[][] board, List<List<String>> result,
                           boolean[] cols, boolean[] diag1, boolean[] diag2) {

        if (row == board.length) {
            result.add(construct1(board));
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if (cols[col] || diag1[row - col + board.length] || diag2[row + col]) {
                continue;
            }
            board[row][col] = 'Q';
            cols[col] = true;
            diag1[row - col + board.length] = true;
            diag2[row + col] = true;
            backtrack(row + 1, board, result, cols, diag1, diag2);
            board[row][col] = '.';
            cols[col] = false;
            diag1[row - col + board.length] = false;
            diag2[row + col] = false;
        }
    }
    private static List<String> construct1(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] row : board) {
            list.add(new String(row));
        }
        return list;
    }
}