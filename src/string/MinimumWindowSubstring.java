package string;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    /* Day 26 - Minimum Window Substring
    *
    * 🔹 Approach 1: Brute Force (Check All Substrings)
    * ----------------------------------------------
    * Idea:
    * - Generate all possible substrings
    * - Check whether substring contains all characters of t
    *
    * How it works:
    * - For every starting index:
    *     → Generate all substrings
    *
    * - For every substring:
    *     → Verify all required characters exist
    *
    * - Track smallest valid window
    *
    * Time Complexity:
    * - O(n^3)
    *
    * Space Complexity:
    * - O(1)
    *
    * Why this is not optimal:
    * - Checks a large number of substrings
    * - Repeated character counting
    */
    public static String minimumWindowSubstringBruteforce(String s, String t) {
        String answer = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String current = s.substring(i, j + 1);

                if (containsAll(current, t)) {
                    if (answer.isEmpty() || current.length() < answer.length()) {
                        answer = current;
                    }
                }
            }
        }

        return answer;
    }

    private static boolean containsAll(String current, String target) {
        int[] count = new int[128];

        for (char ch : current.toCharArray()) {
            count[ch]++;
        }

        for (char ch : target.toCharArray()) {
            if (--count[ch] < 0) {
                return false;
            }
        }

        return true;
    }

    /* Day 26 - Minimum Window Substring
    *
    * 🔹 Approach 2: Optimal (Sliding Window + HashMap)
    * ----------------------------------------------
    * Idea:
    * - Expand window until all required characters found
    * - Shrink window to get minimum valid substring
    *
    * How it works:
    * - Store frequency of characters from t
    *
    * - Expand right pointer:
    *     → Include characters into window
    *
    * - When all characters matched:
    *     → Shrink from left side
    *     → Update minimum window
    *
    * Time Complexity:
    * - O(n)
    *
    * Space Complexity:
    * - O(k)
    *
    * Why this is optimal:
    * - Each character processed at most twice
    * - Efficient sliding window solution
    */
    public static String minimumWindowSubstringOptimal(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int left = 0;
        int matched = 0;
        int minLength = Integer.MAX_VALUE;
        int startIndex = 0;
        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);
            if (map.containsKey(current)) {
                map.put(current, map.get(current) - 1);
                if (map.get(current) >= 0) {
                    matched++;
                }
            }
            while (matched == t.length()) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    startIndex = left;
                }
                char leftChar = s.charAt(left);
                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);
                    if (map.get(leftChar) > 0) {
                        matched--;
                    }
                }
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE
                ? ""
                : s.substring(startIndex, startIndex + minLength);
    }
}