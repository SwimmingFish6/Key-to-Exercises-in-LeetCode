/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        int depth = 0;
        int maxDepth = 0;
        // TreeNode pre = null;
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0;i < size;i++) {
                TreeNode tmp = queue.poll(); 
                
                if (tmp.left != null) queue.offer(tmp.left);
                if (tmp.right != null) queue.offer(tmp.right);
            }
            depth += 1;
            
            if (depth > maxDepth) {
                maxDepth = depth;
            }
        }
        
        
        
        return maxDepth;
    }
}