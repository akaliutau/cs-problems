package com.leetcode.arrays;

import com.leetcode.utils.Utils;

/**
 * https://leetcode.com/problems/rotate-array/
 *
 * Given an array, rotate the array to the right by k steps, where k is
 * non-negative.
 * 
 * Example 1:
 * 
 * Input:  [1,2,3,4,5,6,7] and k = 3 
 * Output: [5,6,7,1,2,3,4] 
 * 
 * Explanation: 
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5] 
 * rotate 3 steps to the right: [5,6,7,1,2,3,4] 
 * 
 * Example 2:
 * 
 * Input:  [-1,-100,3,99] and k = 2 
 * Output: [3,99,-1,-100] 
 * 
 * Explanation: 
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100] 
 * 
 * Note:
 * 
 * do it in-place with O(1) extra space
 * 
 */
public class RotateArray {

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int t = nums[start];
            nums[start] = nums[end];
            nums[end] = t;
            start++;
            end--;
        }
    }
    
     public static void rotate(int[] nums, int k) {
    	int n = nums.length;
        k = k % n;
        if (k == 0) {
        	return;
        }
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

	public static void main(String[] arg) {

		int[] nums = {1,2,3,4,5,6,7};
		rotate(nums,3);
		Utils.print(nums);
		
		int[] nums1 = {-1,-100,3,99};
		rotate(nums1,2);
		Utils.print(nums1);

		int[] nums2 = {1,-100};
		rotate(nums2,2);
		Utils.print(nums2);

		int[] nums3 = {5};
		rotate(nums3,2);
		Utils.print(nums3);

		int[] nums4 = {1,-100};
		rotate(nums4,1);
		Utils.print(nums4);

		int[] nums5 = {1,2,3,4,5,6};
		rotate(nums5,3);
		Utils.print(nums5);

	}
}
