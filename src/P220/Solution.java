class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int begin = 0;
        TreeSet<Long> tree = new TreeSet<Long>();
        
        for (int i = 0;i < nums.length;i++) {
            Long floor = tree.floor((long) nums[i] + t);
            Long ceiling = tree.ceiling((long) nums[i] - t);
            
            if ((floor != null && floor >= (long) nums[i]) || (ceiling != null && ceiling <= (long) nums[i])) return true;
            
            tree.add((long) nums[i]);
            
            if (i >= k) tree.remove((long) nums[i - k]);
        }
        
        return false;
    }
}