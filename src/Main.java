import arrays.LargestElement;
import arrays.MedianOfTwoSortedArraysBruteForceApproach;
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
        //Day 1: MedianOfTwoSortedArraysBruteForceApproach
        int[] arr2 = {1, 3, 5};
        int[] arr3 = {2, 4, 6};
        double median = MedianOfTwoSortedArraysBruteForceApproach.findMedianOf2SortedArrays(arr2, arr3);
        System.out.println("Day 1 - MedianOfTwoSortedArraysBruteForceApproach ==> Median: " + median);
        //---------------------------------------------------

    }
}