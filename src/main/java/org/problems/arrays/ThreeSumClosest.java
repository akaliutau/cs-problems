package org.problems.arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/3sum-closest/
 *
 * Given an array nums of n integers and an integer target, find three integers
 * in nums such that the sum is closest to target. Return the sum of the three
 * integers. You may assume that each input would have exactly one solution.
 *
 * Runtime: 4 ms, faster than 88.03% of Java online submissions for 3Sum
 * Closest. Memory Usage: 38.1 MB, less than 6.67% of Java online submissions
 * for 3Sum Closest.
 *
 */

public class ThreeSumClosest {

	public static int threeSumClosest(int[] nums, int target) {

		Arrays.sort(nums);

		int closest = Integer.MAX_VALUE;
		int closestSum = 0;

		for (int i = 0; i < nums.length - 2; i++) {
			int left = i + 1;
			int right = nums.length - 1;

			int numI = nums[i];
			int numL = nums[left];
			int numR = nums[right];

			while (left < right) {

				int sum = numI + numL + numR - target;
				if (left != right && left != i && right != i) {
					if (closest > Math.abs(sum)) {
						closest = Math.abs(sum);
						closestSum = numI + numL + numR;
						if (closest == 0) {
							return closestSum;
						}
					}
				}

				if (sum == 0) {
					numL = nums[++left];
					numR = nums[--right];
				} else if (sum > 0) {
					numR = nums[--right];
				} else {
					numL = nums[++left];
				}
			}

		}

		return closestSum;

	}

	public static void main(String[] arg) {
		int[] in = { -1, 0, 1, 2, -1, -4 };

		System.out.println(threeSumClosest(in, 3));

		int[] in1 = { -1, 2, 1, -4 };

		System.out.println(threeSumClosest(in1, 1));

		int[] in2 = { 84, 49, -47, -56, 13, -3, 62, -95, 23, 38, -97, 92, 34, 68, 30, 90, 41, 24, -58, 83, 96, -99, -40,
				28, -18, -69, -78, 95, -62, 45, -66, -71, 5, 94, -42, -66, 27, 60, -90, -62, 87, -22, 56, 7, -11, 75,
				53, -16, -7, -19, 17, 18, -14, 43, 98, -11, 0, 80, -82, 40, 5, 37, -94, -14, -62, -82, 84, 23, -9, -68,
				37, -23, 10, 26, -22, -52, 14, 18, -40, -74, -32, 47, -87, -81, -68, 34, 60, 75, 93, -28, 100, -42, 0,
				-87, 60, 75, -47, 7, -57, -61, -2, -96, -18, -98, -3, 25, 38, -83, 60, -12, -62, 78, -41, 75, -5, 89,
				-97, -1, 87, 92, 57, 93, -83, -67, -76, 28, -98, -12, 22, -2, 54, -67, 7, 99, 100, 50, 5, 84, 49, -96,
				-61, -62, -61, 29, -59, 43, 55, 30, -10, -22, 50, -32, -81, -42, 32, 55, -94, 84, -90, -71, -10, 61, 56,
				94, 51, 8, 54, 22, 22, 31 };

		System.out.println(threeSumClosest(in2, 82));

	}

}
