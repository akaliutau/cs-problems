package org.problems.minmax;

import java.util.ArrayList;
import java.util.List;

import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/shortest-distance-to-a-character/
 * 
 * Given a string S and a character C, return an array of integers representing
 * the shortest distance from the character C in the string.
 * 
 * Example 1:
 * 
 * Input: S = "loveleetcode", C = 'e' 
 * Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 * 
 * Note:
 * 
 * S string length is in [1, 10000].
 * C is a single character, and guaranteed to be in string S. 
 * All letters in S and C are lowercase.
 * 
 */
public class ShortestDistance {
	
	static class Holder {
		public List<Integer> pos = new ArrayList<>();
	}

	public static int[] shortestToChar(String s, char c) {
		int n = s.length();
		int[] res = new int[n];
		Holder[] letters = new Holder[26];
		for (int i = 0; i < 26; i++) {
			letters[i] = new Holder();
		}
		
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == c) {
				letters[s.charAt(i) - 'a'].pos.add(i);
			}
		}
		List<Integer> positions = letters[c - 'a'].pos;
		for (int i = 0; i < n; i++) {
			int min = n;
			for (Integer pos : positions) {
				int next = Math.min(min, Math.abs(pos - i));
				if (next > min) {
					break;
				}
				min = next;
			}
			res[i] = min;
		}
		return res;

	}

	public static void main(String[] arg) {

		Utils.print(shortestToChar("loveleetcode", 'c'));

	}

}
