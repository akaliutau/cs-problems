package org.problems.arrays;

/**
 * https://leetcode.com/problems/circular-array-loop/
 * 
 * You are given a circular array nums of positive and negative integers. If a
 * number k at an index is positive, then move forward k steps. Conversely, if
 * it's negative (-k), move backward k steps. Since the array is circular, you
 * may assume that the last element's next element is the first element, and the
 * first element's previous element is the last element.
 * 
 * Determine if there is a loop (or a cycle) in nums. A cycle must start and end
 * at the same index and the cycle's length > 1. Furthermore, movements in a
 * cycle must all follow a single direction. In other words, a cycle must not
 * consist of both forward and backward movements.
 * 
 * Example 1:
 * 
 * Input: [2,-1,1,2,2] Output: true Explanation: There is a cycle, from index 0
 * -> 2 -> 3 -> 0. The cycle's length is 3.
 * 
 * Example 2:
 * 
 * Input: [-1,2] Output: false Explanation: The movement from index 1 -> 1 -> 1
 * ... is not a cycle, because the cycle's length is 1. By definition the
 * cycle's length must be greater than 1.
 * 
 * Example 3:
 * 
 * Input: [-2,1,-1,-2,-2] Output: false Explanation: The movement from index 1
 * -> 2 -> 1 -> ... is not a cycle, because movement from index 1 -> 2 is a
 * forward movement, but movement from index 2 -> 1 is a backward movement. All
 * movements in a cycle must follow a single direction
 */
public class CircularArray {

	static enum Reason {
		END_OF_CYCLE, DIFF_SIGNS
	}

	public static boolean circularArrayLoop(int[] nums) {
		int n = nums.length;
		// contains indecies of all visited positions

		int startIdx = 0;
		while (startIdx < n) {
			boolean[] visitedSet = new boolean[n];
			// number of steps occurred
			int cycleLen = 0;
			boolean direction = nums[startIdx] > 0;// true - forward, false - backward
			Reason reason = null;
			int idx = startIdx;
			while (cycleLen <= n) {
				if (visitedSet[idx]) {// end of cycle
					reason = Reason.END_OF_CYCLE;
					break;
				}
				if (direction ^ (nums[idx] > 0)) {// different signs
					reason = Reason.DIFF_SIGNS;
					break;
				}
				visitedSet[idx] = true;
				int next = nums[idx];
				cycleLen++;
				if (next > 0) {
					next = (idx + next) % n;
				} else {
					int nextComplementary = (-next) % n;
					next = idx - nextComplementary;
					if (next < 0) {
						next = next + n;
					}
				}
				idx = next;
			}
			if (reason == Reason.DIFF_SIGNS) {
				// return false;
			} else if (reason == Reason.END_OF_CYCLE) {
				if (cycleLen > 1 && startIdx == idx) {
					return true;
				}
			}
			startIdx++;
		}

		return false;

	}

	public static void main(String[] arg) {

		int[] nums = { 2, -1, 1, 2, 2 };
		System.out.println(circularArrayLoop(nums));// true

		int[] nums1 = { -1, 2 };
		System.out.println(circularArrayLoop(nums1));// false

		int[] nums2 = { -2, 1, -1, -2, -2 };
		System.out.println(circularArrayLoop(nums2));// false

		int[] nums3 = { -1, -2, -3, -4, -5 };
		System.out.println(circularArrayLoop(nums3));// false - changing cycle

		int[] nums4 = { 3, 1, 2 };
		System.out.println(circularArrayLoop(nums4));// true
		
		int[] nums5 = { 1, 1 };
		System.out.println(circularArrayLoop(nums5));// true

		int[] nums6 = { 1, 1, 2 };
		System.out.println(circularArrayLoop(nums6));// true


	}

}
