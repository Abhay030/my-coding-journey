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
    int currNum = 0;
    int currFreq = 0;
    int maxFreq = 0;
    List<Integer> result = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        dfs(root);
        return result.stream().mapToInt(i -> i).toArray();
    }

    private void dfs(TreeNode root){
        if(root == null) return;

        dfs(root.left);

        if(root.val == currNum){
            currFreq++;
        }
        else{
            currNum = root.val;
            currFreq = 1;
        }

        if(currFreq > maxFreq){
            result.removeAll(result);
            maxFreq = currFreq;
        }

        if(currFreq == maxFreq){
            result.add(root.val);
        }

        dfs(root.right);
    }
}