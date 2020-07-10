package org.problems.arrays;

/**
 * https://leetcode.com/problems/find-pivot-index/
 * 
 * Given an array of integers nums, write a method that returns the "pivot"
 * index of this array.
 * 
 * We define the pivot index as the index where the sum of all the numbers to
 * the left of the index is equal to the sum of all the numbers to the right of
 * the index.
 * 
 * If no such index exists, we should return -1. If there are multiple pivot
 * indexes, you should return the left-most pivot index.
 * 
 * Example 1:
 * 
 * Input: nums = [1,7,3,6,5,6] Output: 3 
 * Explanation: The sum of the numbers to
 * the left of index 3 (nums[3] = 6) is equal to the sum of numbers to the right
 * of index 3. Also, 3 is the first index where this occurs. 
 * 
 * Example 2:
 * 
 * Input: nums = [1,2,3] Output: -1 
 * Explanation: There is no index that
 * satisfies the conditions in the problem statement.
 * 
 * 
 * Constraints:
 * 
 * The length of nums will be in the range [0, 10000]. 
 * Each element nums[i] will be an integer in the range [-1000, 1000].
 */
public class FindPivotIndex {

	public static int pivotIndex(int[] nums) {
		int n = nums.length;
		long[] sum = new long[n];
		if (n == 0) {
			return -1; 
		}
		if (n == 1) {
			return 1; 
		}
		sum[0] = nums[0];
		for (int i = 1; i < n; i++) {
			sum[i] = sum[i - 1] + nums[i];
		}
		for (int i = 0; i < n; i++) {
			long left = i == 0 ? 0 : sum[i - 1];
			long right = i == n - 1 ? 0 : sum[n - 1] - sum[i];
			if (left == right) {
				return i;
			}
		}
		
		return -1;

	}

	public static void main(String[] arg) {

		int[] nums = {1,7,3,6,5,6};
		System.out.println(pivotIndex(nums));

		int[] nums1 = {1,2,3};
		System.out.println(pivotIndex(nums1));

	}

}
