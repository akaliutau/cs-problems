package com.leetcode.strings;

/**
 * https://leetcode.com/problems/construct-k-palindrome-strings/
 *
 * Given a string s and an integer k. You should construct k non-empty
 * palindrome strings using all the characters in s.
 * 
 * Return True if you can use all the characters in s to construct k palindrome
 * strings or False otherwise.
 * 
 * Example 1:
 * 
 * Input: s = "annabelle", k = 2 Output: true 
 * 
 * Explanation: You can construct two
 * palindromes using all characters in s. Some possible constructions:
 *  "anna" + "elble", "anbna" + "elle", "anellena" + "b"
 * 
 */
public class ConstructKPalindromeStrings {

	public static boolean canConstruct(String s, int k) {
		int[] hist = new int[26];
		for (int i = 0; i < s.length(); i++) {
			hist[s.charAt(i) - 'a']++;
		}
		int count = 0;
		int minCount = 0;
		for (int i = 0; i < 26; i++) {
			if (hist[i] % 2 == 1) {
				hist[i]--;
				count++;
				minCount++;
			}
			count += hist[i];
		}

		if (k == s.length()) {
			return true;
		}

		if (k > count) {
			return false;
		}
		if (k < minCount) {
			return false;
		}
		return true;
	}

	public static void main(String[] arg) {

		System.out.println(canConstruct("annabelle", 2));
		System.out.println(canConstruct("leetcode", 3));
		System.out.println(canConstruct("true", 4));
		System.out.println(canConstruct("yzyzyzyzyzyzyzy", 2));
		System.out.println(canConstruct("cr", 7));
		System.out.println(canConstruct("qlkzenwmmnpkopu", 15));
		System.out.println(canConstruct("ibzkwaxxaggkiwjbeysz", 15));
	}

}
