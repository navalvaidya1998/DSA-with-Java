package arrays;
public class SearchInsertPosition {

    /* 🔹 Approach 1: Brute Force (Linear Scan)
    * ----------------------------------------------
    * Idea:
    * - Traverse the array from left to right
    * - Find the first position where element ≥ target
    * - That index will be the correct insert position
    *
    * Key Logic:
    * - Loop through each element:
    *     → If arr[i] ≥ target → return i
    *
    * - If no such element is found:
    *     → Target is greater than all elements
    *     → Return n (insert at end)
    *
    * Time Complexity: O(n)
    *  - In worst case, we traverse the entire array
    *
    * Space Complexity: O(1)
    *  - No extra space used
    *
    * Advantage:
    * - Very simple and easy to understand
    * - Works for both small and large inputs
    *
    * Disadvantage:
    * - Not efficient compared to binary search
    * - Does not utilize the sorted property of array
    */
    public static int searchInsertBruteforce(int[] arr, int target) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] >= target) {
                return i;
            }
        }
        return n;
    }

    /* 🔹 Approach 2: Optimal (Binary Search / Lower Bound)
    * ----------------------------------------------
    * Idea:
    * - Since the array is sorted, use binary search
    * - Find the first index where element ≥ target
    * - This index is either:
    *     → The position of target (if present)
    *     → OR the correct insert position (if not present)
    *
    * Key Logic:
    * - Initialize low = 0, high = n
    *
    * - While low < high:
    *     → Find mid index
    *
    *     → If arr[mid] < target:
    *          - Target lies on right side → move low = mid + 1
    *
    *     → Else:
    *          - Possible answer → move high = mid
    *
    * - Loop ends when low == high
    *     → This is the correct insert position
    *
    * Time Complexity: O(log n)
    *  - Binary search reduces search space by half each step
    *
    * Space Complexity: O(1)
    *  - No extra space used
    *
    * Advantage:
    * - Efficient and meets optimal constraints
    * - Fully utilizes sorted nature of array
    *
    * Disadvantage:
    * - Slightly less intuitive than brute force
    */
    public static int searchInsertOptimal(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
