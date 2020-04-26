package com.leetcode.minmax;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/majority-element/
 *
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than ⌊ n/2 ⌋ times.
 * 
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 * 
 * Example 1:
 * 
 * Input: [3,2,3] Output: 3 
 * 
 * Example 2:
 * 
 * Input: [2,2,1,1,1,2,2] Output: 2
 * 
 * 
 * 
 */
public class MajorityElement {

	public static int majorityElement(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			if (!map.containsKey(num)) {
				map.put(num, 1);
			}else {
				int next = 1+map.get(num);
				if (next > nums.length/2) {
					return num;
				}
				map.put(num, next);
			}
			
		}
		return 0;

	}

	public static void main(String[] arg) {
		
		int[] nums = {3,2,3};
		System.out.println(majorityElement(nums));

		int[] nums1 = {2,2,1,1,1,2,2};
		System.out.println(majorityElement(nums1));

		int[] nums2 = {2,2,2,2};
		System.out.println(majorityElement(nums2));

		int[] nums3 = {1};
		System.out.println(majorityElement(nums3));

	}
}
