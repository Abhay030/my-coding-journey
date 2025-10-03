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
    private void markParents(TreeNode root , Map<TreeNode , TreeNode> parent){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.left != null){
                parent.put(curr.left , curr);
                q.add(curr.left);
            }
            if(curr.right != null){
                parent.put(curr.right , curr);
                q.add(curr.right);
            }
        }
    }

    private TreeNode findTarget(TreeNode root , int start){
        if (root == null) {
        return null; // Base case: no node found
        }

        if (root.val == start) {
            return root; // Target found
        }

        // Search in the left subtree
        TreeNode leftResult = findTarget(root.left, start);
        if (leftResult != null) {
            return leftResult; // Found in left subtree
        }

        // Search in the right subtree
        return findTarget(root.right, start);
    }

    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode , TreeNode> parent = new HashMap<>();
        markParents(root , parent);

        Map<TreeNode , Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode target = findTarget(root , start);
        q.add(target);
        visited.put(target , true);

        int dist = -1;
        while(!q.isEmpty()){
            int size = q.size();


            for(int i = 0; i<size; i++){
                TreeNode curr = q.poll();

                // left child
                if(curr.left != null && !visited.containsKey(curr.left)){
                    q.add(curr.left);
                    visited.put(curr.left , true);
                }
                // right child
                if(curr.right != null && !visited.containsKey(curr.right)){
                    q.add(curr.right);
                    visited.put(curr.right , true);
                }
                // upper child or parent 
                if(parent.containsKey(curr) && !visited.containsKey(parent.get(curr))){
                    q.add(parent.get(curr));
                    visited.put(parent.get(curr) , true);
                }
            }
            dist++;
        }
        return dist;
    }
}