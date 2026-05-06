package arrays;
public class TrappingRainWater {
    /* Day 9 - Trapping Rain Water
    *
    * 🔹 Approach: Brute Force (Check left max & right max for each element)
    * ----------------------------------------------
    * Idea:
    * - For every index, find:
    *     → Maximum height on left
    *     → Maximum height on right
    * - Water stored = min(leftMax, rightMax) - height[i]
    *
    * How it works:
    * - Traverse each index i:
    *
    * - For every i:
    *     → Find leftMax by scanning from 0 to i
    *     → Find rightMax by scanning from i to n-1
    *
    * - Water at index i:
    *     → min(leftMax, rightMax) - height[i]
    *
    * - Add all water values
    *
    * Time Complexity:
    * - O(n^2) (nested loops for each index)
    *
    * Space Complexity:
    * - O(1)
    *
    * Why this is not optimal:
    * - Repeated calculation of left and right max
    * - Very slow for large inputs
    */
    public static int trappingRainWaterBruteforce(int[] height) {
        int n = height.length;
        int water = 0;
        for (int i = 0; i < n; i++) {
            int leftMax = 0, rightMax = 0;
            for (int j = 0; j <= i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }
            for (int j = i; j < n; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }
            water += Math.min(leftMax, rightMax) - height[i];
        }
        return water;
    }

    /* Day 9 - Trapping Rain Water
    *
    * 🔹 Approach: Better (Prefix Max + Suffix Max arrays)
    * ----------------------------------------------
    * Idea:
    * - Precompute:
    *     → leftMax array
    *     → rightMax array
    * - Then calculate water in single pass
    *
    * How it works:
    * - Create leftMax array:
    *     → leftMax[i] = max(height[0] to height[i])
    *
    * - Create rightMax array:
    *     → rightMax[i] = max(height[i] to height[n-1])
    *
    * - For each index:
    *     → Water = min(leftMax[i], rightMax[i]) - height[i]
    *
    * - Sum all water values
    *
    * Time Complexity:
    * - O(n)
    *
    * Space Complexity:
    * - O(n) (extra arrays)
    *
    * Why this is better:
    * - Avoids repeated computation
    *
    * Why not optimal:
    * - Uses extra space
    */
    public static int trappingRainWaterBetter(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        int water = 0;
        for (int i = 0; i < n; i++) {
            water += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return water;
    }

    /* Day 9 - Trapping Rain Water
    *
    * 🔹 Approach: Optimal (Two Pointers)
    * ----------------------------------------------
    * Idea:
    * - Use two pointers (left & right)
    * - Track leftMax and rightMax dynamically
    *
    * Key Observation:
    * - Water depends on the smaller boundary
    *
    * How it works:
    * - Initialize:
    *     → left = 0, right = n - 1
    *     → leftMax = 0, rightMax = 0
    *
    * - While left <= right:
    *
    *     → If height[left] <= height[right]:
    *         → If height[left] >= leftMax:
    *             → Update leftMax
    *         → Else:
    *             → Water += leftMax - height[left]
    *         → Move left++
    *
    *     → Else:
    *         → If height[right] >= rightMax:
    *             → Update rightMax
    *         → Else:
    *             → Water += rightMax - height[right]
    *         → Move right--
    *
    * Time Complexity:
    * - O(n)
    *
    * Space Complexity:
    * - O(1)
    *
    * Why this is optimal:
    * - No extra space
    * - Single pass solution
    * - Most expected in interviews
    */
    public static int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;
        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }
        return water;
    }
}
