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
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        int depth = 1;
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0;i < size;i++) {
                if (queue.peek().left == null && queue.peek().right == null) return depth;
                
                if (queue.peek().left != null) queue.offer(queue.peek().left);
                if (queue.peek().right != null)queue.offer(queue.peek().right);
                
                queue.poll();
            }
            depth++;
        }
        
        return depth;
    }
}
