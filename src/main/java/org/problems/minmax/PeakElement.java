package org.problems.minmax;

/**
 * https://leetcode.com/problems/find-peak-element/
 * 
 * A peak element is an element that is greater than its neighbors.
 * 
 * Given an input array nums, where nums[i] != nums[i+1], find a peak element and
 * return its index.
 * 
 * The array may contain multiple peaks, in that case return the index to any
 * one of the peaks is fine.
 * 
 * You may imagine that nums[-1] = nums[n] = -inf
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3,1] Output: 2 
 * Explanation: 3 is a peak element and your
 * function should return the index number 2. Example 2:
 * 
 * Input: nums = [1,2,1,3,5,6,4] Output: 1 or 5 
 * Explanation: Your function can
 * return either index number 1 where the peak element is 2, or index number 5
 * where the peak element is 6. Note:
 * 
 * Your solution should be in logarithmic complexity.
 * 
 */
public class PeakElement {

	public static int findPeakElement(int[] nums) {
		int left = 0;
		int right = nums.length-1;
		int n = nums.length;
		for (int i = 0; i < n-2; i++) {
			if (nums[i] < nums[i+1] && nums[i+1] > nums[i+2]) {
				return i+1;
			}
		}
		if (nums[left] < nums[right]) {
			return right;
		}
		return left;

	}

	public static void main(String[] arg) {
		
		int[] nums = {1,2,3,1};
		System.out.println(findPeakElement(nums));

		int[] nums1 = {1,2,1,3,5,6,4};
		System.out.println(findPeakElement(nums1));
		
		int[] nums3 = {1};
		System.out.println(findPeakElement(nums3));

		int[] nums4 = {1,2};
		System.out.println(findPeakElement(nums4));
		
		int[] nums5 = {3,1};
		System.out.println(findPeakElement(nums5));


	}

}
