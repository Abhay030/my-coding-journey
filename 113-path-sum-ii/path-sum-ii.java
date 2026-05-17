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
    List<List<Integer>> allPath = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> myPath = new ArrayList<>();
        findPath(root , targetSum , myPath);
        return allPath;
    }

    private void findPath(TreeNode root , int targetSum , List<Integer> myPath){
        if(root == null) return;
        myPath.add(root.val);

        if(root.left == null && root.right == null && root.val == targetSum){
            allPath.add(new ArrayList<>(myPath));
        }

        findPath(root.left , targetSum - root.val , myPath);
        findPath(root.right , targetSum - root.val , myPath);
        myPath.remove(myPath.size()-1);

    }
}