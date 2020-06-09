package org.problems.regex;

/**
 * https://leetcode.com/problems/repeated-substring-pattern/
 * 
 * Given a non-empty string check if it can be constructed by taking a substring
 * of it and appending multiple copies of the substring together. You may assume
 * the given string consists of lowercase English letters only and its length
 * will not exceed 10000.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: "abab" Output: True 
 * Explanation: It's the substring "ab" twice.
 * 
 * Example 2:
 * 
 * Input: "aba" Output: False 
 * 
 * Example 3:
 * 
 * Input: "abcabcabcabc" Output: True 
 * Explanation: It's the substring "abc" four
 * times. (And the substring "abcabc" twice.)
 * 
 * Runtime: 12 ms, faster than 73.34% of Java online submissions for Repeated Substring Pattern.
 * Memory Usage: 40.3 MB, less than 32.73% of Java online submissions for Repeated Substring Pattern
 * 
 */
public class RepeatedSubstringPattern {

	public static boolean repeatedSubstringPattern(String s) {
		int n = s.length();
		if (n <= 1) {
			return false;
		}
		int len = n;
		int div = 1;
		while (len / 2 >= div) {
			div ++;
			if (!(len % div == 0)){
				continue;
			}
			String part = s.substring(0, len / div);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < div; i++) {
				sb.append(part);
			}

			if (s.equals(sb.toString())) {
				return true;
			}
			
		}
		// check all equals case
		char c = s.charAt(0);
		for (int i = 1; i < n; i++) {
			if (s.charAt(i) != c) {
				return false;
			}
		}
				
		return true;

	}

	public static void main(String[] arg) {

		System.out.println(repeatedSubstringPattern("abab"));
		System.out.println(repeatedSubstringPattern("aba"));
		System.out.println(repeatedSubstringPattern("abcabcabcabc"));
		System.out.println(repeatedSubstringPattern("aa"));
		System.out.println(repeatedSubstringPattern("ab"));
		System.out.println(repeatedSubstringPattern("aaa"));
		System.out.println(repeatedSubstringPattern("aaaa"));
		System.out.println(repeatedSubstringPattern("aaaaa"));
		System.out.println(repeatedSubstringPattern("a"));

	}

}
