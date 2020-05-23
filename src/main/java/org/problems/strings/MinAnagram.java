package org.problems.strings;

/**
 * https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/
 * 
 * Given two equal-size strings s and t. In one step you can choose any
 * character of t and replace it with another character.
 * 
 * Return the minimum number of steps to make t an anagram of s.
 * 
 * An Anagram of a string is a string that contains the same characters with a
 * different (or the same) ordering.
 * 
 * Example 1:
 * 
 * Input: s = "bab", t = "aba" Output: 1 
 * 
 * Explanation: Replace the first 'a' in t with b, t = "bba" which is anagram of s.
 * 
 */
public class MinAnagram {

	public static final int n = 12;

	public static int minSteps(String s, String t) {

		int count = 0;
		int chars[] = new int[32768];

		for (int i = 0; i < s.length(); i++) {
			chars[s.charAt(i) - 'a']++;
		}

		for (int i = 0; i < t.length(); i++) {
			if (chars[t.charAt(i) - 'a']-- <= 0) {
				count++;
			}
		}

		return count;
	}

	public static void main(String[] arg) {

		int res = minSteps("bab", "aba");

		System.out.println(res);

	}

}
