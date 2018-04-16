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
    public int maxPathSum(TreeNode root) {
        return helper(root)[1];
    }
    
    public int[] helper(TreeNode root) {
        if (root == null) return new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
        
        int[] res = new int[2];
        
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        
        res[0] = root.val + Math.max(left[0], Math.max(right[0], 0));
        res[1] = Math.max(Math.max(res[0], root.val + Math.max(right[0], 0) + Math.max(left[0], 0)), Math.max(right[1], left[1]));
        
        return res;
    }
}