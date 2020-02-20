package com.zerods.learn.interview.algorithm.sort;

/**
 * @author gengchao05 create on 2020/02/06
 */
public class QuickSort extends AbstractSort {
    public static void main(String[] args) {
        System.out.println(new QuickSort().checkTrue());
    }

    @Override
    public void sort(int[] nums) {
        if (!checkParam(nums)) {
            return;
        }

        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int partition = partition(nums, start, end);
        quickSort(nums, start, partition - 1);
        quickSort(nums, partition + 1, end);
    }

    private int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int pivotRightIndex = start;

        for (int curIndex = start; curIndex < end; curIndex++) {
            int curVal = nums[curIndex];
            if (curVal < pivot) {
                int tmp = nums[pivotRightIndex];
                nums[pivotRightIndex++] = nums[curIndex];
                nums[curIndex] = tmp;
            }
        }

        int tmp = nums[pivotRightIndex];
        nums[pivotRightIndex] = pivot;
        nums[end] = tmp;
        return pivotRightIndex;
    }
}
