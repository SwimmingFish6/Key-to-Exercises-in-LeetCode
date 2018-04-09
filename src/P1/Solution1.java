/**
 * Created by luxuhui on 2018/1/26.
 */
class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        int[] nums_copy = nums.clone();

        int l = 0, r = nums.length - 1;
        int[] positions = new int[nums.length];


        for (int i = 0; i < nums.length;i++){
            positions[i] = i;
        }

        sort(nums, positions, l, r);

        while (l < r) {
            if (nums[l] + nums[r] > target) {
                r--;
            }

            if (nums[l] + nums[r] < target) {
                l++;
            }

            if (nums[l] + nums[r] == target) {
                break;
            }
        }

        if (l > r) {
            int temp = l;
            l = r;
            r = temp;
        }

        return new int[]{positions[l], positions[r]};

    }

    public void sort(int[] nums, int[] positions, int begin, int end){
        int tbegin = begin, tend = end;
        int pivot = nums[begin];
        int pivot_positions = positions[begin];


        while (tbegin < tend){
            while (tbegin < tend && nums[tend] >= pivot ){
                tend--;
            }
            nums[tbegin] = nums[tend];
            positions[tbegin] = positions[tend];

            while (tbegin < tend && nums[tbegin] <= pivot){
                tbegin++;
            }
            nums[tend] = nums[tbegin];
            positions[tend] = positions[tbegin];

        }
        nums[tbegin] = pivot;
        positions[tbegin] = pivot_positions;

        if (begin < tend){
            sort(nums, positions, begin, tend - 1);
        }

        if(tbegin < end){
            sort(nums, positions, tbegin+1, end);
        }

    }
}