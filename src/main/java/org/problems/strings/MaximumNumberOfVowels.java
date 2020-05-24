package org.problems.strings;

import java.util.List;

import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
 * 
 * 
 * Given a string s and an integer k.
 * 
 * Return the maximum number of vowel letters in any substring of s with length
 * k.
 * 
 * Vowel letters in English are (a, e, i, o, u).
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "abciiidef", k = 3 Output: 3 Explanation: The substring "iii"
 * contains 3 vowel letters.
 * 
 */
public class MaximumNumberOfVowels {

	public static int maxVowels(String s, int k) {
		int n = s.length();
		int[] vowels = new int[n];
		int peak = 0;
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
				peak++;
			}
			vowels[i] = peak;
		}
		if (n == k) {
			return vowels[n - 1];
		}
		int max = 0;
		for (int i = 0; i < n - k; i++) {
			int val = 0;
			if (i == 0) {
				val = vowels[i + k - 1];
			} else {
				val = vowels[i + k] - vowels[i];
			}
			max = Math.max(max, val);
			if (max == k) {
				break;
			}
		}
		return max;
	}

	public static void main(String[] arg) {

		System.out.println(maxVowels("abciiidef", 3));
		System.out.println(maxVowels("aeiou", 2));
		System.out.println(maxVowels("leetcode", 3));
		System.out.println(maxVowels("rhythms", 4));
		System.out.println(maxVowels("tryhard", 4));
		System.out.println(maxVowels("tryhard", 7));
		System.out.println(maxVowels("aaa", 2));
		System.out.println(maxVowels("aaa", 3));

	}

}
