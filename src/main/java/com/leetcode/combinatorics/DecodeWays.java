package com.leetcode.combinatorics;

/**
 * https://leetcode.com/problems/decode-ways/
 *
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 * 
 * 'A' -> 1 'B' -> 2 ... 'Z' -> 26 Given a non-empty string containing only
 * digits, determine the total number of ways to decode it.
 * 
 * Example 1: Input: "12" Output: 2 Explanation: It could be decoded as "AB" (1
 * 2) or "L" (12).
 * 
 * Example 2: Input: "226" Output: 3 Explanation: It could be decoded as "BZ" (2
 * 26), "VF" (22 6), or "BBF" (2 2 6)
 */
public class DecodeWays {

	public static boolean isDoubleDigit(int i1, int i2) {
		return i1 * 10 + i2 < 27;
	}

	public static int[] part(int[] s, int from, int to) {
		if (s.length == 0) {
			return new int[0];
		}
		int[] res = new int[s.length - to + from];
		int idx = 0;
		for (int i = 0; i < from; i++) {
			res[idx++] = s[i];
		}
		for (int i = to; i < s.length; i++) {
			res[idx++] = s[i];
		}
		return res;
	}

	public static int getWays(int[] s) {
		int l = s.length;
		if (l == 0) {
			return 0;
		}
		if (l == 1) {
			return s[0] == 0 ? 0 : 1;
		}

		if (l == 2) {
			if (s[0] == 0 && s[1] == 0) {
				return 0;
			}
			if (s[1] == 0) {
				if (s[0] < 3 && s[0] > 0) {
					return 1;
				} else {
					return 0;
				}
			}
			if (s[0] == 0 && s[1] != 0) {
				return 0;
			}
			if (isDoubleDigit(s[0], s[1])) {
				return 2;
			}
			return 1;
		}
		if (s[0] == 0) {
			return 0;
		}

		int total = 0;
		int add = getWays(part(s, 0, 0 + 1));
		total += add;
		if (1 < l) {
			if (isDoubleDigit(s[0], s[0 + 1])) {
				total += getWays(part(s, 0, 0 + 2));
			}
		}
		return total;
	}

	public static int numDecodings(String s) {
		int l = s.length();
		int[] res = new int[l];
		for (int i = 0; i < l; i++) {
			res[i] = s.charAt(i) - '0';
		}
		return getWays(res);
	}

	public static void main(String[] arg) {

		System.out.println(numDecodings("12"));
		System.out.println(numDecodings("226"));
		System.out.println(numDecodings("1226"));

	}

}
