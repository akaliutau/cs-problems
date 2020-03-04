package com.leetcode.numbers;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/integer-to-roman/
 * 
 * Runtime: 4 ms, faster than 76.78% of Java online submissions for Roman to
 * Integer. Memory Usage: 41.4 MB, less than 5.48% of Java online submissions
 * for Roman to Integer.
 */
public class Roman2Integer {

	public static int romanToInt(String s) {
		StringBuilder sb = new StringBuilder();

		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		int n = s.length();

		char[] r = new char[n];

		for (int i = n - 1; i > -1; i--) {
			r[i] = s.charAt(i);
		}

		int integer = 0;

		char[] dp = new char[2];

		int i = 0;
		boolean doubleP = false;
		while (i < n) {
			if (i + 1 < n) {
				doubleP = true;
				dp[1] = r[i];
				dp[0] = r[i + 1];
			} else {
				doubleP = false;
			}
			if (doubleP) {
				if (dp[0] == 'V' && dp[1] == 'I') {
					i += 2;
					integer += 4;
				} else if (dp[0] == 'X' && dp[1] == 'I') {
					i += 2;
					integer += 9;
				} else if (dp[0] == 'L' && dp[1] == 'X') {
					i += 2;
					integer += 40;
				} else if (dp[0] == 'C' && dp[1] == 'X') {
					i += 2;
					integer += 90;
				} else if (dp[0] == 'D' && dp[1] == 'C') {
					i += 2;
					integer += 400;
				} else if (dp[0] == 'M' && dp[1] == 'C') {
					i += 2;
					integer += 900;
				} else {
					integer += map.get(r[i]);
					i++;
				}
			} else {
				integer += map.get(r[i]);
				i++;
			}
		}

		return integer;
	}

	public static void main(String[] arg) {

		System.out.println(romanToInt("XX"));
		System.out.println(romanToInt("III"));
		System.out.println(romanToInt("IV"));
		System.out.println(romanToInt("IX"));
		System.out.println(romanToInt("LVIII"));
		System.out.println(romanToInt("MCMXCIV"));

	}
}
