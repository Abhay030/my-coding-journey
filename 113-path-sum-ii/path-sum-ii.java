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
        //Step 1 :- add
        myPath.add(root.val);

        //Step 2:- Check if the condition is met then add the path
        if(root.left == null && root.right == null && root.val == targetSum){
            allPath.add(new ArrayList<>(myPath));
        }

        // Step 3:- Traverse left and right to find the path
        findPath(root.left , targetSum - root.val , myPath);
        findPath(root.right , targetSum - root.val , myPath);

        // Step 4:- backtrack or remove as we move out of the recursive calls
        myPath.remove(myPath.size()-1);

    }
}