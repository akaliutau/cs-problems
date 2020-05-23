package org.problems.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/valid-anagram/ Given two strings s and t ,
 * write a function to determine if t is an anagram of s.
 * 
 * Example 1:
 * 
 * Input: s = "anagram", t = "nagaram" Output: true 
 * 
 * Example 2:
 * 
 * Input: s = "rat", t = "car" Output: false 
 */
public class ValidAnagram {
	
	static class Char {
		public final char c;
		public int count = 1;
		
		public Char(char c) {
			this.c = c;
		}
	}
	
	public static boolean isAnagram(String s, String t) {
		Map<Character, Char> mapS = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!mapS.containsKey(c)) {
				mapS.put(c, new Char(c));
			}else{
			    mapS.get(c).count++;
            }
		}
		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			if (!mapS.containsKey(c)) {
				return false;
			}
			mapS.get(c).count--;
			if (mapS.get(c).count == 0) {
				mapS.remove(c);
			}
		}
		return mapS.isEmpty();
        
    }


	public static void main(String[] arg) {

		System.out.println(isAnagram("anagram","nagaram"));
		System.out.println(isAnagram("",""));

		System.out.println(isAnagram("rat","car"));

		System.out.println(isAnagram("apple","orange"));

		System.out.println(isAnagram("","orange"));

	}
}
