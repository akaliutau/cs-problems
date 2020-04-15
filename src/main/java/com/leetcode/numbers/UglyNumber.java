package com.leetcode.numbers;

/**
 * https://leetcode.com/problems/ugly-number/
 * 
 * Write a program to check whether a given number is an ugly number.
 * 
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * 
 * Example 1:
 * 
 * Input: 6 Output: true Explanation: 6 = 2 × 3
 * 
 * 
 */
public class UglyNumber {

	public boolean isUgly(int num) {
		if (num == 1) {
			return true;
		}
		if (num <= 0) {
			return false;
		}
		while (num % 2 == 0) {
			num = num / 2;
		}
		while (num % 3 == 0) {
			num = num / 3;
		}
		while (num % 5 == 0) {
			num = num / 5;
		}
		return num == 1;
	}

	public static void main(String[] arg) {

		System.out.println(true);

	}

}
