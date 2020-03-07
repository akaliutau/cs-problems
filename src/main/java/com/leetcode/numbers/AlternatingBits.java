package com.leetcode.numbers;

/**
 * https://leetcode.com/problems/binary-number-with-alternating-bits/
 *
 * Given a positive integer, check whether it has alternating bits: namely, if
 * two adjacent bits will always have different values.
 *
 */
public class AlternatingBits {

	public static boolean hasAlternatingBits(int orig) {
		int pow = (int) (Math.log(orig) / Math.log(2));
		long base = (long) Math.pow(2, pow + 2) - 1;
		long n = (long) orig;
		if (n % 2 == 1) {
			return base == (n ^ (n << 1));
		}
		return base - 1 == (n ^ (n << 1));

	}

	public static void main(String[] arg) {

		System.out.println(hasAlternatingBits(17));
		System.out.println(hasAlternatingBits(5));
		System.out.println(hasAlternatingBits(10));
		System.out.println(hasAlternatingBits(7));
	}

}
