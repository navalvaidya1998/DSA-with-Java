import arrays.LargestElement;
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
        TwoSum twoSumSolver = new TwoSum();
        int[] getTwoSumResult = twoSumSolver.twoSum(arr1, target);
        System.out.println("Day 1 - TwoSum output ==> Indices: " + getTwoSumResult[0] + ", " + getTwoSumResult[1]);
    }
}