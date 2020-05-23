package org.problems.arrays;

import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/product-of-array-except-self/
 *
 * Given an array nums of n integers where n > 1, return an array output such
 * that output[i] is equal to the product of all the elements of nums except
 * nums[i].
 * 
 * Example:
 * 
 * Input: [1,2,3,4] Output: [24,12,8,6] 
 * 
 * Constraint: It's guaranteed that the
 * product of the elements of any prefix or suffix of the array (including the
 * whole array) fits in a 32 bit integer.
 * 
 * 
 */
public class ProductOfArrayExceptSelf {
	
	public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] res = new int[n];

        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = nums[i - 1] * res[i - 1];
        }

        int prod = 1;
        for (int i = n - 1; i >= 0; i--) {
        	res[i] = res[i] * prod;
        	prod *= nums[i];
        }

        return res;
    }


	public static void main(String[] arg) {

		int[] nums = {1,2,3,4};
		Utils.print(productExceptSelf(nums));

	}
}
