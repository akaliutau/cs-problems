package org.problems.dp;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/combination-sum-iv/
 * 
 * Given an integer array with all positive numbers and no duplicates, find the
 * number of possible combinations that add up to a positive integer target.
 * 
 * Example:
 * 
 * nums = [1, 2, 3] target = 4
 * 
 * Therefore the output is 4.
 * 
 * 
 * Follow up: What if negative numbers are allowed in the given array? How does
 * it change the problem? What limitation we need to add to the question to
 * allow negative numbers?
 * 
 * 
 */
public class CombinationSumV {

	public static int combinationSum4(int[] nums, int target) {
		
		if (target == 0) {
			return 0;
		}
		int n = nums.length;
		if (n == 0) {
			return -1;
		}
		Arrays.sort(nums);
		
		int[][] combinations = new int[n][target + 1];
		for (int i = 0; i < n; i++) {
			combinations[i][0] = 1;
		}

		for (int j = 1; j <= target; j++) {
			combinations[0][j] = j % nums[0] == 0 ? 1 : 0;
		
			for (int i = 1; i < n; i++) {
				combinations[i][j] = combinations[i-1][j];
				if (j-nums[i] >= 0) {
					combinations[i][j] += combinations[i][j-nums[i]];
				}
			}
		}
		return combinations[n - 1][target];

	}

	public static void main(String[] arg) {
		
		int[] nums = {1, 2, 3};

		System.out.println(combinationSum4(nums, 4));

	}

}
