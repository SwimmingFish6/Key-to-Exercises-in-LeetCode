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
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        List<Integer> res = new ArrayList<Integer>();
        
        if (root == null) return res;
        
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode tmp = stack.pop();
            if (tmp.right != null) stack.push(tmp.right);
            if (tmp.left != null) stack.push(tmp.left);
            
            res.add(tmp.val);
        }
        
        return res;
    }
}