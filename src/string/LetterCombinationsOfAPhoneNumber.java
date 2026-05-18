package string;

import java.util.*;
public class LetterCombinationsOfAPhoneNumber {
    /* Day 17 - Letter Combinations of a Phone Number
    *
    * 🔹 Approach: Optimal (Backtracking)
    * ----------------------------------------------
    * Idea:
    * - Each digit maps to multiple characters
    * - Generate all combinations using recursion
    *
    * How it works:
    * - Use a mapping of digits to letters
    *
    * - Start from index 0:
    *     → For each character of current digit:
    *         → Add to current combination
    *         → Recurse for next digit
    *
    * - When length equals input length:
    *     → Add combination to result
    *
    * Time Complexity:
    * - O(4^n)
    *
    * Space Complexity:
    * - O(n)
    *
    * Why this is optimal:
    * - Explores all valid combinations efficiently
    * - Standard backtracking approach
    */
    public static List<String> letterCombinationsOfAPhoneNumberOptimal(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;

        String[] map = {
            "", "", "abc", "def", "ghi", "jkl",
            "mno", "pqrs", "tuv", "wxyz"
        };

        backtrack(0, digits, new StringBuilder(), result, map);
        return result;
    }
    private static void backtrack(int index, String digits, StringBuilder current, List<String> result, String[] map) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }
        String letters = map[digits.charAt(index) - '0'];
        for (char ch : letters.toCharArray()) {
            current.append(ch);
            backtrack(index + 1, digits, current, result, map);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
