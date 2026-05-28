package string;

public class AddBinary {
    /* Day 25 - Add Binary
    *
    * 🔹 Approach 1: Brute Force (Convert to Decimal)
    * ----------------------------------------------
    * Idea:
    * - Convert binary strings into decimal numbers
    * - Add numbers and convert back to binary
    *
    * How it works:
    * - Parse both binary strings
    * - Perform addition
    * - Convert result into binary string
    *
    * Time Complexity:
    * - O(n)
    *
    * Space Complexity:
    * - O(1)
    *
    * Why this is not optimal:
    * - May cause overflow for large binary strings
    * - Relies on built-in conversion methods
    */
    public static String addBinaryBruteforce(String a, String b) {
        int num1 = Integer.parseInt(a, 2);
        int num2 = Integer.parseInt(b, 2);
        int sum = num1 + num2;
        return Integer.toBinaryString(sum);
    }

    /* Day 25 - Add Binary
    *
    * 🔹 Approach 2: Optimal (Binary Addition Simulation)
    * ----------------------------------------------
    * Idea:
    * - Simulate binary addition manually
    * - Traverse strings from right to left
    *
    * How it works:
    * - Add digits along with carry
    *
    * - Current bit:
    *     → sum % 2
    *
    * - Carry:
    *     → sum / 2
    *
    * - Reverse final result
    *
    * Time Complexity:
    * - O(max(n, m))
    *
    * Space Complexity:
    * - O(max(n, m))
    *
    * Why this is optimal:
    * - Handles very large binary strings
    * - No integer overflow issues
    */
    public static String addBinaryOptimal(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }
            result.append(sum % 2);
            carry = sum / 2;
        }
        return result.reverse().toString();
    }
}
