package com.leetcode.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/positions-of-large-groups/
 *
 * In a string S of lowercase letters, these letters form consecutive groups of
 * the same character.
 * 
 * For example, a string like S = "abbxxxxzyy" has the groups "a", "bb", "xxxx",
 * "z" and "yy".
 * 
 * Call a group large if it has 3 or more characters. We would like the starting
 * and ending positions of every large group.
 * 
 * The final answer should be in lexicographic order.
 * 
 * Example 1:
 * Input: "abbxxxxzzy" Output: [[3,6]] 
 * Explanation: "xxxx" is the single large group with starting 3 and ending positions 6. 
 * 
 * Example 2:
 * Input: "abc" Output: [] Explanation: We have "a","b" and "c" but no large group. 
 * 
 * Example 3:
 * 
 * Input: "abcdddeeeeaabbbcd" Output: [[3,5],[6,9],[12,14]]
 * 
 * 
 * Note: 1 <= S.length <= 1000
 * 
 * 
 * 
 */
public class PositionsOfLargeGroups {

	public static List<List<Integer>> largeGroupPositions(String s) {
		
		List<List<Integer>> res = new ArrayList<>();
		int lastChar = -1;
		int left = 0;
		int right = 0;
		for (int i = 0; i < s.length(); i++) {
			int c = s.charAt(i);
			if (c != lastChar) {
				if (right - left >= 2) {
					res.add(Arrays.asList(left,right));
				}
				left = i;
				lastChar = c;
			}
			right = i;
		}
		if (right - left >= 2) {
			res.add(Arrays.asList(left,right));
		}
		
		return res;
        
    }	
	
	public static void main(String[] arg) {

		System.out.println(largeGroupPositions("abbxxxxzzy"));
		System.out.println(largeGroupPositions("abc"));
		System.out.println(largeGroupPositions("abcdddeeeeaabbbcd"));
		System.out.println(largeGroupPositions("aaa"));

	}

}
