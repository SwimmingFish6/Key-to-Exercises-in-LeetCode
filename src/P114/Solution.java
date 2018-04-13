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
    public void flatten(TreeNode root) {
        helper(root);
    }
    
    public TreeNode helper(TreeNode root) {
        if (root == null) return null;
        
        TreeNode left = helper(root.left);
        TreeNode right = helper(root.right);
        
        root.left = null;
        
        if (left != null) {
            root.right = left;
            
            while (left.right != null) {
                left = left.right;
            }
            
            left.right = right;
        }
        else {
            root.right = right;
        }
        
        return root;
    }
}
