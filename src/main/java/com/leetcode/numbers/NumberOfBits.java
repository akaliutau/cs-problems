package com.leetcode.numbers;

/**
 * https://leetcode.com/problems/number-of-1-bits/
 *
 * Write a function that takes an unsigned integer and return the number of '1'
 * bits it has (also known as the Hamming weight).
 * 
 * Example 1:
 * 
 * Input: 00000000000000000000000000001011 Output: 3 
 * 
 * Explanation: The input
 * binary string 00000000000000000000000000001011 has a total of three '1' bits.
 * 
 */
public class NumberOfBits {

	// you need to treat n as an unsigned value
	public static int hammingWeight(int n) {
		long l = n;
		int counter = 0;
		for (int i = 0; i < 32; i++) {
			if ((l & 1) == 1) {
				counter ++;
			}
			l = l >> 1;
		}
		return counter;

	}

	public static void main(String[] arg) {

		System.out.println(hammingWeight(1));
		System.out.println(hammingWeight(0));
		System.out.println(hammingWeight(19));
		System.out.println(hammingWeight(-3));

	}
}
