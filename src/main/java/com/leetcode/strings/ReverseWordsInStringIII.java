package com.leetcode.strings;

/**
 *	https://leetcode.com/problems/reverse-words-in-a-string-iii/
 *  
 *  Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Note: In the string, each word is separated by single space and there will not be any extra space in the string

 * 
 */
public class ReverseWordsInStringIII {
	
	public static String reverseString(String word) {
		int n = word.length();
		char[] s = new char[n];
		for (int i = 0; i < n; i++) {
			s[i] = word.charAt(i);
		}
		int i = 0;
		while (i < n/2) {
			char t = s[i];
			s[i] = s[n-i-1];
			s[n-i-1] = t;
			i++;
		}
		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < n; j++) {
			sb.append(s[j]);
		}
		return sb.toString();
	}

	
	public static String reverseWords(String s) {
		String[] words = s.split(" ");
		for (int i = 0; i < words.length; i++) {
			words[i] = reverseString(words[i]);
		}
		
		return String.join(" ", words);
	        
	}
	
	public static void main(String[] arg) {

		System.out.println(reverseWords("Let's take LeetCode contest"));

	}
}
