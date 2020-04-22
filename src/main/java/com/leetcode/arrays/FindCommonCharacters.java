package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-common-characters/
 * 
 * Given an array A of strings made only from lowercase letters, return a list
 * of all characters that show up in all strings within the list (including
 * duplicates). For example, if a character occurs 3 times in all strings but
 * not 4 times, you need to include that character three times in the final
 * answer.
 * 
 * You may return the answer in any order.
 * 
 * Example 1:
 * Input: ["bella","label","roller"] Output: ["e","l","l"] 
 * 
 * Example 2:
 * Input: ["cool","lock","cook"] Output: ["c","o"]
 * 
 * Note:
 * 1 <= A.length <= 100 
 * 1 <= A[i].length <= 100 
 * A[i][j] is a lowercase letter
 */
public class FindCommonCharacters {

	public static List<String> commonChars(String[] a) {
		List<String> res = new ArrayList<>();
		int words = a.length;
		int[][] common = new int[words][26];
		for (int w = 0; w < a.length; w++) {
			String word = a[w];
			for (int i = 0; i < word.length(); i++) {
				common[w][word.charAt(i)-'a'] ++;
			}
		}
		for (int i = 0; i < 26; i++) {
			int counter = Integer.MAX_VALUE;
			for (int w = 0; w < a.length; w++) {
				counter = Math.min(counter, common[w][i]);
			}
			if (counter > 0) {
				while (counter -- > 0) {
					res.add(""+(char)(i+'a'));
				}
			}
		}
		
		return res;

	}

	public static void main(String[] arg) {
		
		String[] a = {"bella","label","roller"};
		System.out.println(commonChars(a));

		String[] a1 = {"cool","lock","cook"};
		System.out.println(commonChars(a1));

	}

}
