package org.problems.combinatorics;

/**
 * https://leetcode.com/problems/number-of-good-ways-to-split-a-string/
 * 
 * You are given a string s, a split is called good if you can split s into 2
 * non-empty strings p and q where its concatenation is equal to s and the
 * number of distinct letters in p and q are the same.
 * 
 * Return the number of good splits you can make in s.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "aacaba" Output: 2 
 * 
 * Explanation: There are 5 ways to split "aacaba"
 * and 2 of them are good. ("a", "acaba") Left string and right string contains
 * 1 and 3 different letters respectively. ("aa", "caba") Left string and right
 * string contains 1 and 3 different letters respectively. ("aac", "aba") Left
 * string and right string contains 2 and 2 different letters respectively (good
 * split). ("aaca", "ba") Left string and right string contains 2 and 2
 * different letters respectively (good split). ("aacab", "a") Left string and
 * right string contains 3 and 1 different letters respectively.
 * 
 * 
 * 
 */
public class NumberOfGoodWaysToSplit {

	public int numSplits(String s) {
		int n = s.length();
		int[] left = new int[26];
		int[] right = new int[26];
		for (int i = 0; i < n; i++) {
			right[s.charAt(i) - 'a']++;
		}
		int counter = 0;
		for (int i = 0; i < n; i++) {
			left[s.charAt(i) - 'a']++;
			right[s.charAt(i) - 'a']--;
			int diff1 = 0;
			int diff2 = 0;
			for (int j = 0; j < 26; j++) {
				if (left[j] > 0) {
					diff1++;
				}
				if (right[j] > 0) {
					diff2++;
				}
			}
			if (diff1 == diff2) {
				counter++;
			}
		}
		return counter;

	}

	public static void main(String[] arg) {
		System.out.println(true);
	}

}
