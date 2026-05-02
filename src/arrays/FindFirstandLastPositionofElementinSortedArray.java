package arrays;

public class FindFirstandLastPositionofElementinSortedArray {

    /* 🔹 Approach 1: Brute Force (Linear Scan)
    * ----------------------------------------------
    * Idea:
    * - Traverse the entire array and track positions of target
    * - Since array may contain duplicates, store:
    *     → First occurrence (start)
    *     → Last occurrence (end)
    *
    * Key Logic:
    * - Initialize start = -1 and end = -1
    * - Loop through array from left to right:
    *     → If element == target:
    *          - If start is not set, assign current index to start
    *          - Always update end to current index
    *
    * - After traversal:
    *     → If target found → return [start, end]
    *     → Else → return [-1, -1]
    *
    * Time Complexity: O(n)
    *  - We scan the entire array once
    *
    * Space Complexity: O(1)
    *  - No extra space used
    *
    * Advantage:
    * - Simple and easy to implement
    * - Works for both sorted and unsorted arrays
    *
    * Disadvantage:
    * - Not efficient for large inputs compared to binary search
    */
    public static int[] FindFirstandLastPositionofElementinSortedArrayBruteForce(int[] arr, int target){
        int n= arr.length;
        int start=-1;
        int end=-1;
        for(int i=0;i<n;i++){
            if(arr[i]==target){
                if(start==-1){
                    start=i;
                }
                end=i;
            }
        }return new int[] {start,end};
    }


    /* 🔹 Approach 2: Optimal (Modified Binary Search)
    * ----------------------------------------------
    * Idea:
    * - Since the array is sorted, use binary search to find boundaries
    * - Instead of finding just one occurrence, find:
    *     → First occurrence (left boundary)
    *     → Last occurrence (right boundary)
    *
    * Key Logic:
    * - Run binary search twice:
    *
    *   1) findFirst():
    *      → When target is found, store index
    *      → Move left (high = mid - 1) to find earlier occurrence
    *
    *   2) findLast():
    *      → When target is found, store index
    *      → Move right (low = mid + 1) to find later occurrence
    *
    * - Continue until search space is exhausted
    *
    * Time Complexity: O(log n)
    *  - Binary search runs twice → O(log n) + O(log n) = O(log n)
    *
    * Space Complexity: O(1)
    *  - No extra space used
    *
    * Advantage:
    * - Efficient and meets optimal constraints
    * - Works well for large sorted arrays
    *
    * Disadvantage:
    * - Requires understanding of boundary-based binary search
    */
    public static int[] FindFirstandLastPositionofElementinSortedArrayOptimal1(int[] arr,int target){
        int first = findFirst(arr, target);
        int last = findLast(arr, target);
        return new int[] {first, last};
    }
    private static int findFirst(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                ans = mid;
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
    private static int findLast(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                ans = mid;
                low = mid + 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    /* 🔹 Approach 3: Optimal (Lower Bound Technique)
    * ----------------------------------------------
    * Idea:
    * - Use binary search to find insertion positions (lower bounds)
    * - Instead of writing two separate searches, reuse one function
    *
    * Key Logic:
    * - lowerBound(target):
    *     → Gives first index where element ≥ target
    *     → This is the first occurrence of target
    *
    * - lowerBound(target + 1):
    *     → Gives first index where element > target
    *     → So last occurrence = (that index - 1)
    *
    * - Final Answer:
    *     → first = lowerBound(target)
    *     → last  = lowerBound(target + 1) - 1
    *
    * - Validation:
    *     → If first is out of bounds OR nums[first] != target
    *       → target not present → return [-1, -1]
    *
    * Time Complexity: O(log n)
    *  - Binary search runs twice → O(log n)
    *
    * Space Complexity: O(1)
    *  - No extra space used
    *
    * Advantage:
    * - Clean and reusable approach
    * - Uses single helper function (lowerBound)
    * - Closest to STL (C++ lower_bound / upper_bound concept)
    *
    * Disadvantage:
    * - Slightly less intuitive for beginners
    * - Edge case: target + 1 may overflow (Integer.MAX_VALUE)
    */
    public static int[] FindFirstandLastPositionofElementinSortedArrayOptimal2(int[] nums, int target) {
        int first = lowerBound(nums, target);
        int last = lowerBound(nums, target + 1) - 1;

        if (first == nums.length || nums[first] != target) {
            return new int[] {-1, -1};
        }

        return new int[] {first, last};
    }
    private static int lowerBound(int[] nums, int target) {
        int low = 0, high = nums.length;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
