package org.problems.arrays;

/**
 * https://leetcode.com/problems/increasing-triplet-subsequence/
 * 
 * Given an unsorted array return whether an increasing subsequence of length 3
 * exists or not in the array.
 * 
 * Formally the function should:
 * 
 * Return true if there exists i, j, k such that arr[i] < arr[j] < arr[k] given
 * 0 ≤ i < j < k ≤ n-1 else return false. Note: Your algorithm should run in
 * O(n) time complexity and O(1) space complexity.
 * 
 * Example 1:
 * 
 * Input: [1,2,3,4,5] Output: true 
 * 
 * Example 2:
 * 
 * Input: [5,4,3,2,1] Output: false
 * 
 * [5,4,3,2,1,3,5]
 * 
 */
public class IncreasingTripletSubseq {
	

	public static boolean increasingTriplet(int[] nums) {
		int n = nums.length;
		
		if (n < 3) {
			return false;
		}
		int minVal = Integer.MAX_VALUE;
		int midVal = Integer.MAX_VALUE;
		
		for (int i = 0; i < n; i++) {
			int cur = nums[i];
	         if(cur > midVal && midVal > minVal) {
	                return true;
	            }
	            else if(cur > minVal) {
	            	midVal = cur;
	            }
	            else if(cur < minVal) {
	            	minVal = cur;
	            }
		}
		
		return false;

	}

	public static void main(String[] arg) {

		int[] nums = {1,2,3,4,5};
		System.out.println(increasingTriplet(nums));

		int[] nums1 = {5,4,3,2,1};
		System.out.println(increasingTriplet(nums1));

		int[] nums2 = {5,4,3,2,1,3,5};
		System.out.println(increasingTriplet(nums2));

		int[] nums3 = {1,2,2};
		System.out.println(increasingTriplet(nums3));

		int[] nums4 = {1,1,1};
		System.out.println(increasingTriplet(nums4));

		int[] nums5 = {2,5,3,4,5};
		System.out.println(increasingTriplet(nums5));

		int[] nums6 = {2,5,3,4,3,5};
		System.out.println(increasingTriplet(nums6));//true

	}

}
