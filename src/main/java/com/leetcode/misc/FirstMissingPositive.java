package com.leetcode.misc;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/first-missing-positive/
 *
 * Given an unsorted integer array, find the smallest missing positive integer.
 * 
 * Example 1:
 * 
 * Input: [1,2,0] Output: 3
 * 
 * Example 2:
 * 
 * Input: [3,4,-1,1] Output: 2
 * 
 * Example 3:
 * 
 * Input: [7,8,9,11,12] Output: 1
 * 
 * Note: Your algorithm should run in O(n) time and uses constant extra space.
 * 
 */
public class FirstMissingPositive {

	public static int firstMissingPositive(int[] nums) {
		if (nums.length == 0) {
			return 1;
		}

		Arrays.sort(nums);
		int smallest = -1;
		int previous = 0;
		for (int i : nums) {
			if (i > 0) {
				if (previous >= 0 && (i - previous) > 1) {
					smallest = smallest == -1 ? previous + 1 : smallest;
                    break;
				} else {
					previous = i;
				}
			}
		}

		if (smallest < 0) {
			int last = nums[nums.length - 1];
			if (last <= 0) {
				return 1;
			} else {
				return last + 1;
			}
		}

		return smallest;

	}

	public static void main(String[] arg) {

		int[] arr = { 1, 2, 0 };
		System.out.println(firstMissingPositive(arr));

		int[] arr1 = { 3, 4, -1, 1 };
		System.out.println(firstMissingPositive(arr1));

		int[] arr2 = { 7, 8, 9, 11, 12 };
		System.out.println(firstMissingPositive(arr2));

		int[] arr3 = {};
		System.out.println(firstMissingPositive(arr3));

	}

}
