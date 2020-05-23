package org.problems.iterations;

/**
 * https://leetcode.com/problems/jump-game/
 * 
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * Example 1:
 * 
 * Input: [2,3,1,1,4] 
 * Output: true
 * 
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 * 
 * Input: [3,2,1,0,4] 
 * Output: false
 * 
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 * jump length is 0, which makes it impossible to reach the last index.
 * 
 * 
 */
public class JumpGame {

	public static boolean canJump(int[] nums) {
		int n = nums.length;
		int maxNumberCovered = 0;
		if (n == 0) {
			return false;
		}
		if (n == 1) {
			return nums[0] >= 0;
		} else if (nums[0] == 0) {
			return false;
		}

		boolean[] coverMap = new boolean[n];
		for (int i = 0; i < n - 1; i++) {
			int dist = nums[i];
			if (dist == 0) {// check wall presence
				if (maxNumberCovered <= i) {
					return false;
				}
			}
			for (int range = i; range <= i + dist; range++) {
				if (range > -1 && range < n) {
					if (range == n - 1) {
						return true;
					}
					if (!coverMap[range]) {
						coverMap[range] = true;
					}
					if (maxNumberCovered < range) {
						maxNumberCovered = range;
					}
				}
			}
		}
		return coverMap[n - 1];

	}

	public static void main(String[] arg) {

		int[] nums = { 2, 3, 1, 1, 4 };
		System.out.println(canJump(nums));

		int[] nums1 = { 3, 2, 1, 0, 4 };
		System.out.println(canJump(nums1));

		int[] nums2 = { 1, 4 };
		System.out.println(canJump(nums2));

		int[] nums3 = { 1 };
		System.out.println(canJump(nums3));

		int[] nums4 = { 1 };
		System.out.println(canJump(nums4));

		int[] nums5 = { 1, 0, 1, 0 };
		System.out.println(canJump(nums5));

	}
}
