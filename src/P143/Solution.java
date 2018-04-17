/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        if (head == null) return;

        int length = 0;
        ListNode node = head;

        while (node != null) {
            node = node.next;
            length++;
        }

        node = head;

        for (int i = 0;i < length / 2;i++) {
            node = node.next;
        }

        ListNode end = reverse(node);

        ListNode begin = head;

        while (begin.next != end && begin != end) {
            ListNode bTmp = begin.next;
            ListNode eTmp = end.next;
            begin.next = end;
            end.next = bTmp;
            begin = bTmp;
            end = eTmp;
        }

        return;

    }

    public ListNode reverse(ListNode root) {
        if (root == null) return null;

        ListNode pre = root, cur = root;

        while (cur.next != null) {
            ListNode tmp = cur.next;
            cur.next = cur.next.next;
            tmp.next = pre;
            pre = tmp;
        }

        return pre;
    }
}