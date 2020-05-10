package com.leetcode.numbers;

/**
 * https://leetcode.com/problems/integer-break/
 * 
 * Given a positive integer n, break it into the sum of at least two positive
 * integers and maximize the product of those integers. Return the maximum
 * product you can get.
 * 
 * Example 1:
 * 
 * Input: 2 Output: 1 Explanation: 2 = 1 + 1, 1 × 1 = 1. 
 * 
 * Example 2:
 * 
 * Input: 10 Output: 36 Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36. 
 * 
 * Note: You may assume that n is not less than 2 and not larger than 58.
 * 
 * 
 */
public class IntegerBreak {
	
	static int product(int n, int base) {
		int mod = n % base;
		int num = n / base;
		if (mod == 0) {
			return (int) Math.pow(base, num);
		}else {
			int cand1 = (int) Math.pow(base, num-1) * (base + mod);
			int cand2 = (int) Math.pow(base, num) * mod;
			return Math.max(cand1, cand2);
		}
	}

	public static int integerBreak(int n) {
		int prod = 0;
		if (n == 1 || n == 2) {
			return 1;
		}
		if (n == 3 ) {
			return 2;
		}
		for (int i = 2; i < n; i++) {
			prod = Math.max(prod, product(n, i));
		}
		return prod;

	}

	public static void main(String[] arg) {

		System.out.println(integerBreak(2));
		System.out.println(integerBreak(10));
		System.out.println(integerBreak(7));//12
		System.out.println(integerBreak(8));//18
		System.out.println(integerBreak(50));
		System.out.println(integerBreak(58));
		System.out.println(integerBreak(59));

	}

}
