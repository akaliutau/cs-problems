package org.problems.minmax;

import java.util.Arrays;

import org.problems.model.TreeNode;

/**
 * https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/
 * 
 * Given the array of integers nums, you will choose two different indices i and j of that array. Return the maximum value of (nums[i]-1)*(nums[j]-1)
 * 
 * 
 */
public class MaximumProduct {
	
	public static int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int maxR = (nums[n-1]-1) * (nums[n-2]-1);
        int maxL = (nums[0]-1) * (nums[1]-1);
        return Math.max(maxL, maxR);
    }


	public static void main(String[] arg) {

		int[] nums = {3,4,5,2};
		System.out.println(maxProduct(nums));
		int[] nums1 = {1,5,4,5};
		System.out.println(maxProduct(nums1));
		int[] nums2 = {3,7};
		System.out.println(maxProduct(nums2));
		int[] nums3 = {1,2};
		System.out.println(maxProduct(nums3));

	}

}
