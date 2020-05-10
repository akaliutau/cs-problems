package com.leetcode.combinatorics;

/**
 * https://leetcode.com/problems/maximum-69-number/
 * 
 * Given a positive integer num consisting only of digits 6 and 9.
 * 
 * Return the maximum number you can get by changing at most one digit (6
 * becomes 9, and 9 becomes 6).
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: num = 9669 Output: 9969 
 * Explanation: Changing the first digit results
 * in 6669. Changing the second digit results in 9969. Changing the third digit
 * results in 9699. Changing the fourth digit results in 9666. The maximum
 * number is 9969. Example 2:
 * 
 * Input: num = 9996 Output: 9999 
 * Explanation: Changing the last digit 6 to 9
 * results in the maximum number. Example 3:
 * 
 * Input: num = 9999 Output: 9999 
 * Explanation: It is better not to apply any
 * change.
 * 
 * 
 * Constraints:
 * 
 * 1 <= num <= 10^4 num's digits are 6 or 9
 * 
 * 
 */
public class Maximum69Number {

	public static int maximum69Number(int num) {
		int n = (int) Math.log10(num) + 1;
		int[] digits = new int[n];
		int base = 1;
		int idx = n - 1;
		while (num != 0) {
			int d = num % 10;
			digits[idx--] = d;
			num -= d;
			num /= 10;
		}
		for (int i = 0; i < n; i++) {
			if (digits[i] == 6) {
				digits[i] = 9;
				break;
			}
		}
		num = 0;
		base = 1;
		for (int i = n-1; i > -1; i--) {
			num += digits[i] * base;
			base *= 10;
		}		
		
		return num;

	}

	public static void main(String[] arg) {

		System.out.println(maximum69Number(9969));
		System.out.println(maximum69Number(9999));
		System.out.println(maximum69Number(6));
		System.out.println(maximum69Number(8));//18
	}

}
