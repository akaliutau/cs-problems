package org.problems.arrays;

/**
 * Given an array of integers nums, find the maximum product of subarray.
 * 
 * A subarray of an array is a consecutive sequence of zero or more values taken
 * out of that array.
 * 
 * Example 1:
 * 
 * Input: nums = [1,-2,-3,4] Output: 24 
 * Explanation: The array nums already has a positive product of 24.
 * 
 * 
 */
public class MaximumProduct {

	static int maxSubnumsayProd(int arr[]) {
		int n = arr.length;
		int res = arr[0];

		int max = arr[0];
		int min = arr[0];

		for (int i = 1; i < n; i++) {

			int cur = arr[i];
			int nextMax = max * cur;
			int nextMin = min * cur;

			max = Math.max(Math.max(nextMax, nextMin), cur);
			min = Math.min(Math.min(nextMax, nextMin), cur);

			res = Math.max(res, max);
		}
		return res;
	}

	public int getMaxLen(int[] nums) {
		return 0;
	}

	public static void main(String[] arg) {

		int arr[] = { 0, 1, -2, -3, -4 };
		System.out.println(maxSubnumsayProd(arr));

		int arr1[] = { 1, -2, -3, 4 };
		System.out.println(maxSubnumsayProd(arr1));
}

}
