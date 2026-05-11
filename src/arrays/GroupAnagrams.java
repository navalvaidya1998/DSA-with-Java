package arrays;
import java.util.*;
public class GroupAnagrams {

    /* Day 12 - Group Anagrams
    *
    * 🔹 Approach: Optimal (HashMap + Sorted String)
    * ----------------------------------------------
    * Idea:
    * - Anagrams have same characters
    * - If we sort them, they become identical
    *
    * How it works:
    * - Traverse each string in array
    *
    * - For every string:
    *     → Convert to char array
    *     → Sort characters
    *     → Create key using sorted string
    *
    * - Store original string in HashMap using key
    *
    * - Finally return all values of map
    *
    * Time Complexity:
    * - O(n * k log k)
    *
    * Space Complexity:
    * - O(n * k)
    *
    * Why this is optimal:
    * - Efficient grouping using hashing
    * - Avoids comparing every pair of strings
    */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
