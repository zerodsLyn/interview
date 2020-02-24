package com.zerods.learn.interview.algorithm.binarysearch;

/**
 * @author gengchao05 create on 2020/02/24
 */
public class BinarySearch {
    public int search(int[] orderedNums, int k) {
        if (orderedNums == null || orderedNums.length < 1) {
            return -1;
        }

        int left = 0;
        int right = orderedNums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int n = orderedNums[mid];
            if (k == n) {
                return mid;
            } else if (k < n) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new BinarySearch().search(new int[]{1, 2, 3, 4}, 0));
        System.out.println(new BinarySearch().search(new int[]{1, 2, 3, 4}, 1));
        System.out.println(new BinarySearch().search(new int[]{1, 2, 3, 4}, 2));
        System.out.println(new BinarySearch().search(new int[]{1, 2, 3, 4}, 3));
        System.out.println(new BinarySearch().search(new int[]{1, 2, 3, 4}, 4));
        System.out.println(new BinarySearch().search(new int[]{1, 2, 3, 4}, 5));
    }
}
