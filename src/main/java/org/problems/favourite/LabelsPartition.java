package org.problems.favourite;

import java.util.LinkedList;
import java.util.List;

/**
 * A string S of lowercase English letters is given. We want to partition this
 * string into as many parts as possible so that each letter appears in at most
 * one part, and return a list of integers representing the size of these parts.
 * 
 * Example 1:
 * 
 * Input: S = "ababcbacadefegdehijhklij" Output: [9,7,8]
 * 
 * Explanation: The partition is "ababcbaca", "defegde", "hijhklij". This is a
 * partition so that each letter appears in at most one part. A partition like
 * "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less
 * parts.
 * 
 * 
 * Note:
 * 
 * S will have length in range [1, 500]. S will consist of lowercase English
 * letters ('a' to 'z') only.
 * 
 * 
 */
public class LabelsPartition {

	public static List<Integer> partitionLabels(String s) {
		int[] letterLastSeenAt = new int[26];
		int n = s.length();
		for (int i = 0; i < n; i++) {
		    letterLastSeenAt[s.charAt(i) - 'a'] = i;
		}

		int end = 0;
		int start = 0;
		List<Integer> result = new LinkedList<>();
		for (int i = 0; i < n; i++) {
		    char cur = s.charAt(i);
			if (letterLastSeenAt[cur - 'a'] > end) {
			    end = letterLastSeenAt[cur - 'a'];// max{All ends for letters met so far}
			}
			if (i == end) {// move until cur letter is the last one from group/block
				result.add(i - start + 1);
				start = i + 1;
			}
		}

		return result;

	}

	public static void main(String[] arg) {
		System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
	}

}
