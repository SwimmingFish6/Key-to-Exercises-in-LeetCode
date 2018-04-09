/**
 * Created by luxuhui on 2018/1/26.
 */


public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode head = result;
        boolean flag = false, isHead = true;

        while (l1 != null && l2 != null) {
            if (isHead) {
                head.val = l1.val + l2.val;
                isHead = false;
            }
            else {
                head.next = new ListNode(l1.val + l2.val);
                head = head.next;
            }
            if (flag) {
                head.val += 1;
                flag = false;
            }

            l1 = l1.next;
            l2 = l2.next;

            if (head.val >= 10) {
                head.val -= 10;
                flag = true;
            }
        }

        ListNode l;

        if (l1 == null) l = l2;

        else l = l1;

        while (l != null) {
            head.next = new ListNode(l.val);
            head = head.next;

            if (flag) {
                head.val += 1;
                flag = false;
                if (head.val >= 10) {
                    head.val -= 10;
                    flag = true;
                }
            }

            l = l.next;
        }

        if (flag) {
            head.next = new ListNode(1);
        }

        return result;
    }

}
