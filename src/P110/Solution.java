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
    public boolean isBalanced(TreeNode root) {
        
        return helper(root) == -1? false:true;
    }
    
    public int helper(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = helper(root.left);
        int rightDepth = helper(root.right);
        
        if (leftDepth == -1 || rightDepth == -1) return -1;
        
        if (Math.abs(leftDepth -rightDepth) > 1) return -1;
        
        return  Math.max(leftDepth, rightDepth)+ 1;
    }
}
