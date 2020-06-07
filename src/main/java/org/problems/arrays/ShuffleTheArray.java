package org.problems.arrays;

import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/shuffle-the-array/
 * 
 * Given the array nums consisting of 2n elements in the form
 * [x1,x2,...,xn,y1,y2,...,yn].
 * 
 * Return the array in the form [x1,y1,x2,y2,...,xn,yn].
 * 
 */
public class ShuffleTheArray {

	public static int[] shuffle(int[] nums, int n) {
		int[] res = new int[2 * n];
		int idx = 0;
		for (int i = 0; i < n; i++) {
			res[idx++] = nums[i];
			res[idx++] = nums[i + n];
		}
		return res;
	}

	public static void main(String[] arg) {

		int[] nums = { 2, 5, 1, 3, 4, 7 };
		Utils.print(shuffle(nums, 3));

	}

}
