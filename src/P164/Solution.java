class Solution {
    public int maximumGap(int[] nums) {        
        return quicksort(nums, 0, nums.length - 1);
    }
    
    public int quicksort(int[] nums, int begin, int end) {
        if (begin == end || nums.length == 0) return 0;
        
        int pivot = nums[begin];
        int left = begin, right = end;
        int lDif = 0, rDif = 0;
        
        while (left < right) {
            while (left < right && nums[right] > pivot) {
                right--;
            }
            nums[left] = nums[right];
            
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            
            nums[right] = nums[left];
        }
        
        nums[left] = pivot;
        
        if (left > begin) {
            lDif = quicksort(nums, begin, left - 1);
        }
        
        if (end > right) {
            rDif = quicksort(nums, right + 1, end);
        }
        
        int gap = 0;
        
        gap = Math.max(left > begin?pivot - nums[left - 1]:0, right < end?nums[right + 1] - pivot:0);
        
        return Math.max(gap, Math.max(lDif, rDif));
    }
}