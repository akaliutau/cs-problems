package com.leetcode.numbers;

/**
 * https://leetcode.com/problems/add-digits/
 *
 * Given a non-negative integer num, repeatedly add all its digits until the
 * result has only one digit.
 * 
 * Example:
 * 
 * Input: 38 Output: 2
 * 
 * Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one
 * digit, return it. Do it without any loop/recursion in O(1) runtime
 * 
 * 
 */
public class AddDigits {

	public static int addDigits(int num) {
		if (num == 0) {
			return 0;
		}
		return (num % 9 == 0) ? 9 : num % 9;

	}

	public static void main(String[] arg) {

		System.out.println(addDigits(38));

	}
}
