package com.zerods.learn.interview.algorithm.sort;

import java.util.Arrays;

/**
 * @author gengchao05 create on 2020/02/06
 */
public class BubbleSort extends AbstractSort {
    public static void main(String[] args) {
        System.out.println(new BubbleSort().checkTrue());
    }

    @Override
    public void sort(int[] nums) {
        if (!checkParam(nums)) {
            return;
        }

        int size = nums.length;
        // 外循环代表的是冒泡的次数，即把未排好序的数列中的最大值冒泡到最右端的次数
        for (int i = 0; i < size - 1; i++) {
            // 这里的-i代表的是右端已经排好序的元素
            boolean exchange = false;
            for (int j = 0; j < size - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                    exchange = true;
                }
            }
            if (!exchange) {
                break;
            }
        }
    }
}
