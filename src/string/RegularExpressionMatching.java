package string;

public class RegularExpressionMatching {
    /* Day 16 - Regular Expression Matching
    *
    * 🔹 Approach: Optimal (Recursion + Memoization)
    * ----------------------------------------------
    * Idea:
    * - Use recursion to match string and pattern
    * - Store results of subproblems to avoid recomputation
    *
    * How it works:
    * - At each step:
    *     → Check if current characters match
    *
    * - If next character in pattern is '*':
    *     → Two choices:
    *         → Ignore "x*" (move pattern by 2)
    *         → Use it if match (move string forward)
    *
    * - If no '*':
    *     → Move both string and pattern forward if match
    *
    * - Use DP (memoization) to store results
    *
    * Time Complexity:
    * - O(n * m)
    *
    * Space Complexity:
    * - O(n * m)
    *
    * Why this is optimal:
    * - Avoids repeated recursion using memoization
    * - Efficient handling of complex pattern matching
    */
    public static boolean regularExpressionMatchingOptimal(String s, String p) {
        Boolean[][] dp = new Boolean[s.length() + 1][p.length() + 1];
        return helper(0, 0, s, p, dp);
    }

    private static boolean helper(int i, int j, String s, String p, Boolean[][] dp) {
        if (dp[i][j] != null) return dp[i][j];
        if (j == p.length()) return dp[i][j] = (i == s.length());
        boolean match = (i < s.length() &&
                (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            boolean skip = helper(i, j + 2, s, p, dp);
            boolean take = match && helper(i + 1, j, s, p, dp);
            return dp[i][j] = (skip || take);
        }
        if (match) {
            return dp[i][j] = helper(i + 1, j + 1, s, p, dp);
        }
        return dp[i][j] = false;
    }
}
