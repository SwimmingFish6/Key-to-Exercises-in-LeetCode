/**
 * Created by luxuhui on 2018/2/1.
 */
class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1 || divisor == 0) return Integer.MAX_VALUE;
        int consult = 0, exp = 0;
        int flag = 1;

        if (divisor == -1) return -dividend;
        if (divisor == 1) return dividend;

        if ((dividend < 0 && divisor > 0) ||(dividend > 0 && divisor < 0) ) {
            flag = -1;
        }
        dividend = - Math.abs(dividend);
        divisor = - Math.abs(divisor);

        while (dividend <= divisor) {
            exp = 0;

            while (dividend - divisor * (int) Math.pow(2, exp) <= divisor * (int) Math.pow(2, exp)) {
                exp++;
            }
            dividend -= divisor * (int) Math.pow(2, exp);
            consult += (int) Math.pow(2, exp);
        }




        return consult * flag;
    }
}
