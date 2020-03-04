package com.leetcode.strings;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 * 
 * Write a function to find the longest common prefix string amongst an array of
 * strings.
 * 
 * If there is no common prefix, return an empty string "".
 * 
 * Example 1:
 * 
 * Input: ["flower","flow","flight"] Output: "fl"
 * 
 * Runtime: 1 ms, faster than 65.63% of Java online submissions for Longest
 * Common Prefix. Memory Usage: 37.7 MB, less than 81.87% of Java online
 * submissions for Longest Common Prefix.
 * 
 */
public class LongestCommonPrefix {

	public static String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) {
			return "";
		}
		String str = strs[0];
		int n = str.length();
		if (n == 0) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		int pos = 0;

		while (pos < n) {
			boolean found = true;
			for (int i = 1; i < strs.length; i++) {
				if (strs[i].length() > 0 && strs[i].length() > pos) {
					if (str.charAt(pos) != strs[i].charAt(pos)) {
						found = false;
						break;
					}
				} else {
					found = false;
					break;
				}
			}
			if (found) {
				sb.append(str.charAt(pos));
			} else {
				break;
			}
			pos++;
		}
		return sb.toString();
	}

	public static void main(String[] arg) {

		String[] strs = new String[] { "flower", "flow", "flight" };
		System.out.println(longestCommonPrefix(strs));

		String[] strs1 = new String[] { "flower" };
		System.out.println(longestCommonPrefix(strs1));

		String[] strs2 = new String[] {};
		System.out.println(longestCommonPrefix(strs2));

		String[] strs3 = new String[] { "aca", "cba" };
		System.out.println(longestCommonPrefix(strs3));

	}
}
