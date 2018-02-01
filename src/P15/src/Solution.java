/**
 * Created by luxuhui on 2018/1/30.
 */
import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> re = new ArrayList<List<Integer>>();


        if (nums.length == 0 ){
            return re;
        }

        quickSort(nums, 0, nums.length - 1);


        for (int i = 0;i < nums.length - 2;i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            List<List<Integer>> returnValue = twoSum(Arrays.copyOfRange(nums, i + 1, nums.length), - nums[i]);
            re.addAll(returnValue);
        }


        return re;

    }

    public List<List<Integer>> twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        List<List<Integer>> re = new ArrayList<List<Integer>>();

        while (left < right ) {
            if (nums[left] + nums[right] == target){
                re.add(new ArrayList<Integer>(Arrays.asList(-target, nums[left], nums[right])));

                while (left < right && nums[left]==nums[left+1]) {
                    left++;
                }
                while (left < right && nums[right]==nums[right-1]) {
                    right--;
                }

                left++;
                right--;
            }

            else if (nums[left] + nums[right] < target) {
                left++;
            }
            else {
                right--;
            }
        }



        return re;
    }

    public void quickSort(int[] nums, int begin, int end) {
        int pivot = nums[begin];
        int left = begin, right = end;

        while (left < right) {
            while (nums[right] >= pivot && left < right) {
                right--;
            }
            nums[left] = nums[right];

            while (nums[left] <= pivot && left < right) {
                left++;
            }
            nums[right] = nums[left];
        }

        nums[left] = pivot;

        if (left > begin)
            quickSort(nums, begin, left - 1);

        if (right < end)
            quickSort(nums, right + 1, end);

    }
}

