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
    List<Integer> inorder = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        inorderTrav(root);
        return inorder;
    }

    private void inorderTrav(TreeNode root){
        if(root == null){
            return;
        }

        inorderTrav(root.left);
        inorder.add(root.val);
        inorderTrav(root.right);
    }
}