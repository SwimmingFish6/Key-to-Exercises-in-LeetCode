

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode front = head, back = head;

        for (int i = 0;i < n - 1;i++) {
            back = back.next;
        }

        if (back.next == null) return head.next;
        else back = back.next;

        while (back.next != null) {
            front = front.next;
            back = back.next;
        }

        front.next = front.next.next;

        return head;
    }
}