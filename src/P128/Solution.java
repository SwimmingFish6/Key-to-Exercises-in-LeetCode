class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> forwardMap = new HashMap<Integer, Integer>();
        Map<Integer, Integer> backMap = new HashMap<Integer, Integer>();
        Set<Integer> set = new HashSet<Integer>();
        
        int maxLength = 0;
        
        for (int i = 0;i < nums.length;i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                int begin = backMap.containsKey(nums[i] - 1)?backMap.get(nums[i] - 1):nums[i];
                int end = forwardMap.containsKey(nums[i] + 1)?forwardMap.get(nums[i] + 1):nums[i];
                
                forwardMap.put(begin, end);
                backMap.put(end, begin);
                
                if (maxLength < 1 + end - begin) maxLength = end - begin + 1;
            }
        }
        
        return maxLength;
    }
}