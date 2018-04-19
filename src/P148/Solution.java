/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        int length = 0;
        
        if (head == null || head.next == null) return head;
        
        ListNode node = head;
        
        while (node != null) {
            node = node.next;
            length++;
        }
        
        node = head;
        
        for (int i = 0;i < length / 2 - 1;i++) {
            node = node.next;
        };
        
        ListNode tmp = node;
        
        node = node.next;
        
        tmp.next = null;
        
        ListNode left = sortList(head);
        ListNode right = sortList(node);        
        ListNode newHead;
        
        if (left.val > right.val) {
            newHead = right;
            right = right.next;
        }
        else {
            newHead = left;
            left = left.next;
        }
        
        node = newHead;
        
        while (left != null && right != null) {
            if (left.val > right.val) {
                node.next = right;
                right = right.next;
            }
            else {
                node.next = left;
                left = left.next;
            }    
            
            node = node.next;
        }
        
        if (left != null) node.next = left;
        if (right != null) node.next = right;
        
        
        return newHead;
    }
}