package org.problems.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/contains-duplicate/
 *
 * Given an array of integers, find if the array contains any duplicates.
 * 
 * Your function should return true if any value appears at least twice in the
 * array, and it should return false if every element is distinct.
 * 
 * Example 1:
 * 
 * Input: [1,2,3,1] Output: true
 * 
 * 
 */
public class ContainsDuplicate {

	public static boolean containsDuplicate(int[] nums) {
		if (nums == null || nums.length < 2) {
			return false;
		}

		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i])) {
				return true;
			}
			set.add(nums[i]);
		}
		return false;
	}

	public static void main(String[] arg) {

		int[] nums = { 1, 2, 3, 1 };
		System.out.println(containsDuplicate(nums));

	}
}
