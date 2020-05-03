package com.leetcode.numbers;

/**
 * https://leetcode.com/problems/max-difference-you-can-get-from-changing-an-integer/
 * 
 * You are given an integer num. You will apply the following steps exactly two
 * times:
 * 
 * Pick a digit x (0 <= x <= 9). Pick another digit y (0 <= y <= 9). The digit y
 * can be equal to x. Replace all the occurrences of x in the decimal
 * representation of num by y. The new integer cannot have any leading zeros,
 * also the new integer cannot be 0. Let a and b be the results of applying the
 * operations to num the first and second times, respectively.
 * 
 * Return the max difference between a and b.
 * 
 * Example 1:
 * 
 * Input: num = 555 Output: 888 
 * Explanation: The first time pick x = 5 and y = 9
 * and store the new integer in a. The second time pick x = 5 and y = 1 and
 * store the new integer in b. We have now a = 999 and b = 111 and max
 * difference = 888
 * 
 * 
 */
public class MaxDifferenceAfterChange {

	static int[] getDigits(int num) {
		int n = (int) Math.log10(num) + 1;
		int[] res = new int[n];
		int idx = n - 1;
		while (num > 0) {
			int d = num % 10;
			res[idx--] = d;
			num -= d;
			num /= 10;
		}
		return res;
	}

	static int getNum(int[] num) {
		int n = num.length;
		int idx = n - 1;
		int res = 0;
		int base = 1;
		while (idx > -1) {
			res += num[idx--] * base;
			base *= 10;
		}
		return res;
	}

	static int[] replace(int[] num, int from, int to) {
		int n = num.length;
		int[] res = new int[n];
		for (int i = 0; i < n; i++) {
			if (num[i] == from) {
				res[i] = to;
			} else {
				res[i] = num[i];
			}
		}
		return res;

	}

	public static int maxDiff(int num) {
		int diff = 0;
		int[] orig = getDigits(num);
		int idx = 0;
		while (idx < orig.length) {
			if (orig[idx] != 9) {
				break;
			}
			idx++;
		}
		int a = getNum(replace(orig, orig[0], 9));
		if (idx < orig.length) {
			a = getNum(replace(orig, orig[idx], 9));
		}
		int b = getNum(replace(orig, orig[0], 1));
		diff = a - b;
		if (orig.length > 1) {
			idx = 1;
			while (idx < orig.length) {
				if (orig[idx] != 0 && orig[idx] != orig[0]) {
					break;
				}
				idx++;
			}
			if (idx < orig.length) {
				int c = getNum(replace(orig, orig[idx], 0));
				if (a - c > diff) {
					return a - c;
				}
			}

		}

		return diff;
	}

	public static void main(String[] arg) {

		System.out.println(maxDiff(555));
		System.out.println(maxDiff(9));
		System.out.println(maxDiff(123456));
		System.out.println(maxDiff(10000));
		System.out.println(maxDiff(9288));

	}

}
