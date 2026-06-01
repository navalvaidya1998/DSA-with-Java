package string;

public class EditDistance {
    /* Day 26 - Edit Distance
    *
    * 🔹 Approach 1: Brute Force (Recursion)
    * ----------------------------------------------
    * Idea:
    * - Try all possible operations:
    *     → Insert
    *     → Delete
    *     → Replace
    *
    * How it works:
    * - If characters match:
    *     → Move both pointers
    *
    * - Otherwise:
    *     → Try insert operation
    *     → Try delete operation
    *     → Try replace operation
    *
    * - Return minimum operations required
    *
    * Time Complexity:
    * - O(3^(n+m))
    *
    * Space Complexity:
    * - O(n+m)
    *
    * Why this is not optimal:
    * - Repeatedly solves same subproblems
    * - Exponential recursion tree
    */
    public static int editDistanceBruteforce(String word1, String word2) {
        return solve(word1, word2, 0, 0);
    }
    private static int solve(String word1, String word2, int i, int j) {
        if (i == word1.length()) {
            return word2.length() - j;
        }
        if (j == word2.length()) {
            return word1.length() - i;
        }
        if (word1.charAt(i) == word2.charAt(j)) {
            return solve(word1, word2, i + 1, j + 1);
        }
        int insert = solve(word1, word2, i, j + 1);
        int delete = solve(word1, word2, i + 1, j);
        int replace = solve(word1, word2, i + 1, j + 1);
        return 1 + Math.min(insert, Math.min(delete, replace));
    }

    /* Day 26 - Edit Distance
    *
    * 🔹 Approach 2: Optimal (Dynamic Programming)
    * ----------------------------------------------
    * Idea:
    * - Store results of subproblems in DP table
    * - Avoid repeated calculations
    *
    * How it works:
    * - dp[i][j]:
    *     → Minimum operations needed to convert
    *       first i characters of word1
    *       into first j characters of word2
    *
    * - If characters match:
    *     → Take diagonal value
    *
    * - Otherwise:
    *     → Insert
    *     → Delete
    *     → Replace
    *
    * - Take minimum among all operations
    *
    * Time Complexity:
    * - O(n * m)
    *
    * Space Complexity:
    * - O(n * m)
    *
    * Why this is optimal:
    * - Each state calculated only once
    * - Efficient DP solution
    */
    public static int editDistanceOptimal(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(
                            dp[i - 1][j - 1],
                            Math.min(dp[i - 1][j], dp[i][j - 1])
                    );
                }
            }
        }
        return dp[n][m];
    }
}
