package com.leetcode.arrays;

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted
 * 
 * Runtime: 8 ms, faster than 42.72% of Java online submissions for Two Sum.
 * Memory Usage: 41.7 MB, less than 5.65% of Java online submissions for Two Sum
 */
public class TwoSumII {

	public static int[] twoSum(int[] nums, int target) {
		for (int left = 0; left < nums.length; left++) {
			int sLeft = nums[left];
			for (int right = left + 1; right < nums.length; right++) {
				int sum = sLeft + nums[right];

				if (sum == target) {
					return new int[] { left, right };
				} else if (sum > target) {
					break;
				}
			}
		}
		return null;

	}

	public static void main(String[] arg) {

		int[] input = { 2, 7, 11, 15 };
		int target = 9;
		int[] res = twoSum(input, target);
		for (int i : res) {
			System.out.println(i);
		}

		int[] input1 = { 2, 3, 4 };
		int target1 = 6;
		int[] res1 = twoSum(input1, target1);
		for (int i : res1) {
			System.out.println(i);
		}

	}

}
