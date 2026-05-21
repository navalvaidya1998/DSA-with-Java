package string;

public class FindTheIndexOfTheFirstOccurrenceInAString {
    /* Day 19 - Find the Index of the First Occurrence in a String
    *
    * 🔹 Approach 1: Brute Force (Check Every Substring)
    * ----------------------------------------------
    * Idea:
    * - Compare needle with every possible substring in haystack
    *
    * How it works:
    * - Traverse haystack from index 0
    *
    * - For every index:
    *     → Compare characters one by one
    *
    * - If all characters match:
    *     → Return starting index
    *
    * - If no match found:
    *     → Return -1
    *
    * Time Complexity:
    * - O(n * m)
    *
    * Space Complexity:
    * - O(1)
    *
    * Why this is not optimal:
    * - Repeated comparisons for overlapping substrings
    */
    public static int findTheIndexOfTheFirstOccurrenceInAStringBruteforce(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        for (int i = 0; i <= n - m; i++) {
            int j = 0;

            while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }

            if (j == m) {
                return i;
            }
        }

        return -1;
    }

    /* Day 19 - Find the Index of the First Occurrence in a String
    *
    * 🔹 Approach 2: Optimal (KMP Algorithm)
    * ----------------------------------------------
    * Idea:
    * - Use LPS array to avoid unnecessary comparisons
    *
    * How it works:
    * - Build LPS (Longest Prefix Suffix) array
    *
    * - Traverse haystack and needle together:
    *     → If characters match:
    *         → Move both pointers
    *
    *     → If mismatch:
    *         → Use LPS to skip comparisons
    *
    * - If needle fully matches:
    *     → Return starting index
    *
    * Time Complexity:
    * - O(n + m)
    *
    * Space Complexity:
    * - O(m)
    *
    * Why this is optimal:
    * - Avoids rechecking matched characters
    * - Efficient string matching algorithm
    */
    public static int findTheIndexOfTheFirstOccurrenceInAStringOptimal(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        int[] lps = buildLPS(needle);

        int i = 0;
        int j = 0;

        while (i < n) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }

            if (j == m) {
                return i - j;
            } else if (i < n && haystack.charAt(i) != needle.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return -1;
    }

    private static int[] buildLPS(String pattern) {
        int[] lps = new int[pattern.length()];

        int len = 0;
        int i = 1;

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
}
