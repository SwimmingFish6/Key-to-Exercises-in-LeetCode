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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        else if (p == null || q == null) return false;
        
        LinkedList<TreeNode> stack1 = new LinkedList<TreeNode>();
        LinkedList<TreeNode> stack2 = new LinkedList<TreeNode>();
        
        stack1.push(p);
        stack2.push(q);
        
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            TreeNode tmp1 = stack1.pop();
            TreeNode tmp2 = stack2.pop();
            
            if (tmp1.val != tmp2.val) return false;
            
            if (tmp1.right != null && tmp2.right != null) {
                stack1.push(tmp1.right);
                stack2.push(tmp2.right);
            }
            else if (!(tmp1.right == null && tmp2.right == null)) return false;
            
            if (tmp1.left != null && tmp2.left != null) {
                stack1.push(tmp1.left);
                stack2.push(tmp2.left);
            }
            else if (!(tmp1.left == null && tmp2.left == null)) return false;
        }
        
        if (stack1.isEmpty() && stack2.isEmpty()) return true;
        
        return false;
    }
}
