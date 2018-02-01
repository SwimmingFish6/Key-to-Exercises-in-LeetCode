import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();

        if (nums.length == 0 ){
            return list;
        }

        quickSort(nums, 0, nums.length - 1);


        for (int i = 0;i < nums.length - 3;i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            List<List<Integer>> returnValue = threeSum(Arrays.copyOfRange(nums, i + 1, nums.length), target - nums[i], nums[i]);
            list.addAll(returnValue);
        }

        return list;
    }

    public List<List<Integer>> threeSum(int[] nums, int target, int preNum) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int i = 0;i < nums.length - 2;i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            List<List<Integer>> returnValue = twoSum(Arrays.copyOfRange(nums, i + 1, nums.length), target - nums[i], preNum, nums[i]);
            list.addAll(returnValue);
        }

        return list;
    }

    public List<List<Integer>> twoSum(int[] nums, int target, int preNum1, int preNum2) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        int left = 0, right = nums.length - 1;

        while (left < right) {
            if (nums[left] + nums[right] == target) {
                list.add(new ArrayList<Integer>(Arrays.asList(preNum1, preNum2, nums[left], nums[right])));

                while (left < right && nums[left] == nums[left + 1]) {
                    left++;
                }

                while (left < right && nums[right] == nums[right - 1]) {
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

        return list;
    }

    public void quickSort(int[] nums, int begin, int end) {
        int left = begin, right = end;
        int pivot = nums[begin];

        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }

            nums[left] = nums[right];

            while (left < right && nums[left] <= pivot) {
                left++;
            }

            nums[right] = nums[left];
        }

        nums[left] = pivot;

        if (left > begin) {
            quickSort(nums, begin, left - 1);
        }

        if (right < end) {
            quickSort(nums, right + 1, end);
        }
    }
}