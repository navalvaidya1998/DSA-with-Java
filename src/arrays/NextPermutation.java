package arrays;

public class NextPermutation {
    /* Day 5
    * 🔹 Approach: Optimal (Greedy + In-place Modification)
    * ----------------------------------------------------
    * Idea:
    * - We want the next lexicographically greater permutation
    * - Instead of generating all permutations, we slightly increase the current arrangement
    *
    * Key Logic:
    * - Traverse from right and find the first index 'i' such that nums[i] < nums[i+1]
    *   → This is called the breakpoint
    *
    * - If no such index exists:
    *   → Array is in descending order (last permutation)
    *   → Reverse the entire array to get the smallest permutation
    *
    * - Otherwise:
    *   → Traverse from right again and find element just greater than nums[i]
    *   → Swap that element with nums[i]
    *
    * - Finally:
    *   → Reverse the part of the array after index 'i'
    *   → This ensures the next smallest lexicographical order
    *
    * Time Complexity: O(n)
    *  - Single pass to find breakpoint
    *  - Single pass to find next greater element
    *  - Single pass to reverse suffix
    *
    * Space Complexity: O(1)
    *  - In-place modification, no extra space used
    *
    * Advantage:
    * - Efficient and optimal solution
    * - No extra memory required
    *
    * Disadvantage:
    * - Slightly tricky to understand at first
    */
    public static void nextPermutation(int[] arr) {
        int n = arr.length;
        int i = n - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = n - 1;
            while (arr[j] <= arr[i]) {
                j--;
            }
            swap(arr, i, j);
        }
        reverse(arr, i + 1, n - 1);
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start++, end--);
        }
    }
}
