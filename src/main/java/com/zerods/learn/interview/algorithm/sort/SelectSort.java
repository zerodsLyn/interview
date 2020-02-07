package com.zerods.learn.interview.algorithm.sort;

/**
 * @author gengchao05 create on 2020/02/07
 * 选择排序的核心思想也是是左侧的都有序了，但是左侧的值的位置都是最终位置，按照由小到大的顺序排列的
 * 每进行一次循环，就往后append一个最小值
 * 因为每次都是选择最小的值和当前需要插入的位置的数字进行交换，因此无法保证稳定性
 */
public class SelectSort extends AbstractSort {

    public static void main(String[] args) {
        System.out.println(new SelectSort().checkTrue());
    }

    @Override
    public void sort(int[] nums) {
        if (!checkParam(nums)) {
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            int min = nums[i];
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    minIndex = j;
                }
            }
            int tmp = nums[i];
            nums[i] = min;
            nums[minIndex] = tmp;
        }
    }
}
