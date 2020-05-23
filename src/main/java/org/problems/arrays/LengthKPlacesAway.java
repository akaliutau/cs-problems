package org.problems.arrays;

/**
 * https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away/
 * 
 * Given an array nums of 0s and 1s and an integer k, return True if all 1's are
 * at least k places away from each other, otherwise return False.
 * 
 * 
 */
public class LengthKPlacesAway {

	public static boolean kLengthApart(int[] nums, int k) {
		if (k == 0) {
			return true;
		}
		int lastIdx = 0;
		int n = nums.length;
		while (lastIdx < n && nums[lastIdx] != 1) {
			lastIdx++;
		}
		if (lastIdx == n) {
			return true;
		}
		int idx = lastIdx + 1;
		while (idx < n) {
			if (nums[idx] == 1) {
				if (idx - lastIdx > k) {
					lastIdx = idx;
				} else {
					return false;
				}
			}
			idx++;
		}
		return true;

	}

	public static void main(String[] arg) {

		int[] nums = { 1, 0, 0, 0, 1, 0, 0, 1 };
		System.out.println(kLengthApart(nums, 2));

		int[] nums1 = { 1, 0, 0, 1, 0, 1 };
		System.out.println(kLengthApart(nums1, 2));

		int[] nums2 = { 0, 1 };
		System.out.println(kLengthApart(nums2, 2));

	}

}
