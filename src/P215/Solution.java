class Solution {
    public int findKthLargest(int[] nums, int k) {
        quicksort(nums, 0, nums.length - 1);
        
        return nums[nums.length - k];
    }
    
    public void quicksort(int[] nums, int start, int end) {        
        int left = start, right = end;
        int pivot = nums[start];
        
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];
            
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        
        nums[left] = pivot;
        
        if (left > start) {
            quicksort(nums, start, left - 1);
        }
        if (right < end) {
            quicksort(nums, right + 1, end);
        }
    }
}