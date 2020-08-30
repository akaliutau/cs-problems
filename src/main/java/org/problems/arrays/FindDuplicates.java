package org.problems.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/
 * 
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements
 * appear twice and others appear once.
 * 
 * Find all the elements that appear twice in this array.
 * 
 */
public class FindDuplicates {

	public static List<Integer> findDuplicates(int[] nums) {
		int n = nums.length;
		List<Integer> dups = new ArrayList<>();
		Set<Integer> dupSet = new HashSet<>();
		for (int i = 0; i < n; i++) {
			if (dupSet.contains(nums[i])) {
				dups.add(nums[i]);
			}else {
				dupSet.add(nums[i]);
			}
		}
		return dups;
	}

	public static void main(String[] arg) {
		int[] nums = {4,3,2,7,8,2,3,1};
		System.out.println(findDuplicates(nums));
	}

}
