package org.problems.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/contains-duplicate-ii/
 *
 * Given an array of integers and an integer k, find out whether there are two
 * distinct indices i and j in the array such that nums[i] = nums[j] and the
 * absolute difference between i and j is at most k.
 * 
 * Example 1:
 * Input: nums = [1,2,3,1], k = 3 Output: true 
 * 
 * Example 2:
 * Input: nums = [1,0,1,1], k = 1 Output: true 
 * 
 * Example 3:
 * Input: nums = [1,2,3,1,2,3], k = 2 Output: false
 * 
 * 
 */
public class ContainsDuplicateII {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
		if (nums == null || nums.length < 2) {
			return false;
		}

		Map<Integer,Integer> firstAppearance = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (firstAppearance.containsKey(nums[i])) {
				if (i-firstAppearance.get(nums[i]) <= k) {
					return true;
				}
			}
			firstAppearance.put(nums[i],i);
		}
		return false;
	}

	public static void main(String[] arg) {

		int[] nums = { 1, 2, 3, 1 };
		System.out.println(containsNearbyDuplicate(nums,3));

		int[] nums1 = {1, 0, 1, 1 };
		System.out.println(containsNearbyDuplicate(nums1,1));

		int[] nums2 = { 1, 2, 3, 1, 2, 3};
		System.out.println(containsNearbyDuplicate(nums2,2));

	}
}
