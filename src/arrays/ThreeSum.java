package arrays;
// import java.util.Arrays;
// import java.util.List;
// import java.util.Collections;
// import java.util.Set;
// import java.util.HashSet;
// import java.util.ArrayList;
import java.util.*;
public class ThreeSum {
    /* Day 3
    * 🔹 Approach 1: Brute Force (3 Nested Loops)
    * -------------------------------------------
    * Idea:
    * - Try all possible triplets (i, j, k)
    * - Check if nums[i] + nums[j] + nums[k] == 0
    * - If yes, store the triplet
    *
    * Key Logic:
    * - Use 3 loops to generate all combinations
    * - Sort each triplet to maintain consistent order
    * - Use Set to avoid duplicate triplets
    *
    * Time Complexity: O(n³)
    *  - Three nested loops
    *
    * Space Complexity: O(n)
    *  - Set used to store unique triplets
    *
    * Advantage:
    * - Easy to understand
    * - Good starting point for learning
    *
    * Disadvantage:
    * - Very slow for large inputs
    */
    public static List<List<Integer>> threeSumBruteForce(int[] arr){
        Set<List<Integer>> tripletSet = new HashSet<>();
        int n = arr.length;
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                for(int k=j+1;k<n;k++){
                    if(arr[i]+arr[j]+arr[k]==0){
                        List<Integer> tripletList = Arrays.asList(arr[i],arr[j],arr[k]);
                        Collections.sort(tripletList);
                        tripletSet.add(tripletList);

                    }
                }
            }
        }
        return new ArrayList<>(tripletSet);
    }

    /* Day 3
    * 🔹 Approach 2: HashSet (Optimized 2Sum inside 3Sum)
    * ---------------------------------------------------
    * Idea:
    * - Fix one element nums[i]
    * - Convert problem into finding two numbers whose sum = -nums[i]
    * - Use HashSet to track elements seen so far
    *
    * Key Logic:
    * - For each i, create a Set (seen)
    * - For each j:
    *     third = -(nums[i] + nums[j])
    * - If third exists in seen → valid triplet
    * - Sort triplet before adding to Set (avoid duplicates)
    *
    * Time Complexity: O(n²)
    *  - Outer loop + inner loop
    *
    * Space Complexity: O(n)
    *  - HashSet used for lookup
    *
    * Advantage:
    * - Faster than brute force
    * - Eliminates one loop using hashing
    *
    * Disadvantage:
    * - Extra space required
    * - Still needs sorting + Set to remove duplicates
    */
    public static List<List<Integer>> threeSumBetterApproach(int[] arr){
        int n = arr.length;
        Set<List<Integer>> tripletSet = new HashSet<>();
        for(int i=0;i<n-2;i++){
            Set<Integer> thirdValue = new HashSet<>();
            for(int j=i+1;j<n;j++){
                int third = -(arr[i]+arr[j]);
                if(thirdValue.contains(third)){
                    List<Integer> tripletList = Arrays.asList(arr[i], arr[j], third);
                    Collections.sort(tripletList);
                    tripletSet.add(tripletList);
                }
                thirdValue.add(arr[j]);
            }
        }return new ArrayList<>(tripletSet);
    }
    /* Day 3
    * 🔹 Approach 3: Two Pointer (Optimal Solution)
    * ---------------------------------------------
    * Idea:
    * - Sort the array first
    * - Fix one element nums[i]
    * - Use two pointers (left, right) to find remaining two elements
    *
    * Key Logic:
    * - If sum < 0 → move left pointer (increase value)
    * - If sum > 0 → move right pointer (decrease value)
    * - If sum == 0 → store triplet
    *
    * Duplicate Handling:
    * - Skip duplicate values for i
    * - Skip duplicate values for left and right after finding triplet
    *
    * Time Complexity: O(n²)
    *  - Sorting + two pointer traversal
    *
    * Space Complexity: O(1)
    *  - No extra space used (excluding result)
    *
    * Advantage:
    * - Most efficient solution
    * - No extra data structures needed
    * - Clean and interview-preferred approach
    *
    * Disadvantage:
    * - Requires understanding of sorting + two pointers
    */
    public static List<List<Integer>> threeSumOptimalApproach(int[] arr){
        List<List<Integer>> triplet = new ArrayList<>();
        int n = arr.length;
        Arrays.sort(arr);
        for(int i=0;i<n-2;i++){
            if (i > 0 && arr[i] == arr[i - 1]) continue;
            int j = i+1, k=n-1;
            while(j < k){
                if(arr[i]+arr[j]+arr[k]<0){
                    j++;
                }else if(arr[i]+arr[j]+arr[k]>0){
                    k--;
                }
                else{
                    triplet.add(Arrays.asList(arr[i],arr[j],arr[k]));
                    j++;
                    k--;
                    while (j < k && arr[j] == arr[j - 1]) j++;
                }
                

            }
        }
        return triplet;

    }
}


