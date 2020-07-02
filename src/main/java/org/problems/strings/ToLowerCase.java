package org.problems.strings;

/**
 * https://leetcode.com/problems/to-lower-case/ 
 * 
 * Implement function ToLowerCase()
 * that has a string parameter str, and returns the same string in lowercase.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: "Hello" Output: "hello" 
 * 
 * Example 2:
 * 
 * Input: "here" Output: "here" 
 * 
 * Example 3:
 * 
 * Input: "LOVELY" Output: "lovely"
 * 
 * 
 * 
 */
public class ToLowerCase {

	public static String toLowerCase(String str) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c >= 'A' && c <= 'Z') {
				int code = c - 'A';
				c = (char)(code + 'a');
			}
			sb.append(c);
		}
		return sb.toString();

	}

	public static void main(String[] arg) {

		System.out.println(toLowerCase("Hello"));

	}

}
