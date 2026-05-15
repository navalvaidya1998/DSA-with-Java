package string;

public class StringToIntegerAtoi {
    /* Day 15 - String to Integer (atoi)
    *
    * 🔹 Approach: Optimal (Simulation + Edge Case Handling)
    * ----------------------------------------------
    * Idea:
    * - Convert string to integer step by step
    * - Handle spaces, sign, digits, and overflow
    *
    * How it works:
    * - Ignore leading whitespaces
    *
    * - Check sign:
    *     → '+' means positive
    *     → '-' means negative
    *
    * - Traverse digits:
    *     → Convert character to number
    *     → Build result = result * 10 + digit
    *
    * - Handle overflow:
    *     → If result exceeds Integer range, return limit
    *
    * - Stop when non-digit character appears
    *
    * Time Complexity:
    * - O(n)
    *
    * Space Complexity:
    * - O(1)
    *
    * Why this is optimal:
    * - Single pass solution
    * - Handles all edge cases efficiently
    */
    public static int stringToIntegerAtoiOptimal(String s) {
        int i = 0, n = s.length();
        int sign = 1;
        long result = 0;
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            result = result * 10 + digit;
            if (sign * result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign * result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            i++;
        }
        return (int)(sign * result);
    }
}
