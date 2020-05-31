package org.problems.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/word-pattern/
 * 
 * Given a pattern and a string str, find if str follows the same pattern.
 * 
 * Here follow means a full match, such that there is a bijection between a
 * letter in pattern and a non-empty word in str.
 * 
 * Example 1:
 * 
 * Input: pattern = "abba", str = "dog cat cat dog" Output: true 
 * 
 * Example 2:
 * 
 * Input:pattern = "abba", str = "dog cat cat fish" Output: false 
 * 
 * Example 3:
 * 
 * Input: pattern = "aaaa", str = "dog cat cat dog" Output: false 
 * 
 * Example 4:
 * 
 * Input: pattern = "abba", str = "dog dog dog dog" Output: false
 * 
 * 
 */
public class WordPattern {

	public static boolean wordPattern(String pattern, String str) {
		String[] words = str.split(" ");
		int n = pattern.length();
		if (words.length != n) {
			return false;
		}
		Map<Character,String> mapping = new HashMap<>();
		Map<String,Character> mapping2 = new HashMap<>();
		for (int i = 0; i < n; i++) {
			char c = pattern.charAt(i);
			mapping.put(c,words[i]);
			mapping2.put(words[i], c);
		}
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(mapping.get(pattern.charAt(i)));
			sb2.append(mapping2.get(words[i]));
		}		
		return sb.toString().equals(str.replace(" ", "")) && sb2.toString().equals(pattern);

	}

	public static void main(String[] arg) {

		System.out.println(wordPattern("abba", "dog cat cat dog"));
		System.out.println(wordPattern("abba", "dog cat cat fish"));
		System.out.println(wordPattern("aaaa", "dog cat cat dog"));
		System.out.println(wordPattern("abba", "fish fish fish fish"));

	}

}
