package org.problems.minmax;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/
 * 
 * Given an array nums, you are allowed to choose one element of nums and change
 * it by any value in one move.
 * 
 * Return the minimum difference between the largest and smallest value of nums
 * after perfoming at most 3 moves.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [5,3,2,4] Output: 0 
 * Explanation: Change the array [5,3,2,4] to
 * [2,2,2,2]. The difference between the maximum and minimum is 2-2 = 0.
 * 
 */
public class MinimumDifference {

	public static int minDifference(int[] nums) {
		int n = nums.length;
		if (n < 4) {
			return 0;
		}
		Arrays.parallelSort(nums);
		int[] var = new int[6];
		var[0] = nums[n - 4] - nums[0];
		var[1] = nums[n - 3] - nums[1];
		var[2] = nums[n - 2] - nums[2];
		var[3] = nums[n - 1] - nums[3];
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 4; i++) {
			min = Math.min(min, var[i]);
		}

		return min;
	}

	public static void main(String[] arg) {
		
		int[] nums = {5,3,2,4};
		System.out.println(minDifference(nums));
	}

}
