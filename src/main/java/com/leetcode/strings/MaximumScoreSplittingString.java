package com.leetcode.strings;

/**
 * https://leetcode.com/problems/maximum-score-after-splitting-a-string/
 * 
 * Given a string s of zeros and ones, return the maximum score after splitting
 * the string into two non-empty substrings (i.e. left substring and right
 * substring).
 * 
 * The score after splitting a string is the number of zeros in the left
 * substring plus the number of ones in the right substring.
 * 
 * 
 */
public class MaximumScoreSplittingString {

	public static int maxScore(String s) {
		int n = s.length();
		int[] zeros = new int[n];
		int[] ones = new int[n];

		zeros[0] = (s.charAt(0) == '0' ? 1 : 0);
		for (int i = 1; i < n; i++) {
			zeros[i] = zeros[i - 1] + (s.charAt(i) == '0' ? 1 : 0);
		}
		ones[n - 1] = (s.charAt(n - 1) == '1' ? 1 : 0);
		for (int i = n - 2; i > -1; i--) {
			ones[i] = ones[i + 1] + (s.charAt(i) == '1' ? 1 : 0);
		}
		int score = 0;
		for (int i = 0; i < n - 1; i++) {
			if (zeros[i] + ones[i + 1] > score) {
				score = zeros[i] + ones[i + 1];
			}
		}
		return score;

	}

	public static void main(String[] arg) {

		System.out.println(maxScore("011101"));
		System.out.println(maxScore("00111"));
		System.out.println(maxScore("1111"));
		System.out.println(maxScore("10"));

	}

}
