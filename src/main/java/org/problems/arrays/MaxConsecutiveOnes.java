package org.problems.arrays;

/**
 * https://leetcode.com/problems/max-consecutive-ones/
 * 
 * Given a binary array, find the maximum number of consecutive 1s in this
 * array.
 * 
 * Example 1: Input: [1,1,0,1,1,1] Output: 3 
 * Explanation: The first two digits
 * or the last three digits are consecutive 1s. The maximum number of
 * consecutive 1s is 3. 
 * 
 * Note:
 * 
 * The input array will only contain 0 and 1. The length of input array is a
 * positive integer and will not exceed 10,000
 * 
 */
public class MaxConsecutiveOnes {

	public static int findMaxConsecutiveOnes(int[] nums) {
		int n = nums.length;
		int len = 0;
		int maxLen = 0;
		for (int i = 0; i < n; i++) {
			if (nums[i] == 0) {
				maxLen = Math.max(maxLen, len);
				len = 0;
			}else {
				len ++;
			}
		}
		maxLen = Math.max(maxLen, len);
		return maxLen;

	}

	public static void main(String[] arg) {
		
		int[] nums = {1,1,0,1,1,1};

		System.out.println(findMaxConsecutiveOnes(nums));

	}

}
