class Solution {
    public int rob(int[] nums) {
        int cur = 0, pre = 0;
        
        if (nums.length == 0) return 0;
        
        for (int i = 1;i < nums.length;i++) {
            int tmp = Math.max(pre + nums[i], cur);
            
            pre = cur;
            cur = tmp;
        }
        
        int num1 = Math.max(pre, cur);
        
        pre = nums[0];
        cur = nums[0];
        
        for (int i = 2;i < nums.length - 1;i++) {
            int tmp = Math.max(pre + nums[i], cur);
            
            pre = cur;
            cur = tmp;
        }
        
        int num2 = Math.max(pre, cur);
        
        return Math.max(num1, num2);
    }
}