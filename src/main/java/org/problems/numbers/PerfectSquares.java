package org.problems.numbers;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/perfect-squares/
 *
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 * 
 * Example 1: Input: n = 12 Output: 3
 * 
 * Explanation: 12 = 4 + 4 + 4.
 * 
 * 
 * Example 2: Input: n = 13 Output: 2
 * 
 * Explanation: 13 = 4 + 9
 * 
 * 
 */
public class PerfectSquares {

	public static int numSquares(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		int dp[] = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 1; i <= n; i++) {
			int nsquares = (int) Math.sqrt(i);
			for (int j = 1; j <= nsquares; j++) {
				dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
			}
		}
		return dp[n];
	}

	public static void main(String[] arg) {

		System.out.println(numSquares(13));

	}
}
