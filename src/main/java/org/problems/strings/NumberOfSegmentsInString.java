package org.problems.strings;

/**
 * https://leetcode.com/problems/number-of-segments-in-a-string/
 * 
 * Count the number of segments in a string, where a segment is defined to be a
 * contiguous sequence of non-space characters.
 * 
 * Please note that the string does not contain any non-printable characters.
 * 
 * Example:
 * 
 * Input: "Hello, my name is John" Output: 5
 * 
 * 
 */
public class NumberOfSegmentsInString {

	public static int countSegments(String s) {
		int counter = 0;
		if (s == null || s.length() == 0) {
			return 0;
		}
		char prev = ' ';
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c != ' ') {
				if (prev == ' ') {
					counter ++;
				}
			}
			prev = c;
		}
		return counter;
        
    }

	public static void main(String[] arg) {

		System.out.println(countSegments("Hello, my name is John"));

		System.out.println(countSegments("Hello  John"));

		System.out.println(countSegments("Hello"));
		System.out.println(countSegments("Hello "));
		System.out.println(countSegments("  Hello"));

		System.out.println(countSegments(" "));
		System.out.println(countSegments(""));

	}

}
