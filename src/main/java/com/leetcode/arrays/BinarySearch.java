package com.leetcode.arrays;

/**
 * https://leetcode.com/problems/binary-search/
 *
 * Given a sorted (in ascending order) integer array nums of n elements and a
 * target value, write a function to search target in nums. If target exists,
 * then return its index, otherwise return -1.
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [-1,0,3,5,9,12], target = 9 Output: 4 
 * Explanation: 9 exists in
 * nums and its index is 4
 *
 * [-1,0,3,5,9,12]
 *     |     |
 *   left   right
 */
public class BinarySearch {

	public static int search(int[] nums, int target) {
		boolean found = false;
		int left = 0;
		int right = nums.length-1;
		int mid = 0;
		
		if (nums[right] == target) {
			return right;
		}else if (nums[right] < target || nums[0] > target) {
			return -1;
		}
		
		if (right == 0) {
			return nums[0] == target ? 0 : -1;
		}
		
		while (!found) {
			mid = (left + right)/2;// always mid < right
			if (nums[mid] <= target && target < nums[mid+1]) {
				found = true;
			}
			if (nums[mid] > target) {
				right = mid;
			}else {
				left = mid;
			}
		}

		return nums[mid] == target ? mid: -1;

	}

	public static void main(String[] arg) {

		int[] arr = {-1,0,3,5,9,12};
		System.out.println(search(arr,4));
		System.out.println(search(arr,12));
		System.out.println(search(arr,5));

		int[] arr1 = {5};
		System.out.println(search(arr1,-5));

		int[] arr2 = {2,5};
		System.out.println(search(arr2,-5));

	}

}
