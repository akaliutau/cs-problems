package org.problems.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/132-pattern/
 * 
 * Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a
 * subsequence ai, aj, ak such that i < j < k and ai < ak < aj. Design an
 * algorithm that takes a list of n numbers as input and checks whether there is
 * a 132 pattern in the list.
 * 
 * Note: n will be less than 15,000.
 * 
 * Example 1: Input: [1, 2, 3, 4]
 * 
 * Output: False
 * 
 * Explanation: There is no 132 pattern in the sequence. 
 * 
 * Example 2: Input: [3, 1, 4, 2]
 * 
 * Output: True
 * 
 * Explanation: There is a 132 pattern in the sequence: [1, 4, 2]. 
 * 
 * Example 3:
 * Input: [-1, 3, 2, 0]
 * 
 * Output: True
 * 
 * Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1,
 * 3, 0] and [-1, 2, 0]
 * 
 * 
 * 
 */
public class Pattern132 {
	
	static class Number {
		public int idx;
		public int num;
		public int pos;

		public Number(int num, int pos) {
			this.num = num;
			this.pos = pos;
		}

		@Override
		public String toString() {
			return "Number [idx=" + idx + ", num=" + num + ", pos=" + pos  + "]";
		}

	}
	
	static Set<Integer> getLocalMax(int[] nums){
		int n = nums.length;
		int cur = nums[0];
		boolean up = true;
		Set<Integer> index = new HashSet<>();
		for (int i = 1; i < n; i++) {
			if (up) {
				if (nums[i] < cur) {
					up = false;
					index.add(i-1);
				}
			}else {
				if (nums[i] > cur) {
					up = true;
				}
			}
			cur = nums[i];
		}
		return index;
	}


	public static boolean find132pattern(int[] nums) {
		int n = nums.length;
		if (n < 3) {
			return false;
		}
		Set<Integer> maxs = getLocalMax(nums);

		if (maxs.isEmpty()) {
			return false;
		}
		Number[] numbers = new Number[n];
		List<Number> positions = new ArrayList<>();
		for (int i = 0; i < n; i ++) {
			numbers[i]  = new Number(nums[i], i);
			if (maxs.contains(i)) {
				positions.add(numbers[i]);
			}
		}
		// biggest first
		Comparator<Number> byNum = (o,p) -> Integer.compare(p.num, o.num);
		Arrays.parallelSort(numbers, byNum);
		
		for (int i = 0; i < n; i ++) {
			numbers[i].idx = i;
		}
		
		
		int idx = 0;
		for (Number mid : positions) {
			idx = mid.idx;
			while (++idx < n) {
				Number right = numbers[idx];
				if (right.num < mid.num) {
					if (right.pos < mid.pos) {
						continue;
					}
					while (++idx < n) {
						Number left = numbers[idx];
						if (left.num < right.num) {
							if (left.pos > mid.pos) {
								continue;
							}
							return true;
						}
					}
				}
			}
		}
		return false;

	}

	public static void main(String[] arg) {

		int[] nums = {1, 2, 3, 4};
		System.out.println(find132pattern(nums));

		int[] nums1 = {3, 1, 4, 2};
		System.out.println(find132pattern(nums1));

		int[] nums2 = {-1, 3, 2, 0};
		System.out.println(find132pattern(nums2));

		int[] nums3 = {1, 6, 6, 4};
		System.out.println(find132pattern(nums3));

		
		int[] nums4 = {0, 1, 6, 6, 4, 5, 7, 8, 9};
		System.out.println(find132pattern(nums4));

		
	}

}
