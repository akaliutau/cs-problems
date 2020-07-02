package org.problems.arrays;

import java.util.HashSet;
import java.util.Set;

import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/single-number-iii/
 * 
 * Given an array of numbers nums, in which exactly two elements appear only
 * once and all the other elements appear exactly twice. Find the two elements
 * that appear only once.
 * 
 * Example:
 * 
 * Input: [1,2,1,3,2,5] Output: [3,5] Note:
 * 
 * The order of the result is not important. So in the above example, [5, 3] is
 * also correct.
 * 
 * 
 */
public class SingleNumberIII {
	

	public static int[] singleNumber(int[] nums) {
		int n = nums.length;
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			if (set.contains(nums[i])) {
				set.remove(nums[i]);
			}else {
				set.add(nums[i]);
			}
		}
		int idx = 0;
		int[] res = new int[2];
		for (Integer i : set) {
			res[idx++] = i;
		}
		return res;

	}

	public static void main(String[] arg) {

		int[] nums = {1,2,1,3,2,5};
		Utils.print(singleNumber(nums));

	}

}
