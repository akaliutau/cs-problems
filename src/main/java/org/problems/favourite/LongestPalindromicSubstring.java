package org.problems.favourite;

/**
 * Longest Palindromic Substring
 * 
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000
 * 
 */
public class LongestPalindromicSubstring {

	public String longestPalindrome(String s) {
		int n = s.length();

		if (n == 0) {
			return "";
		}
		boolean[][] dp = new boolean[n][n];
		char[] str = new char[n];
		for (int i = 0; i < n; i++) {
			str[i] = s.charAt(i);
		}

		int maxLength = 1;
		for (int i = 0; i < n; i++)
			dp[i][i] = true;

		// sub-string of length 2.
		int start = 0;
		for (int i = 0; i < n - 1; i++) {
			if (str[i] == str[i + 1]) {
				dp[i][i + 1] = true;
				start = i;
				maxLength = 2;
			}
		}

		for (int k = 3; k <= n; k++) {
			for (int i = 0; i < n - k + 1; i++) {
				boolean[] nextCol = dp[i + 1];
				boolean[] curCol = dp[i];
				int j = i + k - 1;
				if (nextCol[j - 1] && str[i] == str[j]) {
					curCol[j] = true;
					if (k > maxLength) {
						start = i;
						maxLength = k;
					}
				}
			}
		}
		return s.substring(start, start + maxLength);

	}

	public static void main(String[] arg) {

		System.out.println("D");

	}

}
