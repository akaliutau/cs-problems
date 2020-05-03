package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/largest-divisible-subset/
 * 
 * Given a set of distinct positive integers, find the largest subset such that
 * every pair (Si, Sj) of elements in this subset satisfies:
 * 
 * Si % Sj = 0 or Sj % Si = 0.
 * 
 * If there are multiple solutions, return any subset is fine.
 * 
 * Example 1:
 * 
 * Input: [1,2,3] Output: [1,2] (of course, [1,3] will also be ok)
 * 
 * Example 2:
 * 
 * Input: [1,2,4,8] Output: [1,2,4,8]
 * 
 * 
 */
public class LargestDivSubset {

	public static List<Integer> largestDivisibleSubset(int[] nums) {

		int n = nums.length;
		List<Integer> res = new ArrayList<>();
		Arrays.sort(nums);

		int[] dp = new int[n];
		Arrays.fill(dp, 1);
		dp[0] = 1;
		int[] latest = new int[n];
		Arrays.fill(latest, -1);
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] % nums[j] == 0) {
					if (dp[j] + 1 > dp[i]) {
						dp[i] = dp[j] + 1;
						latest[i] = j;
					}
				}
			}
		}

		int idx = -1;
		int max = 0;
		for (int i = 0; i < n; i++) {
			if (dp[i] > max) {
				max = dp[i];
				idx = i;
			}
		}

		while (idx >= 0) {
			res.add(nums[idx]);
			idx = latest[idx];
		}
		return res;

	}

	public static void main(String[] arg) {
		int[] nums = { 1, 2, 3 };
		System.out.println(largestDivisibleSubset(nums));

		int[] nums1 = { 1, 2, 4, 8 };
		System.out.println(largestDivisibleSubset(nums1));

		int[] nums2 = { 3, 4, 16, 8 };
		System.out.println(largestDivisibleSubset(nums2));

		int[] nums3 = { 2, 3, 4, 8 };
		System.out.println(largestDivisibleSubset(nums3));

		int[] nums4 = { 4, 8, 10, 240 };
		System.out.println(largestDivisibleSubset(nums4));

		int[] nums5 = { 1, 5, 7, 57, 3, 4, 6, 8, 12, 16, 32 };
		System.out.println(largestDivisibleSubset(nums5));

		int[] nums6 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 29, 20, 21, 22, 23, 24, 25, 26,
				27, 28, 210, 240 };
		System.out.println(largestDivisibleSubset(nums6));

		int[] nums7 = { 4, 8, 10, 240 };
		System.out.println(largestDivisibleSubset(nums7));
	}

}
