package com.leetcode.strings;

/**
 * https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/
 */
public class MinAnagram {

	public static final int n = 12;

	public static int minSteps(String s, String t) {

		int count = 0;
		int chars[] = new int[32768];

		for (int i = 0; i < s.length(); i++) {
			chars[s.charAt(i) - 'a']++;
		}

		for (int i = 0; i < t.length(); i++) {
			if (chars[t.charAt(i) - 'a']-- <= 0) {
				count++;
			}
		}

		return count;
	}

	public static void main(String[] arg) {

		int res = minSteps("bab", "aba");

		System.out.println(res);

	}

}
