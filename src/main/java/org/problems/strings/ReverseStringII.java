package org.problems.strings;

/**
 * https://leetcode.com/problems/reverse-string-ii/
 *
 * Given a string and an integer k, you need to reverse the first k characters
 * for every 2k characters counting from the start of the string. If there are
 * less than k characters left, reverse all of them. If there are less than 2k
 * but greater than or equal to k characters, then reverse the first k
 * characters and left the other as original. 
 * 
 * Example: 
 * Input: s = "abcdefg", k = 2 
 * Output: "bacdfeg" 
 * 
 * Restrictions: The string consists of lower English letters only. 
 * Length of the given string and k will in the range [1, 10000]
 */
public class ReverseStringII {

	public static void reverseString(char[] s, int from, int to) {
		int n = to - from;
		int i = 0;
		while (i < n / 2) {
			char t = s[from + i];
			s[from + i] = s[from + n - i - 1];
			s[from + n - i - 1] = t;
			i++;
		}
	}

	public static String reverseStr(String s, int k) {
		int n = s.length();
		char[] str = new char[n];
		for (int i = 0; i < n; i++) {
			str[i] = s.charAt(i);
		}
		for (int left = 0; left < n; left += 2*k) {
			int right = left + k > n ? n : left + k;
			reverseString(str, left, right);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(str[i]);
		}
		return sb.toString();
	}

	public static void main(String[] arg) {

		System.out.println(reverseStr("hello", 2));
		System.out.println(reverseStr("he", 2));
		System.out.println(reverseStr("abcdefg", 2));
		System.out.println(reverseStr("", 2));

	}
}
