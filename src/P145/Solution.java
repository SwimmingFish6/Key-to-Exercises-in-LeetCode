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
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        List<Integer> res = new ArrayList<Integer>();
        
        if (root == null) return res;
        
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode tmp = stack.peek();
            
            if (tmp.right == null && tmp.left == null) {
                stack.pop();
                res.add(tmp.val);
            }
            
            if (tmp.right != null) {
                stack.push(tmp.right);
                tmp.right = null;
            }
            if (tmp.left != null) {
                stack.push(tmp.left);
                tmp.left = null;
            }
        }
        
        return res;
    }
}