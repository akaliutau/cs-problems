package org.problems.favourite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Substrings finder
 * 
 * Given a string S of lowercase letters, you need to find as many as substrings
 * from the S that meets these conditions 1) no overlap 2) one letter can only
 * exist in one substring; for letter 'c' all occurrences also must be in that
 * substring 3) as many substrings as possible 4) if there are 2 solutions,
 * return the set with the smallest total length
 * 
 * Example s = "bbeadcxede"
 * 
 * ["bb", "a", "c", "x"]
 * 
 * s = "baddacxb"
 * 
 * ["dd", "c", "x"]
 * 
 */
public class NonOverlappingStrings {

	static class Interval {
		int l, r;

		public Interval(int l, int r) {
			this.l = l;
			this.r = r;
		}
	}

	public static List<String> maxNumOfSubstrings(String s) {
		int n = s.length();
		List<String> res = new ArrayList<>();
		int[] start = new int[26];
		int[] end = new int[26];

		Arrays.fill(start, Integer.MAX_VALUE);
		Arrays.fill(end, Integer.MIN_VALUE);

		for (int i = 0; i < n; i++) {
			start[s.charAt(i) - 'a'] = Math.min(start[s.charAt(i) - 'a'], i);
			end[s.charAt(i) - 'a'] = Math.max(end[s.charAt(i) - 'a'], i);
		}

		List<Interval> intervals = new ArrayList<>();

		for (int i = 0; i < 26; i++) {
			if (start[i] == Integer.MAX_VALUE) {
				continue;
			}
			int left = start[i], right = end[i];
			boolean valid = true;
			for (int j = left + 1; j < right; j++) {
				if (start[s.charAt(j) - 'a'] < left) {
					valid = false;
					break;
				}
				right = Math.max(right, end[s.charAt(j) - 'a']);
			}
			if (valid) {
				intervals.add(new Interval(left, right));
			}
		}

		Collections.sort(intervals, (o, p) -> Integer.compare(o.r - o.l, p.r - p.l));

		int len = intervals.size();
		boolean[] valid = new boolean[len];
		Arrays.fill(valid, true);

		for (int i = 0; i < len; i++) {
			if (!valid[i]) {
				continue;
			}
			for (int j = i + 1; j < len; j++) {
				if (intervals.get(j).l <= intervals.get(i).l && intervals.get(i).r <= intervals.get(j).r) {
					valid[j] = false;
				}
			}
		}
		for (int i = 0; i < len; i++) {
			if (valid[i]) {
				res.add(s.substring(intervals.get(i).l, intervals.get(i).r + 1));
			}
		}
		return res;
	}

	public static void main(String[] arg) {
		System.out.println(maxNumOfSubstrings("bbeadcxede"));
		System.out.println(maxNumOfSubstrings("baddacxb"));
	}

}
