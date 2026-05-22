package string;

public class CountAndSay {
    /* Day 20 - Count and Say
    *
    * 🔹 Approach: Optimal (String Simulation)
    * ----------------------------------------------
    * Idea:
    * - Build sequence iteratively
    * - Read previous string and generate next string
    *
    * How it works:
    * - Start with "1"
    *
    * - For each iteration:
    *     → Count consecutive repeating characters
    *     → Append count followed by character
    *
    * - Repeat until nth sequence generated
    *
    * Time Complexity:
    * - O(n * m)
    *
    * Space Complexity:
    * - O(m)
    *
    * Why this is optimal:
    * - Direct sequence generation
    * - Efficient iterative simulation
    */
    public static String countAndSayOptimal(int n) {
        String result = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder current = new StringBuilder();
            int count = 1;
            for (int j = 1; j <= result.length(); j++) {
                if (j < result.length() && result.charAt(j) == result.charAt(j - 1)) {
                    count++;
                } else {
                    current.append(count);
                    current.append(result.charAt(j - 1));
                    count = 1;
                }
            }
            result = current.toString();
        }
        return result;
    }
}
