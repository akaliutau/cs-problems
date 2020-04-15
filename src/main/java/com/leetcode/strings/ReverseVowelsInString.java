package com.leetcode.strings;

import java.util.Stack;

/**
 * https://leetcode.com/problems/reverse-vowels-of-a-string/
 *
 * Write a function that takes a string as input and reverse only the vowels of
 * a string.
 * 
 * Example 1:
 * 
 * Input: "hello" Output: "holle" Example 2:
 * 
 * Input: "leetcode" Output: "leotcede" 
 */
public class ReverseVowelsInString {

	public static String reverseVowels(String s) {
		boolean[] vowels = new boolean[256];
		vowels['a'] = true;
		vowels['e'] = true;
		vowels['i'] = true;
		vowels['o'] = true;
		vowels['u'] = true;
		vowels['A'] = true;
		vowels['E'] = true;
		vowels['I'] = true;
		vowels['O'] = true;
		vowels['U'] = true;

		int n = s.length();
		char[] str = new char[n];
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			str[i] = c;
			if (vowels[c]) {
				stack.add(c);
			}
		}
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			if (vowels[c]) {
				str[i] = stack.pop();
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(str[i]);
		}
		return sb.toString();

	}

	public static void main(String[] arg) {

		System.out.println(reverseVowels("hello"));
		System.out.println(reverseVowels("leetcode"));

	}
}
