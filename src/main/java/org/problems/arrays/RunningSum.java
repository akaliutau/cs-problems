package org.problems.arrays;

/**
 * https://leetcode.com/problems/running-sum-of-1d-array/
 * 
 * Given an array nums. We define a running sum of an array as runningSum[i] =
 * sum(nums[0]…nums[i]).
 * 
 * Return the running sum of nums.
 * 
 * 
 * 
 */
public class RunningSum {

	public int[] runningSum(int[] nums) {
		int n = nums.length;
		int[] res = new int[n];
		res[0] = nums[0];
		for (int i = 1; i < n; i++) {
			res[i] = res[i - 1] + nums[i];
		}
		return res;
	}

	public static void main(String[] arg) {

		System.out.println(true);

	}

}
