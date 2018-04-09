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
    public boolean isValidBST(TreeNode root) {
        return verify(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }
    
    public boolean verify(TreeNode root, long maxValue, long minValue) {
        if (root == null) return true;
        
        else if (root.val >= maxValue || root.val <= minValue){
            return false;
        }
        
        return verify(root.left, root.val, minValue) && verify(root.right, maxValue, root.val);
        
    }
}
