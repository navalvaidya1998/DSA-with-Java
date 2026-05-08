package arrays;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    /* Day 10 - Permutations
    *
    * 🔹 Approach 1: Brute Force (Using Visited Array)
    * ----------------------------------------------
    * Idea:
    * - Generate permutations by picking unused elements
    * - Track used elements using a visited array
    *
    * How it works:
    * - Start with an empty list
    *
    * - For every index i:
    *     → If not visited:
    *         → Mark as visited
    *         → Add to current list
    *
    * - Recursively build permutation
    *
    * - Once size == n:
    *     → Add to result
    *
    * - Backtrack:
    *     → Remove element
    *     → Mark as unvisited
    *
    * Time Complexity:
    * - O(n! * n)
    *
    * Space Complexity:
    * - O(n)
    *
    * Why this is not optimal:
    * - Uses extra space for visited array
    */
    public static List<List<Integer>> permutationsBruteforce(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        helper(nums, visited, new ArrayList<>(), res);
        return res;
    }
    private static void helper(int[] nums, boolean[] visited, List<Integer> curr, List<List<Integer>> res) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            curr.add(nums[i]);
            helper(nums, visited, curr, res);
            curr.remove(curr.size() - 1);
            visited[i] = false;
        }
    }

    /* Day 10 - Permutations
    *
    * 🔹 Approach 2: Optimal (Backtracking with In-place Swapping)
    * ----------------------------------------------
    * Idea:
    * - Fix elements by swapping positions
    * - Generate permutations in-place
    *
    * How it works:
    * - Start from index 0
    *
    * - For every index i:
    *     → Swap current index with i
    *     → Recursively solve for next index
    *
    * - Once index == n:
    *     → Store permutation
    *
    * - Backtrack:
    *     → Swap back to original position
    *
    * Time Complexity:
    * - O(n! * n)
    *
    * Space Complexity:
    * - O(n)
    *
    * Why this is optimal:
    * - No extra data structures used
    * - In-place and efficient solution
    */
    public static List<List<Integer>> permutationsOptimal(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, 0, res);
        return res;
    }
    private static void helper(int[] nums, int index, List<List<Integer>> res) {
        if (index == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) list.add(num);
            res.add(list);
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            helper(nums, index + 1, res);
            swap(nums, index, i);
        }
    }
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
