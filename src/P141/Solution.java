/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        
        ListNode runner = head, walker = head;
        
        while (runner.next != null && walker.next != null && walker.next.next != null) {
            runner = runner.next;
            walker = walker.next.next;
            
            if (runner == walker || runner == walker.next) return true;
        }
        
        return false;
    }
}
