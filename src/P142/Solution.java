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
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        
        boolean flag = false;
        
        ListNode runner = head, walker = head;
        
        while (runner.next != null && walker.next != null && walker.next.next != null) {
            runner = runner.next;
            walker = walker.next.next;
            
            if (runner == walker) {
                flag = true;
                break;
            }
        }
        
        if (!flag) return null;
        
        runner = head;
        
        while (runner != walker) {
            runner = runner.next;
            walker = walker.next;
        }
        
        return runner;
    }
}
