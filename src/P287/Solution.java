class Solution {
    public int findDuplicate(int[] nums) {    
        int walker = nums[0];
        int runner = nums[walker];
        
        while (walker != runner) {
            walker = nums[walker];
            runner = nums[nums[runner]];
        }
        
        walker = 0;
        
        while (walker != runner) {
            walker = nums[walker];
            runner = nums[runner];
        }
        
        return walker;
    }
}