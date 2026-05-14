package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    /* Day 14 - Longest Substring Without Repeating Characters
    *
    * 🔹 Approach 1: Brute Force (Check All Substrings)
    * ----------------------------------------------
    * Idea:
    * - Generate all substrings
    * - Check if characters are unique using a Set
    *
    * How it works:
    * - For every starting index i:
    *     → Expand substring using j
    *     → Stop if duplicate character found
    *
    * - Track maximum length of valid substring
    *
    * Time Complexity:
    * - O(n^2)
    *
    * Space Complexity:
    * - O(n)
    *
    * Why this is not optimal:
    * - Repeatedly checks overlapping substrings
    */
    public static int longestSubstringWithoutRepeatingCharactersBruteforce(String s) {
        int n = s.length();
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < n; j++) {
                if (set.contains(s.charAt(j))) break;
                set.add(s.charAt(j));
                maxLen = Math.max(maxLen, j - i + 1);
            }
        }
        return maxLen;
    }

    /* Day 14 - Longest Substring Without Repeating Characters
    *
    * 🔹 Approach 2: Optimal (Sliding Window + HashMap)
    * ----------------------------------------------
    * Idea:
    * - Use two pointers to maintain a window of unique characters
    * - Expand window and shrink when duplicate appears
    *
    * How it works:
    * - Use left and right pointers
    *
    * - For each character:
    *     → If duplicate found:
    *         → Move left pointer to skip previous occurrence
    *
    * - Update maximum length at each step
    *
    * Time Complexity:
    * - O(n)
    *
    * Space Complexity:
    * - O(n)
    *
    * Why this is optimal:
    * - Each character is processed only once
    * - Efficient sliding window technique
    */
    public static int longestSubstringWithoutRepeatingCharactersOptimal(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLen = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (map.containsKey(ch)) {
                left = Math.max(left, map.get(ch) + 1);
            }
            map.put(ch, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
