package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/minimum-subsequence-in-non-increasing-order/
 * 
 * Given the array nums, obtain a subsequence of the array whose sum of elements
 * is strictly greater than the sum of the non included elements in such
 * subsequence.
 * 
 * If there are multiple solutions, return the subsequence with minimum size and
 * if there still exist multiple solutions, return the subsequence with the
 * maximum total sum of all its elements. A subsequence of an array can be
 * obtained by erasing some (possibly zero) elements from the array.
 * 
 * Note that the solution with the given constraints is guaranteed to be unique.
 * Also return the answer sorted in non-increasing order.
 * 
 * Input: nums = [4,3,10,9,8] Output: [10,9]
 * 
 * 
 */
public class MinimumSubsequenceInNonIncreasingOrder {

	public static List<Integer> minSubsequence(int[] nums) {
		List<Integer> result = new ArrayList<>();
		Arrays.sort(nums);
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		int rightSum = 0;
		for (int i = nums.length - 1; i > -1; i--) {
			rightSum += nums[i];
			result.add(nums[i]);
			sum -= nums[i];
			if (rightSum > sum) {
				break;
			}
		}

		Comparator<Integer> c = (o, p) -> Integer.compare(p, o);
		Collections.sort(result, c);
		return result;

	}

	public static void main(String[] arg) {
		int[] nums = { 4, 3, 10, 9, 8 };
		System.out.println(minSubsequence(nums));

		int[] nums1 = { 4, 4, 7, 6, 7 };
		System.out.println(minSubsequence(nums1));

		int[] nums2 = { 6 };
		System.out.println(minSubsequence(nums2));

	}

}
