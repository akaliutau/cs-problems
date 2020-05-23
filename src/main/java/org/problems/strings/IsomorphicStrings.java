package org.problems.strings;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/isomorphic-strings/
 *
 * Given two strings s and t, determine if they are isomorphic.
 * 
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * 
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters. No two characters may map to the same
 * character but a character may map to itself.
 * 
 * Example 1:
 * Input: s = "egg", t = "add" Output: true 
 * 
 * Example 2:
 * Input: s = "foo", t = "bar" Output: false
 * 
 */
public class IsomorphicStrings {

	public static boolean isIsomorphic(String s, String t) {
		int[] mapping = new int[256];
		boolean[] mapped = new boolean[256];
		Arrays.fill(mapping, -1);
		
		if (s.length() != t.length()) {
			return false;
		}
		
		for (int i = 0; i < s.length(); i++) {
			int from = s.charAt(i);
			int to = t.charAt(i);
			
			if (mapping[from] == -1) {
				if (!mapped[to]) {
					mapping[from] = to;
					mapped[to] = true;
				}else {
					return false;
				}
			}else {
				if (mapping[from] != to) {
					return false;
				}
			}
        }
		return true;
	}

	public static void main(String[] arg) {

		System.out.println(isIsomorphic("egg", "add"));
		System.out.println(isIsomorphic("foo", "bar"));
		System.out.println(isIsomorphic("ab", "aa"));

	}
}
