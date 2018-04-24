/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        
        ListNode pre = head, cur = head;
        
        while (cur.next != null) {
            ListNode tmp = cur.next;
            cur.next = tmp.next;
            tmp.next = pre;
            pre = tmp;
        }
    
        return pre;
    }
}