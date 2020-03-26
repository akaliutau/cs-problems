package com.leetcode.numbers;

/**
 *	https://leetcode.com/problems/factorial-trailing-zeroes/
 *
 * Given an integer n, return the number of trailing zeroes in n!.

Example 1:

Input: 3
Output: 0
Explanation: 3! = 6, no trailing zero.
Example 2:

Input: 5
Output: 1
Explanation: 5! = 120, one trailing zero.
Note: Your solution should be in logarithmic time complexity.


 * 
 */
public class FactorialTrailingZeroes {
	
	public static int trailingZeroes(int n) {
		int zeros = n/5;
		int totalZeros = zeros;
		while (zeros >= 5) {
			zeros = zeros/5;
			totalZeros += zeros;
		}
		return totalZeros;
        
    }
	
	
	public static void main(String[] arg) {

		System.out.println(trailingZeroes(1));//0
		System.out.println(trailingZeroes(3));//0
		System.out.println(trailingZeroes(5));//1
		System.out.println(trailingZeroes(23));//4
		System.out.println(trailingZeroes(123));//28
		System.out.println(trailingZeroes(1123));//277

		System.out.println(trailingZeroes(625));//156

	}
}
