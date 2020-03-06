package com.leetcode.arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/missing-number/
 * 
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find
 * the one that is missing from the array.
 * 
 * Example 1:
 * 
 * Input: [3,0,1] Output: 2
 * 
 * 
 * 
 */
public class MissingNumber {

	public static int missingNumber(int[] nums) {
		int n = nums.length;
		if (n == 1) {
			return nums[0] == 0 ? 1 : 0;
		}
		boolean[] map = new boolean[n+1];
		for (int i = 0; i < n; i++) {
			map[nums[i]] = true;
		}
		for (int i = 0; i < n; i++) {
			if (!map[i]) {
				return i;
			}
		}		
		return n;
    }

	public static void main(String[] arg) {

		int[] nums = {3,0,1};
		System.out.println(missingNumber(nums));

		int[] nums1 = {0};
		System.out.println(missingNumber(nums1));


		int[] nums2 = {1};
		System.out.println(missingNumber(nums2));


	}
}
