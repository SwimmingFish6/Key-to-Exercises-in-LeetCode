/**
 * Created by luxuhui on 2018/2/1.
 */
import java.util.*;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        else if (lists.length == 1) {
            return lists[0];
        }

        else if (lists.length == 2) {
            return mergeTwoLists(lists[0], lists[1]);
        }

        else {
            return mergeTwoLists(mergeKLists(Arrays.copyOfRange(lists, 0, lists.length / 2)), mergeKLists(Arrays.copyOfRange(lists, lists.length / 2, lists.length)));

        }


    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mergedList;
        ListNode l1 = list1, l2 = list2;

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val > l2.val) {
            mergedList = new ListNode(l2.val);
            l2 = l2.next;
        }
        else {
            mergedList = new ListNode(l1.val);
            l1 = l1.next;
        }

        ListNode head = mergedList;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                mergedList.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            else {
                mergedList.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            mergedList = mergedList.next;
        }

        if (l1 == null) {
            mergedList.next = l2;
        }
        else {
            mergedList.next = l1;
        }

        return head;
    }
}
