import java.util.*;

class Solution {
    public boolean circularArrayLoop(int[] nums) {
        boolean flag;
        HashSet<Integer> total = new HashSet<Integer>();

        for (int i = 0;i < nums.length;i++) {
            int index = i;

            if (total.contains(i)) continue;

            if (nums[index] > 0) flag = true;
            else flag = false;
            int tmp = index;
            HashSet<Integer> set = new HashSet<Integer>();

            while (!set.contains(index)) {
                if (flag && nums[index] < 0) break;
                if (!flag && nums[index] > 0) break;
                
                set.add(index);

                tmp = index;

                index += nums[index];
                if (index < 0) index = nums.length -1 - (-index - 1) % nums.length;
                else if (index >= nums.length) index = (index - nums.length + 1) % nums.length - 1;
                
                if (index == -1) index = nums.length - 1;
            }

            if (tmp != index && set.contains(index)) return true;

            total.addAll(set);

        }

        return false;
    }
}