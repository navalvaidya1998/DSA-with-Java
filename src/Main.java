import arrays.ContainerWithMostWater;
import arrays.FourSum;
import arrays.LargestElement;
import arrays.LongestCommonPrefix;
import arrays.MedianOfTwoSortedArrays;
import arrays.ThreeSum;
import arrays.ThreeSumClosest;
import arrays.TwoSum;
import java.util.List;
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

        //Day 3: FourSum with Brute Force,Better and Optimal Approach(Two Pointer)
        int[] arr5 = {2,1,2,-1,-1,0,-4,3,4,-2,-1,1,2,3};
        int target1 = 3; 
        List<List<Integer>> quadruplets = FourSum.fourSumBruteForce(arr5, target1);
        List<List<Integer>> quadruplets1 = FourSum.fourSumBetterApproach(arr5, target1);
        List<List<Integer>> quadruplets2 = FourSum.fourSumOptimalApproach(arr5, target1);
        System.out.println("Day 3 - FourSum ==> Quadruplets that sum to target (Brute Force): " + quadruplets);
        System.out.println("Day 3 - FourSum ==> Quadruplets that sum to target (Better Approach): " + quadruplets1);
        System.out.println("Day 3 - FourSum ==> Quadruplets that sum to target (Optimal Approach): " + quadruplets2);
        //--------------------------------------------------------------------------------------

        //Day 4: ThreeSumClosest with Brute Force and Optimal Approach 
        int[] arr6 = {1,3,-2,-3,1,0,3,5,2,-1,-2,0};
        int target2 = 15;
        int checkClosest = ThreeSumClosest.threeSumClosestBruteForce(arr6,target2);
        System.out.println("Day 4 - ThreeSumClosest ==> Closest sum to target (Brute Force): " + checkClosest);
        int checkClosest1 = ThreeSumClosest.threeSumClosestOptimalApproach(arr6,target2);
        System.out.println("Day 4 - ThreeSumClosest ==> Closest sum to target (Optimal Approach): " + checkClosest1);

        //Day 4: RemoveDuplicatesFromSortedArray with BruteForce and Two Pointer Approach 
        int[] arr7 = {1,1,1,2,2,3,4,4,5,5,6};
        int[] copy1 = arr7.clone();
        int[] copy2 = arr7.clone();
        int newLength = arrays.RemoveDuplicatesFromSortedArray.removeDuplicatesBruteForce(copy1);
        int newLength1 = arrays.RemoveDuplicatesFromSortedArray.removeDuplicatesOptimal(copy2);
        System.out.println("Day 4 - RemoveDuplicatesFromSortedArray ==> New Length (Brute Force Approach): " + newLength);
        System.out.println("Day 4 - RemoveDuplicatesFromSortedArray ==> New Length (Two Pointer Approach): " + newLength1);

        //Day 4: RemoveElement with Two Pointer and Swap Approach
        int[] arr8 = {1,1,3,2,2,3,4,5,3,6,7,3};
        int target3 = 3;   
        int[] copy3 = arr8.clone();
        int[] copy4 = arr8.clone();
        int newLength2 = arrays.RemoveElement.removeElementOptimal(copy3, target3);
        int newLength3 = arrays.RemoveElement.removeElementSwap(copy4, target3);
        System.out.println("Day 4 - RemoveElement ==> New Length (Two Pointer Approach): " + newLength2);
        System.out.println("Day 4 - RemoveElement ==> New Length (Swap Approach): " + newLength3);
        //--------------------------------------------------------------------------------------

        //Day 5: NextPermutation
        int[] arr9 = {4,5,6,3,2,1};
        System.out.println("Day 5 - NextPermutation ==> Original Array: " + java.util.Arrays.toString(arr9));
        arrays.NextPermutation.nextPermutation(arr9);
        System.out.println("Day 5 - NextPermutation ==> Next Permutation: " + java.util.Arrays.toString(arr9));
        
        //Day 5: SearchinRotatedSortedArray with Brute Force and Optimal Approach
        int[] arr10 = {4,5,6,7,0,1,2};
        int target4 = 0;
        int searchResult = arrays.SearchinRotatedSortedArray.searchinRotatedSortedArrayBruteForce(arr10, target4);
        int searchResult1 = arrays.SearchinRotatedSortedArray.searchinRotatedSortedArrayOptimal(arr10, target4);
        System.out.println("Day 5 - SearchinRotatedSortedArray ==> Index of target (Brute Force): " + searchResult);
        System.out.println("Day 5 - SearchinRotatedSortedArray ==> Index of target (Optimal Approach): " + searchResult1);
    }
}