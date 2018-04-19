/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {        
        if (head == null || head.next == null) return head;
        
        ListNode cur = head.next, pre = head, newHead = head;;
        
        while (cur != null) {
            if (cur.val >= pre.val) {
                cur = cur.next;
                pre = pre.next;
                continue;
            }
            
            ListNode tmp = cur;
            pre.next = cur.next;
            if (tmp.val < newHead.val) {
                // newHead.next = tmp.next;
                tmp.next = newHead;
                newHead = tmp;
                cur = pre.next;
            }
            else {
                ListNode begin = newHead;
            
                while (begin.next != null) {
                    if (begin.next.val > tmp.val) {
                        tmp.next = begin.next;
                        begin.next = tmp;
                        break;
                    }
                    begin = begin.next;
                }
            }
            
            cur = pre.next;
        }
        
        return newHead;
    }
}