class Solution {
    public void rotate(int[] nums, int k) {
        
        k = k % nums.length;
        int left = 0, right = nums.length - 1;
        int switchLength = Math.min(k, nums.length - k);
        int pivot = nums.length - k - 1;
        
        while (switchLength != 0) {
            for (int i = 0;i < switchLength;i++) {
                nums[i + left] = nums[i + left] + nums[right - switchLength + i + 1];
                nums[right - switchLength + i + 1] = nums[i + left] - nums[right - switchLength + i + 1];
                nums[i + left] = nums[i + left] - nums[right - switchLength + i + 1];
            }
            if (pivot - left + 1 > right - pivot) {
                left = left + right - pivot;
                switchLength = Math.min(right - pivot, pivot - left + 1);
            }
            else if (pivot - left + 1 < right - pivot) {
                right = right - pivot + left - 1;
                switchLength = Math.min(right - pivot, pivot - left + 1);
            }
            else break;
        }
    }
}