package org.problems.strings;

/**
 * https://leetcode.com/problems/number-of-substrings-with-only-1s/
 * 
 * Given a binary string s (a string consisting only of '0' and '1's).
 * 
 * Return the number of substrings with all characters 1's.
 * 
 * Since the answer may be too large, return it modulo 10^9 + 7.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "0110111" Output: 9 
 * Explanation: There are 9 substring in total
 * with only 1's characters. "1" -> 5 times. "11" -> 3 times. "111" -> 1 time.
 * 
 */
public class NumberOf1Substrings {

	static long counter(int len) {
		return (long) len * (len + 1) / 2;
	}

	public static int numSub(String s) {
		String[] digs = s.split("0");
		long count = 0;
		for (String str : digs) {
			count += counter(str.length());
			count %= 1000000007;
		}
		return (int) count;
	}

	public static void main(String[] arg) {
		System.out.println(numSub("0011101101111"));
	}

}
