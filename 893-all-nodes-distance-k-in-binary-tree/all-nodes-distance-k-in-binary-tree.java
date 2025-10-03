/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// 1. Parent-Child Mapping
// Normal BFS ya DFS karke har node ke parent ko map me store kar lo:
// map.put(node, parent)
// Kyunki hume target se upar (parent) move karne ke liye parent ka reference chahiye.

// 2. BFS from Target Node
// BFS queue ko target se start karo
// Har level BFS chalte hi ek currentDistance track karo.
// Jab currentDistance == k ho jaye, to queue me bache huye nodes hi answer honge.

// 3. Visiting Logic
// Har node ke teen direction explore karne honge:
// node.left
// node.right
// parentMap.get(node) (upar wala)
// Visited set rakho taaki ek node dobara visit na ho (warna infinite loop ban jaayega parent-child ke bich).

// 4. Answer Collect
// Jab currentDistance == k, tab queue me jitne nodes hai un sabko answer list me daal do.
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

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode , TreeNode> parent = new HashMap<>();
        markParents(root , parent);

        Map<TreeNode , Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        visited.put(target , true);

        int dist = 0;
        while(!q.isEmpty()){
            int size = q.size();
            if(dist == k) {
                List<Integer> ans = new ArrayList<>();
                for (TreeNode node : q) ans.add(node.val);
                return ans;
            };

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
        return new ArrayList<>();
    }
}