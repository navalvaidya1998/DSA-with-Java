package arrays;

public class SearchinRotatedSortedArray{

    /* Day 5
    * 🔹 Approach 1: Brute Force (Linear Search)
    * -----------------------------------------
    * Idea:
    * - Ignore the rotation and simply traverse the array
    * - Compare each element with the target
    *
    * Key Logic:
    * - Loop through the array from index 0 to n-1
    * - If arr[i] == target → return i
    * - If loop ends and target not found → return -1
    *
    * Time Complexity: O(n)
    *  - In worst case, we check every element
    *
    * Space Complexity: O(1)
    *  - No extra space used
    *
    * Advantage:
    * - Very simple and easy to implement
    * - Works regardless of rotation
    *
    * Disadvantage:
    * - Does not utilize sorted property
    * - Not optimal (problem expects O(log n))
    */
    public static int searchinRotatedSortedArrayBruteForce(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    /* 🔹 Approach 2: Optimal (Modified Binary Search)
    * ----------------------------------------------
    * Idea:
    * - Use binary search since array is partially sorted
    * - At least one half (left or right) is always sorted
    *
    * Key Logic:
    * - Find mid element
    * - Check which half is sorted:
    *     → If arr[low] <= arr[mid], left half is sorted
    *     → Else, right half is sorted
    *
    * - Check if target lies in the sorted half:
    *     → If yes, move inside that half
    *     → Else, move to the other half
    *
    * - Repeat until target is found or search space is exhausted
    *
    * Time Complexity: O(log n)
    *  - Binary search reduces search space by half each time
    *
    * Space Complexity: O(1)
    *  - No extra space used
    *
    * Advantage:
    * - Efficient and meets problem constraints
    *
    * Disadvantage:
    * - Slightly tricky logic compared to brute force
    */
    public static int searchinRotatedSortedArrayOptimal(int[] arr, int target) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[low] <= arr[mid]) {
                if (target >= arr[low] && target < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            else {
                if (target > arr[mid] && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
