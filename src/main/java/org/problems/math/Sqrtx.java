package org.problems.math;

/**
 * https://leetcode.com/problems/sqrtx/
 *
 * Implement int sqrt(int x).
 * 
 * Compute and return the square root of x, where x is guaranteed to be a
 * non-negative integer.
 * 
 * Since the return type is an integer, the decimal digits are truncated and
 * only the integer part of the result is returned.
 * 
 * Example 1:
 * Input: 4 Output: 2 
 * 
 * Example 2:
 * Input: 8 Output: 2
 * 
 */
public class Sqrtx {

	public static int mySqrt(int num) {
		if (num == 0 || num == 1) {
			return num;
		}
		if (num < 0) {
			return -1;
		}
	    int xn = num;
	    int next = num-1;
	    while (next != xn && next < xn) {
	    	xn = next;
	    	next = (xn + num/xn) / 2;
	    }
	    return next*next > num ? next-1 : next;
	}

	public static void main(String[] arg) {

		System.out.println(mySqrt(4));
		System.out.println(mySqrt(8));

	}
}
