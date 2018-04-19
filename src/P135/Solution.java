class Solution {
    public int candy(int[] ratings) {
        if (ratings.length == 0 || ratings.length == 1) return ratings.length;
        
        int res = 0;
        int[] nums = new int[ratings.length];
        
        
        for (int i = 1;i < ratings.length;i++) {
            if (ratings[i - 1] < ratings[i]) nums[i] = nums[i - 1] + 1;
        }
        
        for (int i = ratings.length - 1;i > 0;i--) {
            if (ratings[i - 1] > ratings[i]) nums[i - 1] = Math.max(nums[i - 1], nums[i] + 1);
        }
        
        for (int i = 0;i < ratings.length;i++) {
            res += nums[i] + 1;
        }
        
        return res;
    }
}