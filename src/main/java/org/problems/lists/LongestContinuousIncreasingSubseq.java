package org.problems.lists;

/**
 * https://leetcode.com/problems/longest-continuous-increasing-subsequence/
 * 
 * Given an unsorted array of integers, find the length of longest continuous
 * increasing subsequence (subarray).
 * 
 * Example 1: Input: [1,3,5,4,7] Output: 3 
 * Explanation: The longest continuous
 * increasing subsequence is [1,3,5], its length is 3. Even though [1,3,5,7] is
 * also an increasing subsequence, it's not a continuous one where 5 and 7 are
 * separated by 4. 
 * 
 * Example 2: Input: [2,2,2,2,2] Output: 1 
 * 
 * Explanation: The
 * longest continuous increasing subsequence is [2], its length is 1.
 * 
 * 
 * 
 */
public class LongestContinuousIncreasingSubseq {

	public static int findLengthOfLCIS(int[] nums) {
		int n = nums.length;
		if (n <= 1) {
			return n;
		}
		int maxLen = 1;
		int len = 1;

		for (int i = 1; i < n; i++) {
			if (nums[i] > nums[i-1]) {
				len ++;
			}else {
				maxLen = Math.max(maxLen, len);
				len = 1;
			}
		}
		maxLen = Math.max(maxLen, len);
		return maxLen;

	}

	public static void main(String[] arg) {

		int[] nums = {1,3,5,4,7};
		System.out.println(findLengthOfLCIS(nums));

		int[] nums1 = {2,2,2,2,2};
		System.out.println(findLengthOfLCIS(nums1));

	}

}
