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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        
        Queue<TreeNode> treeQueue = new LinkedList<TreeNode>();
        Queue<Integer> numQueue = new LinkedList<Integer>();
        
        treeQueue.offer(root);
        numQueue.offer(root.val);
        
        while (!treeQueue.isEmpty()) {
            int size = treeQueue.size();
            
            for (int i = 0;i < size;i++) {
                if (treeQueue.peek().left == null && treeQueue.peek().right == null && numQueue.peek() == sum) return true;
                if (treeQueue.peek().left != null) {
                    treeQueue.offer(treeQueue.peek().left);
                    numQueue.offer(numQueue.peek() + treeQueue.peek().left.val);
                }
                if (treeQueue.peek().right != null) {
                    treeQueue.offer(treeQueue.peek().right);
                    numQueue.offer(numQueue.peek() + treeQueue.peek().right.val);
                }
                
                numQueue.poll();
                treeQueue.poll();
            }
        }
        
        return false;
    }
}