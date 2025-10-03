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
    private TreeNode targetNode = null; // Store target node reference

    /**
     * Builds a map of parent pointers for each node and finds the target node.
     * 
     * @param root    Root of the tree
     * @param parent  Map storing child → parent relationships
     * @param start   Target value to search
     */
    private void markParents(TreeNode root, Map<TreeNode, TreeNode> parent, int start) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            // Check if current node is the target node
            if (curr.val == start) {
                targetNode = curr;
            }

            // Add left child to queue and store parent mapping
            if (curr.left != null) {
                parent.put(curr.left, curr);
                q.add(curr.left);
            }

            // Add right child to queue and store parent mapping
            if (curr.right != null) {
                parent.put(curr.right, curr);
                q.add(curr.right);
            }
        }
    }

    /**
     * Calculates the amount of time to spread something from target node
     * to the entire tree (similar to burning tree problem).
     *
     * @param root   Root of the tree
     * @param start  Value of the target node
     * @return       Time taken to reach all nodes
     */
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> parent = new HashMap<>(); // Stores parent relationships

        // Step 1: Build parent map and find target node
        markParents(root, parent, start);

        if (targetNode == null) return 0; // If target not found

        Map<TreeNode, Boolean> visited = new HashMap<>(); // Track visited nodes
        Queue<TreeNode> q = new LinkedList<>();          // BFS queue

        // Step 2: Start BFS from target node
        q.add(targetNode);
        visited.put(targetNode, true);

        int dist = -1; // Initialize distance counter

        while (!q.isEmpty()) {
            int size = q.size(); // Number of nodes at current level

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                // Visit left child if not visited
                if (curr.left != null && !visited.containsKey(curr.left)) {
                    q.add(curr.left);
                    visited.put(curr.left, true);
                }

                // Visit right child if not visited
                if (curr.right != null && !visited.containsKey(curr.right)) {
                    q.add(curr.right);
                    visited.put(curr.right, true);
                }

                // Visit parent if not visited
                if (parent.containsKey(curr) && !visited.containsKey(parent.get(curr))) {
                    q.add(parent.get(curr));
                    visited.put(parent.get(curr), true);
                }
            }

            dist++; // Increase distance after each BFS level
        }

        return dist;
    }
}
