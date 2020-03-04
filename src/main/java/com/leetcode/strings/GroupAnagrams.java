package com.leetcode.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/group-anagrams/
 * 
 * Given an array of strings, group anagrams together.
 * 
 * Example:
 * 
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 
 * Output:
 * 
 * [ ["ate","eat","tea"], ["nat","tan"], ["bat"] ]
 * 
 * Runtime: 6 ms, faster than 98.32% of Java online submissions for Group Anagrams.
 * Memory Usage: 44.9 MB, less than 39.18% of Java online submissions for Group Anagrams.
 * 
 */
public class GroupAnagrams {
	
	public static class FootPrint {
		public int[] chars = new int[26];

		public FootPrint(String s){
			int n = s.length();
			for (int i = 0; i < n; i++) {
				chars[(int)(s.charAt(i)-'a')]++;
			}
		}

		@Override
		public boolean equals(Object o) {
			FootPrint fp = (FootPrint) o;
			if (chars.length == fp .chars.length) {
				for (int i = 0; i < chars.length; i++) {
					if (chars[i] != fp.chars[i]) {
						return false;
					}
				}
				return true;
			}
			return false;
		}
		
		@Override
		public int hashCode() {
			return Arrays.hashCode(chars);
		}
	}
	static Set<Character> footPrint(String s){
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
		}
		return set;
	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> results = new ArrayList<>();
		if (strs.length == 0) {
			return results;
		}
		Map<FootPrint,List<String>> groupped = new HashMap<>();
		for (String s: strs) {
			FootPrint fp = new FootPrint(s);
			if (!groupped.containsKey(fp)) {
				groupped.put(fp, new ArrayList<>());
			}
			groupped.get(fp).add(s);
		}
		
		results.addAll(groupped.values());
		return results;
        
    }

	public static void main(String[] arg) {
		
		System.out.println((int) 'A');
		System.out.println((int) 'a');
		
		String[] in = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println(groupAnagrams(in));

		String[] in1 = new String[] {"eatnat"};
		System.out.println(groupAnagrams(in1));

		String[] in2 = new String[] {};
		System.out.println(groupAnagrams(in2));

	}
}
