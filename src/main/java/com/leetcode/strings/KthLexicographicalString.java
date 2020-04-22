package com.leetcode.strings;

/**
 * https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/
 * 
 * A happy string is a string that:
 * 
 * consists only of letters of the set ['a', 'b', 'c']. 
 * 
 * s[i] != s[i + 1] for all
 * values of i from 1 to s.length - 1 (string is 1-indexed). 
 * 
 * For example,
 * strings "abc", "ac", "b" and "abcbabcbcb" are all happy strings and strings
 * "aa", "baa" and "ababbc" are not happy strings.
 * 
 * Given two integers n and k, consider a list of all happy strings of length n
 * sorted in lexicographical order.
 * 
 * Return the kth string of this list or return an empty string if there are
 * less than k happy strings of length n
 * 
 */
public class KthLexicographicalString {

	static boolean getNextHappyStr(int[] str) {
		int n = str.length;
		int excess = (str[n - 1] + 1) / 3;
		str[n - 1] = (str[n - 1] + 1) % 3;
		for (int i = n - 2; i > -1; i--) {
			int excess1 = (str[i] + excess) / 3;
			str[i] = (str[i] + excess) % 3;
			excess = excess1;
			if (excess == 0) {
				break;
			}
		}
		if (excess != 0) {
			return false;
		}
		return true;
	}

	static boolean isHappyStr(int[] str) {
		int n = str.length;
		for (int i = n - 1; i > 0; i--) {
			if (str[i] == str[i - 1]) {
				return false;
			}
		}
		return true;
	}

	static boolean getHappyStr(int[] str) {
		boolean found = false;
		while (!found) {
			if (getNextHappyStr(str)) {
				if (isHappyStr(str)) {
					return true;
				}
			} else {
				return false;
			}
		}
		return false;
	}

	public static String getHappyString(int n, int k) {
		int[] str = new int[n];
		if (n == 1) {
			if (k > 3) {
				return "";
			}
			char c = (char) ('a' + k - 1);
			StringBuilder sb = new StringBuilder();
			sb.append(c);
			return sb.toString();
		}
		// first happy string
		int c = 0;
		for (int i = 0; i < n; i++) {
			str[i] = c;
			c = c == 0 ? 1 : 0;
		}
		for (int i = 0; i < k - 1; i++) {
			if (!getHappyStr(str)) {
				return "";
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append((char) ('a' + str[i]));
		}
		return sb.toString();
	}

	public static void main(String[] arg) {

		System.out.println(getHappyString(1, 3));
		System.out.println(getHappyString(3, 9));
		System.out.println(getHappyString(2, 7));
		System.out.println(getHappyString(10, 100));

	}

}
