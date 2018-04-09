class Solution {
    public int maxSubArray(int[] nums) {
        int back = 0, front = 0;
        int maxSum = nums[0];
        int curSum = 0;
        
        while (back < nums.length) {
            curSum += nums[back];
            
            if (curSum > maxSum) {
                maxSum = curSum;
            }
            
            if (curSum < 0) {
                front = back + 1;
                curSum = 0;
            }
            
            back++;
        }
        
        return maxSum;
    }
}
