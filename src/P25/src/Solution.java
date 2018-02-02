/**
 * Created by luxuhui on 2018/2/1.
 */
import java.util.*;

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return head;

        ListNode l = head, preNode = null;

        while (l != null) {
            ListNode[] reversedSublists = reverseList(l, k);

            if (preNode == null) head = reversedSublists[0];
            else preNode.next = reversedSublists[0];

            preNode = reversedSublists[1];
            l = reversedSublists[1].next;
        }

        return head;
    }

    public ListNode[] reverseList(ListNode list, int length) {
        int i = 1;
        ListNode[] re = new ListNode[2];
        ListNode head, tail, temp;

        if (list.next == null) {
            re[0] = list;
            re[1] = list;
            return re;
        }

        head = list;
        tail = list;

        while (i < length && head.next != null) {
            temp = head.next;
            head.next = head.next.next;
            temp.next = tail;

            tail= temp;
            i++;
        }

        if (i < length) {
            head = tail;

            while (head.next != null) {
                temp = head.next;
                head.next = head.next.next;
                temp.next = tail;

                tail= temp;
            }
            re[0] = tail;
            re[1] = head;

            return re;
        }

        re[0] = tail;
        re[1] = head;

        return re;
    }
}
