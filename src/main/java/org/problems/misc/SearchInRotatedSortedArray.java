package org.problems.misc;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * 
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * 
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in
 * Rotated Sorted Array. Memory Usage: 37.9 MB, less than 47.17% of Java online
 * submissions for Search in Rotated Sorted Array.
 */
public class SearchInRotatedSortedArray {


	public static int findOn(int[] nums, int left, int right, int tgt) {
		int central = (right + left) / 2;
		if (nums[central] == tgt) {
			return central;
		}
		if (left == right) {
			return -1;
		}
		if (left + 1 == right) {
            return nums[right] == tgt ? right : -1;
		}

		if (nums[left] < nums[right]) {
			if (tgt < nums[left] || tgt > nums[right]) {
				return -1;
			}
			return tgt < nums[central] ? findOn(nums, left, central, tgt) : findOn(nums, central, right, tgt);
		} else {
			int res1 = findOn(nums, left, central, tgt);
			int res2 = findOn(nums, central, right, tgt);
			return res1 == -1 ? res2 : res1;
		}
	}

	public static int search(int[] nums, int target) {
		if (nums.length == 0) {
			return -1;
		}
		return findOn(nums, 0, nums.length - 1, target);
	}

	public static void main(String[] arg) {

		int[] nums = { 4, 5, 6, 7, 0, 1, 2 };

		System.out.println(search(nums, 6));

		int[] nums1 = { 4 };

		System.out.println(search(nums1, 6));

		int[] nums2 = { 5 };

		System.out.println(search(nums2, 5));

		int[] nums3 = {};

		System.out.println(search(nums3, 3));

	}
}
