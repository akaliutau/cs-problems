package com.leetcode.math;

/**
 * https://leetcode.com/problems/valid-perfect-square/
 *
 * Given a positive integer num, write a function which returns True if num is a
 * perfect square else False.
 * 
 * Note: Do not use any built-in library function such as sqrt.
 * 
 * Example 1:
 * 
 * Input: 16 Output: true Example 2:
 * 
 * Input: 14 Output: false
 * 
 */
public class ValidPerfectSquare {

	public static boolean isPerfectSquare(int num) {
		if (num == 0 || num == 1) {
			return true;
		}
		if (num < 0) {
			return false;
		}
		int xn = num;
		int next = num - 1;
		while (next != xn && next < xn) {
			xn = next;
			next = (xn + num / xn) / 2;
		}
		return next * next == num;
	}

	public static void main(String[] arg) {

		System.out.println(isPerfectSquare(0));
		System.out.println(isPerfectSquare(1));
		System.out.println(isPerfectSquare(2));
		System.out.println(isPerfectSquare(65534));
		System.out.println(isPerfectSquare(65536));
		System.out.println(isPerfectSquare(65537));
		System.out.println(isPerfectSquare(195));

	}
}
