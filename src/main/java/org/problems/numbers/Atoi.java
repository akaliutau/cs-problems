package org.problems.numbers;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 * 
 * 
 * 
 * Runtime: 3 ms, faster than 33.85% of Java online submissions for String to
 * Integer (atoi). Memory Usage: 38.6 MB, less than 5.59% of Java online
 * submissions for String to Integer (atoi).
 */
public class Atoi {

	public static int myAtoi(String str) {
		if (str == null || str == "") {
			return 0;
		}
		int i = 0;

		boolean signFound = false;
		boolean digitFound = false;

		int sign = 1;

		StringBuilder sb = new StringBuilder();
		while (i++ < str.length()) {
			char c = str.charAt(i - 1);
			if (c == ' ') {
				if (digitFound || signFound) {
					break;
				}
				continue;
			}
			if (c == '-') {
				if (digitFound || signFound) {
					break;
				} else {
					sign = -1;
					signFound = true;
				}
				continue;
			}
			if (c == '+') {
				if (digitFound || signFound) {
					break;
				} else {
					sign = 1;
					signFound = true;
				}
				continue;
			}
			int dig = (int) c - 48;
			if (dig >= 0 && dig < 10) {
				digitFound = true;
				sb.append(dig);
				continue;
			}
			break;
		}
		if (!digitFound) {
			return 0;
		}

		try {
			long eval = sign * Long.valueOf(sb.toString());

			if (eval >= Integer.MAX_VALUE) {
				return Integer.MAX_VALUE;
			}
			if (eval <= Integer.MIN_VALUE) {
				return Integer.MIN_VALUE;
			}
			return (int) eval;
		} catch (Exception e) {
			return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
		}
	}

	public static void main(String[] arg) {

		System.out.println(myAtoi("42"));
		System.out.println(myAtoi("-42"));
		System.out.println(myAtoi("  -42"));
		System.out.println(myAtoi(" -  42"));
		System.out.println(myAtoi("4193 with words"));
		System.out.println(myAtoi("words and 987"));
		System.out.println(myAtoi("-91283472332"));
		System.out.println(myAtoi("-2147483647"));
		System.out.println(myAtoi("214191919199991917483647"));
	}
}
