/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public int length = 1;
    
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        
        ListNode tail = head, tmp;
        
        // head = reverseList(head);
        
        ListNode node = head;
        
        while (node.next != null) {
            node = node.next;
            length++;
        }
        
        
        k = k % length;
        
        int remain = length - k;
        
        tmp = head;
        
        for (int i = 1;i < remain;i++) {
            tmp = tmp.next;
        }
        
        node.next = head;
        
        ListNode res = tmp.next;
        tmp.next = null;
        
        return res;
        
        // return reverseList(head);
    }
    
    public ListNode reverseList(ListNode list) {
        ListNode head = list, tail = head;
        ListNode tmp;
        length = 1;
        
        while (tail.next != null) {
            tmp = tail.next.next;
            tail.next.next = head;
            // tmp = tail.next;
            head = tail.next;
            tail.next = tmp;
            length++;
        }
        
        return head;
    }
}
