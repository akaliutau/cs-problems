package org.problems.active;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * 
 * 
 */
public class Sol31 {

	static class Interval implements Comparable<Interval> {
		public int left;
		public int right;

		public Interval(int left, int right) {
			this.left = left;
			this.right = right;
		}

		public boolean isIncluded(Interval interval) {
			return left >= interval.left && right <= interval.right;
		}

		public boolean includes(Interval interval) {
			return left <= interval.left && right >= interval.right;
		}

		public boolean isDistinct(Interval interval) {
			return left > interval.right || left < interval.right;
		}

		public int dist() {
			return right - left + 1;
		}

		@Override
		public int compareTo(Interval intr) {
			return Integer.compare(this.dist(), intr.dist());
		}

	}

	/**
	 * find the best [left,right] for each Vowel, if not present - [0,len-1]
	 * 
	 * the best interval must: 1) include ALL other intervals 2) exclude SOME
	 * intervals
	 * 
	 * @param ints
	 * @return -1 if found the best interval or # of faulty interval
	 */

	public static int check(Interval[] ints, Interval best) {
		int fail = -1;

		return fail;

	}

	/**
	 * try to find next best covering interval mutating left and right boundary
	 * 
	 * @param prev
	 * @param s
	 * @param c
	 * @return true if found, else false
	 */
	public static boolean findTheNextBestInterval(Interval prev, String s, char c, int diff) {

		return false;
	}

	public static List<Interval> findAllIntervals(String str, char c) {
		List<Interval> res = new ArrayList<>();
		// calc number of c in str
		int totalChars = 0;
		int n = str.length();
		for (int j = 0; j < n; j++) {
			char ch = str.charAt(j);
			totalChars++;
		}
		
		if (totalChars % 2 == 0) {// add the whole interval
			res.add(new Interval(0, n - 1));
		}
		
		// find 2 initial left and right points
		int left = 0; 
		int right = n-1;
		
		
		// add all empty intervals, which does not include c

		return res;
	}

	public static int findTheLongestSubstring(String s) {
		int total = 0;

		return total;
	}

	public static void main(String[] arg) {

		System.out.println(findTheLongestSubstring("eleetminicoworoep"));// 13
		System.out.println(findTheLongestSubstring("leetcodeisgreat"));// 5
		System.out.println(findTheLongestSubstring("bcbcbc"));// 6

	}

}
