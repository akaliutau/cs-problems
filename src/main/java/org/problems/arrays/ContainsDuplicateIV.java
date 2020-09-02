package org.problems.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/contains-duplicate-iii/
 * 
 * Given an array of integers, find out whether there are two distinct indices i
 * and j in the array such that the absolute difference between nums[i] and
 * nums[j] is at most t and the absolute difference between i and j is at most
 * k.
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3,1], k = 3, t = 0 Output: true Example 2:
 * 
 * Input: nums = [1,0,1,1], k = 1, t = 2 Output: true Example 3:
 * 
 * Input: nums = [1,5,9,1,5,9], k = 2, t = 3 Output: false
 */
public class ContainsDuplicateIV {

	  public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
     		int n = nums.length;
		List<int[]> all = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				long diff = Math.abs((long)nums[i] - (long)nums[j]);
				System.out.println("diff="+diff);
				if (diff <= t && j - i <= k) {
					return true;
				}
				if (j - i > k) {
					break;
				}
			}
		}

		return false;

  }

	public static void main(String[] arg) {
		
		int[] nums = {1,2,3,1};
		System.out.println(containsNearbyAlmostDuplicate(nums, 3, 0));

		int[] nums1 = {2147483647,-2147483647};
		System.out.println(containsNearbyAlmostDuplicate(nums1, 1, 2147483647));

	}

}
