package com.leetcode.numbers;

import com.leetcode.utils.Utils;

/**
 * https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/
 * 
 * Given an integer n, return any array containing n unique integers such that
 * they add up to 0.
 * 
 * Example 1:
 * 
 * Input: n = 5 Output: [-7,-1,1,3,4] 
 * 
 * Explanation: These arrays also are
 * accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
 * 
 * 
 * 
 */
public class NUniqueIntegersSumUp {

	public static int[] sumZero(int N) {
		if (N == 1) {
			int[] allNumbers = new int[1];
			allNumbers[0] = 0;
			return allNumbers;
		}
		int sum = 0;
		int[] allNumbers = new int[N];
		for (int i = 1; i < N; i++) {
			sum = sum + i;
			allNumbers[i - 1] = i;
		}
		allNumbers[N - 1] = 0 - sum;
		return allNumbers;
	}

	public static void main(String[] arg) {
		
		Utils.print(sumZero(3));

	}
}
