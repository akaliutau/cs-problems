package org.problems.strings;

/**
 * https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
 * 
 * Runtime: 5 ms, faster than 100.00% of Java online submissions for Number of
 * Substrings Containing All Three Characters. Memory Usage: 41.4 MB, less than
 * 100.00% of Java online submissions for Number of Substrings Containing All
 * Three Characters.
 */
public class NumberOfSubstrings {

	public static int numberOfSubstrings(String s) {
		int n = s.length();

		char[] str = new char[n];
		for (int i = 0; i < n; i++) {
			str[i] = s.charAt(i);
		}

		int total = (n * (n + 1)) / 2;
		int cum = total;

		int aIdx = 0;
		int bIdx = 0;
		int cIdx = 0;

		for (int i = 0; i < n; i++) {
			if (str[i] == 'a') {
				aIdx = i + 1;
				cum -= Math.min(bIdx, cIdx);
			} else if (str[i] == 'b') {
				bIdx = i + 1;
				cum -= Math.min(aIdx, cIdx);
			} else {
				cIdx = i + 1;
				cum -= Math.min(aIdx, bIdx);
			}
		}

		return total - cum;
	}

	public static void main(String[] arg) {

		System.out.println(numberOfSubstrings("abcabc"));
		System.out.println(numberOfSubstrings("aaacb"));
		System.out.println(numberOfSubstrings("abc"));
		System.out.println(numberOfSubstrings(""));
		System.out.println(numberOfSubstrings("aaa"));
		System.out.println(numberOfSubstrings("a"));

	}

}
