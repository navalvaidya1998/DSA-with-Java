package string;

public class MultiplyStrings {
    /* Day 21 - Multiply Strings
    *
    * 🔹 Approach 1: Brute Force (Using BigInteger)
    * ----------------------------------------------
    * Idea:
    * - Convert strings into numbers
    * - Multiply directly using BigInteger
    *
    * How it works:
    * - Convert num1 and num2 into BigInteger
    * - Multiply both numbers
    * - Convert result back to string
    *
    * Time Complexity:
    * - O(n * m)
    *
    * Space Complexity:
    * - O(n + m)
    *
    * Why this is not optimal:
    * - Uses built-in library support
    * - Does not demonstrate manual multiplication logic
    */
    public static String multiplyStringsBruteforce(String num1, String num2) {
        java.math.BigInteger n1 = new java.math.BigInteger(num1);
        java.math.BigInteger n2 = new java.math.BigInteger(num2);
        return n1.multiply(n2).toString();
    }

    /* Day 21 - Multiply Strings
    *
    * 🔹 Approach 2: Optimal (Manual Multiplication)
    * ----------------------------------------------
    * Idea:
    * - Simulate multiplication like pen-and-paper method
    * - Store intermediate results in array
    *
    * How it works:
    * - Traverse digits from right to left
    *
    * - Multiply every digit pair:
    *     → Store carry and remainder in result array
    *
    * - Build final string from result array
    *
    * - Ignore leading zeros
    *
    * Time Complexity:
    * - O(n * m)
    *
    * Space Complexity:
    * - O(n + m)
    *
    * Why this is optimal:
    * - Does not use BigInteger
    * - Efficient manual multiplication approach
    */
    public static String multiplyStringsOptimal(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int n = num1.length();
        int m = num2.length();
        int[] result = new int[n + m];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = mul + result[i + j + 1];
                result[i + j + 1] = sum % 10;
                result[i + j] += sum / 10;
            }
        }
        StringBuilder answer = new StringBuilder();
        for (int num : result) {
            if (!(answer.length() == 0 && num == 0)) {
                answer.append(num);
            }
        }
        return answer.toString();
    }
}
