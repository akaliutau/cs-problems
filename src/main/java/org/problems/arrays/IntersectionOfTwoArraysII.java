package org.problems.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 *
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example 1:
 * Input: nums1 = [1,2,2,1], nums2 = [2,2] Output: [2,2] 
 * 
 * Example 2:
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4] Output: [4,9]
 */
public class IntersectionOfTwoArraysII {
	
	static class Elem {
		public int num;
		public int count = 1;

		public Elem(int num) {
			this.num = num;
		}
}
	
	static Map<Integer,Elem> setOf(int[] nums){
		Map<Integer,Elem> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) {
				map.put(nums[i], new Elem(nums[i]));
			}else {
				map.get(nums[i]).count++;
			}
			
		}
		return map;
	}

	public static int[] intersect(int[] nums1, int[] nums2) {
		List<Integer> res = new ArrayList<>(); 
		Map<Integer, Elem> set2 = setOf(nums2);
		for (int i = 0; i < nums1.length; i++) {
			if (set2.containsKey(nums1[i])) {
				if (set2.get(nums1[i]).count-- > 0 )
					res.add(nums1[i]);
			}
		}		
		
		int[] arr = new int[res.size()];
		int idx = 0;
		for (Integer i : res) {
			arr[idx++] = i;
		}
		return arr;
	}

	public static void main(String[] arg) {
		
		int[] nums1 = {1,2,2,1};
		int[] nums2 = {2};

		Utils.print(intersect(nums1, nums2));

	}
}
