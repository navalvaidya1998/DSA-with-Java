import arrays.ContainerWithMostWater;
import arrays.FourSum;
import arrays.LargestElement;
import arrays.LongestCommonPrefix;
import arrays.MedianOfTwoSortedArrays;
import arrays.SudokuSolver;
import arrays.ThreeSum;
import arrays.ThreeSumClosest;
import arrays.TwoSum;
import arrays.ValidSudoku;
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
        int[] arr9 = {1,6,4,3,5,2};
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
        //--------------------------------------------------------------------------------------

        //Day 6: FindFirstAndLastPositionOfElementInSortedArray with Brute Force, Optimal Approach and Lower Bound Technique
        int[] arr11 = {5,7,7,8,8,9,9,9,9,9,9,9,10};
        int target5 = 9;
        int[] findResult = arrays.FindFirstandLastPositionofElementinSortedArray.FindFirstandLastPositionofElementinSortedArrayBruteForce(arr11, target5);
        int[] findResult1 = arrays.FindFirstandLastPositionofElementinSortedArray.FindFirstandLastPositionofElementinSortedArrayOptimal1(arr11, target5);
        int[] findResult2 = arrays.FindFirstandLastPositionofElementinSortedArray.FindFirstandLastPositionofElementinSortedArrayOptimal2(arr11, target5);
        System.out.println("Day 6 - FindFirstAndLastPositionOfElementInSortedArray ==> First and Last Position (Brute Force): " + java.util.Arrays.toString(findResult));
        System.out.println("Day 6 - FindFirstAndLastPositionOfElementInSortedArray ==> First and Last Position (Optimal Approach): " + java.util.Arrays.toString(findResult1));
        System.out.println("Day 6 - FindFirstAndLastPositionOfElementInSortedArray ==> First and Last Position (Lower Bound Technique): " + java.util.Arrays.toString(findResult2));
        //Day 6: SearchInsertPosition with Brute Force and Optimal Approach
        int[] arr12 = {1,2,3,5,6};
        int target6 = 4;
        int searchResult2 = arrays.SearchInsertPosition.searchInsertBruteforce(arr12, target6);
        int searchResult3 = arrays.SearchInsertPosition.searchInsertOptimal(arr12, target6);
        System.out.println("Day 6 - SearchInsertPosition ==> Index to insert target (Brute Force): " + searchResult2);
        System.out.println("Day 6 - SearchInsertPosition ==> Index to insert target (Optimal Approach): " + searchResult3);
        //--------------------------------------------------------------------------------------

        //Day 7: ValidSudoku Brute Force and Optimal Approach
        char[][] invalidboard = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '8', '8', '8', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        char[][] validBoard = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '.', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        boolean isValid = ValidSudoku.isValidSudokuBruteForce(invalidboard);
        boolean isValid1 = ValidSudoku.isValidSudokuBruteForce(validBoard);
        boolean isValid2 = ValidSudoku.isValidSudokuOptimal(invalidboard);
        boolean isValid3 = ValidSudoku.isValidSudokuOptimal(validBoard);
        System.out.println("Day 7 - ValidSudoku ==> Is Valid Sudoku (Invalid Board): " + isValid);
        System.out.println("Day 7 - ValidSudoku ==> Is Valid Sudoku (Valid Board): " + isValid1);
        System.out.println("Day 7 - ValidSudoku ==> Is Valid Sudoku (Invalid Board - Optimal): " + isValid2);
        System.out.println("Day 7 - ValidSudoku ==> Is Valid Sudoku (Valid Board - Optimal): " + isValid3);

        //Day 7: CombinationSum with Backtracking Approach
        int[] arr13 = {1,4,5,7};
        int target7 = 8;
        List<List<Integer>> combinations = arrays.CombinationSum.combinationSum(arr13, target7);
        System.out.println("Day 7 - CombinationSum ==> Combinations that sum to target: " + combinations);
        //--------------------------------------------------------------------------------------

        //Day 8: SudokuSolver with Backtracking and Optimization Approach
        SudokuSolver.sudokuSolverBackTrack(validBoard);
        System.out.println("Day 8 - SudokuSolver ==> Solved Board (Backtracking): ");
        for (int i = 0; i < 9; i++) {
            System.out.println(java.util.Arrays.toString(validBoard[i]));
        }
        SudokuSolver.sudokuSolverOptimal(validBoard);
        System.out.println("Day 8 - SudokuSolver ==> Solved Board (Optimal): ");
        for (int i = 0; i < 9; i++) {
            System.out.println(java.util.Arrays.toString(validBoard[i]));
        }
        //Day 8: CombinationSumII with Brute Force and Optimal Approach
        int[] arr14 = {1, 1, 2, 2, 3, 5, 6, 7, 10};
        int target8 = 7;
        List<List<Integer>> combinationsBruteForce = arrays.CombinationSumII.combinationSumIIBruteForce(arr14, target8);
        List<List<Integer>> combinationsIIOptimal = arrays.CombinationSumII.combinationSumIIOptimal(arr14, target8);
        System.out.println("Day 8 - CombinationSumII ==> Combinations that sum to target (Brute Force): " + combinationsBruteForce);
        System.out.println("Day 8 - CombinationSumII ==> Combinations that sum to target (Optimal): " + combinationsIIOptimal);
        
        //--------------------------------------------------------------------------------------

        //Day 9: FirstMissingPositive with Brute Force, Better and Optimal Approach
        int[] arr15 = {0, 1, 2, 0, 5, 4};
        int[] arr16 = {3, 4, -1, 1, 5, 2};
        int[] arr17 = {7, 8, 9, 11, 12};
        int missingPositive1 = arrays.FirstMissingPositive.firstMissingPositiveBruteforce(arr15);
        int missingPositive2 = arrays.FirstMissingPositive.firstMissingPositiveBettter(arr16);
        int missingPositive3 = arrays.FirstMissingPositive.firstMissingPositiveOptimal(arr17);
        System.out.println("Day 9 - FirstMissingPositive ==> Missing Positive (Brute Force): " + missingPositive1);
        System.out.println("Day 9 - FirstMissingPositive ==> Missing Positive (Better): " + missingPositive2);
        System.out.println("Day 9 - FirstMissingPositive ==> Missing Positive (Optimal): " + missingPositive3);

        //Day 9: TrappingRainWater with Brute Force, Better and Optimal Approach
        int[] height1 = {0,1,3,4,2,0,2,1,0,1,3,2,1,2,1,3,2,1,0,1,2,1,0};
        int waterBruteForce = arrays.TrappingRainWater.trappingRainWaterBruteforce(height1);
        int waterBetter = arrays.TrappingRainWater.trappingRainWaterBetter(height1);
        int waterOptimal = arrays.TrappingRainWater.trap(height1);
        System.out.println("Day 9 - TrappingRainWater ==> Water (Brute Force): " + waterBruteForce);
        System.out.println("Day 9 - TrappingRainWater ==> Water (Better): " + waterBetter);
        System.out.println("Day 9 - TrappingRainWater ==> Water (Optimal): " + waterOptimal);

        //-------------------------------------------------------------------------------

        //Day 10: JumpGameII with Brute Force, Better and Optimal Approach
        int[] jumps = {2,3,1,1,4,4,4,5,6};
        int jumpsBruteForce = arrays.JumpGameII.jumpGame2Bruteforce(jumps);
        int jumpsBetter = arrays.JumpGameII.jumpGame2Better(jumps);
        int jumpsOptimal = arrays.JumpGameII.jumpGame2Optimal(jumps);
        System.out.println("Day 10 - JumpGameII ==> Jumps (Brute Force): " + jumpsBruteForce);
        System.out.println("Day 10 - JumpGameII ==> Jumps (Better): " + jumpsBetter);
        System.out.println("Day 10 - JumpGameII ==> Jumps (Optimal): " + jumpsOptimal);

        //Day 10: Permutations with Brute Force and Optimal Approach
        int[] permArr = {1, 2, 3};
        List<List<Integer>> permutationsBruteForce = arrays.Permutations.permutationsBruteforce(permArr);
        List<List<Integer>> permutationsOptimal = arrays.Permutations.permutationsOptimal(permArr);
        System.out.println("Day 10 - Permutations ==> Permutations (Brute Force): " + permutationsBruteForce);
        System.out.println("Day 10 - Permutations ==> Permutations (Optimal): " + permutationsOptimal);

        //---------------------------------------------------------------------------------

        //Day 11: PermutationsII with Backtracking Approach
        int[] permArr2 = {1, 1, 2};
        List<List<Integer>> permutationsII = arrays.PermutationsII.permutations2(permArr2);
        System.out.println("Day 11 - PermutationsII ==> Permutations (Backtracking): " + permutationsII);
        
        //---------------------------------------------------------------------------------

        //Day 12: RotateImage with Brute Force and Optimal Approach
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("Day 12 - RotateImage ==> Original Matrix:");
        for (int[] matrix1 : matrix) {
            System.out.println(java.util.Arrays.toString(matrix1));
        }  
        arrays.RotateImage.rotateImageBruteforce(matrix);
        System.out.println("Day 12 - RotateImage ==> Rotated Matrix (Brute Force):");
        for (int[] matrix1 : matrix) {
            System.out.println(java.util.Arrays.toString(matrix1));
        }  
        arrays.RotateImage.rotateImageOptimal(matrix);
        System.out.println("Day 12 - RotateImage ==> Rotated Matrix (Optimal):");
        for (int[] matrix1 : matrix) {
            System.out.println(java.util.Arrays.toString(matrix1));
        }

        //Day 12: GroupAnagrams with Optimal Approach
        String[] anagrams = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> groupedAnagrams = arrays.GroupAnagrams.groupAnagrams(anagrams);
        System.out.println("Day 12 - GroupAnagrams ==> Grouped Anagrams (Optimal): " + groupedAnagrams);

        //---------------------------------------------------------------------------------

        //Day 13: NQueens with Brute Force and Optimal Approaches
        List<List<String>> nQueensBruteForce = arrays.NQueens.nQueensBruteforce(4);
        List<List<String>> nQueensOptimal = arrays.NQueens.nQueensOptimal(4);
        System.out.println("Day 13 - NQueens ==> Solutions (Brute Force): " + nQueensBruteForce);
        System.out.println("Day 13 - NQueens ==> Solutions (Optimal): " + nQueensOptimal);

        //Day 14: LongestSubstringWithoutRepeatingCharacters with Brute Force and Optimal Approaches
        String s = "abcabcbb";
        int longestSubstringBruteForce = string.LongestSubstringWithoutRepeatingCharacters.longestSubstringWithoutRepeatingCharactersBruteforce(s);
        int longestSubstringOptimal = string.LongestSubstringWithoutRepeatingCharacters.longestSubstringWithoutRepeatingCharactersOptimal(s);
        System.out.println("Day 14 - LongestSubstringWithoutRepeatingCharacters ==> Length (Brute Force): " + longestSubstringBruteForce);
        System.out.println("Day 14 - LongestSubstringWithoutRepeatingCharacters ==> Length (Optimal): " + longestSubstringOptimal);

        //Day 14: LongestPalindromicSubstring with Brute Force, Better and Optimal Approach
        String s1 = "babad";
        String longestPalindromeBruteForce = string.LongestPalindromicSubstring.longestPalindromicSubstringBruteforce(s1);
        String longestPalindromeBetter = string.LongestPalindromicSubstring.longestPalindromicSubstringBetter(s1);
        String longestPalindromeOptimal = string.LongestPalindromicSubstring.longestPalindromicSubstringOptimal(s1);
        System.out.println("Day 14 - LongestPalindromicSubstring ==> Longest Palindrome (Brute Force): " + longestPalindromeBruteForce);
        System.out.println("Day 14 - LongestPalindromicSubstring ==> Longest Palindrome (Better): " + longestPalindromeBetter);
        System.out.println("Day 14 - LongestPalindromicSubstring ==> Longest Palindrome (Optimal): " + longestPalindromeOptimal);
    }
}