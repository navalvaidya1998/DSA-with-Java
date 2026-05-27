package string;

public class ValidNumber {
    /* Day 23 - Valid Number
    *
    * 🔹 Approach 1: Brute Force (Using Parsing)
    * ----------------------------------------------
    * Idea:
    * - Try converting string into number
    * - Catch exception if invalid
    *
    * How it works:
    * - Trim spaces
    * - Use Double.parseDouble()
    * - Return true if parsing succeeds
    *
    * Time Complexity:
    * - O(n)
    *
    * Space Complexity:
    * - O(1)
    *
    * Why this is not optimal:
    * - Relies on built-in parsing
    * - Does not validate manually
    */
    public static boolean validNumberBruteforce(String s) {
        try {
            Double.parseDouble(s.trim());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* Day 23 - Valid Number
    *
    * 🔹 Approach 2: Optimal (Manual Validation)
    * ----------------------------------------------
    * Idea:
    * - Traverse string and validate character rules
    * - Track digits, decimal point, and exponent
    *
    * How it works:
    * - Ignore leading and trailing spaces
    *
    * - Digits:
    *     → Mark number found
    *
    * - Decimal point:
    *     → Allowed only once before exponent
    *
    * - Exponent:
    *     → Allowed once
    *     → Must have number before it
    *
    * - Sign:
    *     → Allowed at beginning or after exponent
    *
    * Time Complexity:
    * - O(n)
    *
    * Space Complexity:
    * - O(1)
    *
    * Why this is optimal:
    * - Manual single-pass validation
    * - No built-in parsing methods used
    */
    public static boolean validNumberOptimal(String s) {
        s = s.trim();
        boolean numberSeen = false;
        boolean dotSeen = false;
        boolean exponentSeen = false;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                numberSeen = true;
            } else if (ch == '.') {
                if (dotSeen || exponentSeen) {
                    return false;
                }
                dotSeen = true;
            } else if (ch == 'e' || ch == 'E') {
                if (exponentSeen || !numberSeen) {
                    return false;
                }
                exponentSeen = true;
                numberSeen = false;
            } else if (ch == '+' || ch == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return numberSeen;
    }
}