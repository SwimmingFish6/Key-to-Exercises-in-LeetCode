/**
 * Created by luxuhui on 2018/2/1.
 */
class Solution {
    public int removeElement(int[] nums, int val) {
        int elementCount = 0;

        for (int i = 0;i < nums.length;i++) {
            if (nums[i] == val) {
                elementCount++;
                continue;
            }
            else nums[i - elementCount] = nums[i];
        }

        return nums.length - elementCount;
    }
}