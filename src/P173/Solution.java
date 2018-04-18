/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    LinkedList<TreeNode> stack;
    TreeNode cur;
    TreeNode pre;
    
    public BSTIterator(TreeNode root) {
        stack = new LinkedList<TreeNode>();
        cur = root;
        pre = null;
        if (cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;             
            }
        
            cur = stack.pop();
        
            pre = cur;
            cur = cur.right;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (!stack.isEmpty() || pre != null) return true;
        else return false;
    }

    /** @return the next smallest number */
    public int next() {
        int res = pre.val;
        
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;             
        }
        
        cur = stack.isEmpty()?null:stack.pop();
        
        pre = cur;
        cur = cur == null?null:cur.right;
        
        return res;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */