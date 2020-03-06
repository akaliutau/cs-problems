package com.leetcode.combinatorics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/subsets/
 * 
 * Given a set of distinct integers, nums, return all possible subsets (the
 * power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * Example:
 * 
 * Input: nums = [1,2,3] 
 * Output: [ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], [] ]
 * 
 * 
 * 
 */
public class SubsetsI {
	
	public static void getSubset(List<Integer> nums, Set<List<Integer>> results) {
		if (nums.size() == 0) {
			results.add(new ArrayList<>());
		}else {
			for (int i = 0; i < nums.size(); i++) {
				List<Integer> next = new ArrayList<>();
				for (int j = 0; j < nums.size(); j++) {
					if (i != j) {
						next.add(nums.get(j));
					}
				}
				if (!results.contains(next)) {
					results.add(next);
					getSubset(next,results);
				}
			}
		}
	}

	public static List<List<Integer>> subsets(int[] nums) {
		Set<List<Integer>> results = new HashSet<>();
		
		Arrays.sort(nums);
		List<Integer> next = new ArrayList<>();
		for (Integer s: nums) {
			next.add(s);
		}
		getSubset(next,results);
		results.add(next);
		return new ArrayList<>(results);

	}

	public static void main(String[] arg) {
		int[] nums = {1,2,3};

		System.out.println(subsets(nums));

	}
}
