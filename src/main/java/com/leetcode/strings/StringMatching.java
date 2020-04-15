package com.leetcode.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/string-matching-in-an-array
 * 
 * Given an array of string words. Return all strings in words which is
 * substring of another word in any order.
 * 
 * String words[i] is substring of words[j], if can be obtained removing some
 * characters to left and/or right side of words[j].
 * 
 */
public class StringMatching {

	public static List<String> stringMatching(String[] words) {
		List<String> res = new ArrayList<>();

		for (String subword : words) {
			for (String word : words) {
				if (!word.equals(subword)) {
					if (word.contains(subword)) {
						res.add(subword);
						break;
					}
				}
			}
		}
		return res;

	}

	public static void main(String[] arg) {
		String[] words = { "mass", "as", "hero", "superhero" };
		System.out.println(stringMatching(words));

		String[] words1 = { "leetcode", "et", "code" };
		System.out.println(stringMatching(words1));

		String[] words2 = { "blue", "green", "bu" };
		System.out.println(stringMatching(words2));

	}

}
