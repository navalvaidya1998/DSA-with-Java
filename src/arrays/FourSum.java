package arrays;

import java.util.*;

public class FourSum{
    /* Day 3
    * 🔹 Approach 1: Brute Force (4 Nested Loops)
    * -------------------------------------------
    * Idea:
    * - Try all possible quadruplets (i, j, k, l)
    * - Check if nums[i] + nums[j] + nums[k] + nums[l] == target
    *
    * Key Logic:
    * - Use 4 loops to generate all combinations
    * - Ensure indices are different: i < j < k < l
    * - Sort each quadruplet to maintain consistent order
    * - Use Set to avoid duplicate results
    *
    * Time Complexity: O(n⁴)
    *  - Four nested loops
    *
    * Space Complexity: O(n)
    *  - Set used to store unique quadruplets
    *
    * Advantage:
    * - Easy to understand and implement
    *
    * Disadvantage:
    * - Very slow for large inputs
    */
    public static List<List<Integer>> fourSumBruteForce(int[] nums, int target) {
        Set<List<Integer>> fourSumSet = new HashSet<>();
        int n = nums.length;

        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                for (int k = j + 1; k < n - 1; k++) {
                    for (int l = k + 1; l < n; l++) {
                        int sum = nums[i] + nums[j] + nums[k] + nums[l];
                        if (sum == target) {
                            List<Integer> fourSumList = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                            Collections.sort(fourSumList);
                            fourSumSet.add(fourSumList);
                        }
                    }
                }
            }
        }

        return new ArrayList<>(fourSumSet);
    }

    /* Day 3
    * 🔹 Approach 2: HashSet (can be use with 3Sum)
    * -----------------------------------------
    * Idea:
    * - Fix two elements nums[i] and nums[j]
    * - Reduce problem to finding two numbers whose sum = target - (nums[i] + nums[j])
    * - Use HashSet to efficiently find the remaining two numbers
    *
    * Key Logic:
    * - For each pair (i, j), use a Set to store visited elements
    * - For each k:
    *     fourth = target - (nums[i] + nums[j] + nums[k])
    * - If fourth exists in Set → valid quadruplet found
    * - Sort quadruplet before adding to Set to avoid duplicates
    *
    * Time Complexity: O(n³)
    *  - Two loops + one loop with HashSet lookup
    *
    * Space Complexity: O(n)
    *  - HashSet used for lookup
    *
    * Advantage:
    * - Faster than brute force
    * - Eliminates one loop using hashing
    *
    * Disadvantage:
    * - Extra space required
    * - Still needs sorting + Set for duplicate handling
    */

    public static List<List<Integer>> fourSumBetterApproach(int[] arr, int target) {
        Set<List<Integer>> fourSumSet = new HashSet<>();
        int n = arr.length;
        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                Set<Integer> fourthCheck = new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    int fourthValue = target - (arr[i] + arr[j] + arr[k]);
                    if (fourthCheck.contains(fourthValue)) {
                        List<Integer> fourSumList = Arrays.asList(arr[i], arr[j], arr[k], fourthValue);
                        Collections.sort(fourSumList);
                        fourSumSet.add(fourSumList);
                    }
                    fourthCheck.add(arr[k]);
                }
            }
        }

        return new ArrayList<>(fourSumSet);
    }

        /* Day 3
    * 🔹 Approach 3: Two Pointer (Optimal Solution)
    * ---------------------------------------------
    * Idea:
    * - Sort the array first
    * - Fix two elements nums[i] and nums[j]
    * - Use two pointers (left, right) to find remaining two elements
    *
    * Key Logic:
    * - For each pair (i, j), solve 2Sum using two pointers
    * - If sum < target → move left pointer forward
    * - If sum > target → move right pointer backward
    * - If sum == target → store quadruplet
    *
    * Duplicate Handling:
    * - Skip duplicate values for i and j
    * - Skip duplicate values for left and right after finding a match
    *
    * Time Complexity: O(n³)
    *  - Two loops + two pointer scan
    *
    * Space Complexity: O(1)
    *  - No extra space used (excluding result)
    *
    * Advantage:
    * - Most efficient solution for 4Sum
    * - No extra data structures needed
    *
    * Disadvantage:
    * - Slightly complex due to multiple pointers
    */

    public static List<List<Integer>> fourSumOptimalApproach(int[] arr, int target) {
        List<List<Integer>> fourSumList = new ArrayList<>();
        int n = arr.length;
        Arrays.sort(arr);
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && arr[j] == arr[j - 1]) continue;
                int left = j + 1;
                int right = n - 1;
                while (left < right) {
                    long sum = (long) arr[i] + arr[j] + arr[left] + arr[right];
                    if (sum < target) {
                        left++;
                    }
                    else if (sum > target) {
                        right--;
                    }
                    else {
                        fourSumList.add(Arrays.asList(arr[i], arr[j], arr[left], arr[right]));
                        while (left < right && arr[left] == arr[left + 1]) left++;
                        while (left < right && arr[right] == arr[right - 1]) right--;
                        left++;
                        right--;
                    }
                }
            }
        }

        return fourSumList;
    }
}