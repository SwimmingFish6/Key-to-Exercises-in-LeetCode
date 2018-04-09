class Solution {
    public boolean canJump(int[] nums) {
        int range = nums[0];
        int lastReach = 0;
        int step = 0;
        
        for (int i = 0;i <= lastReach && i < nums.length;i++) {
            if (i > range) {
                step++;
                range = lastReach;
            }
            
            lastReach = Math.max(lastReach, i + nums[i]);
        }
        
        if (range < nums.length - 1) return false;
        else return true;
        
    }
}
