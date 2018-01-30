/**
 * Created by luxuhui on 2018/1/27.
 */
import java.util.Arrays;

class Solution1 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int left = (nums1.length + nums2.length + 1) / 2, right = (nums1.length + nums2.length + 2) / 2;

        return (findKth(nums1, nums2, left) + findKth(nums1, nums2, right)) / 2.0;
    }

    public int findKth(int[] nums1, int[] nums2, int k) {
        if (nums1.length > nums2.length) return findKth(nums2, nums1, k);

        if (nums1.length == 0) return nums2[k - 1];

        if (k == 1) return min(nums1[0], nums2[0]);

        int index1 = min(nums1.length, k / 2), index2 = k / 2;

        if (nums1[index1 -1] > nums2[index2 - 1]) {
            if (index2 == nums2.length) return nums1[k - index2 -1 ];

            if (k - index2 == 1) return min(nums1[0], nums2[index2]);

            else return findKth(Arrays.copyOfRange(nums2, index2, nums2.length), nums1, k - index2);
        }
        else {
            if (index1 == nums1.length) return nums2[k - index1 - 1];
            if (k - index1 == 1) return min(nums2[0], nums1[index1]);

            else return findKth(Arrays.copyOfRange(nums1, index1, nums1.length), nums2, k - index1);
        }

    }

    public int min(int x, int y) {
        return x < y ? x:y;
    }
}
