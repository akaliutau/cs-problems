package org.problems.minmax;

/**
 * https://leetcode.com/problems/maximum-swap/
 * 
 * Given a non-negative integer, you could swap two digits at most once to get
 * the maximum valued number. Return the maximum valued number you could get.
 * 
 * Example 1: Input: 2736 Output: 7236 Explanation: Swap the number 2 and the
 * number 7.
 * 
 * Example 2: Input: 9973 Output: 9973 Explanation: No swap. Note: The given
 * number is in the range [0, 10^8]
 * 
 */
public class MaximumSwap {

	static void find(int[] digits, int len) {
		for (int i = len - 1; i > -1; i--) {
			int d = digits[i];
			int max = d;
			int pos = i;
			for (int j = i - 1; j > -1; j--) {
				if (max <= digits[j]) {
					max = digits[j];
					pos = j;
				}
			}
			if (max > d) {
				int t = digits[pos];
				digits[pos] = digits[i];
				digits[i] = t;
				return;
			}
		}

	}

	public static int maximumSwap(int num) {
		if (num <= 10) {
			return num;
		}
		int len = (int) Math.log10(num) + 1;
		int[] digits = new int[len];
		int idx = 0;
		while (num > 0) {
			int d = num % 10;
			digits[idx++] = d;
			num -= d;
			num /= 10;
		}
		find(digits, len);
		idx = 0;
		int base = 1;
		num = 0;
		while (idx < len) {
			num += base * digits[idx++];
			base *= 10;
		}
		return num;

	}

	public static void main(String[] arg) {

		System.out.println(maximumSwap(1993));
		System.out.println(maximumSwap(2736));
		System.out.println(maximumSwap(2739));
		System.out.println(maximumSwap(9973));
		System.out.println(maximumSwap(1));
		System.out.println(maximumSwap(99));

	}

}
