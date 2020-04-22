package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 * 
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some
 * elements appear twice and others appear once.
 * 
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * 
 * Could you do it without extra space and in O(n) runtime? You may assume the
 * returned list does not count as extra space.
 * 
 * Example:
 * 
 * Input: [4,3,2,7,8,2,3,1]
 * 
 * Output: [5,6]
 * 
 */
public class DisappearedNumbers {

	public static List<Integer> findDisappearedNumbers(int[] nums) {
		int[] res = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			if (res[nums[i]-1] == 0) {
				res[nums[i]-1] = 1;
			}else if (res[nums[i]-1] == 1) {
				res[nums[i]-1] = 2;
			}
		}
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			if (res[i] == 0 || res[i] > 2) {
				result.add(i+1);
			}
		}
		return result;		

	}

	public static void main(String[] arg) {
		
		int[] nums = {4,3,2,7,8,2,3,1};
		System.out.println(findDisappearedNumbers(nums));

		int[] nums1 = {1, 3, 3};
		System.out.println(findDisappearedNumbers(nums1));

		int[] nums2 = {1, 2, 2};
		System.out.println(findDisappearedNumbers(nums2));

	}

}
