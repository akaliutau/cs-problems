package com.leetcode.numbers;

import java.util.List;

/**
 * https://leetcode.com/problems/sum-of-two-integers/
 * 
 * Calculate the sum of two integers a and b, but you are not allowed to use the
 * operator + and -.
 * 
 * Example 1:
 * 
 * Input: a = 1, b = 2 Output: 3
 * 
 * Example 2:
 * 
 * Input: a = -2, b = 3 Output: 1
 * 
 */
public class SumOfTwoIntegers {

	public static int getSum(int a, int b) {
		while (b != 0) {
			long iterm = a & b;
			a = a ^ b;
			b = (int) (iterm << 1);
		}
		return a;
	}

	public static void main(String[] arg) {

		System.out.println(getSum(1, 3));
		System.out.println(getSum(2, 3));
		System.out.println(getSum(-2, 3));

	}

}
