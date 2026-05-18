package string;
import java.util.*;
public class RomanToInteger {
    /* Day 17 - Roman to Integer
    *
    * 🔹 Approach: Optimal (Traversal + Mapping)
    * ----------------------------------------------
    * Idea:
    * - Convert Roman characters to values
    * - Traverse string and decide to add or subtract
    *
    * How it works:
    * - Map Roman symbols to integer values
    *
    * - Traverse string from left to right:
    *     → If current value < next value:
    *         → Subtract current value
    *     → Else:
    *         → Add current value
    *
    * - This handles cases like:
    *     → IV = 4 (5 - 1)
    *     → IX = 9 (10 - 1)
    *
    * Time Complexity:
    * - O(n)
    *
    * Space Complexity:
    * - O(1)
    *
    * Why this is optimal:
    * - Single pass traversal
    * - Constant space mapping
    */
    public static int romanToIntegerOptimal(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int curr = map.get(s.charAt(i));
            if (i < s.length() - 1 && curr < map.get(s.charAt(i + 1))) {
                result -= curr;
            } else {
                result += curr;
            }
        }
        return result;
    }
}
