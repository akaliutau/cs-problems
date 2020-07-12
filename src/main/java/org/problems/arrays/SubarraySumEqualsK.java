package org.problems.arrays;

import java.util.List;

/**
 * https://leetcode.com/problems/subarray-sum-equals-k/
 * 
 * 
 * Given an array of integers and an integer k, you need to find the total
 * number of continuous subarrays whose sum equals to k.
 * 
 * Example 1:
 * 
 * Input:nums = [1,1,1], k = 2 Output: 2
 * 
 * 
 * Constraints:
 * 
 * The length of the array is in range [1, 20,000]. The range of numbers in the
 * array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 * 
 * 
 */
public class SubarraySumEqualsK {

	public static int subarraySum(int[] nums, int k) {
		int n = nums.length;
		if (n == 0 && k != 0) {
			return 0;
		}
		if (n == 1) {
			return nums[0] == k ? 1 : 0;
		}
		int count = 0;
		int[] sum = new int[n + 1];
		sum[0] = 0;
		for (int i = 1; i <= n; i++)
			sum[i] = sum[i - 1] + nums[i - 1];
		for (int left = 0; left < n; left++) {
			for (int right = left + 1; right <= n; right++) {
				if (sum[right] - sum[left] == k)
					count++;
			}
		}
		return count;
	}

	public static void main(String[] arg) {

		int[] nums = { 1, 1, 1 };
		System.out.println(subarraySum(nums, 2));

		int[] nums1 = { -1, -1, 1 };
		System.out.println(subarraySum(nums1, 0));

	}

}
