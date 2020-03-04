package com.leetcode.strings;

/**
 * https://leetcode.com/problems/palindrom-i/ 
 * 
 * Runtime: 1 ms, faster than
 * 91.80% of Java online submissions for Keys and Rooms. Memory Usage: 43.3 MB,
 * less than 58.62% of Java online submissions for Keys and Rooms.
 */
public class PalindromeI {

	public static boolean isPalindrome(int x) {
		String s = Integer.toString(x);
		int n = s.length();
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) != s.charAt(n - i - 1)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] arg) {
		// 0 1 2 3

		System.out.println(isPalindrome(121));

	}
}
