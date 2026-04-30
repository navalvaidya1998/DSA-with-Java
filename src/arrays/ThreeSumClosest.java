package arrays;
import java.util.Arrays;
public class ThreeSumClosest {
    /* Day 4
    * 🔹 Approach 1: Brute Force (3 Nested Loops)
    * -------------------------------------------
    * Idea:
    * - Try all possible triplets (i, j, k)
    * - Calculate sum = nums[i] + nums[j] + nums[k]
    * - Track the sum which is closest to the target
    *
    * Key Logic:
    * - Use 3 loops to generate all combinations
    * - Ensure indices are different: i < j < k
    * - For each sum, compare |target - sum| with current closest
    * - Update closest sum if a better one is found
    *
    * Time Complexity: O(n³)
    *  - Three nested loops
    *
    * Space Complexity: O(1)
    *  - No extra space used
    *
    * Advantage:
    * - Simple and guarantees correct result
    *
    * Disadvantage:
    * - Very slow for large inputs
    */
    public static int threeSumClosestBruteForce(int[] arr, int target){
        int n = arr.length;
        int closest = arr[0]+arr[1]+arr[2];
        if(target==closest) return closest;
        for(int i=0; i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                for(int k=j+1;k<n;k++){
                    int sum = arr[i]+arr[j]+arr[k];
                    if(target == sum) return sum;
                    if(Math.abs(target-closest)>Math.abs(target-sum)){
                        closest = sum;
                    }
                }
            }
        }return closest;
    }

    /* 🔹 Approach 2: Optimal (Sorting + Two Pointers)
    * -----------------------------------------------
    * Idea:
    * - Sort the array
    * - Fix one element and use two pointers to find best pair
    *
    * Key Logic:
    * - Sort the array to apply two-pointer technique
    * - Fix index i, then use:
    *      left = i + 1
    *      right = n - 1
    * - Compute sum and compare with target
    * - Update closest if better difference is found
    * - If sum < target → move left++
    * - If sum > target → move right--
    * - If sum == target → return immediately (perfect match)
    *
    * Time Complexity: O(n²)
    *  - Outer loop + two pointer traversal
    *
    * Space Complexity: O(1)
    *  - No extra space (ignoring sorting)
    *
    * Advantage:
    * - Much faster than brute force
    * - Efficient and commonly expected in interviews
    *
    * Disadvantage:
    * - Requires sorting (slight overhead)
    */

    public static int threeSumClosestBetterApproach(int[] arr,int target){
        int n=arr.length;
        Arrays.sort(arr);
        int closest=arr[0]+arr[1]+arr[2];
        if(closest == target) return closest;
        for(int i=0; i<n-2; i++){
            int start = i+1;
            int end = n-1;
            while(start<end){
                int sum=arr[i]+arr[start]+arr[end];
                if(sum==target) return sum;
                if(Math.abs(target-sum)<Math.abs(target-closest)){
                    closest = sum;
                }
                if(sum<target){
                    start++;
                }else{
                    end--;
                }

            }

        }
        return closest;

    }

}
