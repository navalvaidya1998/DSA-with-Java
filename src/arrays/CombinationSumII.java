package arrays;
import java.util.*;
public class CombinationSumII {
    /* Day 8 - Combination Sum II
    * 🔹 Approach: Brute Force (Generate all + remove duplicates)
    * ----------------------------------------------
    * Idea:
    * - Try all possible subsets using recursion
    * - For each subset, check if sum equals target
    * - Since duplicates exist, use a Set to avoid duplicate combinations
    *
    * How it works:
    * - Sort the array (to keep combinations in consistent order)
    *
    * - At each index:
    *     → We have two choices:
    *         1. Pick the element
    *         2. Skip the element
    *
    * - If we pick:
    *     → Add element to list
    *     → Reduce target
    *     → Move to next index
    *
    * - If we skip:
    *     → Just move to next index
    *
    * - Base cases:
    *     → If target == 0 → valid combination → add to Set
    *     → If index == n OR target < 0 → stop recursion
    *
    * Time Complexity:
    * - O(2^n) (explores all subsets)
    *
    * Space Complexity:
    * - O(k) recursion stack + Set (extra space for duplicates removal)
    *
    * Why this is not optimal:
    * - Generates duplicate combinations
    * - Uses extra Set to filter duplicates
    * - Does unnecessary work
    */
    public static List<List<Integer>> combinationSumIIBruteForce(int[] arr, int target) {
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(arr);
        backtrack(0, arr, target, new ArrayList<>(), set);
        return new ArrayList<>(set);
    }
    private static void backtrack(int index, int[] arr, int target,
                           List<Integer> temp, Set<List<Integer>> set) {
        if (target == 0) {
            set.add(new ArrayList<>(temp));
            return;
        }
        if (index == arr.length || target < 0) return;
        temp.add(arr[index]);
        backtrack(index + 1, arr, target - arr[index], temp, set);
        temp.remove(temp.size() - 1);
        backtrack(index + 1, arr, target, temp, set);
    }

    /* Day 8 - Combination Sum II
    * 🔹 Approach: Backtracking (Optimal with duplicate skipping)
    * ----------------------------------------------
    * Idea:
    * - Use backtracking to generate combinations
    * - Avoid duplicates during recursion itself (instead of removing later)
    *
    * How it works:
    * - Sort the array (important for skipping duplicates and early stopping)
    *
    * - Start from index = 0
    *
    * - For each element:
    *     → If it is same as previous element at same level → skip it
    *         (i > index && arr[i] == arr[i - 1])
    *
    *     → If element > target → break loop (no need to check further)
    *
    *     → Otherwise:
    *         1. Pick the element
    *         2. Reduce target
    *         3. Move to next index (no reuse allowed)
    *         4. Backtrack (remove last element)
    *
    * - Base case:
    *     → If target == 0 → valid combination → add to result
    *
    * Time Complexity:
    * - Exponential (depends on number of valid combinations)
    *
    * Space Complexity:
    * - O(k) recursion stack + list (k = combination length)
    *
    * Why this is optimal:
    * - Avoids generating duplicate combinations
    * - Uses early stopping to reduce recursion
    * - No extra space like Set is required
    */

    public static List<List<Integer>> combinationSumIIOptimal(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        solve(0, arr, target, new ArrayList<>(), result);
        return result;
    }
    private static void solve(int index, int[] arr, int target,
                       List<Integer> curr, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1]) continue;
            if (arr[i] > target) break;
            curr.add(arr[i]);
            solve(i + 1, arr, target - arr[i], curr, result);
            curr.remove(curr.size() - 1);
        }
    }
}
