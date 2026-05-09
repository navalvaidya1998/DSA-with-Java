package arrays;
import java.util.ArrayList;
import java.util.List;
public class PermutationsII {
    /* Day 11 - Permutations II
    *
    * 🔹 Approach: Optimal (Backtracking with In-place Swapping + Duplicate Check)
    * ----------------------------------------------
    * Idea:
    * - Generate permutations using swapping (in-place)
    * - Avoid duplicates by checking if an element is already used at current recursion level
    *
    * How it works:
    * - Start from index 0
    *
    * - For every index i from start to n:
    *     → Check if current element should be skipped using shouldSkip()
    *     → This ensures no duplicate element is chosen at the same level
    *
    * - If valid:
    *     → Swap nums[start] with nums[i]
    *     → Recursively generate permutations for next index (start + 1)
    *
    * - Once start == n:
    *     → Convert array to list and add to result
    *
    * - Backtrack:
    *     → Swap back to restore original array state
    *
    * Duplicate Handling:
    * - For each recursion level:
    *     → Check elements in range [start, current)
    *     → If same value already exists, skip current element
    *
    * Time Complexity:
    * - O(n! * n)
    *
    * Space Complexity:
    * - O(n) (recursion stack)
    *
    * Why this is optimal:
    * - Generates only unique permutations
    * - No extra space like Set or visited array
    * - Uses in-place swapping for efficiency
    */
    public static List<List<Integer>> permutations2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, result);
        return result;
    }
    private static void backtrack(int[] nums, int start, List<List<Integer>> result) {
        if (start == nums.length) {
            result.add(convertToList(nums));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (shouldSkip(nums, start, i)) continue;
            swap(nums, start, i);
            backtrack(nums, start + 1, result);
            swap(nums, start, i);
        }
    }
    private static List<Integer> convertToList(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        return list;
    }
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private static boolean shouldSkip(int[] nums, int start, int current) {
        for (int i = start; i < current; i++) {
            if (nums[i] == nums[current]) {
                return true;
            }
        }
        return false;
    }
}
