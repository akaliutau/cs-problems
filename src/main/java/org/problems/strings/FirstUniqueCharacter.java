package org.problems.strings;

/**
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 *
 * Given a string, find the first non-repeating character in it and return it's
 * index. If it doesn't exist, return -1.
 * 
 * Examples:
 * 
 * s = "leetcode" return 0.
 * 
 * s = "loveleetcode", return 2. 
 * 
 * Note: You may assume the string contain only lowercase letters
 */
public class FirstUniqueCharacter {

	public static int firstUniqChar(String s) {
		int[] hist = new int[26];
		for (int i = 0; i < s.length(); i++) {
			hist[s.charAt(i)-'a']++;
		}
		for (int i = 0; i < s.length(); i++) {
			if (hist[s.charAt(i)-'a'] == 1) {
				return i; 
			}
		}		
		return -1;

	}

	public static void main(String[] arg) {

		System.out.println(firstUniqChar("leetcode"));
		System.out.println(firstUniqChar("loveleetcode"));

	}
}
