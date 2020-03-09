package com.zerods.learn.interview.algorithm.dp;

/**
 * @author gengchao05 create on 2020/03/09
 */
public class Fibonacci_DP {
    public static long fibonacci_recursive(int n) {
        if (n == 1 || n == 2) {
            return n;
        }

        return fibonacci_recursive(n - 1) + fibonacci_recursive(n - 2);
    }

    public static long fibonacci_dp(int n) {
        if (n == 1 || n == 2) {
            return n;
        }

        long sumOfNMinusOne = 1;
        long sumOfNMinusTwo = 2;
        long i = 3;
        while (i < n) {
            long tmp = sumOfNMinusTwo;
            sumOfNMinusTwo = sumOfNMinusOne + sumOfNMinusTwo;
            sumOfNMinusOne = tmp;
            i++;
        }

        return sumOfNMinusOne + sumOfNMinusTwo;
    }

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        System.out.println(fibonacci_recursive(50));
        System.out.println(System.currentTimeMillis() - a);

        long b = System.currentTimeMillis();
        System.out.println(fibonacci_dp(50));
        System.out.println(System.currentTimeMillis() - b);
    }
}
