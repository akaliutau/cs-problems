package com.leetcode.strings;

/**
 * https://leetcode.com/problems/implement-strstr/
 * 
 * Implement strStr().
 * 
 * Return the index of the first occurrence of needle in haystack, or -1 if
 * needle is not part of haystack.
 * 
 * Example 1:
 * 
 * Input: haystack = "hello", needle = "ll" Output: 2 Example 2:
 * 
 * Input: haystack = "aaaaa", needle = "bba" Output: -1
 * 
 * 
 */
public class ImplementStrstr {

	public static int strStr(String haystack, String needle) {
		int[] stack = new int[haystack.length()];
		for (int i = 0; i < haystack.length(); i++) {
			stack[i] = haystack.charAt(i);
		}

		int[] ndl = new int[needle.length()];
		for (int i = 0; i < needle.length(); i++) {
			ndl[i] = needle.charAt(i);
		}
		if (needle.length() == 0) {
			return 0;
		}

		int pos = 0;
		while (pos <= haystack.length() - needle.length()) {
			boolean found = true;
			for (int i = 0; i < needle.length(); i++) {
				if (stack[pos + i] != ndl[i]) {
					found = false;
					break;
				}
			}
			if (found) {
				return pos;
			}
			pos++;
		}

		return -1;
	}

	public static void main(String[] arg) {

		System.out.println(strStr("hello", "ll"));
		System.out.println(strStr("aaaaa", "a"));
		System.out.println(strStr("abaa", "b"));
		System.out.println(strStr("aaaaa", "bba"));
		System.out.println(strStr("aaaaa", ""));
		System.out.println(strStr("a", "a"));

	}
}
