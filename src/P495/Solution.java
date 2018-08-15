class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int total = duration * timeSeries.length;
        
        for (int i = 1;i < timeSeries.length;i++) {
            int gap = duration - (timeSeries[i] - timeSeries[i - 1]);
            
            total -= gap > 0? gap : 0;
        }
        
        return total;
    }
}
