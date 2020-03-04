package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/4sum/
 * 
 * Given an array nums of n integers and an integer target, are there elements
 * a, b, c, and d in nums such that a + b + c + d = target? Find all unique
 * quadruplets in the array which gives the sum of target. Note: The solution
 * set must not contain duplicate quadruplets.
 */
public class FourSum {

	public static List<List<Integer>> fourSum(int[] nums, int target) {
		Map<Set<Integer>, List<Integer>> res = new HashMap<>();
		if (nums.length > 3) {
			for (int i = 0; i < nums.length - 3; i++) {
				for (int j = i + 1; j < nums.length; j++) {
					for (int k = j + 1; k < nums.length; k++) {
						for (int l = k + 1; l < nums.length; l++) {
							if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
								List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
								res.put(new HashSet<>(list), list);
							}
						}

					}

				}

			}
		}
		List<List<Integer>> lst = new ArrayList<>();
		for (Set<Integer> s : res.keySet()) {
			lst.add(new ArrayList<Integer>(res.get(s)));
		}
		return lst;

	}

	public static void main(String[] arg) {
		int[] arr = { 1, 0, -1, 0, -2, 2 };
		System.out.println(fourSum(arr, 0));

		int[] arr1 = { 0, 0, 0, 0 };
		System.out.println(fourSum(arr1, 0));

	}

}
