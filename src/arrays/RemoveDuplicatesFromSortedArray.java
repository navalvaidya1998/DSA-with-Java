package arrays;
import java.util.*;
public class RemoveDuplicatesFromSortedArray {
    /* Day 4
    * 🔹 Approach 1: Brute Force (Using LinkedHashSet)
    * ------------------------------------------------
    * Idea:
    * - Use a Set to store unique elements
    * - Since Set does not allow duplicates, it automatically removes them
    *
    * Key Logic:
    * - Traverse the array and insert elements into LinkedHashSet
    * - LinkedHashSet is used to preserve insertion order
    * - Copy elements from Set back into original array
    * - Return size of Set as the new length
    *
    * Time Complexity: O(n)
    *  - Single traversal + Set operations
    *
    * Space Complexity: O(n)
    *  - Extra space used for Set
    *
    * Advantage:
    * - Simple and works for both sorted and unsorted arrays
    *
    * Disadvantage:
    * - Uses extra space (not in-place)
    */
    public static int removeDuplicatesBruteForce(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Set<Integer> set = new LinkedHashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int index = 0;
        for (int num : set) {
            nums[index++] = num;
        }

        return index;
    }
    /* 🔹 Approach 2: Optimal (Two Pointer - In Place)
    * -----------------------------------------------
    * Idea:
    * - Use two pointers to overwrite duplicates in-place
    * - Works because the array is already sorted
    *
    * Key Logic:
    * - Pointer i tracks the position of last unique element
    * - Pointer j scans the array from left to right
    * - If arr[j] != arr[i], increment i and update arr[i] = arr[j]
    * - First (i + 1) elements will always be unique
    *
    * Time Complexity: O(n)
    *  - Single traversal of array
    *
    * Space Complexity: O(1)
    *  - No extra space used
    *
    * Advantage:
    * - In-place solution (optimal as per problem requirement)
    * - Efficient and widely used pattern
    *
    * Disadvantage:
    * - Works only because array is sorted
    *
    * Important Note:
    * - Both approaches modify the array in-place
    * - Always use a fresh copy of the array when testing multiple methods
    * - Two-pointer approach requires sorted input; if array is modified incorrectly,
    *   it may give wrong results
    */

    public static int removeDuplicatesOptimal(int[] arr) {
        if (arr == null || arr.length == 0) return 0;

        int i = 0;

        for (int j = 1; j < arr.length; j++) {
            if (arr[j] != arr[i]) {
                arr[++i] = arr[j];
            }
        }
        return i + 1;
    }
}
