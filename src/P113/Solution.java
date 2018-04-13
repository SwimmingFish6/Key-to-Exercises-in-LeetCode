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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if (root == null) {
            return res;
        }
        
        if (sum == root.val && root.left == null && root.right == null) {
            List<Integer> tmp = new ArrayList<Integer>();
            tmp.add(root.val);
            
            res.add(tmp);
            
            return res;
        }
        
        List<List<Integer>> left = pathSum(root.left, sum - root.val);
        List<List<Integer>> right = pathSum(root.right, sum - root.val);
        
        for (int i = 0;i < left.size();i++) {
            List<Integer> tmp = left.get(i);
            tmp.add(0, root.val);
            res.add(tmp);
        }
        
        for (int i = 0;i < right.size();i++) {
            List<Integer> tmp = right.get(i);
            tmp.add(0, root.val);
            res.add(tmp);
        }
        
        return res;
    }
}
