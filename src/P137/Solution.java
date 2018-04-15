class Solution {
    public int singleNumber(int[] nums) {
        int two = 0, one = 0;
        
        for (int i = 0;i < nums.length;i++) {
            one = (one ^ nums[i]) & ~two;
            two = (two ^ nums[i]) & ~one;
        }
        
        return one;
    }
}
