package com.leetcode.numbers;

/**
 * https://leetcode.com/problems/integer-to-roman/
 * 
 * Runtime: 4 ms, faster than 89.32% of Java online submissions for Integer to
 * Roman. Memory Usage: 41.1 MB, less than 11.25% of Java online submissions for
 * Integer to Roman.
 */
public class Integer2Roman {

	public String intToRoman(int num) {
		StringBuilder sb = new StringBuilder();
		String[] romans = new String[] { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M" };
		int[] integers = new int[] { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000 };
		for (int i = integers.length - 1; i >= 0; i--) {
			int times = num / integers[i];
			num %= integers[i];
			while (times-- > 0) {
				sb.append(romans[i]);
			}
		}
		return sb.toString();
	}

	public static void main(String[] arg) {

		System.out.println(true);

	}
}
