package arrays;
public class ContainerWithMostWater {
    /* Day 2
    * 🔹 Approach 1: Brute Force (Check All Pairs)
    * -------------------------------------------
    * Idea:
    * - Consider every possible pair of lines using two nested loops
    * - For each pair (i, j), calculate:
    *      width = j - i
    *      height = min(height[i], height[j])
    *      water = width * height
    * - Keep track of the maximum water among all pairs
    *
    * Time Complexity: O(n^2)
    *  - We check all possible pairs of indices
    *
    * Space Complexity: O(1)
    *  - No extra space is used
    *
    * Drawback:
    * - Inefficient for large inputs (LeetCode will give TLE)
    *
    * Note:
    * - This is a basic approach to understand the problem
    * - Can be optimized using Two Pointer approach to O(n)
    *
    *Time Limit Exceeded for this soloution-
    *this is not recommended but good to explain a brutforce approach*/
    public static int maxWater(int[] height){
        int mostWater =0;
        int totalLength = height.length;
        for(int i=0;i<totalLength;i++){
            for(int j=i+1;j<totalLength;j++){
                int width = j-i;
                int checkWater = height[i]<height[j] ? height[i]*width:height[j]*width;
                if(checkWater>mostWater){
                    mostWater = checkWater;
                }
                /*we can use math functions also
                int minHeight = Math.min(height[i], height[j]);
                int checkWater = width * minHeight;
                mostWater = Math.max(mostWater, checkWater);*/
            }
        }
        return mostWater;
    }
    /* Day 2
    * 🔹 Approach 2: Two Pointer (Optimized)
    * -------------------------------------
    * Idea:
    * - Use two pointers, one at the beginning (left) and one at the end (right)
    * - At each step:
    *      width = right - left
    *      height = min(height[left], height[right])
    *      water = width * height
    * - Update the maximum water found so far
    *
    * Key Logic:
    * - Move the pointer pointing to the smaller height
    * - Because the shorter line limits the water capacity
    * - Moving the taller line will not help, as height remains limited
    *
    * Why it works:
    * - We start with maximum width and gradually reduce it
    * - By moving the smaller height pointer, we try to find a taller line
    *   that may increase the overall area
    *
    * Time Complexity: O(n)
    *  - Each element is visited at most once
    *
    * Space Complexity: O(1)
    *  - No extra space is used
    *
    * Advantage:
    * - Much faster than brute force (O(n^2))
    * - Efficient for large inputs (passes all test cases)
    */
    public static int maxWater1(int[] height){
        int n=height.length;
        int left = 0;
        int right = n-1;
        int mostWater=0;
        while(left<right){
            int width = right-left;
            int currWater = Math.min(height[left],height[right])*width;
            mostWater = Math.max(currWater,mostWater);
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }

        }
        return mostWater;
    }

}
