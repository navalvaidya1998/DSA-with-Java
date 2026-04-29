import java.util.List;

import arrays.ContainerWithMostWater;
import arrays.LargestElement;
import arrays.LongestCommonPrefix;
import arrays.MedianOfTwoSortedArrays;
import arrays.ThreeSum;
import arrays.TwoSum;

public class Main {
    public static void main(String[] args) {
        //Sample example------------------------------------
        int[] arr = {3, 7, 2, 9, 5};
        int result = LargestElement.findLargest(arr);
        System.out.println("Largest Element: " + result);
        //--------------------------------------------------
        //Day 1: TwoSum
        int[] arr1 = {2, 7, 11, 15};
        int target = 26;
        int[] result1 = TwoSum.twoSum(arr1, target);
        if (result1 != null) {
            System.out.println("Day 1 - TwoSum ==> Indices: " + result1[0] + ", " + result1[1]);
        } else {
            System.out.println("No valid pair found");
        }
        //Day 1: MedianOfTwoSortedArrays with BruteForce and Better Approach
        int[] arr2 = {1, 3, 5};
        int[] arr3 = {2, 4, 6};
        double median = MedianOfTwoSortedArrays.bruteForce(arr2, arr3);
        System.out.println("Day 1 - MedianOfTwoSortedArraysBruteForceApproach ==> Median (Brute Force Approach): " + median);
        double median1 = MedianOfTwoSortedArrays.bruteForce(arr2, arr3);
        System.out.println("Day 1 - MedianOfTwoSortedArraysBruteForceApproach ==> Median (Better Approach): " + median1);
        //---------------------------------------------------

        //Day 2: ContainerWithMostWater with BruteForce and Two Pointer Approach
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int maxWater = ContainerWithMostWater.maxWater(height);
        int maxWater1 = ContainerWithMostWater.maxWater1(height);
        System.out.println("Day 2 - ContainerWithMostWater ==> Maximum Water (Brute Force): " + maxWater);
        System.out.println("Day 2 - ContainerWithMostWater ==> Maximum Water (Two Pointer Approach): " + maxWater1);

        //Day 2: LongestCommonPrefix with Horizontal and Vertical Scanning Approach
        String[] strs = {"BandWidth", "Band", "Banana"};
        String prefix = LongestCommonPrefix.longestCommonPrefixHorizontal(strs);
        System.out.println("Day 2 - LongestCommonPrefix ==> Longest Common Prefix (Horizontal Scanning): " + prefix);
        String prefix1 = LongestCommonPrefix.longestCommonPrefixVertical(strs);
        System.out.println("Day 2 - LongestCommonPrefix ==> Longest Common Prefix (Vertical Scanning): " + prefix1);
        //---------------------------------------------------

        //Day 3: ThreeSum with Brute Force, Better Approach and Optimal Approach(Two Pointer)
        int[] arr4 = { 1, 2, 3, -3, -1, -2, 0, 0, 1, 4, -4, -4};
        List<List<Integer>> tripletes = ThreeSum.threeSumBruteForce(arr4);
        List<List<Integer>> tripletes1 = ThreeSum.threeSumBetterApproach(arr4);
        List<List<Integer>> tripletes2 = ThreeSum.threeSumOptimalApproach(arr4);
        System.out.println("Day 3 - ThreeSum ==> Triplets that sum to zero (Brute Force): " + tripletes);
        System.out.println("Day 3 - ThreeSum ==> Triplets that sum to zero (Better Approach): " + tripletes1);
        System.out.println("Day 3 - ThreeSum ==> Triplets that sum to zero (Better Approach): " + tripletes2);




    }
}