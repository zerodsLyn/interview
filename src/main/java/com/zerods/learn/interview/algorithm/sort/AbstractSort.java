package com.zerods.learn.interview.algorithm.sort;

import java.util.Arrays;

/**
 * @author gengchao05 create on 2020/02/07
 */
public abstract class AbstractSort implements Sort{
    public boolean checkParam(int[] nums) {
        return nums != null && nums.length != 0;
    }

    public boolean checkTrue() {
        int[] nums1 = new int[]{5, 4, 3, 1, 2, 0, 8, 7, 6, 7};
        sort(nums1);

        int[] nums2 = new int[]{5, 4, 3, 1, 2, 0, 8, 7, 6, 7};
        Arrays.sort(nums2);


        int[] nums3 = new int[]{5, 5, 5, 5, 2, 2, 2, 0, 8, 7, 6, 7};
        sort(nums3);

        int[] nums4 = new int[]{5, 5, 5, 5, 2, 2, 2, 0, 8, 7, 6, 7};
        Arrays.sort(nums4);

        return checkArrayEquals(nums1, nums2) && checkArrayEquals(nums3, nums4);
    }

    public boolean checkArrayEquals(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        if (length1 != length2) {
            return false;
        }

        for (int i = 0; i < length1; i++) {
            if (nums1[i] != nums2[i]) {
                return false;
            }
        }

        return true;

    }
}
