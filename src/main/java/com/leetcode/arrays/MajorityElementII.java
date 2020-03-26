package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/majority-element-ii/ 
 * 
 * Given an integer array of
 * size n, find all elements that appear more than  n/3  times.
 * 
 * Note: The algorithm should run in linear time and in O(1) space.
 * 
 * Example 1:
 * 
 * Input: [3,2,3] Output: [3] 
 * 
 * Example 2:
 * 
 * Input: [1,1,1,3,3,2,2,2] Output: [1,2]
 * 
 * 
 */
public class MajorityElementII {
	
	public static List<Integer> majorityElement(int[] nums) {
		List<Integer> res = new ArrayList<>();
		int n = nums.length;
		if (n  == 0) {
			return res;
		}
		Arrays.sort(nums);
		int lastElem = nums[0];
		int counter = 1;
		int idx = 0;
		while (++idx < n) {
			if (nums[idx] != lastElem) {
				if (counter > n/3) {
					res.add(lastElem);
				}
				counter = 1;
				lastElem = nums[idx];
			}else {
				counter ++;
			}
		}
		if (counter > n/3) {
			res.add(lastElem);
		}
		
		return res;
        
    }

	public static void main(String[] arg) {

		int[] nums = {2};
		System.out.println(majorityElement(nums));

		int[] nums0 = {1,2};
		System.out.println(majorityElement(nums0));

		int[] nums1 = {3,2,3};
		System.out.println(majorityElement(nums1));

		int[] nums2 = {1,1,1,3,3,2,2,2};
		System.out.println(majorityElement(nums2));

	}
}
