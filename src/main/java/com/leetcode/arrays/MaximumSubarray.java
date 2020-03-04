package com.leetcode.arrays;

/**
 * https://leetcode.com/problems/maximum-subarray/
 * 
 * Given an integer array nums, find the contiguous subarray (containing at
 * least one number) which has the largest sum and return its sum.
 * 
 * Example:
 * 
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 *          |      |
 * Output: 6 
 * 
 * Explanation: [4,-1,2,1] has the largest sum = 6
 * 
 * 
 */
public class MaximumSubarray {

	public static int maxSubArray(int[] nums) {
		
		int curPos = 1;
		int sum = nums[0];// sum of all elems left to index = right
		int bestLeft = 0;
		int bestRight = 0;
		int bestSum = sum;
		
		while (curPos < nums.length) {
			sum = Math.max(sum, 0) + nums[curPos];
			// choose max of 3 values
			if (nums[curPos] > sum) {
				sum = nums[curPos];
				if (sum > bestSum) {
					bestLeft = curPos;
					bestRight = curPos;
				}
			}else if (sum > bestSum){
				bestSum = sum;
				bestRight = curPos;
			}
			curPos++;
		}
		System.out.println(bestLeft+":"+bestRight);
		
		return bestSum;
    }

	public static void main(String[] arg) {

		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(nums));
		
		int[] nums1 = {8,-19,5,-4,20};
		System.out.println(maxSubArray(nums1));

		int[] nums2 = {-1,-2};
		System.out.println(maxSubArray(nums2));

		int[] nums3 = {-2,1};
		System.out.println(maxSubArray(nums3));


	}
}
