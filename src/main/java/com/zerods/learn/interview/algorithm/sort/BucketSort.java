package com.zerods.learn.interview.algorithm.sort;

import com.sun.tools.javac.util.Assert;

/**
 * @author gengchao05 create on 2020/02/07
 *
 * 桶排序需要确定需要排序的范围，假设这里的nums的范围是[1, 1000]
 */
public class BucketSort extends AbstractSort {

    public static void main(String[] args) {
        System.out.println(new BucketSort().checkTrue());
    }

    @Override
    public void sort(int[] nums) {
        if (!checkParam(nums)) {
            return;
        }

        int index0 = 0;
        int index1 = 0;
        int index2 = 0;
        int index3 = 0;
        int index4 = 0;
        int index5 = 0;
        int index6 = 0;
        int index7 = 0;
        int index8 = 0;
        int index9 = 0;
        int[][] buckets = new int[10][100];
        for (int num : nums) {
            Assert.check(num > 0);
            Assert.check(num < 1001);
            if (0 < num && num <= 100) {
                buckets[0][index0++] = num;
            } else if (num <= 200) {
                buckets[1][index1++] = num;
            } else if (num <= 300) {
                buckets[2][index2++] = num;
            } else if (num <= 400) {
                buckets[3][index3++] = num;
            } else if (num <= 500) {
                buckets[4][index4++] = num;
            } else if (num <= 600) {
                buckets[5][index5++] = num;
            } else if (num <= 700) {
                buckets[6][index6++] = num;
            } else if (num <= 800) {
                buckets[7][index7++] = num;
            } else if (num <= 900) {
                buckets[8][index8++] = num;
            } else if (num <= 1000) {
                buckets[9][index9++] = num;
            }
        }

        for (int[] bucket : buckets) {
            (new MergeSort()).sort(bucket);
        }

        int index = 0;
        for (int[] bucket : buckets) {
            for (int i : bucket) {
                if (i != 0) {
                    nums[index++] = i;
                }
            }
        }
    }
}
