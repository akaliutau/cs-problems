package org.problems.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/
 * 
 * Given a binary array nums, you should delete one element from it.
 * 
 * Return the size of the longest non-empty subarray containing only 1's in the
 * resulting array.
 * 
 * Return 0 if there is no such subarray.
 * 
 * Example 1:
 * 
 * Input: nums = [1,1,0,1] Output: 3 
 * Explanation: After deleting the number in
 * position 2, [1,1,1] contains 3 numbers with value of 1's.
 * 
 */
public class LongestSubarrayOf1s {

	static class Segment {
		public int val;
		public int len;

		public Segment(int val, int len) {
			this.val = val;
			this.len = len;
		}

		@Override
		public String toString() {
			return "Segment [val=" + val + ", len=" + len + "]";
		}

	}

	public int longestSubarray(int[] nums) {

		int n = nums.length;
		List<Segment> segms = new ArrayList<>();

		int prev = nums[0];
		Segment s = new Segment(prev, 1);

		for (int i = 1; i < n; i++) {
			if (nums[i] == s.val) {
				s.len++;
			} else {
				segms.add(s);
				s = new Segment(nums[i], 1);
			}
		}
		segms.add(s);
		int len = segms.size();
		if (len == 0) {
			return 0;
		}
		if (len == 1) {
			return segms.get(0).val == 1 ? segms.get(0).len - 1 : 0;
		}
		if (len < 3) {
			if (segms.get(0).val == 1) {
				return segms.get(0).len;
			} else {
				return segms.get(1).len;
			}
		}
		int idx = 0;
		while (segms.get(idx).val == 0 && idx < len) {
			idx++;
		}
		int max = 0;
		System.out.println(segms);
		for (int i = idx; i < len - 2; i += 2) {
			max = Math.max(max, Math.max(segms.get(i).len, segms.get(i + 2).len));
			int ln = segms.get(i).len + segms.get(i + 2).len;
			if (segms.get(i + 1).len == 1) {
				max = Math.max(ln, max);
			}
		}

		return max;

	}

	public static void main(String[] arg) {

		System.out.println(true);

	}

}
