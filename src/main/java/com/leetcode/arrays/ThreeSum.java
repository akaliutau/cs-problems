package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/3sum/
 * 
 * Given an array nums of n integers, are there elements a, b, c in nums such
 * that a + b + c = 0? Find all unique triplets in the array which gives the sum
 * of zero.
 * 
 * Note:
 * 
 * The solution set must not contain duplicate triplets.
 * 
 * Runtime: 382 ms, faster than 14.90% of Java online submissions for 3Sum.
 * Memory Usage: 45.5 MB, less than 96.47% of Java online submissions for 3Sum.
 */
public class ThreeSum {

	public static List<List<Integer>> threeSum(int[] nums) {
		Set<List<Integer>> threeSumSet = new HashSet<>();
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			int left = i + 1;
			int right = nums.length - 1;

			int numI = nums[i];
			int numL = nums[left];
			int numR = nums[right];

			while (left < right) {

				int sum = numI + numL + numR;

				if (sum == 0) {
					threeSumSet.add(Arrays.asList(numI, numL, numR));
					numL = nums[++left];
					numR = nums[--right];
				} else if (sum > 0) {
					numR = nums[--right];
				} else {
					numL = nums[++left];
				}
			}

		}

		return new ArrayList<>(threeSumSet);

	}

	public static void main(String[] arg) {
		// 0 1 2 3

		int[] in = { -1, 0, 1, 2, -1, -4 };

		System.out.println(threeSum(in));

	}
}
