import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int distance = Integer.MAX_VALUE;

        if (nums.length == 1 ){
            return nums[0];
        }

        quickSort(nums, 0, nums.length - 1);


        for (int i = 0;i < nums.length - 2;i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            distance = twoSum(Arrays.copyOfRange(nums, i + 1, nums.length), target - nums[i] , distance);

            if (distance == 0) return target;

        }


        return target - distance;

    }

    public int twoSum(int[] nums, int target, int distance) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            if (Math.abs(nums[left] + nums[right] - target) < Math.abs(distance)){
                distance = target - nums[left] - nums[right];

                if(distance == 0) return distance;
            }

            else if (nums[left] + nums[right] < target) {
                left++;
            }
            else {
                right--;
            }
        }


        return distance;
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


