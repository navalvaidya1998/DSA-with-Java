package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
    /* Day 19 - Substring with Concatenation of All Words
    *
    * 🔹 Approach: Optimal (Sliding Window + HashMap)
    * ----------------------------------------------
    * Idea:
    * - Each word has same length
    * - Use sliding window to check valid concatenation
    *
    * How it works:
    * - Store word frequencies in a HashMap
    *
    * - Traverse string with different starting offsets
    *
    * - For each window:
    *     → Extract words of fixed length
    *     → Maintain current window frequency map
    *
    * - If frequency exceeds limit:
    *     → Shrink window from left
    *
    * - If all words matched:
    *     → Add starting index to result
    *
    * Time Complexity:
    * - O(n * wordLength)
    *
    * Space Complexity:
    * - O(number of words)
    *
    * Why this is optimal:
    * - Efficient fixed-size sliding window
    * - Avoids checking all permutations
    */
    public static List<Integer> substringWithConcatenationOfAllWordsOptimal(String s, String[] words) {
        List<Integer> result = new ArrayList<>();

        if (s == null || words == null || words.length == 0) {
            return result;
        }

        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        int wordLength = words[0].length();
        int totalWords = words.length;

        for (int i = 0; i < wordLength; i++) {
            int left = i;
            int count = 0;

            Map<String, Integer> currentMap = new HashMap<>();

            for (int right = i; right + wordLength <= s.length(); right += wordLength) {
                String word = s.substring(right, right + wordLength);

                if (wordCount.containsKey(word)) {
                    currentMap.put(word, currentMap.getOrDefault(word, 0) + 1);
                    count++;

                    while (currentMap.get(word) > wordCount.get(word)) {
                        String leftWord = s.substring(left, left + wordLength);

                        currentMap.put(leftWord, currentMap.get(leftWord) - 1);

                        left += wordLength;
                        count--;
                    }

                    if (count == totalWords) {
                        result.add(left);

                        String leftWord = s.substring(left, left + wordLength);

                        currentMap.put(leftWord, currentMap.get(leftWord) - 1);

                        left += wordLength;
                        count--;
                    }
                } else {
                    currentMap.clear();
                    count = 0;
                    left = right + wordLength;
                }
            }
        }

        return result;
    }
}