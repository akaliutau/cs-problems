package org.problems.arrays;

import java.util.TreeMap;

/**
 * https://leetcode.com/problems/contains-duplicate-iii/
 *
 * Given an array of integers, find out whether there are two distinct indices i
 * and j in the array such that the | nums[i] - nums[j] | <= t and |i - j | <=
 * k.
 * 
 * Example 1: Input: nums = [1,2,3,1], k = 3, t = 0 Output: true
 * 
 * Example 2: Input: nums = [1,0,1,1], k = 1, t = 2 Output: true
 * 
 * Example 3: Input: nums = [1,5,9,1,5,9], k = 2, t = 3 Output: false
 * 
 * 
 */
public class ContainsDuplicateIII {

	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (nums == null || nums.length < 2) {
			return false;
		}

		TreeMap<Long, Integer> map = new TreeMap<>();
		map.put((long) nums[0], 0);
		
		long diff = t;
		for (int i = 1; i < nums.length; i++) {
			long num = (long) nums[i];
			if (t == 0) {
				if (map.containsKey(num) && i - map.get(num) <= k) {
					return true;
				}
			} else {
				Long l = map.ceilingKey(num - diff); 
				Long h = map.floorKey(num + diff); 
				if (l != null && h != null && (Math.abs(num - l) <= diff || Math.abs(num - h) <= diff)) { 
					int left = map.get(l);
					int right = map.get(h);
					if (i - left <= k || i - right <= k) {
						return true;
					}
				}
			}
			map.put(num, i);
		}
		return false;
	}

	public static void main(String[] arg) {

		int[] nums = { 1, 2, 3, 1 };
		System.out.println(containsNearbyAlmostDuplicate(nums, 3, 0));// true

		int[] nums1 = { 1, 0, 1, 1 };
		System.out.println(containsNearbyAlmostDuplicate(nums1, 1, 2));// true

		int[] nums2 = { 1, 5, 9, 1, 5, 9 };
		System.out.println(containsNearbyAlmostDuplicate(nums2, 2, 3));// false

		int[] nums3 = { -1, 2147483647 };
		System.out.println(containsNearbyAlmostDuplicate(nums3, 1, 2147483647));// false

	}
}
