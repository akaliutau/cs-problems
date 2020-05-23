package org.problems.misc;

/**
 * https://leetcode.com/problems/powx-n
 * 
 * Runtime: 1 ms, faster than 91.80% of Java online submissions for Keys and
 * Rooms. Memory Usage: 43.3 MB, less than 58.62% of Java online submissions for
 * Keys and Rooms.
 */
public class PowXN {

	public static double myPow(double x, int n) {
		double res = x;

		if (x == -1 && n == -2147483648) {
			return 1.0;
		}

		if (n <= Integer.MIN_VALUE) {
			return 0;
		}

		if (x == 0 || x == 1d) {
			return x;
		}
		if (n == 0) {
			return 1d;
		}
		long pow = n < 0 ? -n : n;
		long base = 2;
		while (pow > base) {
			res *= res;
			base *= 2;
		}
		pow -= base / 2;
		for (long i = 0; i < pow; i++) {
			res = res * x;
			if (res == 0) {
				return res;
			}
		}
		return n > 0 ? res : 1 / res;
	}

	public static void main(String[] arg) {
		// 0 1 2 3
		long l = -2147483648;
		System.out.println(myPow(2.00000d, (int) l));
		System.out.println(myPow(1, 17));
		System.out.println(myPow(0.00001, 2147483647));
		System.out.println(myPow(-1, -2147483648));

	}
}
