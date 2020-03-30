package com.leetcode.arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/contiguous-array/
 *
 * Given a binary array, find the maximum length of a contiguous subarray with
 * equal number of 0 and 1.
 * 
 * Example 1: Input: [0,1] Output: 2 Explanation: [0, 1] is the longest
 * contiguous subarray with equal number of 0 and 1.
 * 
 * Example 2: Input: [0,1,0] Output: 2 Explanation: [0, 1] (or [1, 0]) is a
 * longest contiguous subarray with equal number of 0 and 1.
 * 
 * Note: The length of the given binary array will not exceed 50,000.
 * 
 */
public class ContiguousBinaryArray {

	public static int findMaxLength(int[] nums) {
        int n = nums.length;
        int[] arr = new int[2 * n + 1];
        Arrays.fill(arr, -2);
        arr[n] = -1;
        int len = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            count = count + (nums[i] == 0 ? -1 : 1);
            if (arr[count + n] >= -1) {
                len = Math.max(len, i - arr[count + n]);
            } else {
                arr[count + n] = i;
            }

        }
        return len;

	}

	public static void main(String[] arg) {
		
		int[] nums = { 0, 1, 0, 0, 0, 1, 1 };
		System.out.println(findMaxLength(nums));//6


		int[] nums0 = { 0, 1, 0, 0, 0, 0, 1, 1 };
		System.out.println(findMaxLength(nums0));//4

		int[] nums1 = { 0, 1, 0};
		System.out.println(findMaxLength(nums1));//2

		int[] nums2 = { 0, 1};
		System.out.println(findMaxLength(nums2));//2

		int[] nums3 = { 0, 1, 0, 1, 0, 0, 1, 1 };
		System.out.println(findMaxLength(nums3));//8


		int[] nums4 = { };
		System.out.println(findMaxLength(nums4));//0
		
		int[] nums5 = {0,1,1,0,1,1,1,0};
		System.out.println(findMaxLength(nums5));//4

		int[] nums6 = {1,1,1,1,1,1,1,0,0,0,0,1,1,0,1,0,0,1,1,1,1,1,1,1,1,1,0,0,0,0,1,0,0,0,0,1,0,1,0,0,0,1,1,0,0,0,0,1,0,0,1,1,1,1,1,0,0,1,0,1,1,0,0,0,1,0,0,0,1,1,1,0,1,1,0,1,0,0,1,1,0,1,0,0,1,1,1,0,0,1,0,1,1,1,0,0,1,0,1,1};
		System.out.println(findMaxLength(nums6));//94

		int[] nums7 = {0,1,0,1,1,1,0,0,1,1,0,1,1,1,1,1,1,0,1,1,0,1,1,0,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,0,0,0,0,1,0,0,0,1,1,1,0,1,0,0,1,1,1,1,1,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,0,0,0,1,0,1,0,1,1,0,0,1,1,0,1,1,1,1,0,1,1,0,0,0,1,1};
		System.out.println(findMaxLength(nums7));//68



	}

}
