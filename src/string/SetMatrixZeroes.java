package string;

public class SetMatrixZeroes {
    /* Day 27 - Set Matrix Zeroes
    *
    * 🔹 Approach 1: Brute Force (Mark Rows and Columns)
    * ----------------------------------------------
    * Idea:
    * - Whenever a zero is found:
    *     → Mark its entire row and column
    *
    * How it works:
    * - Traverse matrix and store rows and columns containing zero
    *
    * - Traverse matrix again:
    *     → If row or column is marked
    *     → Set cell to zero
    *
    * Time Complexity:
    * - O(m * n)
    *
    * Space Complexity:
    * - O(m + n)
    *
    * Why this is not optimal:
    * - Uses extra arrays to store row and column information
    */
    public static void setMatrixZeroesBruteforce(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean[] zeroRows = new boolean[rows];
        boolean[] zeroCols = new boolean[cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    zeroRows[i] = true;
                    zeroCols[j] = true;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (zeroRows[i] || zeroCols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /* Day 27 - Set Matrix Zeroes
    *
    * 🔹 Approach 2: Optimal (First Row and Column as Markers)
    * ----------------------------------------------
    * Idea:
    * - Use first row and first column to store marker information
    * - Avoid extra space usage
    *
    * How it works:
    * - Check whether first column contains zero
    *
    * - Traverse matrix:
    *     → Mark row and column in first row/column
    *
    * - Traverse matrix again:
    *     → Set cells to zero based on markers
    *
    * - Finally process first row and first column
    *
    * Time Complexity:
    * - O(m * n)
    *
    * Space Complexity:
    * - O(1)
    *
    * Why this is optimal:
    * - Uses matrix itself for storage
    * - No extra row/column arrays required
    */
    public static void setMatrixZeroesOptimal(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean firstColZero = false;
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
            }
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (firstColZero) {
                matrix[i][0] = 0;
            }
        }
    }
}
