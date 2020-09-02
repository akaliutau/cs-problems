package org.problems.favourite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Find Interval With Given Sum
 * 
 * Given a list of positive integers nums and an int target, return indices of
 * the two numbers such that they add up to a target - 30.
 * 
 * Conditions:
 * 
 * You will pick exactly 2 numbers. You cannot pick the same element twice. If
 * you have muliple pairs, select the pair with the largest number. 
 * 
 * Example 1:
 * 
 * Input: nums = [1, 10, 25, 35, 60], target = 90 
 * Output: [2, 3]
 * Explanation:
 * nums[2] + nums[3] = 25 + 35 = 60 = 90 - 30 
 * 
 * Example 2:
 * 
 * Input: nums = [20, 50, 40, 25, 30, 10], target = 90 Output: [1, 5]
 * Explanation: nums[0] + nums[2] = 20 + 40 = 60 = 90 - 30 nums[1] + nums[5] =
 * 50 + 10 = 60 = 90 - 30 
 * You should return the pair with the largest number.
 * 
 */
public class FindPairWithGivenSum {

	public static class Pos implements Comparable<Pos> {
		int val;
		int index;

		public Pos(int val, int index) {
			this.val = val;
			this.index = index;
		}

		@Override
		public int compareTo(Pos o) {
			return this.val - o.val;
		}

		@Override
		public String toString() {
			return val + ":" + index;
		}

	}

	public static List<Integer> twoSum(int[] nums, int target) {
		int n = nums.length;
		List<Pos> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(new Pos(nums[i], i));
		}
		Collections.sort(list);
		for (int left = 0; left < n; left++) {
			int sLeft = list.get(left).val;
			for (int right = left + 1; right < n; right++) {
				int sum = sLeft + list.get(right).val;
				if (sum == target) {
					return Arrays.asList(list.get(left).index, list.get(right).index);
				} else if (sum > target) {
					break;
				}
			}
		}
		return null;
	}

	public static void main(String[] arg) {
		System.out.println(twoSum(new int[] {1, 10, 25, 35, 60}, 90 - 30));
		System.out.println(twoSum(new int[] {20, 50, 40, 25, 30, 10}, 90 - 30));
	}

}
