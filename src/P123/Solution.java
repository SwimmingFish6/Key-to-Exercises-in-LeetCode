class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        
        int[] forward = new int[prices.length], reverse = new int[prices.length];
        int maxP = 0, minPrice = prices[0], maxPrice = prices[prices.length - 1];
        
        forward[0] = 0;
        
        for (int i = 1;i < prices.length;i++) {
            if (maxP < prices[i] - minPrice) {
                maxP = prices[i] - minPrice;
            }
            
            if (prices[i] < minPrice) minPrice = prices[i];
            
            forward[i] = maxP;
        }
        
        maxP = 0;
        reverse[prices.length - 1] = 0;
        
        for (int i = prices.length - 2;i >= 0;i--) {
            if (maxP < maxPrice - prices[i]) {
                maxP = maxPrice - prices[i];
            }
            
            if (prices[i] > maxPrice) maxPrice = prices[i];
            
            reverse[i] = maxP;
        }
        maxP = 0;
        
        for (int i = 0;i < prices.length - 1;i++) {
            int tmp = Math.max(forward[i], Math.max(reverse[i], reverse[i] + forward[i]));
            if (maxP < tmp) maxP = tmp;
        }
        
        return maxP > forward[prices.length - 1]?maxP:forward[prices.length - 1];
    }
}
