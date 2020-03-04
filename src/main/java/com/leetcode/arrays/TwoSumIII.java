package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/two-sum/
 * 
 * Runtime: 8 ms, faster than 42.72% of Java online submissions for Two Sum.
 * Memory Usage: 41.7 MB, less than 5.65% of Java online submissions for Two Sum
 */
public class TwoSumIII {

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

	public static int[] twoSum(int[] nums, int target) {
		int[] res = new int[2];
		List<Pos> list = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			list.add(new Pos(nums[i], i));
		}
		Collections.sort(list);

		for (int left = 0; left < nums.length; left++) {
			int sLeft = list.get(left).val;
			for (int right = left + 1; right < nums.length; right++) {
				int sum = sLeft + list.get(right).val;

				if (sum == target) {
					res[0] = list.get(left).index;
					res[1] = list.get(right).index;
					return res;
				} else if (sum > target) {
					break;
				}
			}
		}
		return null;

	}

	public static void main(String[] arg) {

		int[] input = { 2, 7, 11, 15 };
		int target = 9;
		int[] res = twoSum(input, target);
		for (int i : res) {
			System.out.println(i);
		}

		int[] input1 = { 3, 2, 4 };
		int target1 = 6;
		int[] res1 = twoSum(input1, target1);
		for (int i : res1) {
			System.out.println(i);
		}

	}

}
