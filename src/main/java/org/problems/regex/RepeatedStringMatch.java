package org.problems.regex;

/**
 * https://leetcode.com/problems/repeated-string-match/
 * 
 * Given two strings A and B, find the minimum number of times A has to be
 * repeated such that B is a substring of it. If no such solution, return -1.
 * 
 * For example, with A = "abcd" and B = "cdabcdab".
 * 
 * Return 3, because by repeating A three times (“abcdabcdabcd”), B is a
 * substring of it; and B is not a substring of A repeated two times
 * ("abcdabcd").
 * 
 * Note: The length of A and B will be between 1 and 10000.
 * 
 * 
 * 
 */
public class RepeatedStringMatch {

	public static int repeatedStringMatch(String a, String b) {
		
		int lenA = a.length();
		int lenB = b.length();
		StringBuilder sb = new StringBuilder();
		
		if (lenA >= lenB) {
			sb.append(a);
			if ( sb.toString().contains(b)) {
				return 1;
			}
			sb.append(a);
			if (sb.toString().contains(b)) {
				return 2;
			}
			return -1;
		}
		int times = lenB % lenA == 0 ? lenB / lenA : lenB / lenA + 1;
		for (int i = 0; i < times; i++) {
			sb.append(a);
		}
		if (sb.toString().contains(b)) {
			return times;
		}
		sb.append(a);
		if (sb.toString().contains(b)) {
			return times + 1;
		}
		return -1;
	}

	public static void main(String[] arg) {

		System.out.println(repeatedStringMatch("abcd","cdabcdab"));
		System.out.println(repeatedStringMatch("abc","bcabca"));
		System.out.println(repeatedStringMatch("a","aa"));

	}

}
