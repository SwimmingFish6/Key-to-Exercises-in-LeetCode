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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int val1 = p.val, val2 = q.val;
        TreeNode node = root;
        
        while (true) {
            if (val1 > node.val && val2 > node.val) {
                node = node.right;
            }
            else if (val1 < node.val && val2 < node.val) {
                node = node.left;
            }
            else {
                break;
            }
        }
        
        return node;
    }
}