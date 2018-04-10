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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, preorder.length, 0, inorder.length, preorder, inorder);
    }
    
    public TreeNode helper(int preStart, int preEnd, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart >= preEnd) return null;
        
        int inIndex = 0;
        TreeNode node = new TreeNode(preorder[preStart]);
        
        for (int i = inStart;i < inEnd;i++) {
            if (preorder[preStart] == inorder[i]) {
                inIndex = i;
                break;
            }
        }
        
        node.left = helper(preStart + 1, preStart + inIndex - inStart + 1, inStart, inIndex, preorder, inorder);
        node.right = helper(preStart + inIndex - inStart + 1, preEnd, inIndex + 1, inEnd, preorder, inorder);

        return node;        
    }
}