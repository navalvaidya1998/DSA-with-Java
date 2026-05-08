package arrays;

public class JumpGameII {

    /* Day 10 - Jump Game II
    *
    * 🔹 Approach 1: Brute Force (Try all possible jumps)
    * ----------------------------------------------
    * Idea:
    * - From each index, explore all reachable positions
    * - Recursively calculate minimum jumps needed to reach the end
    *
    * How it works:
    * - Start from index 0
    *
    * - For every index i:
    *     → Try all jumps from 1 to nums[i]
    *     → Recursively calculate jumps for each position
    *
    * - Take minimum of all possible paths
    *
    * Time Complexity:
    * - Exponential (O(n^n))
    *
    * Space Complexity:
    * - O(n) (recursion stack)
    *
    * Why this is not optimal:
    * - Recomputes same subproblems multiple times
    * - Very slow for large inputs
    */
    public static int jumpGame2Bruteforce(int[] nums) {
        return helper(nums, 0);
    }
    private static int helper(int[] nums, int index) {
        if (index >= nums.length - 1) return 0;
        int min = Integer.MAX_VALUE;
        for (int step = 1; step <= nums[index]; step++) {
            int res = helper(nums, index + step);
            if (res != Integer.MAX_VALUE) {
                min = Math.min(min, 1 + res);
            }
        }
        return min;
    }

    /* Day 10 - Jump Game II
    *
    * 🔹 Approach 2: Better (DP - Memoization)
    * ----------------------------------------------
    * Idea:
    * - Store already computed results to avoid recomputation
    *
    * How it works:
    * - Use a dp[] array where:
    *     → dp[i] = minimum jumps needed from index i to end
    *
    * - For every index i:
    *     → Try all jumps from 1 to nums[i]
    *     → Recursively compute result
    *     → Store result in dp[i]
    *
    * - Reuse stored values instead of recomputing
    *
    * Time Complexity:
    * - O(n^2)
    *
    * Space Complexity:
    * - O(n) (dp array + recursion stack)
    *
    * Why this is better:
    * - Avoids repeated calculations
    * - Faster than brute force
    */
    public static int jumpGame2Better(int[] nums) {
        Integer[] dp = new Integer[nums.length];
        return helper(nums, 0, dp);
    }
    private static int helper(int[] nums, int index, Integer[] dp) {
        if (index >= nums.length - 1) return 0;
        if (dp[index] != null) return dp[index];
        int min = Integer.MAX_VALUE;
        for (int step = 1; step <= nums[index]; step++) {
            int res = helper(nums, index + step, dp);
            if (res != Integer.MAX_VALUE) {
                min = Math.min(min, 1 + res);
            }
        }
        return dp[index] = min;
    }

    /* Day 10 - Jump Game II
    *
    * 🔹 Approach 3: Optimal (Greedy - Range Expansion / BFS Concept)
    * ----------------------------------------------
    * Idea:
    * - Instead of checking all paths, track the farthest reachable index
    * - Only jump when current range is exhausted
    *
    * How it works:
    * - Maintain 3 variables:
    *     → farthest: maximum index reachable so far
    *     → currentEnd: end of current jump range
    *     → jumps: number of jumps taken
    *
    * - Traverse array:
    *
    * - For every index i:
    *     → Update farthest = max(farthest, i + nums[i])
    *
    * - If i reaches currentEnd:
    *     → Increment jumps
    *     → Update currentEnd = farthest
    *
    * - Continue until end
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
    * - Uses greedy decision making
    */
    public static int jumpGame2Optimal(int[] nums) {
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }
        return jumps;
    }
}
