package com.interview.datastructures;

/**
 * Tree Data Structure Interview Questions
 *
 * This class contains top 10 most important tree manipulation interview questions
 * with detailed solutions, time complexity, and space complexity analysis.
 *
 * @author Interview Guide Team
 * @version 1.0.0
 */
public class TreeQuestions {
    /**
     * 1. Maximum Depth of Binary Tree
     * Problem: Given the root of a binary tree, return its maximum depth.
     * Time Complexity: O(n)
     * Space Complexity: O(h)
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    /**
     * 2. Invert Binary Tree
     * Problem: Invert a binary tree.
     * Time Complexity: O(n)
     * Space Complexity: O(h)
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    /**
     * 3. Symmetric Tree
     * Problem: Check if a tree is symmetric around its center.
     * Time Complexity: O(n)
     * Space Complexity: O(h)
     */
    public boolean isSymmetric(TreeNode root) {
        return root == null || isMirror(root.left, root.right);
    }
    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
            && isMirror(t1.left, t2.right)
            && isMirror(t1.right, t2.left);
    }

    /**
     * 4. Binary Tree Level Order Traversal
     * Problem: Return the level order traversal of a binary tree's nodes' values.
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public java.util.List<java.util.List<Integer>> levelOrder(TreeNode root) {
        java.util.List<java.util.List<Integer>> res = new java.util.ArrayList<>();
        if (root == null) return res;
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            java.util.List<Integer> level = new java.util.ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(level);
        }
        return res;
    }

    /**
     * 5. Validate Binary Search Tree
     * Problem: Check if a binary tree is a valid BST.
     * Time Complexity: O(n)
     * Space Complexity: O(h)
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }

    /**
     * 6. Lowest Common Ancestor of a Binary Tree
     * Problem: Find the lowest common ancestor (LCA) of two nodes in a binary tree.
     * Time Complexity: O(n)
     * Space Complexity: O(h)
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    /**
     * 7. Serialize and Deserialize Binary Tree
     * Problem: Design an algorithm to serialize and deserialize a binary tree.
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }
    private void serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null,");
            return;
        }
        sb.append(node.val).append(",");
        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
    }
    public TreeNode deserialize(String data) {
        java.util.Queue<String> nodes = new java.util.LinkedList<>(java.util.Arrays.asList(data.split(",")));
        return deserializeHelper(nodes);
    }
    private TreeNode deserializeHelper(java.util.Queue<String> nodes) {
        String val = nodes.poll();
        if (val.equals("null")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = deserializeHelper(nodes);
        node.right = deserializeHelper(nodes);
        return node;
    }

    /**
     * 8. Path Sum
     * Problem: Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values equals the given sum.
     * Time Complexity: O(n)
     * Space Complexity: O(h)
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return sum == root.val;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    /**
     * 9. Construct Binary Tree from Preorder and Inorder Traversal
     * Problem: Given preorder and inorder traversal of a tree, construct the binary tree.
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    private TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = inStart;
        while (inRoot <= inEnd && inorder[inRoot] != root.val) inRoot++;
        int leftSize = inRoot - inStart;
        root.left = buildTreeHelper(preorder, preStart + 1, preStart + leftSize, inorder, inStart, inRoot - 1);
        root.right = buildTreeHelper(preorder, preStart + leftSize + 1, preEnd, inorder, inRoot + 1, inEnd);
        return root;
    }

    /**
     * 10. Flatten Binary Tree to Linked List
     * Problem: Flatten a binary tree to a linked list in-place.
     * Time Complexity: O(n)
     * Space Complexity: O(h)
     */
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = left;
        TreeNode curr = root;
        while (curr.right != null) curr = curr.right;
        curr.right = right;
    }

    /**
     * Definition for a binary tree node.
     */
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }
}