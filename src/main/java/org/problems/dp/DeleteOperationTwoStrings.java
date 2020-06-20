package org.problems.dp;

/**
 * https://leetcode.com/problems/delete-operation-for-two-strings/
 * 
 * Given two words word1 and word2, find the minimum number of steps required to
 * make word1 and word2 the same, where in each step you can delete one
 * character in either string.
 * 
 * Example 1: Input: "sea", "eat" Output: 2 Explanation: You need one step to
 * make "sea" to "ea" and another step to make "eat" to "ea". Note: The length
 * of given words won't exceed 500. Characters in given words can only be
 * lower-case letters.
 * 
 * 
 * 
 */
public class DeleteOperationTwoStrings {

	public static int minDistance(String word1, String word2) {

		int len1 = word1.length();
		int len2 = word2.length();
		if (len1 == 0 || len2 == 0) {
			return Math.max(len1, len2);
		}

		int[][] dp = new int[len2 + 1][len1 + 1];

		for (int i = 0; i < len1; i++) {
			dp[0][i] = 0;
		}
		for (int i = 0; i < len2; i++) {
			dp[i][0] = 0;
		}
		for (int i = 1; i < len2 + 1; i++) {
			char c2 = word2.charAt(i - 1);
			for (int j = 1; j < len1 + 1; j++) {
				char c1 = word1.charAt(j - 1);
				if (c1 == c2) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		return len1 + len2 - 2 * dp[len2][len1];

	}

	public static void main(String[] arg) {

		System.out.println(minDistance("sea", "eat"));// 2
		System.out.println(minDistance("sea", ""));
		System.out.println(minDistance("", ""));
		System.out.println(minDistance("sea", "ate"));// 4

	}

}
