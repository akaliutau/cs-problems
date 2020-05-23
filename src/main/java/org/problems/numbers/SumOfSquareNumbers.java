package org.problems.numbers;

/**
 * https://leetcode.com/problems/sum-of-square-numbers/
 *
 * Given a non-negative integer c, your task is to decide whether there're two
 * integers a and b such that a2 + b2 = c.
 * 
 * Example 1:
 * Input: 5 Output: True 
 * Explanation: 1 * 1 + 2 * 2 = 5
 * 
 * 
 * Example 2:
 * Input: 3 Output: False
 * 
 */
public class SumOfSquareNumbers {

	public static boolean judgeSquareSum(int c) {
		if (c == 0) {
			return true;
		}
		for (int i = 0; i < c; i++) {
			int s = c-i*i;
			if (s < 0) {
				return false;
			}
			int second = (int) Math.sqrt(s);
			if (second*second + i*i == c) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] arg) {

		System.out.println(judgeSquareSum(0));
		System.out.println(judgeSquareSum(1));
		System.out.println(judgeSquareSum(2));
		System.out.println(judgeSquareSum(3));
		System.out.println(judgeSquareSum(4));
		System.out.println(judgeSquareSum(5));
		System.out.println(judgeSquareSum(6));
		System.out.println(judgeSquareSum(7));

	}
}
