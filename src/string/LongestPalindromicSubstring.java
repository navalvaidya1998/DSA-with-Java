package string;

public class LongestPalindromicSubstring {
    /* Day 14 - Longest Palindromic Substring
    *
    * 🔹 Approach 1: Brute Force (Check All Substrings)
    * ----------------------------------------------
    * Idea:
    * - Generate all substrings
    * - Check if each substring is palindrome
    *
    * How it works:
    * - For every index i:
    *     → Generate substring from i to j
    *     → Check if it is palindrome
    *
    * - Track longest valid substring
    *
    * Time Complexity:
    * - O(n^3)
    *
    * Space Complexity:
    * - O(1)
    *
    * Why this is not optimal:
    * - Too many repeated checks
    */
    public static String longestPalindromicSubstringBruteforce(String s) {
        int n = s.length();
        String result = "";
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String sub = s.substring(i, j + 1);
                if (isPalindrome(sub) && sub.length() > result.length()) {
                    result = sub;
                }
            }
        }
        return result;
    }

    /* Day 14 - Longest Palindromic Substring
    *
    * 🔹 Approach 2: Better (Dynamic Programming)
    * ----------------------------------------------
    * Idea:
    * - Use DP to store palindrome information
    *
    * How it works:
    * - dp[i][j] = true if substring from i to j is palindrome
    *
    * - Build solution for smaller substrings first
    * - Expand to larger substrings
    *
    * Time Complexity:
    * - O(n^2)
    *
    * Space Complexity:
    * - O(n^2)
    *
    * Why this is better:
    * - Avoids repeated palindrome checks
    */
    public static String longestPalindromicSubstringBetter(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int start = 0, maxLen = 1;
        for (int i = 0; i < n; i++) dp[i][i] = true;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLen = 2;
            }
        }
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    start = i;
                    maxLen = len;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    /* Day 14 - Longest Palindromic Substring
    *
    * 🔹 Approach 3: Optimal (Expand Around Center)
    * ----------------------------------------------
    * Idea:
    * - Every palindrome expands from a center
    * - Try both odd and even centers
    *
    * How it works:
    * - For each index:
    *     → Expand around single center (odd length)
    *     → Expand around double center (even length)
    *
    * - Track longest palindrome found
    *
    * Time Complexity:
    * - O(n^2)
    *
    * Space Complexity:
    * - O(1)
    *
    * Why this is optimal:
    * - No extra space required
    * - Efficient expansion technique
    */
    public static String longestPalindromicSubstringOptimal(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    private static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
