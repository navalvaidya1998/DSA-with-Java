package arrays;
import java.util.HashSet;
public class FirstMissingPositive {
    /* Day 9 - First Missing Positive
    *
    * 🔹 Approach: Brute Force (Check every number one by one)
    * ----------------------------------------------
    * Idea:
    * - Start checking from number 1 upwards
    * - For each number, scan the entire array to see if it exists
    * - The first number not found is the answer
    *
    * How it works:
    * - Loop from i = 1 to n + 1
    *
    * - For each i:
    *     → Traverse the array
    *     → If i is found → continue
    *     → If i is not found → return i
    *
    * - If all numbers from 1 to n exist:
    *     → Return n + 1
    *
    * Time Complexity:
    * - O(n^2) (for every number, we scan the whole array)
    *
    * Space Complexity:
    * - O(1) (no extra space used)
    *
    * Why this is not optimal:
    * - Too slow for large inputs
    * - Repeated scanning of the array
    */
    public static int firstMissingPositiveBruteforce(int[] nums) {
        int n = nums.length;
        for (int i = 1; i <= n + 1; i++) {
            boolean found = false;
            for (int num : nums) {
                if (num == i) {
                    found = true;
                    break;
                }
            }
            if (!found) return i;
        }
        return n + 1;
    }

    /* Day 9 - First Missing Positive
    *
    * 🔹 Approach: Better (HashSet / Extra Space)
    * ----------------------------------------------
    * Idea:
    * - Store all elements in a HashSet for fast lookup
    * - Then check from 1 upwards which number is missing
    *
    * How it works:
    * - Traverse the array:
    *     → Add each element into HashSet
    *
    * - Loop from i = 1 to n + 1:
    *     → If i is not present in set → return i
    *
    * - If all numbers exist:
    *     → Return n + 1
    *
    * Time Complexity:
    * - O(n) (single pass + lookup)
    *
    * Space Complexity:
    * - O(n) (extra space for HashSet)
    *
    * Why this is not optimal:
    * - Uses extra space which violates problem constraint
    */
    public static int firstMissingPositiveBettter(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 1; i <= nums.length + 1; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return nums.length + 1;
    }

    /* Day 9 - First Missing Positive
    *
    * 🔹 Approach: Optimal (Cyclic Sort / Index Placement)
    * ----------------------------------------------
    * Idea:
    * - Place each number at its correct index
    * - Correct position for value x is index (x - 1)
    *
    * How it works:
    * - Traverse the array:
    *     → While current element is in range [1, n]
    *     → And not at its correct position
    *         → Swap it with its correct index
    *
    * - After placement:
    *     → Traverse array again
    *     → First index i where nums[i] != i + 1 → return i + 1
    *
    * - If all elements are correctly placed:
    *     → Return n + 1
    *
    * Time Complexity:
    * - O(n) (each element placed at most once)
    *
    * Space Complexity:
    * - O(1) (in-place, no extra space)
    *
    * Why this is optimal:
    * - Meets both constraints: O(n) time and O(1) space
    * - No extra data structures used
    */
    public static int firstMissingPositiveOptimal(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int correctIndex = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
