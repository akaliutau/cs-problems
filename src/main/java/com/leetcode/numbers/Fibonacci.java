package com.leetcode.numbers;

/**
 * https://leetcode.com/problems/fibonacci-number/
 * 
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the
 * Fibonacci sequence, such that each number is the sum of the two preceding
 * ones, starting from 0 and 1. That is,
 * 
 * F(0) = 0, F(1) = 1 F(N) = F(N - 1) + F(N - 2), for N > 1.
 * 
 */
public class Fibonacci {

	public static int fib(int n) {
		if (n == 0) {
			return 0;
		}

		if (n == 1) {
			return 1;
		}
		long prevN2 = 0;
		long prevN1 = 1;
		for (int i = 1; i < n; i++) {
			long cur = prevN1 + prevN2;
			prevN2 = prevN1;
			prevN1 = cur;
		}
		return (int) prevN1;
	}

	public static void main(String[] arg) {

		System.out.println(fib(0));
		System.out.println(fib(1));
		System.out.println(fib(2));
		System.out.println(fib(3));
		System.out.println(fib(4));

	}

}
