package org.problems.arrays;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/next-greater-element-iv/
 * 
 * Given a positive 32-bit integer n, you need to find the greatest 32-bit
 * integer which has exactly the same digits existing in the integer n and is
 * greater in value than n. If no such positive 32-bit integer exists, you need
 * to return -1.
 * 
 * Example 1:
 * 
 * Input: 12 Output: 21
 * 
 * 
 * Example 2:
 * 
 * Input: 21 Output: -1.
 * 
 */
public class NextGreaterElementIV {

	public static int nextGreaterElement(int n) {
		if (n <= 10) {
			return -1;
		}
		int pow = (int) Math.log10(n) + 1;
		int[] digits = new int[pow];
		int idx = pow - 1;
		int num = n;
		while (num > 0) {
			int digit = num % 10;
			digits[idx--] = digit;
			num -= digit;
			num /= 10;
		}
		Arrays.sort(digits);
		long greaterNum = 0;
		long base = 1;
		for (int i = 0; i < digits.length; i++) {
			greaterNum += base * digits[i];
			base *= 10;
		}
		int res = (int) greaterNum;
		return res > n ? res : -1;

	}

	public static void main(String[] arg) {

		System.out.println(nextGreaterElement(12));
		System.out.println(nextGreaterElement(21));
		System.out.println(nextGreaterElement(11));
		System.out.println(nextGreaterElement(123454));

	}

}
