package arrays;
public class LongestCommonPrefix {
    /* Day 2
     * 🔹 Approach 1: Horizontal Scanning
     * ----------------------------------
     * Idea:
     * - Take the first string as the initial prefix
     * - Compare this prefix with each string in the array
     * - If the current string does not start with the prefix,
     *   keep reducing the prefix (remove last character)
     * - Repeat until the prefix matches or becomes empty
     *
     * Key Logic:
     * - Use startsWith() to check prefix match
     * - Gradually shrink prefix using substring()
     *
     * Time Complexity: O(n * m)
     *  - n = number of strings
     *  - m = length of prefix
     *
     * Space Complexity: O(1)
     *  - No extra space used
     *
     * Advantage:
     * - Simple and easy to understand
     * - Stops early if prefix becomes empty
     */
    public static String longestCommonPrefixHorizontal(String[] strs){
        if(strs.length<1) return "";
        String prefix = strs[0];
        for (String str : strs) {
            while (!str.startsWith(prefix)) {
                prefix = prefix.substring(0,prefix.length()-1);
                if(prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
    /* Day 2
     * 🔹 Approach 2: Vertical Scanning
     * --------------------------------
     * Idea:
     * - Compare characters column by column (index-wise)
     * - Take first string as reference
     * - For each character index i:
     *      compare with same index in all strings
     * - Stop when:
     *      1. Index exceeds any string length
     *      2. Characters do not match
     *
     * Key Logic:
     * - If mismatch or string ends → return substring(0, i)
     *
     * Time Complexity: O(n * m)
     *  - n = number of strings
     *  - m = length of shortest string
     *
     * Space Complexity: O(1)
     *  - No extra space used
     *
     * Advantage:
     * - Efficient due to early stopping on mismatch
     * - Cleaner comparison logic
     */
    public static String longestCommonPrefixVertical(String[] strs){
        if(strs.length<1) return "";
        for(int i=0;i<strs[0].length();i++){
            char c = strs[0].charAt(i);
            for (String str : strs) {
                if (i >= str.length() || str.charAt(i) != c) {
                    return strs[0].substring(0,i);
                }
            }
        }
        return "";
    }
}
