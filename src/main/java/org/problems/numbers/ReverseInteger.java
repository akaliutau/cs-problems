package org.problems.numbers;

/**
 * https://leetcode.com/problems/reverse-integer/
 * 
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Reverse
 * Integer. Memory Usage: 37.2 MB, less than 5.55% of Java online submissions
 * for Reverse Integer.
 */
public class ReverseInteger {

	public static int reverse(int x) {
		String s = Integer.toString(x);

		int shift = x < 0 ? 1 : 0;
		int len = s.length() - shift;

		long factor = (long) Math.pow(10, len - 1);
		long res = 0;
		for (int i = len - 1 + shift; i > shift - 1; i--) {
			res += factor * (s.charAt(i) - 48);
			factor /= 10;
		}
		long est = (long) (2 * (0.5 - shift) * res);
		if (est != (int) est) {
			return 0;
		}
		return (int) (est);
	}

	public static void main(String[] arg) {

		System.out.println(reverse(1534236469));

	}

}
