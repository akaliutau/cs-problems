package org.problems.arrays;

/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 * 
 * Given an array of n positive integers and a positive integer s, find the
 * minimal length of a contiguous subarray of which the sum ≥ s. If there isn't
 * one, return 0 instead.
 * 
 * Example:
 * 
 * Input: s = 7, nums = [2,3,1,2,4,3] Output: 2 Explanation: the subarray [4,3]
 * has the minimal length under the problem constraint.
 * 
 * 
 */
public class MinimumSizeSubarraySum {

	public static int minSubArrayLen(int s, int[] nums) {
		int n = nums.length;
		int len = Integer.MAX_VALUE;
		int left = 0;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += nums[i];
			while (sum >= s) {
				len = Math.min(len, i + 1 - left);
				sum -= nums[left++];
			}
		}
		return (len != Integer.MAX_VALUE) ? len : 0;
	}

	public static void main(String[] arg) {

		int[] nums = { 2, 3, 1, 2, 4, 3 };

		System.out.println(minSubArrayLen(7, nums));

	}

}
