package arrays;

public class RotateImage {
    /* Day 12 - Rotate Image
    *
    * 🔹 Approach 1: Brute Force (Using Extra Matrix)
    * ----------------------------------------------
    * Idea:
    * - Create a new matrix to store rotated values
    * - Place each element at its correct rotated position
    *
    * How it works:
    * - For every element matrix[i][j]:
    *     → Place it at result[j][n-1-i]
    *
    * - Copy result matrix back to original matrix
    *
    * Time Complexity:
    * - O(n^2)
    *
    * Space Complexity:
    * - O(n^2)
    *
    * Why this is not optimal:
    * - Uses extra space for another matrix
    */
    public static void rotateImageBruteforce(int[][] matrix) {
        int n = matrix.length;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[j][n - 1 - i] = matrix[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            System.arraycopy(result[i], 0, matrix[i], 0, n);
        }
    }

    /* Day 12 - Rotate Image
    *
    * 🔹 Approach 2: Optimal (Transpose + Reverse)
    * ----------------------------------------------
    * Idea:
    * - Rotate matrix in-place without extra space
    * - Use matrix transformation properties
    *
    * How it works:
    * - Step 1: Transpose the matrix
    *     → Convert rows into columns
    *
    * - Step 2: Reverse each row
    *     → This results in 90° clockwise rotation
    *
    * Time Complexity:
    * - O(n^2)
    *
    * Space Complexity:
    * - O(1)
    *
    * Why this is optimal:
    * - No extra space used
    * - In-place transformation
    * - Efficient and commonly asked in interviews
    */
    public static void rotateImageOptimal(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            reverse(matrix[i]);
        }
    }
    private static void reverse(int[] row) {
        int left = 0, right = row.length - 1;
        while (left < right) {
            int temp = row[left];
            row[left] = row[right];
            row[right] = temp;
            left++;
            right--;
        }
    }
}
