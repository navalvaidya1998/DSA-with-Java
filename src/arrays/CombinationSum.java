package arrays;
import java.util.*;
public class CombinationSum {

/*Day 7 - Combination Sum 
 *🔹 Approach: Backtracking (Optimal for Combination Sum)
 * ----------------------------------------------
 * Idea:
 * - Try all possible combinations using recursion
 * - At each step, we decide whether to include a number
 * - Since repetition is allowed, we stay on same index after picking
 *
 * How it works:
 * - Sort the array (helps in early stopping)
 * - Start from index = 0
 *
 * - For each element:
 *     → If it is greater than target → stop further loop (because sorted)
 *     → Otherwise:
 *         1. Pick the element
 *         2. Reduce target
 *         3. Call recursion again with same index (reuse allowed)
 *         4. Backtrack (remove last element)
 *
 * - Base case:
 *     → If target == 0 → valid combination → add to result
 *
 * Time Complexity:
 * - Exponential (depends on number of combinations)
 *
 * Space Complexity:
 * - O(k) recursion stack + list (k = combination length)
 *
 * Why this is optimal:
 * - We must explore all valid combinations
 * - Early stopping avoids unnecessary recursion
 */
public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, current, result);
        return result;
    }
    private static void backtrack(int[] arr, int target, int start, List<Integer> current,List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < arr.length; i++) {
            if (arr[i] > target) break;
            current.add(arr[i]);
            backtrack(arr, target - arr[i], i, current, result);
            current.remove(current.size() - 1);
        }
    }
}
