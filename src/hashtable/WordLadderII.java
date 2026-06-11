package hashtable;

import java.util.*;

public class WordLadderII {
    /* Day 29 - Word Ladder II
    *
    * 🔹 Approach 1: Brute Force (DFS All Paths)
    * ----------------------------------------------
    * Idea:
    * - Try every possible word transformation recursively
    * - Store paths reaching endWord
    *
    * How it works:
    * - Generate neighboring words
    * - Visit unused words recursively
    * - Collect all valid paths
    *
    * Time Complexity:
    * - Exponential
    *
    * Space Complexity:
    * - O(n)
    *
    * Why this is not optimal:
    * - Explores many unnecessary paths
    * - Causes TLE for large inputs
    */

    /* Day 29 - Word Ladder II
    *
    * 🔹 Approach 2: Optimal (BFS + Backtracking)
    * ----------------------------------------------
    * Idea:
    * - Use BFS to build shortest path graph
    * - Use DFS to reconstruct all shortest sequences
    *
    * How it works:
    * - BFS stores parents of each word
    * - Only shortest transformations are kept
    * - DFS backtracks from endWord to beginWord
    *
    * Time Complexity:
    * - O(N × L × 26)
    *
    * Space Complexity:
    * - O(N)
    *
    * Why this is optimal:
    * - Finds only shortest sequences
    * - Avoids exploring longer paths
    */
    public static List<List<String>> wordLadderIIOptimal(String beginWord,
                                                         String endWord,
                                                         List<String> wordList) {

        Set<String> dictionary = new HashSet<>(wordList);
        List<List<String>> result = new ArrayList<>();

        if (!dictionary.contains(endWord)) {
            return result;
        }

        Map<String, List<String>> parents = new HashMap<>();
        Map<String, Integer> level = new HashMap<>();

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        level.put(beginWord, 0);

        while (!queue.isEmpty()) {
            String currentWord = queue.poll();
            int currentLevel = level.get(currentWord);

            char[] chars = currentWord.toCharArray();

            for (int i = 0; i < chars.length; i++) {
                char original = chars[i];

                for (char ch = 'a'; ch <= 'z'; ch++) {
                    chars[i] = ch;
                    String nextWord = new String(chars);

                    if (!dictionary.contains(nextWord)) {
                        continue;
                    }

                    if (!level.containsKey(nextWord)) {
                        level.put(nextWord, currentLevel + 1);
                        queue.offer(nextWord);
                        parents.put(nextWord, new ArrayList<>());
                        parents.get(nextWord).add(currentWord);
                    } else if (level.get(nextWord) == currentLevel + 1) {
                        parents.get(nextWord).add(currentWord);
                    }
                }

                chars[i] = original;
            }
        }

        if (!level.containsKey(endWord)) {
            return result;
        }

        List<String> path = new ArrayList<>();
        buildPaths(endWord, beginWord, parents, path, result);

        return result;
    }

    private static void buildPaths(String word,
                                   String beginWord,
                                   Map<String, List<String>> parents,
                                   List<String> path,
                                   List<List<String>> result) {

        path.add(word);

        if (word.equals(beginWord)) {
            List<String> sequence = new ArrayList<>(path);
            Collections.reverse(sequence);
            result.add(sequence);
        } else {
            for (String parent : parents.getOrDefault(word, new ArrayList<>())) {
                buildPaths(parent, beginWord, parents, path, result);
            }
        }

        path.remove(path.size() - 1);
    }
}
