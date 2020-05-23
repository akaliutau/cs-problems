package org.problems.strings;

/**
 * https://leetcode.com/problems/generate-a-string-with-characters-that-have-odd-counts/
 * 
 * Given an integer n, return a string with n characters such that each
 * character in such string occurs an odd number of times.
 * 
 * The returned string must contain only lowercase English letters. If there are
 * multiples valid strings, return any of them.
 * 
 */
public class StringGenerator {

	public static String generateTheString(int n) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < n - 1; i++) {
			sb.append('a');
		}
		if (n % 2 == 0) {
			sb.append('z');
		} else {
			sb.append('a');
		}
		return sb.toString();

	}

	public static void main(String[] arg) {

		System.out.println(generateTheString(4));
		System.out.println(generateTheString(3));
		System.out.println(generateTheString(1));

	}

}
