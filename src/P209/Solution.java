class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        LinkedList<Integer> queue = new LinkedList<Integer>();
        int curValue = 0;
        int minLength = Integer.MAX_VALUE;
        
        for (int i = 0;i < nums.length;i++) {
            curValue += nums[i];
            queue.offer(nums[i]);
                        
            while (curValue >= s) {
                minLength = Math.min(minLength, queue.size());
                curValue -= queue.poll();
            }
        }
        
        return minLength != Integer.MAX_VALUE?minLength:0;
        
    }
}