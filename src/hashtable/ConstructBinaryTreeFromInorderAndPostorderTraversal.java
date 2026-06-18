package hashtable;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /* Day 30 - Construct Binary Tree from Inorder and Postorder Traversal
    *
    * 🔹 Approach 1: Brute Force (Recursive Search)
    * ----------------------------------------------
    * Idea:
    * - Last element in postorder is always the root
    * - Search root in inorder array every time
    *
    * How it works:
    * - Create root using last postorder element
    *
    * - Find root position in inorder using linear search
    *
    * - Elements on left:
    *     → Left subtree
    *
    * - Elements on right:
    *     → Right subtree
    *
    * - Build right subtree first because
    *   postorder processes root at the end
    *
    * Time Complexity:
    * - O(n²)
    *
    * Space Complexity:
    * - O(n)
    *
    * Why this is not optimal:
    * - Linear search repeated for every node
    */
    public static TreeNode constructBinaryTreeFromInorderAndPostorderTraversalBruteforce(int[] inorder, int[] postorder) {
        return buildBruteforce(
                inorder,
                0,
                inorder.length - 1,
                postorder,
                0,
                postorder.length - 1
        );
    }

    private static TreeNode buildBruteforce(int[] inorder,
                                            int inStart,
                                            int inEnd,
                                            int[] postorder,
                                            int postStart,
                                            int postEnd) {

        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);

        int rootIndex = inStart;

        while (rootIndex <= inEnd && inorder[rootIndex] != root.val) {
            rootIndex++;
        }

        int leftSize = rootIndex - inStart;

        root.left = buildBruteforce(
                inorder,
                inStart,
                rootIndex - 1,
                postorder,
                postStart,
                postStart + leftSize - 1
        );

        root.right = buildBruteforce(
                inorder,
                rootIndex + 1,
                inEnd,
                postorder,
                postStart + leftSize,
                postEnd - 1
        );

        return root;
    }

    /* Day 30 - Construct Binary Tree from Inorder and Postorder Traversal
    *
    * 🔹 Approach 2: Optimal (HashMap + Recursion)
    * ----------------------------------------------
    * Idea:
    * - Store inorder indices in HashMap
    * - Get root position in O(1)
    *
    * How it works:
    * - Last postorder element:
    *     → Root node
    *
    * - Find root index using HashMap
    *
    * - Calculate size of left subtree
    *
    * - Recursively construct:
    *     → Left subtree
    *     → Right subtree
    *
    * Time Complexity:
    * - O(n)
    *
    * Space Complexity:
    * - O(n)
    *
    * Why this is optimal:
    * - Each node processed once
    * - HashMap avoids repeated searches
    */
    public static TreeNode constructBinaryTreeFromInorderAndPostorderTraversalOptimal(int[] inorder, int[] postorder) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildOptimal(
                inorder,
                0,
                inorder.length - 1,
                postorder,
                0,
                postorder.length - 1,
                map
        );
    }

    private static TreeNode buildOptimal(int[] inorder,
                                         int inStart,
                                         int inEnd,
                                         int[] postorder,
                                         int postStart,
                                         int postEnd,
                                         Map<Integer, Integer> map) {

        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);

        int rootIndex = map.get(root.val);

        int leftSize = rootIndex - inStart;

        root.left = buildOptimal(
                inorder,
                inStart,
                rootIndex - 1,
                postorder,
                postStart,
                postStart + leftSize - 1,
                map
        );

        root.right = buildOptimal(
                inorder,
                rootIndex + 1,
                inEnd,
                postorder,
                postStart + leftSize,
                postEnd - 1,
                map
        );

        return root;
    }
}