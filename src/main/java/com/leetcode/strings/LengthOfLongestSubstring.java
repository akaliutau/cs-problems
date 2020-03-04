package com.leetcode.strings;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 * Given a string, find the length of the longest substring without repeating
 * characters.
 * 
 * Runtime: 16 ms, faster than 24.99% of Java online submissions for Longest
 * Substring Without Repeating Characters. Memory Usage: 41.1 MB, less than
 * 5.20% of Java online submissions for Longest Substring Without Repeating
 */
public class LengthOfLongestSubstring {

	public static int lengthOfLongestSubstring(String s) {
		int n = s.length();
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		int[] set = new int[256];
		Arrays.fill(set, -1);
		int i = 0;
		int len = 0;
		int lastMaxLen = -1;
		int[] chars = new int[n];
		for (int j = 0; j < n; j++) {
			chars[j] = (int) s.charAt(j);
		}
		while (i < n) {
			int c = chars[i];
			if (set[c] != -1) {// dup, reset the search to i+1, save the results
				if (len > lastMaxLen) {
					lastMaxLen = len;
				}
				len = 0;
				i = set[c] + 1;
				Arrays.fill(set, -1);
			} else {
				len++;
				set[c] = i;
				i++;
			}
		}
		if (len > lastMaxLen) {
			lastMaxLen = len;
		}

		return lastMaxLen == -1 ? len : lastMaxLen;
	}

	public static void main(String[] arg) {

		System.out.println(lengthOfLongestSubstring("abcabcbb"));
		System.out.println(lengthOfLongestSubstring("pwwkew"));
		System.out.println(lengthOfLongestSubstring("au"));
		System.out.println(lengthOfLongestSubstring("aab"));
		System.out.println(lengthOfLongestSubstring("dvdf"));

	}
}
