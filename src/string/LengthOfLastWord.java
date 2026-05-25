package string;

public class LengthOfLastWord {
    /* Day 23 - Length of Last Word
    *
    * 🔹 Approach 1: Brute Force (Split String)
    * ----------------------------------------------
    * Idea:
    * - Split string using spaces
    * - Return length of last word
    *
    * How it works:
    * - Trim trailing spaces
    * - Split string into words
    * - Return length of last word
    *
    * Time Complexity:
    * - O(n)
    *
    * Space Complexity:
    * - O(n)
    *
    * Why this is not optimal:
    * - Uses extra space for split array
    * - Additional string operations
    */
    public static int lengthOfLastWordBruteforce(String s) {
        s = s.trim();
        String[] words = s.split("\\s+");
        return words[words.length - 1].length();
    }

    /* Day 23 - Length of Last Word
    *
    * 🔹 Approach 2: Optimal (Reverse Traversal)
    * ----------------------------------------------
    * Idea:
    * - Traverse string from end
    * - Count characters of last word directly
    *
    * How it works:
    * - Ignore trailing spaces
    *
    * - Start counting characters:
    *     → Until space encountered
    *
    * - Return count
    *
    * Time Complexity:
    * - O(n)
    *
    * Space Complexity:
    * - O(1)
    *
    * Why this is optimal:
    * - No extra space used
    * - Single traversal solution
    */
    public static int lengthOfLastWordOptimal(String s) {
        int length = 0;
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }
        return length;
    }
}
