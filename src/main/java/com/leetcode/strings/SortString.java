package com.leetcode.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.leetcode.utils.Utils;

/**
 * https://leetcode.com/problems/increasing-decreasing-string
 * 
 * Given a string s. You should re-order the string using the following
 * algorithm:
 * 
 * Pick the smallest character from s and append it to the result. 
 * Pick the
 * smallest character from s which is greater than the last appended character
 * to the result and append it. 
 * Repeat step 2 until you cannot pick more
 * characters. 
 * 
 * Pick the largest character from s and append it to the result.
 * Pick the largest character from s which is smaller than the last appended
 * character to the result and append it. 
 * Repeat step 5 until you cannot pick
 * more characters. 
 * 
 * Repeat the steps from 1 to 6 until you pick all characters
 * from s. 
 * 
 * In each step, If the smallest or the largest character appears more
 * than once you can choose any occurrence and append it to the result.
 * 
 * Return the result string after sorting s with this algorithm.
 * 
 */
public class SortString {

	public static String sortString(String s) {
		Set<Character> set = new HashSet<>();
		int n = s.length();
		if (n == 0) {
			return "";
		}
		int[] all = new int[26];
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			set.add(c);
			all[c - 'a']++;
		}
		List<Character> lst = new ArrayList<>(set);
		Collections.sort(lst);
		System.out.println(lst);
		Utils.print(all);
		StringBuffer sb = new StringBuffer();
		int counter = 0;
		int m = lst.size();
		while (counter < n) {
			int i = 0;
			while (counter < n && i < m) {
				char c = lst.get(i);
				if (all[c - 'a']-- > 0) {
					sb.append(c);
					counter++;
				}
				i++;
			}
			int j = m - 1;
			while (counter < n && j > -1) {
				char c = lst.get(j);
				if (all[c - 'a']-- > 0) {
					sb.append(c);
					counter++;
				}
				j--;
			}
		}

		return sb.toString();
	}

	public static void main(String[] arg) {

		int[] arr = {};
		System.out.println(sortString("aaaabbbbcccc"));
		System.out.println(sortString("rat"));
		System.out.println(sortString("leetcode"));
		System.out.println(sortString("gggggg"));
		System.out.println(sortString("spo"));

	}

}
