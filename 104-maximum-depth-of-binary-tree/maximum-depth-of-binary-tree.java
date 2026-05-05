/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        return depth(root);
    }

    private int depth(TreeNode root){
        if(root == null) return 0;

        int leftH = 1 + depth(root.left);
        int rightH = 1 + depth(root.right);

        return Math.max(leftH , rightH);
    }
}