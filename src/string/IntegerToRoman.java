package string;

public class IntegerToRoman {
    /* Day 16 - Integer to Roman
    *
    * 🔹 Approach: Optimal (Greedy + Mapping)
    * ----------------------------------------------
    * Idea:
    * - Use predefined values and symbols
    * - Always pick the largest possible value
    *
    * How it works:
    * - Maintain arrays:
    *     → Integer values
    *     → Corresponding Roman symbols
    *
    * - Traverse values:
    *     → While number >= value:
    *         → Append symbol
    *         → Subtract value
    *
    * - Continue until number becomes 0
    *
    * Time Complexity:
    * - O(1)
    *
    * Space Complexity:
    * - O(1)
    *
    * Why this is optimal:
    * - Fixed number of Roman symbols
    * - Direct greedy construction
    */
    public static String integerToRomanOptimal(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                result.append(symbols[i]);
                num -= values[i];
            }
        }
        return result.toString();
    }
}