/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        
        TreeLinkNode pre = root;
        TreeLinkNode cur = null;
        TreeLinkNode tmp;
        
        while (pre != null) {
            cur = pre;
            
            while (cur != null) {
                if (cur.left != null || cur.right != null) {
                    if (cur.right != null && cur.left != null) {
                        cur.left.next = cur.right;
                    }
                    
                    if (cur.right == null){
                        tmp = cur.left;
                    }
                    else  {
                        tmp = cur.right;
                    }
                    cur = cur.next;
                    while (cur != null) {
                        if (cur.left != null) {
                            tmp.next = cur.left;
                            break;
                        }
                        if (cur.right != null) {
                            tmp.next = cur.right;
                            break;
                        }
                        cur = cur.next;
                    }
                }
                else cur = cur.next;
            }
            
            while (pre != null) {
                if (pre.left != null) {
                    pre = pre.left;
                    break;
                }
                if (pre.right != null) {
                    pre = pre.right;
                    break;
                }
                pre = pre.next;
            }
            
        }
    }
}