package string;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    /* Day 18 - Generate Parentheses
    *
    * 🔹 Approach: Optimal (Backtracking)
    * ----------------------------------------------
    * Idea:
    * - Generate all valid parentheses combinations
    * - Use recursion with open and close counts
    *
    * How it works:
    * - At each step:
    *     → Add '(' if open count < n
    *     → Add ')' if close count < open count
    *
    * - When string length becomes 2 * n:
    *     → Add combination to result
    *
    * Time Complexity:
    * - O(4^n / √n)
    *
    * Space Complexity:
    * - O(n)
    *
    * Why this is optimal:
    * - Generates only valid combinations
    * - Efficient backtracking solution
    */
    public static List<String> generateParenthesesOptimal(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private static void backtrack(List<String> result, StringBuilder current,
                                  int open, int close, int n) {
        if (current.length() == 2 * n) {
            result.add(current.toString());
            return;
        }

        if (open < n) {
            current.append('(');
            backtrack(result, current, open + 1, close, n);
            current.deleteCharAt(current.length() - 1);
        }

        if (close < open) {
            current.append(')');
            backtrack(result, current, open, close + 1, n);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
