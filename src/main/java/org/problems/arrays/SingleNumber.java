package org.problems.arrays;

/**
 * https://leetcode.com/problems/single-number/
 * 
 * Given a non-empty array of integers, every element appears twice except for
 * one. Find that single one.
 * 
 * Note:
 * 
 * Your algorithm should have a linear runtime complexity. Could you implement
 * it without using extra memory?
 * 
 * Example 1:
 * 
 * Input: [2,2,1] Output: 1
 * 
 * Example 2:
 * 
 * Input: [4,1,2,1,2] Output: 4
 * 
 * XOR: 
 * 0^0 = 0
 * 0^1 = 1
 * 1^0 = 1
 * 1^1 = 0
 */
public class SingleNumber {

	public static int singleNumber(int[] nums) {
		int numb = nums[0];
		for (int i = 1; i < nums.length; i++) {
			numb ^= nums[i];
		}
		
		return numb;

	}

	public static void main(String[] arg) {
		
		int[] nums = {2,2,1};
		System.out.println(singleNumber(nums));

		int[] nums1 = {4,1,2,1,2};
		System.out.println(singleNumber(nums1));
		

	}
}
