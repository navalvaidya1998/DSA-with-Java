package string;
import java.util.*;

public class ZigzagConversion {
    /* Day 15 - Zigzag Conversion
    *
    * 🔹 Approach: Optimal (Simulation using Rows)
    * ----------------------------------------------
    * Idea:
    * - Simulate zigzag pattern row by row
    * - Traverse string while moving down and up
    *
    * How it works:
    * - Create a list of StringBuilder for each row
    *
    * - Traverse each character:
    *     → Add character to current row
    *     → Change direction when reaching top or bottom
    *
    * - Finally combine all rows
    *
    * Time Complexity:
    * - O(n)
    *
    * Space Complexity:
    * - O(n)
    *
    * Why this is optimal:
    * - Direct simulation of pattern
    * - No unnecessary computations
    */
    public static String zigzagConversionOptimal(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) return s;
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        int currentRow = 0;
        boolean goingDown = false;
        for (char ch : s.toCharArray()) {
            rows.get(currentRow).append(ch);
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }
            currentRow += goingDown ? 1 : -1;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }
        return result.toString();
    }
}