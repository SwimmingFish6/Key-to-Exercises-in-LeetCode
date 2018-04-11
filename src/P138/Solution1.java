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
        
        ArrayList<RandomListNode> list = new ArrayList<RandomListNode>();
        ArrayList<RandomListNode> newList = new ArrayList<RandomListNode>();
        
        while (head != null) {
            list.add(head);
            newList.add(new RandomListNode(head.label));
            head = head.next;
        }
        
        for (int i = 0;i < list.size();i++) {
            RandomListNode tmp = list.get(i).random;
            if (tmp != null) {
                int index = list.indexOf(tmp);
                newList.get(i).random = newList.get(index);
            }
            
            if (i < list.size() - 1) newList.get(i).next = newList.get(i + 1);
            
        }
        
        
        return newList.get(0);
    }
}
