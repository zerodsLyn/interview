package com.zerods.learn.interview.algorithm.sort;

/**
 * @author gengchao05 create on 2020/02/07
 * 插入排序的核心思想是左侧的都有序了，然后右边的值以此往里插牌的思想，
 * 由大到小开始比较，为了维持稳定性，如果相等，不修改顺序的
 */
public class InsertionSort extends AbstractSort {
    public static void main(String[] args) {
        System.out.println(new InsertionSort().checkTrue());
    }

    @Override
    public void sort(int[] nums) {
        if (!checkParam(nums)) {
            return;
        }

        for (int i = 1; i < nums.length; i++) {
            int curNum = nums[i];
            int j =  i - 1;
            for (; j >= 0; j--) {
                if (nums[j] > curNum) {
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }

            }
            nums[j + 1] = curNum;
        }
    }
}
