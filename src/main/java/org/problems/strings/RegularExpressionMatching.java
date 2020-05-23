package org.problems.strings;

/**
 * https://leetcode.com/problems/regular-expression-matching/
 * 
 * Given an input string (s) and a pattern (p), implement regular expression
 * matching with support for '.' and '*'.
 * 
 * '.' Matches any single character. '*' Matches zero or more of the preceding
 * element. The matching should cover the entire input string (not partial).
 * 
 * Note:
 * 
 * s could be empty and contains only lowercase letters a-z. p could be empty
 * and contains only lowercase letters a-z, and characters like . or *.
 * 
 * 
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Regular
 * Expression Matching. Memory Usage: 38.2 MB, less than 47.47% of Java online
 * submissions for Regular Expression Matching.
 */
public class RegularExpressionMatching {

	private int[][] dp;

	private boolean isMatch(char[] text, char[] reg, int ti, int ri) {

		if (ri == reg.length) {
			return ti == text.length;
		}

		if (ti == text.length) {
			return isNextCharStar(reg, ri) && isMatch(text, reg, ti, ri + 2);
		}

		if (dp[ti][ri] > 0)
			return dp[ti][ri] == 1;

		boolean result;
		final boolean hasFirstMatched = text[ti] == reg[ri] || reg[ri] == '.';

		if (isNextCharStar(reg, ri)) {
			result = isMatch(text, reg, ti, ri + 2);
			if (hasFirstMatched) {
				result = result || isMatch(text, reg, ti + 1, ri);
			}
			dp[ti][ri] = result ? 1 : 2;
			return result;
		}

		dp[ti][ri] = (hasFirstMatched && isMatch(text, reg, ti + 1, ri + 1)) ? 1 : 2;
		return dp[ti][ri] == 1;

	}

	private boolean isNextCharStar(char[] reg, int ri) {
		return ri < reg.length - 1 && reg[ri + 1] == '*';
	}

	public boolean isMatch(String s, String p) {
		int n = s.length();
		int m = p.length();

		if (m == 0) {
			return (n == 0);
		}

		char[] str = new char[n];
		char[] prn = new char[m];

		for (int i = 0; i < n; i++) {
			str[i] = s.charAt(i);
		}

		for (int j = 0; j < m; j++) {
			prn[j] = p.charAt(j);
		}

		dp = new int[n][m];
		return isMatch(str, prn, 0, 0);
	}

	public static void main(String[] arg) {
		RegularExpressionMatching rem = new RegularExpressionMatching();

		System.out.println(rem.isMatch("afa", ".*f*a*"));
		System.out.println(rem.isMatch("", "a"));
		System.out.println(rem.isMatch("aa", "a"));
		System.out.println(rem.isMatch("a", ""));
		System.out.println(rem.isMatch("aab", "c*ab"));
		System.out.println(rem.isMatch("aab", "aa*b"));
		System.out.println(rem.isMatch("aab", "c*a*b*"));
		System.out.println(rem.isMatch("", ".*"));

	}
}
