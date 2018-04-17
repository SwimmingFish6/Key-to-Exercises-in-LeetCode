/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        
        ListNode cur = headA;
        
        int lengthA = 0, lengthB = 0;
        
        while (cur != null) {
            cur = cur.next;
            lengthA++;
        }

        cur = headB;
        
        while (cur != null) {
            cur = cur.next;
            lengthB++;
        }
        
        while (lengthA > lengthB) {
            headA = headA.next;
            lengthA--;
        }
        
        while (lengthB > lengthA) {
            headB = headB.next;
            lengthB--;
        }       
        
        while (headA != null && headB != null) {
            if (headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        
        return null;
    }
}