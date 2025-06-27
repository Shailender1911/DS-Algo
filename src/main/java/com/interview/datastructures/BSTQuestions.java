package com.interview.datastructures;

/**
 * Binary Search Tree (BST) Interview Questions
 *
 * This class contains top 10 most important BST interview questions
 * with detailed solutions, time complexity, and space complexity analysis.
 *
 * @author Interview Guide Team
 * @version 1.0.0
 */
public class BSTQuestions {
    // 1. Search in a Binary Search Tree
    // 2. Insert into a Binary Search Tree
    // 3. Delete Node in a BST
    // 4. Validate Binary Search Tree
    // 5. Lowest Common Ancestor in a BST
    // 6. Convert Sorted Array to BST
    // 7. Convert BST to Greater Tree
    // 8. Kth Smallest Element in a BST
    // 9. Two Sum IV - Input is a BST
    // 10. Trim a Binary Search Tree

    // Example:
    /**
     * 1. Search in a Binary Search Tree
     * Problem: Given the root of a BST and a value, return the node with that value.
     * Time Complexity: O(h)
     * Space Complexity: O(1)
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
    }

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    // ... (other 9 questions will be added in the same style)
} 