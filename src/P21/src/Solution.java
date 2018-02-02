/**
 * Created by luxuhui on 2018/1/31.
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode re = new ListNode(0);
        ListNode head = re;

        if (l1.val < l2.val) {
            re.val = l1.val;
            l1 = l1.next;
        }
        else {
            re.val = l2.val;
            l2 = l2.next;
        }

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                re.next = l1;
                l1 = l1.next;
            }
            else {
                re.next = l2;
                l2 = l2.next;
            }
            re = re.next;
        }

        if (l1 == null) re.next = l2;
        else re.next = l1;

        return head;
    }
}
