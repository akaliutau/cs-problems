package com.leetcode.palindrome;

/**
 * https://leetcode.com/problems/longest-palindrome/
 *
 * Given a string which consists of lowercase or uppercase letters, find the
 * length of the longest palindromes that can be built with those letters.
 * 
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 * 
 * Note: Assume the length of given string will not exceed 1,010.
 * 
 * Example:
 * 
 * Input: "abccccdd"
 * 
 * Output: 7
 * 
 * Explanation: One longest palindrome that can be built is "dccaccd", whose
 * length is 7
 */
public class LongestPalindrome {

	public static int longestPalindrome(String s) {
		
		int[] hist = new int[256];
		for (int i = 0; i < s.length(); i++) {
			hist[s.charAt(i)] ++;
		}
		// find the max of
		// 1) pairs, i.e. # of hist[i] >= 2
		// 2) if there is an extra hist[i] > 0, +1
		int counter = 0;
		boolean centerAdded = false;
		for (int i = 0; i < hist.length; i++) {
			if (hist[i] > 0) {
				if (hist[i] >= 2) {
					int chars = hist[i] / 2;
					counter += 2 * chars;
					if (hist[i] % 2 != 0 && !centerAdded) {
						centerAdded = true;
						counter ++;
					}
				}else if (hist[i] > 0 && !centerAdded){
					centerAdded = true;
					counter ++;
				}
			}
		}
		return counter;

	}

	public static void main(String[] arg) {

		System.out.println(longestPalindrome("abccccdd"));
		System.out.println(longestPalindrome(""));
		System.out.println(longestPalindrome("aA"));

	}
}
