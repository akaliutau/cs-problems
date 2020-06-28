package org.problems.numbers;

/**
 * https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
 * 
 * Given an array nums of integers, return how many of them contain an even
 * number of digits.
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [12,345,2,6,7896] Output: 2 
 * Explanation: 12 contains 2 digits
 * (even number of digits). 345 contains 3 digits (odd number of digits). 2
 * contains 1 digit (odd number of digits). 6 contains 1 digit (odd number of
 * digits). 7896 contains 4 digits (even number of digits). Therefore only 12
 * and 7896 contain an even number of digits. 
 * 
 * Example 2:
 * 
 * Input: nums = [555,901,482,1771] Output: 1 
 * Explanation: Only 1771 contains an even number of digits.
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 500 
 * 1 <= nums[i] <= 10^5
 * 
 */
public class NumbersWithEvenNumberOfDigits {

	public static int findNumbers(int[] nums) {
		
		int n = nums.length;
		int even = 0;
		for (int i = 0; i < n; i++) {
			int len = (int) Math.log10(nums[i]) + 1;  
			if (len > 0 && len % 2 == 0) {
				even ++;
			}
		}
		
		return even;

	}

	public static void main(String[] arg) {
		
		int[] nums = {12,345,2,6,7896};
		System.out.println(findNumbers(nums));

		int[] nums1 = {555,901,482,1771};
		System.out.println(findNumbers(nums1));

	}

}
