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
    public boolean isSymmetric(TreeNode root) {
        return checkSame(root.left , root.right);
    }

    private boolean checkSame(TreeNode p , TreeNode q){
        if(p == null && q == null) return true;
        if(p == null && q != null || q == null && p != null) return false;

        boolean checkleft = checkSame(p.left , q.right);
        if(p.val != q.val) return false;
        boolean checkright = checkSame(p.right , q.left);

        return checkleft && checkright;
    }
}