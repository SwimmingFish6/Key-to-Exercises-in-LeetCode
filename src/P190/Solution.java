public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0, bit = 1;

        for (int i = 0;i < 32;i++) {
            if (31 - i - i > 0) res = res | ((bit & n) << (31 - i - i));
            else res = res | ((bit & n) >>> (i + i - 31));

            bit = bit << 1;
        }

        return res;
    }
}