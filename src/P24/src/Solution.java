/**
 * Created by luxuhui on 2018/2/1.
 */
import java.util.*;

class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return head;

        ListNode l1 = head, l2 = head.next;
        ListNode preNode = null;

        while (l2 != null) {
            ListNode temp = l2.next;
            l2.next = l1;
            l1.next = temp;

            if (preNode != null) {
                preNode.next = l2;
            }
            else {
                head = l2;
            }

            preNode = l1;

            if (l1.next != null) l1 = l1.next;
            else return head;

            l2 = l1.next;
        }

        return head;
    }
}