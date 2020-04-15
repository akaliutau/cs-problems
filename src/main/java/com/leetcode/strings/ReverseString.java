package com.leetcode.strings;

import com.leetcode.utils.Utils;

/**
 * https://leetcode.com/problems/reverse-string/
 * 
 * Write a function that reverses a string. The input string is given as an
 * array of characters char[].
 * 
 * Do not allocate extra space for another array, you must do this by modifying
 * the input array in-place with O(1) extra memory.
 * 
 * You may assume all the characters consist of printable ascii characters.
 * 
 * Example 1:
 * 
 * Input: ["h","e","l","l","o"] Output: ["o","l","l","e","h"] 
 * 
 * Example 2:
 * 
 * Input: ["H","a","n","n","a","h"] Output: ["h","a","n","n","a","H"]
 */
public class ReverseString {

	public static void reverseString(char[] s) {
		int n = s.length;
		int i = 0;
		while (i < n/2) {
			char t = s[i];
			s[i] = s[n-i-1];
			s[n-i-1] = t;
			i++;
		}
	}

	public static void main(String[] arg) {

		char[] s = {'h','e','l','l','o'};
		reverseString(s);
		Utils.print(s, 0);

		char[] s1 = {'h'};
		reverseString(s1);
		Utils.print(s1, 0);

		char[] s2 = {};
		reverseString(s2);
		Utils.print(s2, 0);

	}
}
