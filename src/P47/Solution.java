class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        generateList(res, nums, 0);
        
        return res;
    }

    public void generateList(List<List<Integer>> res, int[] nums, int index) {
        List list = new ArrayList<Integer>();
        
        if (index == nums.length - 1) {
            List<Integer> temp = new ArrayList<Integer>();
            
            for (int i: nums) temp.add(i);
            
            res.add(temp);
            return;
        }
        
        list.add(nums[index]);
        generateList(res, nums, index + 1);
        
        for (int i = index + 1;i < nums.length;i++) {
            if (list.contains(nums[i])) continue;
            list.add(nums[i]);
            swap(nums, i, index);
            generateList(res, nums, index + 1);
            swap(nums, i, index);
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}