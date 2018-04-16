class Solution {
    public int findPeakElement(int[] nums) {
        
        return findMax(nums, 0, nums.length - 1);
        
    }
    
    public int findMax(int[] nums, int begin, int end) {
        if (begin == end) return begin;
        
        
        int left = findMax(nums, begin, (begin + end) / 2);
        
        int right = findMax(nums, (begin + end) / 2 + 1, end);
        
        if (nums[left] > nums[right]) return left;
        else return right;
    
    }
}