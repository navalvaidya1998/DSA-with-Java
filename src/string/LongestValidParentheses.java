package string;

import java.util.Stack;
public class LongestValidParentheses {
    /* Day 20 - Longest Valid Parentheses
    *
    * 🔹 Approach 1: Brute Force (Check All Substrings)
    * ----------------------------------------------
    * Idea:
    * - Generate all possible substrings
    * - Check whether substring is valid
    *
    * How it works:
    * - Generate substrings of even length only
    *
    * - For every substring:
    *     → Use stack to validate parentheses
    *
    * - Track maximum valid length
    *
    * Time Complexity:
    * - O(n^3)
    *
    * Space Complexity:
    * - O(n)
    *
    * Why this is not optimal:
    * - Checks all possible substrings
    * - Repeated validation operations
    */
    public static int longestValidParenthesesBruteforce(String s) {
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 2; j <= s.length(); j += 2) {
                if (isValid(s.substring(i, j))) {
                    maxLength = Math.max(maxLength, j - i);
                }
            }
        }
        return maxLength;
    }
    private static boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
    /* Day 20 - Longest Valid Parentheses
    *
    * 🔹 Approach 2: Optimal (Stack)
    * ----------------------------------------------
    * Idea:
    * - Use stack to track indices of parentheses
    * - Calculate valid substring lengths dynamically
    *
    * How it works:
    * - Push initial index -1 into stack
    *
    * - Traverse string:
    *     → If '(':
    *         → Push index
    *
    *     → If ')':
    *         → Pop stack
    *
    * - If stack becomes empty:
    *     → Push current index
    *
    * - Else:
    *     → Calculate valid length
    *
    * Time Complexity:
    * - O(n)
    *
    * Space Complexity:
    * - O(n)
    *
    * Why this is optimal:
    * - Single pass traversal
    * - Efficient index tracking using stack
    */
    public static int longestValidParenthesesOptimal(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }
        return maxLength;
    }
}
