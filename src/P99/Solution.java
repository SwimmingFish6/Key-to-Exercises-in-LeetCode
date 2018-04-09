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
    public void recoverTree(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode pre = null;
        TreeNode cur = root;
        TreeNode fir = null;
        TreeNode sec = null;
        
        while (cur != null) {
            if (cur.left == null) {
                s
                cur = cur.left;
            }
            cur = stack.pop();
            if (pre != null && pre.val >= cur.val) {
                if (fir == null) {
                    fir = pre;
                    sec = cur;
                }
                else {
                    sec = cur;
                    break;
                }
            }
            
            pre = cur;
            cur = cur.right;
        }
        
        fir.val = sec.val + fir.val;
        sec.val = fir.val - sec.val;
        fir.val = fir.val - sec.val;
        
    }
}
