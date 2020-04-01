package com.leetcode.arrays;

import com.leetcode.utils.Utils;

/**
 * https://leetcode.com/problems/move-zeroes/
 *
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 * 
 * Example:
 * 
 * Input: [0,1,0,3,12] Output: [1,3,12,0,0]
 * 
 * Note:
 * 
 * You must do this in-place without making a copy of the array. Minimize the
 * total number of operations
 */
public class MoveZeroes {

	static void swap(int i, int j, int[] nums) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}

	public static void moveZeroes(int[] nums) {
		int pos = 0;
		int n = nums.length;
		if (n < 2) {
			return;
		}
		while (pos < n) {
			int i = pos;
			while (i < n) {
				if (nums[i] != 0) {
					break;
				}
				i++;
			}
			if (i == n) {
				return;
			}
			swap(pos, i, nums);
			pos++;
		}

	}

	public static void main(String[] arg) {
		int[] nums = { 0, 1, 0, 3, 12 };
		moveZeroes(nums);
		Utils.print(nums);

		int[] nums1 = { 0, 0, 0 };
		moveZeroes(nums1);
		Utils.print(nums1);

		int[] nums2 = { 0, 0, 1 };
		moveZeroes(nums2);
		Utils.print(nums2);
	}
}
