package com.zerods.learn.interview.algorithm.sort;

/**
 * @author gengchao05 create on 2020/02/06
 */
public class MergeSort extends AbstractSort {
    public static void main(String[] args) {
        System.out.println(new MergeSort().checkTrue());
    }

    @Override
    public void sort(int[] nums) {
        if (!checkParam(nums)) {
            return;
        }

        mergeSort(nums, 0, nums.length - 1);
    }

    private void mergeSort(int[] nums, int start, int end) {
        if (start == end) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    private void merge(int[] nums, int start, int mid, int end) {
        int leftIndex = start;
        int rightIndex = mid + 1;

        int[] tmp = new int[end - start + 1];
        int tmpIndex = 0;
        while (leftIndex <= mid && rightIndex <= end) {
            int leftVal = nums[leftIndex];
            int rightVal = nums[rightIndex];
            if (leftVal <= rightVal) {
                tmp[tmpIndex++] = nums[leftIndex++];
            } else {
                tmp[tmpIndex++] = nums[rightIndex++];
            }
        }

        if (leftIndex > mid) {
            while (rightIndex <= end) {
                tmp[tmpIndex++] = nums[rightIndex++];
            }
        } else {
            while (leftIndex <= mid) {
                tmp[tmpIndex++] = nums[leftIndex++];;
            }
        }

        System.arraycopy(tmp, 0, nums, start, end - start + 1);
    }
}
