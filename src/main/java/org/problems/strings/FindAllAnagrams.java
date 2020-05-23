package org.problems.strings;

import java.util.ArrayList;
import java.util.List;

import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/ Given a string s
 * and a non-empty string p, find all the start indices of p's anagrams in s.
 * 
 * Strings consists of lowercase English letters only and the length of both
 * strings s and p will not be larger than 20,100.
 * 
 * The order of output does not matter.
 * 
 * Example 1:
 * 
 * Input: s: "cbaebabacd" p: "abc"
 * Output: [0, 6]
 * 
 * Explanation: The substring with start index = 0 is "cba", which is an anagram
 * of "abc". The substring with start index = 6 is "bac", which is an anagram of
 * "abc". 
 * 
 * Example 2:
 * 
 * Input: s: "abab" p: "ab"
 * Output: [0, 1, 2]
 * 
 * Explanation: The substring with start index = 0 is "ab", which is an anagram
 * of "ab". The substring with start index = 1 is "ba", which is an anagram of
 * "ab". The substring with start index = 2 is "ab", which is an anagram of
 * "ab".
 *
 */
public class FindAllAnagrams {
	
	/**
	 * Returns 26-numbers vector generated from the string
	 * @param p
	 * @return
	 */
	public static int[] getPattern(String s) {
		int[] vector = new int[26];
		for (int i = 0; i < s.length(); i++) {
			vector[s.charAt(i) - 'a'] ++;
		}		
		return vector;
	}
	
	public static int[] getPattern(int[][] freq, int from, int to) {
		int[] vector = new int[26];
		for (int i = 0; i < 26; i++) {
			if (from  == 0) {
				vector[i] = freq[i][to];
			}else {
				vector[i] = freq[i][to] - freq[i][from-1];
			}
		}	
		return vector;
	}
	
	public static boolean getPattern(int[] p1, int[] p2) {
		for (int i = 0; i < 26; i++) {
			if (p1[i] != p2[i]) {
				return false;
			}
		}
		return true;
	}	
	
	public static List<Integer> findAnagrams(String s, String p) {
		List<Integer> res = new ArrayList<>();
		// build a frequency table 26x26 for all symbols in s
		int n = s.length();
		if (n == 0) {
			return res;
		}
		int[][] freq = new int[26][n+1];
		for (int i = 0; i < n; i++) {
			int code = s.charAt(i) - 'a';
			for (int j = 0; j < 26; j++) {
				int prev = i == 0 ? 0 : freq[j][i-1];
				if (code == j) {
					prev ++;
				}
				freq[j][i] = prev;
			}
		}
		for (int j = 0; j < 26; j++) {
			freq[j][n] = freq[j][n-1];
		}
		Utils.print(freq);
		
		// find matching hist patterns
		int[] pattern = getPattern(p);
		System.out.println("pattern:");
		Utils.print(pattern);

		for (int i = 0; i <= n - p.length(); i++) {
			int[] matcher = getPattern(freq,i,i+p.length()-1);
			if (getPattern(pattern,matcher)) {
				res.add(i);
			}
			
		}
		return res;
     }

	public static void main(String[] arg) {

		System.out.println(findAnagrams("cbaebabacd","abc"));
		System.out.println(findAnagrams("abab","ab"));

		System.out.println(findAnagrams("","abc"));


	}
}
