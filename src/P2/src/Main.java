public class Main {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);

        Solution solution = new Solution();
        solution.addTwoNumbers(l1, l2);

    }
}
