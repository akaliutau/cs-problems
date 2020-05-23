package org.problems.minmax;

import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/
 * 
 * Given an array of integers nums, you start with an initial positive value
 * startValue.
 * 
 * In each iteration, you calculate the step by step sum of startValue plus
 * elements in nums (from left to right).
 * 
 * Return the minimum positive value of startValue such that the step by step
 * sum is never less than 1.
 * 
 * Example 1:
 * 
 * Input: nums = [-3,2,-3,4,2] Output: 5 
 * 
 * Explanation: If you choose startValue =
 * 4, in the third iteration your step by step sum is less than 1. step by step
 * sum startValue = 4 | startValue = 5 | nums (4 -3 ) = 1 | (5 -3 ) = 2 | -3 (1
 * +2 ) = 3 | (2 +2 ) = 4 | 2 (3 -3 ) = 0 | (4 -3 ) = 1 | -3 (0 +4 ) = 4 | (1 +4
 * ) = 5 | 4 (4 +2 ) = 6 | (5 +2 ) = 7 | 2
 * 
 */
public class MinStepByStepSum {

	public static int minStartValue(int[] nums) {
		int n = nums.length;
		int[] sum = new int[n];
		sum[0] = nums[0];
		int min = nums[0];
		int min1 = nums[0];
		for (int i = 1; i < n; i++) {
			sum[i] = sum[i - 1] + nums[i];
			if (min > sum[i]) {
				min = sum[i];
			}
			if (min1 > nums[i]) {
				min1 = nums[i];
			}
		}
		if (min < 0) {
			return 1 - min;
		}
		if (min1 < 0) {
			return nums[0] < 0 ? 1 - nums[0] : 1;
		}
		return min1;

	}

	public static void main(String[] arg) {

		int[] nums = { 1, 2 };
		System.out.println(minStartValue(nums));

		int[] nums1 = { 1, -2, -3 };
		System.out.println(minStartValue(nums1));

		int[] nums2 = { 2, 3, 5, -5, -1 };
		System.out.println(minStartValue(nums2));

		int[] nums3 = { -3, 6, 2, 5, 8, 6 };
		System.out.println(minStartValue(nums3));

		int[] nums4 = { -9, 12, -10, 2, 8, 10, -11 };
		System.out.println(minStartValue(nums4));

	}

}
