package org.problems.palindrome;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-pairs/
 *
 * Given a list of unique words, find all pairs of distinct indices (i, j) in
 * the given list, so that the concatenation of the two words, i.e. words[i] +
 * words[j] is a palindrome.
 * 
 * Example 1:
 * Input: ["abcd","dcba","lls","s","sssll"] Output: [[0,1],[1,0],[3,2],[2,4]]
 * Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
 * 
 * Example 2:
 * Input: ["bat","tab","cat"] Output: [[0,1],[1,0]] 
 * Explanation: The palindromes are ["battab","tabbat"]
 */
public class PalindromePairs {
	
	static boolean isPalindrome(String s) {
		
		int n = s.length();
		for (int i = 0; i < n/2; i++) {
			if (s.charAt(i) != s.charAt(n-i-1)) {
				return false;
			}
		}
		return true;
	}

	
	static boolean isPalindrome(String s1, String s2) {
		
		int n2 =  s2.length();
		if (s1.length() == 0) {
			return isPalindrome(s2);
		}else if (n2 == 0) {
			return isPalindrome(s1);
		}
			
		if (s1.charAt(0) != s2.charAt(n2-1)) {
				return false;
		}
		return isPalindrome(s1+s2);
	}

	public static List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> res = new ArrayList<>();
		int n = words.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i != j) {
					if (isPalindrome(words[i],words[j])) {
						res.add(Arrays.asList(i,j));
					}
				}
			}
		}
		
		return res;

	}

	public static void main(String[] arg) {

		String[] words = {"abcd","dcba","lls","s","sssll"};
		System.out.println(palindromePairs(words));

		String[] words1 = {"bat","tab","cat"};
		System.out.println(palindromePairs(words1));

	}
}
