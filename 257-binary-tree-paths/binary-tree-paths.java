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
    List<String> paths = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        findPaths(root , "");
        return paths;
    }

    private void findPaths(TreeNode root , String dash){
        if(root == null){
            return;
        }
        dash += root.val;
        if(root.left == null && root.right == null){
            paths.add(dash);
        }
        dash += "->";

        findPaths(root.left , dash);
        findPaths(root.right , dash);

    }
}