package org.problems.active;

/**
 * https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
 * 
 * Given an array of integers nums and an integer limit, return the size of the
 * longest continuous subarray such that the absolute difference between any two
 * elements is less than or equal to limit. In case there is no subarray
 * satisfying the given condition return 0.
 * 
 */
public class LongestContinuousSubarrayWithLimit {
	
	static class Interval {
		public int left;
		public int right;
		public int min;
		public int max;
		public int limit;
		public int maxLength;
		
		public int getRange() {
			return max - min;
		}
		
		public boolean outOfRange(int elem) {
			return (Math.abs(elem - min) > limit || Math.abs(elem - max) > limit);
		}
		
		public void updateRange(int elem) {
			min = Math.min(min, elem);
			max = Math.max(max, elem);
			if (getRange() <= limit) {
				maxLength = Math.max(maxLength, length());
			}
		}
		
		public int length() {
			return right - left;
		}

		@Override
		public String toString() {
			return "Interval [left=" + left + ", right=" + right + ", min=" + min + ", max=" + max + "]";
		}
	}
	
	// return left >= 0 such that all elems in range [left,right] in limit
	// do not change interval.right
	// update interval.left
	// update interval.min
	// update interval.max
	static void backtrace(int[] a, Interval interval, int limit) {
		interval.left = interval.right;
		int elem = a[interval.left];
		interval.min = elem;
		interval.max = elem;
		while (interval.left >= 0 && !interval.outOfRange(elem)) {
			interval.updateRange(elem);
			elem = a[interval.left--];
		}
		interval.left ++;// will stop on the latest valid elem
	}
	
	public static int longestSubarray(int[] a, int limit) {
		int n = a.length;
		Interval interval = new Interval();
		interval.left = 0;
		interval.right = 0;
		interval.min = a[0];
		interval.max = a[0];
		interval.limit = limit;
		
		int val = a[0];
		boolean eq = true;
		for (int i = 0; i < n; i++) {
			if (val != a[i]) {
				eq = false;
				break;
			}
		}
		if (eq) {
			return n;
		}

		int maxLen = 0;
		while (interval.right < n) {
			int elem = a[interval.right];
			maxLen = Math.max(maxLen, interval.length());
			if (interval.outOfRange(elem)) {
				backtrace(a, interval, limit);
			}else {
				interval.updateRange(elem);
			}
			interval.right ++;
		}
		return interval.maxLength;
	}

	/**
	 * Brute force
	 * @param a
	 * @param limit
	 * @return
	 */
	public static int longestSubarray2(int[] a, int limit) {

		int len = 0, n = a.length;

		int val = a[0];
		boolean eq = true;
		for (int i = 0; i < n; i++) {
			if (val != a[i]) {
				eq = false;
				break;
			}
		}
		if (eq) {
			return n;
		}

		for (int i = 0; i < n; i++) {
			int min = a[i], max = a[i], ln = 1;
			for (int j = i; j < n; j++) {
				if (a[j] < min) {
					min = a[j];
				}
				if (a[j] > max) {
					max = a[j];
				}
				if (max - min <= limit) {
					ln = j - i + 1;
				} else {
					break;
				}
			}
			if (ln > len) {
				len = ln;
			}
		}
		return len;
	}

	public static void main(String[] arg) {

		int[] nums = { 8, 2, 4, 7 };
		System.out.println(longestSubarray(nums, 4));//2
		System.out.println(longestSubarray2(nums, 4));//2

		int[] nums1 = { 10, 1, 2, 4, 7, 2 };
		System.out.println(longestSubarray(nums1, 5));// 4
		System.out.println(longestSubarray2(nums1, 5));// 4

		int[] nums2 = { 4, 2, 2, 2, 4, 4, 2, 2 };
		System.out.println(longestSubarray(nums2, 0));// 3
		System.out.println(longestSubarray2(nums2, 0));// 3

		int[] nums3 = { 8, 2 };
		System.out.println(longestSubarray(nums3, 2));//1
		System.out.println(longestSubarray2(nums3, 2));//1

		int[] nums4 = { 1, 1, 1};
		System.out.println(longestSubarray(nums4, 2));//1
		System.out.println(longestSubarray2(nums4, 2));//1
		
		int[] nums5 = { 1, 1, 1, 4, 5,3, 6,5,5,5, 3, 7, 8, 9,4, 3,2,2,2,5 ,6, 7, 7, 7, 8};
		System.out.println(longestSubarray(nums5, 7));//1
		System.out.println(longestSubarray2(nums5, 7));//1


	}

}
