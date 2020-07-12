package org.problems.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/range-sum-of-sorted-subarray-sums/
 * 
 * Given the array nums consisting of n positive integers. You computed the sum
 * of all non-empty continous subarrays from the array and then sort them in
 * non-decreasing order, creating a new array of n * (n + 1) / 2 numbers.
 * 
 * Return the sum of the numbers from index left to index right (indexed from
 * 1), inclusive, in the new array. Since the answer can be a huge number return
 * it modulo 10^9 + 7
 * 
 */
public class RangeSum {

	public int rangeSum(int[] nums, int n, int left, int right) {

		long sum = 0;
		List<Integer> lst = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			Integer s = nums[i];
			lst.add(s);
			for (int j = i + 1; j < n; j++) {
				s += nums[j];
				lst.add(s);
			}
		}
		Collections.sort(lst);
		for (int i = left - 1; i <= right - 1; i++) {
			sum += lst.get(i);
			sum = sum % 1000000007;
		}
		return (int) sum;

	}

	public static void main(String[] arg) {
		System.out.println(true);
	}

}
