/**
 * Created by luxuhui on 2018/1/28.
 */
class Solution {
    public int reverse(int x) {
        long reverse_num = 0;
        long origin_num = x;

        int flag = 1;

        if (origin_num < 0) {
            origin_num = -origin_num;
            flag = -1;
        }


        while (origin_num != 0) {
            reverse_num = 10 * reverse_num + origin_num % 10;

            if (reverse_num > 2147483647) return 0;

            origin_num /= 10;

        }


        return flag * (int) reverse_num;

    }
}