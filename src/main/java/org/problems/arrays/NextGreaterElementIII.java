package org.problems.arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/next-greater-element-iii/
 * 
 * Given a positive 32-bit integer n, you need to find the smallest 32-bit
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
public class NextGreaterElementIII {

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
		idx = pow - 1;
		// find subseq which can be ordered, i.e there is an elem greater then max(all
		// previous)
		int max = digits[idx];
		int maxIdx = idx;
		while (idx > -1) {
			if (digits[idx] < max) {
				break;
			}
			if (max < digits[idx]) {
				max = digits[idx];
			}
			idx--;
		}
		if (idx == -1) {
			return -1;
		}
		// find next max for idx on range [idx,pow]
		int min = digits[idx];
		max = min;

		int[] suffix = Arrays.copyOfRange(digits, idx, pow);
		Arrays.sort(suffix);
		for (int i = 0; i < suffix.length; i++) {
			if (suffix[i] > min) {
				max = suffix[i];
				maxIdx = i;
				break;
			}
		}
		int idx1 = idx + 1;
		
		for (int i = 0; i < suffix.length; i++) {
			if (i != maxIdx) {
				digits[idx1++] = suffix[i];
			}
		}
		// idx points to start of suffix - replace this with max
		digits[idx] = max;
		long greaterNum = 0;
		long base = 1;
		for (int i = 0; i < digits.length; i++) {
			greaterNum += base * digits[digits.length - 1 - i];
			base *= 10;
		}
		if (greaterNum > Integer.MAX_VALUE) {
			return -1;
		}
			
		int res = (int) greaterNum;
		return res;

	}

	public static void main(String[] arg) {

		System.out.println(nextGreaterElement(12));
		System.out.println(nextGreaterElement(21));
		System.out.println(nextGreaterElement(11));
		System.out.println(nextGreaterElement(123454));
		System.out.println(nextGreaterElement(230241));// 230412
		System.out.println(nextGreaterElement(12443322));// 13222344
		System.out.println(nextGreaterElement(1999999999));// -1

	}

}
