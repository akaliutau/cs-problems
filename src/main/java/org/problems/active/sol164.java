package org.problems.active;

import java.util.List;

/**
 * https://leetcode.com/problems/longest-palindromic-subsequence/
 * 
 * Given a string s, find the longest palindromic subsequence's length in s. You
 * may assume that the maximum length of s is 1000.
 * 
 * Example 1: Input:
 * "bbbab" Output: 4 One possible longest palindromic subsequence is "bbbb".
 * 
 * 
 * Example 2: Input:
 * "cbbd" Output: 2 One possible longest palindromic subsequence is "bb"
 * 
 * 
 */
public class sol164 {

	public static int longestPalindromeSubseq2(String s) {
		
		int[] hist = new int[26];
		for (int i = 0; i < s.length(); i++) {
			hist[s.charAt(i)-'a'] ++;
		}
		// calculate numbers of double elements
		int len = 0;
		for (int i = 0; i < 26; i++) {
			int let = hist[i];
			int counter = let / 2;
			hist[i] -= counter;
			len += 2 * counter;
		}
		for (int i = 0; i < 26; i++) {
			if (hist[i] > 0) {
				return len + 1;
			}
		}
		return len;
	}
	
	// start from center
	static int constructPolindrome1(char[] str, int center) {
		int left = center;
		int right = center;
		int len = 0;
		left --;
		right ++;
		int deleted = 0;
		while (left < 0 || right == str.length) {
			if (str[left] != str[right]) {
				// choose the best strategy to find the next pair such that s[left]=s[right]
				// calc cost for each combination
				int r = right;
				int toDel1 = 0;
				while (r < str.length && str[left] != str[r]) {
					r ++;
					toDel1 ++;
				}
				int costR = r == str.length ? Integer.MAX_VALUE : toDel1;
				int l = left;
				int toDel2 = 0;
				while (l >=0 && str[right] != str[l]) {
					l --;
					toDel2 ++;
				}
				int costL = l < 0 ? Integer.MAX_VALUE : toDel2;
				if (costL == Integer.MAX_VALUE && costR == Integer.MAX_VALUE) {
					return 0;
				}else if (costL == Integer.MAX_VALUE) {
					right = r;
				}else if (costR == Integer.MAX_VALUE) {
					left = l;
				}else if (costR > costL) {
					left = l;
				}else {
					right = r;
				}
				
			} else {
				left --;
				right ++;
			}
		}
		return deleted;
	}
	
	public static int longestPalindromeSubseq(String s) {
		int len = 0;
		int n = s.length();
		
		char[] str = new char[n];
		for (int i = 0; i < n; i++) {
			str[i] = s.charAt(i);
		}
		
		
		
		return len;
	}

	public static void main(String[] arg) {

		System.out.println(longestPalindromeSubseq("bbbab"));//4
		System.out.println(longestPalindromeSubseq("bbaaaacab"));//7

	}

}
