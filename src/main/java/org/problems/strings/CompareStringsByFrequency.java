package org.problems.strings;

import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/compare-strings-by-frequency-of-the-smallest-character/
 *
 * Let's define a function f(s) over a non-empty string s, which calculates the
 * frequency of the smallest character in s. For example, if s = "dcce" then
 * f(s) = 2 because the smallest character is "c" and its frequency is 2.
 * 
 * Now, given string arrays queries and words, return an integer array answer,
 * where each answer[i] is the number of words such that f(queries[i]) < f(W),
 * where W is a word in words.
 * 
 * Example 1:
 * 
 * Input: queries = ["cbd"], words = ["zaaaz"] Output: [1] 
 * 
 * Explanation: On the
 * first query we have f("cbd") = 1, f("zaaaz") = 3 so f("cbd") < f("zaaaz").
 * 
 * Example 2:
 * 
 * Input: queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"] Output: [1,2]
 * Explanation: On the first query only f("bbb") < f("aaaa"). On the second
 * query both f("aaa") and f("aaaa") are both > f("cc").
 * 
 * 
 * Constraints:
 * 
 * 1 <= queries.length <= 2000 
 * 1 <= words.length <= 2000 
 * 1 <= queries[i].length, words[i].length <= 10 
 * queries[i][j], words[i][j] are English lowercase letters
 * 
 * 
 */
public class CompareStringsByFrequency {
	
	public static int freq(String word) {
		if (word.length() == 0) {
			return 0;
		}
		int[] map = new int[26];
		for (int i = 0; i < word.length(); i++) {
			map[(int)(word.charAt(i)-'a')]++;
		}
		for (int i = 0; i < 26; i++) {
			if (map[i] > 0) {
				return map[i];
			}
		}
		return 0;
	}

	public static int[] numSmallerByFrequency(String[] queries, String[] words) {
		
		int w = words.length;
		int[] freqMap = new int[w];
		int idx = 0;
		for (String word : words) {
			freqMap[idx++] = freq(word);
		}
		int n = queries.length;
		int[] res = new int[n];
		idx = 0;
		for (String q : queries) {
			int f = freq(q);
			for (int i = 0; i < w; i++) {
				if (f < freqMap[i]) {
					res[idx]++;
				}
			}
			idx++;
		}
		return res;

	}

	public static void main(String[] arg) {
		
		String[] queries = {"cbd"};
		String[] words = {"zaaaz"};
		Utils.print(numSmallerByFrequency(queries, words));

		String[] queries1 = {"bbb","cc"};
		String[] words1 = {"a","aa","aaa","aaaa"};
		Utils.print(numSmallerByFrequency(queries1, words1));

	}
}
