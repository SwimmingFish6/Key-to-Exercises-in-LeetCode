class Solution {
    public int majorityElement(int[] nums) {        
//         HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//         int res = 0;
        
        
//         for (int i = 0;i < nums.length;i++) {
//             if (map.containsKey(nums[i])) {
//                 map.put(nums[i], map.get(nums[i]) + 1);
//             }
//             else {
//                 map.put(nums[i], 1);
//             }
            
//             if (map.get(nums[i]) > nums.length / 2) {
//                 res = nums[i];
//                 break;
//             }
//         }
        
//         return res;
        
        Arrays.sort(nums);
        
        return nums[nums.length / 2];
    }
}