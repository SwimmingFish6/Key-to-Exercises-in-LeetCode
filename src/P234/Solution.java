/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode node = head;
        ListNode half = head;
        
        while (node != null && node.next != null) {
            node = node.next.next;
            half = half.next;
        }

        ListNode end = reverse(half);
        
        while (end != null) {
            if (end.val != head.val) return false;
            end = end.next;
            head = head.next;
        }
        
        return true;
    }
    
    public ListNode reverse(ListNode head) {
        if (head == null && head.next == null) return head;
        
        ListNode pre = head;
        ListNode cur = head;
        
        while (cur.next != null) {
            ListNode tmp = cur.next;
            cur.next = cur.next.next;
            tmp.next = pre;
            pre = tmp;
        }
        
        return pre;
    }
}