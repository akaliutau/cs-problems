package org.problems.arrays;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
 * 
 * Given an integer array, you need to find one continuous subarray that if you
 * only sort this subarray in ascending order, then the whole array will be
 * sorted in ascending order, too.
 * 
 * You need to find the shortest such subarray and output its length.
 * 
 * Example 1: Input: [2, 6, 4, 8, 10, 9, 15] Output: 5 
 * Explanation: You need to
 * sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in
 * ascending order. 
 * 
 * Note: Then length of the input array is in range [1,
 * 10,000]. The input array may contain duplicates, so ascending order here
 * means <=
 * 
 */
public class ShortestUnsortedSubarray {
	
	static class Number {
		public int num;
		public int pos;

		public Number(int num, int pos) {
			this.num = num;
			this.pos = pos;
		}

	}

	public static int findUnsortedSubarray(int[] nums) {
		int n = nums.length;
		int start = 0;
		int end = 0;
		if (n == 1) {
			return 0;
		}
		Number[] numbers = new Number[n];
		for (int i = 0; i < n; i ++) {
			numbers[i]  = new Number(nums[i], i);
		}
		Comparator<Number> byNum = (o,p) -> Integer.compare(o.num, p.num);
		Arrays.parallelSort(numbers, byNum);
		for (int i = 0; i < n; i ++) {
			if (numbers[i].pos != i) {
				start = i;
				break;
			}
		}		
		for (int i = n-1; i > -1; i --) {
			if (numbers[i].pos != i) {
				end = i;
				break;
			}
		}	
		if (start == 0 && end == 0) {
			return 0;
		}
		return end - start + 1;

	}

	public static void main(String[] arg) {

		int[] nums = {2, 6, 4, 8, 10, 9, 15};
		System.out.println(findUnsortedSubarray(nums));

		int[] nums1 = {1, 4, 7, 8};
		System.out.println(findUnsortedSubarray(nums1));

	}

}
