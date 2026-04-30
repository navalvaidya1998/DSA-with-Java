package arrays;

public class RemoveElement {
    /* Day 4
    * 🔹 Approach 1: Two Pointer (In Place - Stable)
    * ----------------------------------------------
    * Idea:
    * - Use two pointers to overwrite elements not equal to val
    * - Maintain order of remaining elements
    *
    * Key Logic:
    * - Pointer i tracks position to place valid elements
    * - Pointer j scans the array
    * - If nums[j] != val, assign nums[i] = nums[j] and increment i
    * - Skip elements equal to val
    *
    * Time Complexity: O(n)
    *  - Single traversal
    *
    * Space Complexity: O(1)
    *  - In-place modification
    *
    * Advantage:
    * - Maintains order of elements
    * - Simple and reliable
    *
    * Disadvantage:
    * - Slightly more writes compared to swap approach
    */

    public static int removeElementOptimal(int[] arr, int val) {
        int i = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != val) {
                arr[i++] = arr[j];
            }
        }
        return i;
    }

    /* 🔹 Approach 2: Swap with End (In Place - Unstable)
    * --------------------------------------------------
    * Idea:
    * - Replace elements equal to val with last element
    * - Reduce effective array size
    *
    * Key Logic:
    * - Use pointer i to traverse array
    * - If nums[i] == val:
    *      replace nums[i] with nums[n-1]
    *      decrease n (array size)
    * - Else:
    *      increment i
    *
    * Important:
    * - Do NOT increment i after swap
    * - Because swapped element must be checked again
    *
    * Time Complexity: O(n)
    *  - Each element processed at most once
    *
    * Space Complexity: O(1)
    *  - In-place modification
    *
    * Advantage:
    * - Fewer write operations in some cases
    *
    * Disadvantage:
    * - Does NOT maintain order of elements
    * - Easy to introduce bugs if pointer movement is wrong
    *
    * Testing Note:
    * - Both approaches modify array in-place
    * - Always use separate copies of array while testing
    */
    public static int removeElementSwap(int[] nums, int val) {
    int i = 0;
    int n = nums.length;

        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } else {
                i++;
            }
        }
        return n;
    }
}

