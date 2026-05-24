package string;

public class WildcardMatching {
    /* Day 22 - Wildcard Matching
    *
    * 🔹 Approach 1: Brute Force (Recursion)
    * ----------------------------------------------
    * Idea:
    * - Try all possible matching combinations recursively
    * - '*' can match:
    *     → Empty sequence
    *     → One or more characters
    *
    * How it works:
    * - Traverse string and pattern recursively
    *
    * - If characters match or '?':
    *     → Move both pointers
    *
    * - If '*':
    *     → Try skipping '*'
    *     → Try matching current character
    *
    * Time Complexity:
    * - O(2^(n + m))
    *
    * Space Complexity:
    * - O(n + m)
    *
    * Why this is not optimal:
    * - Repeated recursive computations
    * - Causes exponential time complexity
    */
    public static boolean wildcardMatchingBruteforce(String s, String p) {
        return solve(s, p, 0, 0);
    }
    private static boolean solve(String s, String p, int i, int j) {
        if (i == s.length() && j == p.length()) {
            return true;
        }
        if (j == p.length()) {
            return false;
        }
        if (i == s.length()) {
            while (j < p.length()) {
                if (p.charAt(j) != '*') {
                    return false;
                }
                j++;
            }
            return true;
        }
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            return solve(s, p, i + 1, j + 1);
        }
        if (p.charAt(j) == '*') {
            return solve(s, p, i, j + 1) || solve(s, p, i + 1, j);
        }
        return false;
    }

    /* Day 22 - Wildcard Matching
    *
    * 🔹 Approach 2: Optimal (Dynamic Programming)
    * ----------------------------------------------
    * Idea:
    * - Use DP table to store matching states
    * - Avoid repeated recursive calculations
    *
    * How it works:
    * - dp[i][j]:
    *     → Represents whether first i characters of s
    *       match first j characters of p
    *
    * - If characters match or '?':
    *     → Take diagonal value
    *
    * - If '*':
    *     → Match empty sequence
    *     → Match one or more characters
    *
    * Time Complexity:
    * - O(n * m)
    *
    * Space Complexity:
    * - O(n * m)
    *
    * Why this is optimal:
    * - Eliminates repeated computations
    * - Efficient pattern matching solution
    */
    public static boolean wildcardMatchingOptimal(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int j = 1; j <= m; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);
                if (sc == pc || pc == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }
        return dp[n][m];
    }
}