package string;

import java.util.Stack;

public class SimplifyPath {
    /* Day 25 - Simplify Path
    *
    * 🔹 Approach 1: Brute Force (String Processing)
    * ----------------------------------------------
    * Idea:
    * - Split path using '/'
    * - Process directories manually
    *
    * How it works:
    * - Ignore:
    *     → Empty strings
    *     → "."
    *
    * - If "..":
    *     → Remove previous directory
    *
    * - Otherwise:
    *     → Add valid directory
    *
    * Time Complexity:
    * - O(n)
    *
    * Space Complexity:
    * - O(n)
    *
    * Why this is not optimal:
    * - Uses extra list handling
    * - Multiple string operations
    */
    public static String simplifyPathBruteforce(String path) {
        String[] parts = path.split("/");
        java.util.List<String> list = new java.util.ArrayList<>();
        for (String part : parts) {
            if (part.equals("") || part.equals(".")) {
                continue;
            }
            if (part.equals("..")) {
                if (!list.isEmpty()) {
                    list.remove(list.size() - 1);
                }
            } else {
                list.add(part);
            }
        }
        StringBuilder result = new StringBuilder();
        for (String dir : list) {
            result.append("/").append(dir);
        }
        return result.length() == 0 ? "/" : result.toString();
    }

    /* Day 25 - Simplify Path
    *
    * 🔹 Approach 2: Optimal (Stack)
    * ----------------------------------------------
    * Idea:
    * - Use stack to maintain valid directories
    * - Process path components efficiently
    *
    * How it works:
    * - Ignore:
    *     → Empty strings
    *     → "."
    *
    * - If "..":
    *     → Pop directory from stack
    *
    * - Otherwise:
    *     → Push valid directory
    *
    * - Build simplified path from stack
    *
    * Time Complexity:
    * - O(n)
    *
    * Space Complexity:
    * - O(n)
    *
    * Why this is optimal:
    * - Efficient directory tracking
    * - Clean stack-based solution
    */
    public static String simplifyPathOptimal(String path) {
        String[] parts = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String part : parts) {
            if (part.equals("") || part.equals(".")) {
                continue;
            }
            if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(part);
            }
        }
        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/").append(dir);
        }
        return result.length() == 0 ? "/" : result.toString();
    }
}
