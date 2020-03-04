package com.leetcode.misc;

import com.leetcode.utils.Utils;

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * Given an array of integers nums sorted in ascending order, find the starting
 * and ending position of a given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * Example 1:
 * 
 * Input: nums = [5,7,7,8,8,10], target = 8 
 * 
 *  0 1 2 3 4 5 
 * 
 * [5,7,7,8,8,10]
 * 
 * choose choose 
 * right left 
 * 
 * [0,5]
 * -1					
 * [0,2],		 		[3,5]
 * -1		-1			 		
 * [0,0], [1,2] 		 [3,3], [4,5]
 * -1		-1		-1						-1
 * [0,0], [1,1], [2,2]  	[3,3], [4,4], [5,5]
 * 
 * 
 * Output: [3,4]
 * 
 */
public class FirstnLastPosition {
	
	/**
	 * Check [left, right]
	 * @param nums
	 * @param target
	 * @param result
	 */
	public static void search(int[] nums, int left, int right, int target, int[] result) {
		if (left >= right) {
			if (nums[left] == target) {
				if (result[0] > left) {
					result[0] = left;
				}
				if (result[1] < left) {
					result[1] = left;
				}
			}
			return;
		}
		int center = (left + right - 1) / 2;
		search(nums,left,center,target,result);
		search(nums,center+1,right,target,result);
	}

	public static int[] searchRange(int[] nums, int target) {
		int[] res = new int[2];
		res[0] = nums.length;
		res[1] = -1;
		if (nums.length > 0) {
			search(nums,0,nums.length-1,target,res);
		}else {
			res[0] = -1;
			res[1] = -1;
		}
		if (res[0] == nums.length || res[1] == -1) {
			res[0] = -1;
			res[1] = -1;
		}
		
		return res;

	}

	public static void main(String[] arg) {

		int[] arr = { 5, 7, 7, 8, 8, 10 };
		Utils.print(searchRange(arr, 10));
		int[] arr1 = {  };
		Utils.print(searchRange(arr1, 10));

		int[] arr2 = { 5};
		Utils.print(searchRange(arr2, 5));
		
		int[] arr3 = { 5};
		Utils.print(searchRange(arr3, 1));

		int[] arr4 = { 5, 5};
		Utils.print(searchRange(arr4, 1));
		
		int[] arr5 = { 5, 5};
		Utils.print(searchRange(arr5, 5));

}

}
