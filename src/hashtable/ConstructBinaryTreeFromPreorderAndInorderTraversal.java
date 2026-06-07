package hashtable;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /* Day 28 - Construct Binary Tree from Preorder and Inorder Traversal
    *
    * 🔹 Approach 1: Brute Force (Recursive Search)
    * ----------------------------------------------
    * Idea:
    * - First element in preorder is always the root
    * - Search root in inorder array every time
    *
    * How it works:
    * - Create root using preorder element
    *
    * - Find root position in inorder by linear search
    *
    * - Elements on left:
    *     → Left subtree
    *
    * - Elements on right:
    *     → Right subtree
    *
    * - Recursively construct both subtrees
    *
    * Time Complexity:
    * - O(n²)
    *
    * Space Complexity:
    * - O(n)
    *
    * Why this is not optimal:
    * - Root position searched repeatedly
    * - Linear search performed for every node
    */
    public static TreeNode constructBinaryTreeFromPreorderAndInorderTraversalBruteforce(int[] preorder, int[] inorder) {
        return buildBruteforce(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    private static TreeNode buildBruteforce(int[] preorder, int preStart, int preEnd,
                                            int[] inorder, int inStart, int inEnd) {

        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        int rootIndex = inStart;

        while (rootIndex <= inEnd && inorder[rootIndex] != root.val) {
            rootIndex++;
        }

        int leftSize = rootIndex - inStart;

        root.left = buildBruteforce(
                preorder,
                preStart + 1,
                preStart + leftSize,
                inorder,
                inStart,
                rootIndex - 1
        );

        root.right = buildBruteforce(
                preorder,
                preStart + leftSize + 1,
                preEnd,
                inorder,
                rootIndex + 1,
                inEnd
        );

        return root;
    }

    /* Day 28 - Construct Binary Tree from Preorder and Inorder Traversal
    *
    * 🔹 Approach 2: Optimal (HashMap + Recursion)
    * ----------------------------------------------
    * Idea:
    * - Store inorder indices in HashMap
    * - Get root position in O(1)
    *
    * How it works:
    * - First preorder element:
    *     → Root node
    *
    * - Find root index using HashMap
    *
    * - Calculate left subtree size
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
    public static TreeNode constructBinaryTreeFromPreorderAndInorderTraversalOptimal(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildOptimal(
                preorder,
                0,
                preorder.length - 1,
                inorder,
                0,
                inorder.length - 1,
                map
        );
    }

    private static TreeNode buildOptimal(int[] preorder, int preStart, int preEnd,
                                         int[] inorder, int inStart, int inEnd,
                                         Map<Integer, Integer> map) {

        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        int rootIndex = map.get(root.val);

        int leftSize = rootIndex - inStart;

        root.left = buildOptimal(
                preorder,
                preStart + 1,
                preStart + leftSize,
                inorder,
                inStart,
                rootIndex - 1,
                map
        );

        root.right = buildOptimal(
                preorder,
                preStart + leftSize + 1,
                preEnd,
                inorder,
                rootIndex + 1,
                inEnd,
                map
        );

        return root;
    }
}
