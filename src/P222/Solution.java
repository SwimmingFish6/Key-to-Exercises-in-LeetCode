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
    public int height(TreeNode root) {
        return root == null? -1:height(root.left) + 1;
    }
    
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        
        int h = height(root);
        
        return height(root.left) == height(root.right)?(1 << h) + countNodes(root.right):(1 << h - 1) + countNodes(root.left);
    }
}