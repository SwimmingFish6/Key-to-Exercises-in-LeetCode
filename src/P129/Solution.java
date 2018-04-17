/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<Integer> valQueue = new LinkedList<Integer>();
        int res = 0;

        queue.offer(root);
        valQueue.offer(0);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0;i < size;i++) {
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                    valQueue.offer(valQueue.peek() * 10 + queue.peek().val);
                }

                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                    valQueue.offer(valQueue.peek() * 10 + queue.peek().val);
                }

                if (queue.peek().left == null && queue.peek().right == null) {
                    res += valQueue.peek() * 10 + queue.peek().val;
                }

                queue.poll();
                valQueue.poll();
            }
        }


        return res;
    }
}







