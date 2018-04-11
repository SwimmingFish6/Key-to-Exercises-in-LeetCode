class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        
        int totalFit = 0;
        int minPrice = prices[0];
        
        for (int i = 1;i < prices.length;i++) {
            if (prices[i] > prices[i - 1]) continue;
            else {
                totalFit += prices[i - 1] - minPrice;
                minPrice = prices[i];
            }
        }
        
        totalFit += prices[prices.length - 1] - minPrice;
        
        return totalFit;
    }
}
