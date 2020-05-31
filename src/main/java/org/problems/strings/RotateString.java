package org.problems.strings;

/**
 * https://leetcode.com/problems/rotate-string/
 * 
 * We are given two strings, A and B.
 * 
 * A shift on A consists of taking string A and moving the leftmost character to
 * the rightmost position. For example, if A = 'abcde', then it will be 'bcdea'
 * after one shift on A. Return True if and only if A can become B after some
 * number of shifts on A.
 * 
 * Example 1: Input: A = 'abcde', B = 'cdeab' Output: true
 * 
 * Example 2: Input: A = 'abcde', B = 'abced' Output: false Note:
 * 
 * A and B will have length at most 100
 * 
 * 
 */
public class RotateString {
	
	static boolean compare(String a, String b, int posB) {
		int n = a.length();
		for (int i = 0; i < n; i++) {
			if (a.charAt(i) != b.charAt((i + posB) % n)) {
				return false;
			}
		}
		return true;
	}

	public static boolean rotateString(String a, String b) {
		if (a.length() != b.length()) {
			return false;
		}
		if (a.length() == 0) {
			return true;
		}
		int posA = 0;
		int posB = 0;
		char c1 = a.charAt(posA);
		int next = b.indexOf(c1, posB);
		while (next > -1) {
			if (compare(a, b, next)) {
				return true;
			}
			next = b.indexOf(c1, next+1);
		}
		return false;

	}

	public static void main(String[] arg) {

		System.out.println(rotateString("abcde","cdeab"));
		System.out.println(rotateString("abcde","abced"));

	}

}
