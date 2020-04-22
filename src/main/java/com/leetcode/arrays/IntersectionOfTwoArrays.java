package com.leetcode.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 *
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example 1:
 * 
 * Input: nums1 = [1,2,2,1], nums2 = [2,2] Output: [2]
 * 
 * 
 */
public class IntersectionOfTwoArrays {

	static Set<Integer> getSet(int[] nums) {
		Set<Integer> set1 = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			set1.add(nums[i]);
		}
		return set1;
	}

	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set1 = getSet(nums1);
		Set<Integer> set2 = getSet(nums2);
		Set<Integer> res = new HashSet<>();
		for (Integer first : set1) {
			if (set2.contains(first)) {
				res.add(first);
			}
		}
		int[] ret = new int[res.size()];
		int idx = 0;
		for (Integer i : res) {
			ret[idx++] = i;
		}
		return ret;

	}

	public static void main(String[] arg) {

		System.out.println(true);

	}
}
