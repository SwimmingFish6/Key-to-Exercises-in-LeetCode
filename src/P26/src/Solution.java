/**
 * Created by luxuhui on 2018/2/1.
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        int signal = Integer.MAX_VALUE;
        int length = 0;

        for (int i = 0;i < nums.length;i++) {
            if (nums[i] != signal) {
                nums[length] = nums[i];
                signal = nums[i];
                length++;
            }
        }
        return length;
    }
}
