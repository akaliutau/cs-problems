package com.leetcode.strings;

/**
 * https://leetcode.com/problems/is-subsequence/
 * 
 * Given a string s and a string t, check if s is subsequence of t.
 * 
 * You may assume that there is only lower case English letters in both s and t.
 * t is potentially a very long (length ~= 500,000) string, and s is a short
 * string (<=100).
 * 
 * A subsequence of a string is a new string which is formed from the original
 * string by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (ie, "ace" is a
 * subsequence of "abcde" while "aec" is not).
 * 
 * Example 1: s = "abc", t = "ahbgdc"
 * Return true.
 * 
 * Example 2: s = "axc", t = "ahbgdc"
 * Return false
 * 
 * Runtime: 5 ms, faster than 81.14% of Java online submissions for Is Subsequence.
 * Memory Usage: 42.6 MB, less than 100.00% of Java online submissions for Is Subsequence
 * 
 */
public class IsSubsequence {

	public static boolean isSubsequence(String s, String t) {
		int pos = 0;
		int subPos = 0;
		int fromPos = 0;
		while (subPos < s.length() && pos < t.length()) {// check both pointers
			char c = s.charAt(subPos);
			boolean charFound = false;
			while (pos < t.length()) {
				if (t.charAt(pos) == c) {
					charFound = true;
					if (subPos == 0) {
						fromPos = pos;
					}
					break;
				}
				pos++;
			}
			if (!charFound) {// reset substr
				if (subPos == 0) {
					return false;
				}
				pos = fromPos + 1;
				subPos = 0;
			}else { // go to next char
				pos++;
				subPos ++;
			}
		}
		return subPos == s.length();
	}

	public static void main(String[] arg) {

		System.out.println(isSubsequence("abc","ahbgdc"));
		System.out.println(isSubsequence("axc","ahbgdc"));
		System.out.println(isSubsequence("axc",""));
		System.out.println(isSubsequence("","ahbgdc"));
		System.out.println(isSubsequence("",""));
		System.out.println(isSubsequence("aha","ahbahcaha"));
		System.out.println(isSubsequence("caa","ahbahcaha"));

	}
}
