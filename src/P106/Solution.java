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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }
    
    public TreeNode helper(int[] inorder, int[] postorder, int is, int ie, int ps, int pe) {
        if (ps > pe) return null;
        
        TreeNode node = new TreeNode(postorder[pe]);
        int inIndex = 0;
        
        for (int i = is;i <= ie;i++) {
            if (inorder[i] == node.val) {
                inIndex = i;
                break;
            }
        }
        
        node.right = helper(inorder, postorder, inIndex + 1, ie, ps + inIndex - is, pe - 1);
        node.left = helper(inorder, postorder, is, inIndex - 1, ps, ps + inIndex - is - 1);
            
        return node;
    }
}