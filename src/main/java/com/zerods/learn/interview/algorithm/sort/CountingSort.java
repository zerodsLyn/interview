package com.zerods.learn.interview.algorithm.sort;

import java.util.Arrays;

/**
 * @author gengchao05 create on 2020/02/21
 * 计数排序需要确定需要排序的范围，假设这里的nums的范围是[0, 9]
 */
public class CountingSort extends AbstractSort {
    public static void main(String[] args) {
        System.out.println(new CountingSort().checkTrue());
    }

    @Override
    public void sort(int[] nums) {
        if (!checkParam(nums)) {
            return;
        }

        int[] countArray = new int[10];
        for (int num : nums) {
            countArray[num] = countArray[num] + 1;
        }
        for (int i = 1; i < countArray.length; i++) {
            countArray[i] = countArray[i - 1] + countArray[i];
        }

        int[] sortedNums = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            sortedNums[countArray[num] - 1] = num;
            countArray[num] = countArray[num] - 1;
        }

        System.arraycopy(sortedNums, 0, nums, 0, nums.length);
        System.out.println(Arrays.toString(nums));
    }
}
