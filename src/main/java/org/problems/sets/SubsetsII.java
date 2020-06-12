package org.problems.sets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/subsets-ii/
 * 
 * Given a collection of integers that might contain duplicates, nums, return
 * all possible subsets (the power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * Example:
 * 
 * Input: [1,2,2] Output: [ [2], [1], [1,2,2], [2,2], [1,2], [] ]
 * 
 * 
 * 
 */
public class SubsetsII {
	
	static void getSubsetOf(List<Integer> nums, Set<List<Integer>> res) {
//		System.out.println("call:"+nums);
		if (nums.size() == 1) {
			res.add(nums);
			return;
		}
		res.add(nums);
		for (int i = 0; i < nums.size(); i++) {
			List<Integer> copy = new ArrayList<>(nums);
			copy.remove(i);
			if (!res.contains(copy)) {
				getSubsetOf(copy, res);
			}
		}
	}

	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		
		Set<List<Integer>> res = new HashSet<>();
		res.add(Arrays.asList());
		 Arrays.sort(nums);
		List<Integer> arr = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			arr.add(nums[i]);
		}
		getSubsetOf(arr,res);
		return new ArrayList<>(res);

	}

	public static void main(String[] arg) {

		int[] nums = {1,2,2};
		System.out.println(subsetsWithDup(nums));

		int[] nums1 = {1,1,1,2,2};
		System.out.println(subsetsWithDup(nums1));

	}

}
