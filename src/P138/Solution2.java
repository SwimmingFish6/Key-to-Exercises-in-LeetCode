/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        
        RandomListNode l1, l2, res;
        
        l1 = head;
        while (l1 != null) {
            l2 = new RandomListNode(l1.label);
            l2.next = l1.next;
            l1.next = l2;
            l1 = l1.next.next;
        }
        
        res = head.next;
        
        l1 = head;
        while (l1 != null) {
            if (l1.random != null) l1.next.random = l1.random.next;
            l1 = l1.next.next;
        }
        
        l1 = head;
        
        while (l1 != null) {
            l2 = l1.next;
            l1.next = l2.next;
            if (l2.next != null) l2.next = l2.next.next;
            l1 = l1.next;
        }
        
        return res;
    }
}