class Solution {
    public int rob(int[] nums) {        
        int pre = 0, cur = 0;
        
        
        for (int i = 0;i < nums.length;i++) {
            int tmp = Math.max(pre + nums[i], cur);
            
            pre = cur;
            cur = tmp;
        }
        
        return Math.max(pre, cur);
    }
}