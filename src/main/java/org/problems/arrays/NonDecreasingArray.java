package org.problems.arrays;

/**
 * https://leetcode.com/problems/non-decreasing-array/
 * 
 * Given an array nums with n integers, your task is to check if it could become
 * non-decreasing by modifying at most 1 element.
 * 
 * We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for
 * every i (0-based) such that (0 <= i <= n - 2).
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [4,2,3] Output: true 
 * 
 * Explanation: You could modify the first 4
 * to 1 to get a non-decreasing array. Example 2:
 * 
 * Input: nums = [4,2,1] Output: false 
 * 
 * Explanation: You can't get a
 * non-decreasing array by modify at most one element.
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 10 ^ 4 
 * -10 ^ 5 <= nums[i] <= 10 ^ 5
 * 
 */
public class NonDecreasingArray {

	public static boolean checkPossibility(int[] nums) {
		int n = nums.length;
		int counter = 0;
		if (n <=1) {
			return true;
		}
        for (int i = 0; i < n-1; i++) {
        	if (nums[i] > nums[i+1]) {
        		counter++;
        		if ( i - 1 < 0) {
        			nums[i] = nums[i+1];
        		}else if (nums[i-1] <= nums[i+1]) {
            		nums[i] = nums[i-1];
            	}else {
            		nums[i+1] = nums[i];	
            	}
        	}
        	if (counter > 1) {
        		return false;
        	}
        }
        return true;
    }

	public static void main(String[] arg) {
		
		int[] nums = {4,2,3};
		System.out.println(checkPossibility(nums));//true

		int[] nums1 = {4,2,1};
		System.out.println(checkPossibility(nums1));//false

		int[] nums2 = {3,4,2,3};
		System.out.println(checkPossibility(nums2));//false

		int[] nums3 = {2,3,3,2,4};
		System.out.println(checkPossibility(nums3));//true

	}

}
