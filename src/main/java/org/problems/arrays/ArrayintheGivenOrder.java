package org.problems.arrays;

import org.problems.utils.Utils;

/**
 * https://leetcode.com/contest/weekly-contest-181/problems/create-target-array-in-the-given-order/
 * 
 * Given two arrays of integers nums and index. Your task is to create target
 * array under the following rules:
 * 
 * Initially target array is empty. From left to right read nums[i] and
 * index[i], insert at index index[i] the value nums[i] in target array. Repeat
 * the previous step until there are no elements to read in nums and index.
 * Return the target array.
 * 
 * 
 */
public class ArrayintheGivenOrder {

	public static int[] createTargetArray(int[] nums, int[] index) {
		int n = nums.length;
		int[] res = new int[n];
		int curLen = 0;
		for (int i = 0; i < n; i++) {
			int at = index[i];
			if (at < curLen) {
				for (int j = curLen; j >= at; j--) {
					if (j + 1 < n)
						res[j + 1] = res[j];
				}
			}
			res[at] = nums[i];
			curLen++;
		}
		return res;

	}

	public static void main(String[] arg) {

		int[] nums = { 0, 1, 2, 3, 4 };
		int[] index = { 0, 1, 2, 2, 1 };

		Utils.print(createTargetArray(nums, index));
		;

		int[] nums1 = { 1, 2, 3, 4, 0 };
		int[] index1 = { 0, 1, 2, 3, 0 };

		Utils.print(createTargetArray(nums1, index1));
		;

		int[] nums2 = { 1 };
		int[] index2 = { 0 };

		Utils.print(createTargetArray(nums2, index2));
		;

	}

}
