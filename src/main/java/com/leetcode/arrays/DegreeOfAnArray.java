package com.leetcode.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/degree-of-an-array/
 *
 * Given a non-empty array of non-negative integers nums, the degree of this
 * array is defined as the maximum frequency of any one of its elements.
 * 
 * Your task is to find the smallest possible length of a (contiguous) subarray
 * of nums, that has the same degree as nums.
 * 
 * Example 1: Input: [1, 2, 2, 3, 1] Output: 2 
 * Explanation: The input array has
 * a degree of 2 because both elements 1 and 2 appear twice. Of the subarrays
 * that have the same degree: 
 * [1, 2, 2, 3, 1], 
 * [1, 2, 2, 3], 
 * [2, 2, 3, 1], 
 * [1, 2, 2], 
 * [2, 2, 3], 
 * [2, 2] 
 * The shortest length is 2. So return 2. 
 * 
 * Example 2: Input: [1,2,2,3,1,4,2] Output: 6 
 * 
 * Note:
 * 
 * nums.length will be between 1 and 50,000. 
 * nums[i] will be an integer between 0 and 49,999
 * 
 */
public class DegreeOfAnArray {
	
	public static int findShortestSubArray(int[] nums) {
		int[][] freq = new int[50001][3];
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			int num = nums[i];
			if (freq[num][0] == 0) {// 1st time
				freq[num][1] = i;// left boundary
			}else {
				freq[num][2] = i;// right boundary
			}
			freq[num][0] ++;
		}
		
		int degree = 0;
		int numb = 0;
		for (int i = 0; i < 50000; i++) {
			if (degree < freq[i][0]) {
				degree = freq[i][0];
				numb = i;
			}
		}
		if (degree < 2) {
			return degree;
		}
		// degree now contains the degree of array
		// find others if any
		Set<Integer> numbers = new HashSet<>();
		numbers.add(numb);
		for (int i = 0; i < 50000; i++) {
			if (degree == freq[i][0]) {
				numbers.add(i);
			}
		}	
		System.out.println(numbers);
		// go though all numbers and detect the narrowest one
		// with interval [left,right]
		int smallestContLength = Integer.MAX_VALUE;

		for (Integer num : numbers) {
			int length = freq[num][2] - freq[num][1] + 1;
			if (smallestContLength > length) {
				smallestContLength = length;
			}
		}
		
		return smallestContLength;
	}

	public static void main(String[] arg) {

		int[] nums = {1, 2, 2, 3, 1};
		System.out.println(findShortestSubArray(nums));
		int[] nums1 = {1,2,2,3,1,4,2};
		System.out.println(findShortestSubArray(nums1));

	}
}
