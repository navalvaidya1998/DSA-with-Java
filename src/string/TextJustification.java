package string;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    /* Day 24 - Text Justification
    *
    * 🔹 Approach: Optimal (Greedy + String Simulation)
    * ----------------------------------------------
    * Idea:
    * - Pack maximum words into each line
    * - Distribute spaces evenly between words
    *
    * How it works:
    * - Select words that fit in current line
    *
    * - Calculate total spaces required
    *
    * - If last line or single word:
    *     → Left justify line
    *
    * - Otherwise:
    *     → Distribute spaces evenly
    *     → Extra spaces added from left side
    *
    * Time Complexity:
    * - O(n)
    *
    * Space Complexity:
    * - O(n)
    *
    * Why this is optimal:
    * - Single traversal through words
    * - Efficient greedy line construction
    */
    public static List<String> textJustificationOptimal(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int index = 0;
        while (index < words.length) {
            int totalChars = words[index].length();
            int last = index + 1;
            while (last < words.length) {
                if (totalChars + 1 + words[last].length() > maxWidth) {
                    break;
                }
                totalChars += 1 + words[last].length();
                last++;
            }
            StringBuilder line = new StringBuilder();
            int numberOfWords = last - index;
            int gaps = numberOfWords - 1;
            if (last == words.length || gaps == 0) {
                for (int i = index; i < last; i++) {
                    line.append(words[i]);
                    if (i < last - 1) {
                        line.append(" ");
                    }
                }
                while (line.length() < maxWidth) {
                    line.append(" ");
                }
            } else {
                int totalSpaces = maxWidth;
                for (int i = index; i < last; i++) {
                    totalSpaces -= words[i].length();
                }
                int spacePerGap = totalSpaces / gaps;
                int extraSpaces = totalSpaces % gaps;
                for (int i = index; i < last; i++) {
                    line.append(words[i]);
                    if (i < last - 1) {
                        for (int j = 0; j < spacePerGap; j++) {
                            line.append(" ");
                        }
                        if (extraSpaces > 0) {
                            line.append(" ");
                            extraSpaces--;
                        }
                    }
                }
            }
            result.add(line.toString());
            index = last;
        }
        return result;
    }
}