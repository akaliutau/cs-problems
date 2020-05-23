package org.problems.arrays;

/**
 * https://leetcode.com/problems/search-insert-position
 * 
 * Given a sorted array and a target value, return the index if the target is
 * found. If not, return the index where it would be if it were inserted in
 * order.
 * 
 * You may assume no duplicates in the array.
 * 
 */

public class SearchInsertPosition {

	public static int searchInsert(int[] nums, int target) {
		int idx = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target) {
				return i;
			}
			if (nums[i] > target && idx == -1) {
				idx = i;
			}
		}
		return idx == -1 ? nums.length : idx;
	}

	public static void main(String[] arg) {

		int[] nums1 = { 1, 3, 5, 6 };
		System.out.println(searchInsert(nums1, 5));

		int[] nums2 = { 1, 3, 5, 6 };
		System.out.println(searchInsert(nums2, 2));

		int[] nums3 = { 1, 3, 5, 6 };
		System.out.println(searchInsert(nums3, 7));

		int[] nums4 = { 1, 3, 5, 6 };
		System.out.println(searchInsert(nums4, 0));

		int[] nums5 = { 1, 3, 5, 6 };
		System.out.println(searchInsert(nums5, 7));

		int[] nums6 = {};
		System.out.println(searchInsert(nums6, 7));

		int[] nums7 = { 1 };
		System.out.println(searchInsert(nums7, 7));

	}
}
