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
    public List<TreeNode> generateTrees(int n) {
        return dfs(1, n);
    }
    
    public List<TreeNode> dfs(int begin, int end) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        
        if (begin == end)  {
            res.add(new TreeNode(begin));
            return res;
        }
        
        for (int i = begin;i <= end;i++) {
            if (i == begin) {
                List<TreeNode> subList = dfs(begin + 1, end);
                for (int j = 0;j < subList.size();j++) {
                    TreeNode tmp = new TreeNode(i);
                    tmp.left = null;
                    tmp.right = subList.get(j);
                    
                    res.add(tmp);
                }
                
            }
            else if (i == end) {
                List<TreeNode> subList = dfs(begin, end - 1);
                for (int j = 0;j < subList.size();j++) {
                    TreeNode tmp = new TreeNode(i);
                    tmp.right = null;
                    tmp.left = subList.get(j);
                    
                    res.add(tmp);
                }
            }
            else {
                List<TreeNode> leftSubList = dfs(begin, i - 1);
                List<TreeNode> rightSubList = dfs(i + 1, end);
                for (int j = 0;j < rightSubList.size();j++) {
                    for (int k = 0;k < leftSubList.size();k++) {
                        TreeNode tmp = new TreeNode(i);
                        tmp.left = leftSubList.get(k);
                        tmp.right = rightSubList.get(j);
                        
                        res.add(tmp);
                    }
                }
            }
        }
        
        return res;
    }
}
