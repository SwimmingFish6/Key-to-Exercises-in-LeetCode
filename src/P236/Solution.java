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
    int count = 0;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p, q);
    }
    
    public TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        int sign = count;
        if (root == null) return null;
        
        if (root == p) count++;
        if (root == q) count++;
    
        
        TreeNode t1 = helper(root.left, p, q);
        TreeNode t2 = helper(root.right, p, q);
        
        if (t1 != null) return t1;
        if (t2 != null) return t2;
        
        if (sign == 0 && count == 2) return root;
        
        return null;
        
    }
}