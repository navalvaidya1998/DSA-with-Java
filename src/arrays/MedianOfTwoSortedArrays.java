package arrays;
public class MedianOfTwoSortedArrays{

    /*
     * 🔹 Approach 1: Brute Force (Merge Array)
     * ---------------------------------------
     * Idea:
     * - Merge both sorted arrays into a new array
     * - Then find median from merged array
     *
     * Time Complexity: O(m + n)
     *  - We traverse both arrays once
     *
     * Space Complexity: O(m + n)
     *  - Extra array used to store merged result
     */
    public static double bruteForce(int[] arr1, int[] arr2) {
        int m = arr1.length, n = arr2.length;
        int i = 0, j = 0, k = 0;
        int[] mergeArray = new int[m + n];
        while (i < m && j < n) {
            if (arr1[i] < arr2[j]) {
                mergeArray[k++] = arr1[i++];
            } else {
                mergeArray[k++] = arr2[j++];
            }
        }
        while (i < m) {
            mergeArray[k++] = arr1[i++];
        }
        while (j < n) {
            mergeArray[k++] = arr2[j++];
        }
        int len = mergeArray.length;

        if (len % 2 == 0) {
            return (mergeArray[len / 2] + mergeArray[len / 2 - 1]) / 2.0;
        } else {
            return mergeArray[len / 2];
        }
    }

    /*
     * 🔹 Approach 2: Better (Without Extra Space)
     * ------------------------------------------
     * Idea:
     * - Simulate merge process
     * - Stop when we reach median index
     * - Track only 2 variables: prev and curr
     *
     * Time Complexity: O(m + n)
     *  - In worst case we iterate till middle
     *
     * Space Complexity: O(1)
     *  - No extra space used
     */
    public static double better(int[] arr1, int[] arr2) {
        int m = arr1.length, n = arr2.length;
        int total = m + n;
        int i = 0, j = 0;
        int prev = 0, curr = 0;
        for (int count = 0; count <= total / 2; count++) {
            prev = curr;
            if (i < m && (j >= n || arr1[i] < arr2[j])) {
                curr = arr1[i++];
            } else {
                curr = arr2[j++];
            }
        }
        if (total % 2 == 0) {
            return (prev + curr) / 2.0;
        } else {
            return curr;
        }
    }
}