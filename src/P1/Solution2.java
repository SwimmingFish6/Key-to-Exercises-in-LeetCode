/**
 * Created by luxuhui on 2018/1/26.
 */
import java.util.HashMap;

public class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        int[] index = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0;i < nums.length;i++) {
            if (map.containsKey(target - nums[i])) {
                index[0] = map.get(target - nums[i]);
                index[1] = i;

            }
            else {
                map.put(nums[i], i);
            }
        }

        return index;
    }
}