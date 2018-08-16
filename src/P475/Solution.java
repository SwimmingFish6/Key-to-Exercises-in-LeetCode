class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        int res = 0;
        Arrays.sort(heaters);
        
        for (int house : houses) {
            int index = Arrays.binarySearch(heaters, house);
            
            if (index < 0) {
                index = -(index + 1);
            }
            
            int left = index - 1 >= 0? house - heaters[index - 1]: Integer.MAX_VALUE;
            
            int right = index < heaters.length?heaters[index] - house: Integer.MAX_VALUE;
            
            res = Math.max(res, Math.min(left, right));
        }
        
        return res;
    }
}