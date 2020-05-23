package org.problems.numbers;

import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/plus-one/
 *
 * Given a non-empty array of digits representing a non-negative integer, plus
 * one to the integer.
 * 
 * The digits are stored such that the most significant digit is at the head of
 * the list, and each element in the array contain a single digit.
 * 
 * You may assume the integer does not contain any leading zero, except the
 * number 0 itself.
 * 
 * Example 1:
 * 
 * Input: [1,2,3] Output: [1,2,4] Explanation: The array represents the integer
 * 123. Example 2:
 * 
 * Input: [4,3,2,1] Output: [4,3,2,2] Explanation: The array represents the
 * integer 4321.
 * 
 */
public class PlusOne {

	public static int[] plusOne(int[] digits) {
		int excess = 0;
		int n = digits.length - 1;
		

		if (digits[n] < 9 && excess == 0) {
			digits[n] = digits[n] + 1;
			return digits;
		} else if (digits[n] == 9) {
			digits[n] = excess;
			excess = 1;
		}
		for (int i = n - 1; i > -1; i--) {
			digits[i] = digits[i] + excess;
			excess = 0;
			if (digits[i] == 10) {
				excess = 1;
				digits[i] = 0;
			}
			if (excess == 0) {
				return digits;
			}
		}
		if (excess == 0) {
			return digits;
		}
		System.out.println("special");
		int[] arr = new int[n+2];
		arr[0] = 1;
		for (int i = 0; i < n; i ++) {
			arr[i+1] = digits[i];
		}
		return arr;
	}

	public static void main(String[] arg) {

		int[] arr = { 1, 2, 3 };
		Utils.print(plusOne(arr));

		int[] arr1 = { 4, 2, 3, 1 };
		Utils.print(plusOne(arr1));

		int[] arr2 = { 1, 2, 9 };
		Utils.print(plusOne(arr2));

		int[] arr3 = { 1, 9, 9 };
		Utils.print(plusOne(arr3));

		int[] arr4 = { 0};
		Utils.print(plusOne(arr4));

		int[] arr5 = {1, 0};
		Utils.print(plusOne(arr5));

		int[] arr6 = { 9};
		Utils.print(plusOne(arr6));

		int[] arr7 = { 9, 9};
		Utils.print(plusOne(arr7));
	}

}
