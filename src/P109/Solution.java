/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        
        ListNode last = head, mid = head, pre = null;
        
        while (true) {
            if (last != null && last.next != null) {
                last = last.next.next;
            }
            else {
                break;
            }
            pre = mid;
            mid = mid.next;
        }
        
        
        TreeNode res = new TreeNode(mid.val);
        pre.next = null;
        
        res.left = sortedListToBST(head);
        res.right = sortedListToBST(mid.next);
        
        return res;
    }
}
