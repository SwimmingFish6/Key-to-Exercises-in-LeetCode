class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int res = 0;
        int bit = 1;
        
        while(n != m) {
            n = n >> 1;
            m = m >> 1;
            bit = bit << 1;
        }
        
        return m * bit;
    }
}