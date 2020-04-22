package com.leetcode.strings;

/**
 * https://leetcode.com/problems/detect-capital/
 * 
 * Given a word, you need to judge whether the usage of capitals in it is right
 * or not.
 * 
 * We define the usage of capitals in a word to be right when one of the
 * following cases holds:
 * 
 * All letters in this word are capitals, like "USA". All letters in this word
 * are not capitals, like "leetcode". Only the first letter in this word is
 * capital, like "Google". Otherwise, we define that this word doesn't use
 * capitals in a right way.
 * 
 * 
 * Example 1:
 * 
 * Input: "USA" Output: True
 * 
 * 
 * Example 2:
 * 
 * Input: "FlaG" Output: False
 * 
 */
public class DetectCapital {
	
	static boolean allLowerCase(String word, int from) {
		System.out.println("check lower" + from);
		for (int i = from; i < word.length(); i++) {
			char c = word.charAt(i);
			if ('a' <= c && c <= 'z') {
			}else {
				return false;
			}
		}
		return true;
	}

	static boolean allUpperCase(String word) {
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if ('A' <= c  && c <= 'Z') {
			}else {
				return false;
			}
		}
		return true;
	}

	public static boolean detectCapitalUse(String word) {
		int n = word.length();
		if (n < 2) {
			return true; 
		}
		char c0 = word.charAt(0);
		char c1 = word.charAt(1);
		if ('A' <= c0  && c0 <= 'Z' && 'A' <= c1  && c1 <= 'Z') {
			return allUpperCase(word);
		}
		if ('A' <= c0  && c0 <= 'Z' && 'a' <= c1  && c1 <= 'z') {
			return allLowerCase(word,1);
		}
		return allLowerCase(word,0);
        
    }

	public static void main(String[] arg) {

		System.out.println(detectCapitalUse("USA"));
		System.out.println(detectCapitalUse("FlaG"));
		System.out.println(detectCapitalUse("Leetcode"));

	}

}
