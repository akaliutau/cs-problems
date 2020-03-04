package com.leetcode.strings;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 * 
 * Runtime: 1 ms, faster than 91.80% of Java online submissions for Keys and
 * Rooms. Memory Usage: 43.3 MB, less than 58.62% of Java online submissions for
 * Keys and Rooms.
 */
public class LongestPalindromicSubstr {

	public static String longestPalindrome(String s) {
		int n = s.length(); // get length of input string

		if (n == 0) {
			return "";
		}
		boolean table[][] = new boolean[n][n];

		int maxLength = 1;
		for (int i = 0; i < n; ++i) {
			table[i][i] = true;
		}

		// check for sub-string of length 2.
		int start = 0;
		for (int i = 0; i < n - 1; ++i) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				table[i][i + 1] = true;
				start = i;
				maxLength = 2;
			}
		}

		for (int k = 3; k <= n; ++k) {
			for (int i = 0; i < n - k + 1; ++i) {
				int j = i + k - 1;
				if (table[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
					table[i][j] = true;
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
		// 0 1 2 3

		System.out.print("Longest palindrome substring is  " + longestPalindrome("babad"));
		System.out.println(true);

	}
}
