package com.leetcode.arrays;

import java.util.Arrays;

import com.leetcode.utils.Utils;

/**
 * https://leetcode.com/problems/set-mismatch/
 *
 * The set S originally contains numbers from 1 to n. But unfortunately, due to
 * the data error, one of the numbers in the set got duplicated to another
 * number in the set, which results in repetition of one number and loss of
 * another number.
 * 
 * Given an array nums representing the data status of this set after the error.
 * Your task is to firstly find the number occurs twice and then find the number
 * that is missing. Return them in the form of an array.
 * 
 * Example 1: Input: nums = [1,2,2,4] Output: [2,3] 
 * 
 * Note: The given array size will in the range [2, 10000]. 
 * The given array's numbers won't have any order.
 * 
 */
public class FindDuplicateII {

	public static int[] findErrorNums(int[] nums) {
        int[] dup = new int[2];
        int n = nums.length;
        
        Arrays.sort(nums);
        int num = nums[0];
        for (int i = 1; i < n; i++) {
        	if (num == nums[i]) {
        		break;
        	}
        	num = nums[i];
        }
        
        dup[0] = num;
        int sum = 0;
        for (int i = 0; i < n; i++) {
        	sum += nums[i];
        }
        dup[1] = n * (n + 1)/2 - sum + num;
        
          
		return dup;
        
    }

	public static void main(String[] arg) {
		
		int[] nums = {1, 3, 4, 2, 2};
		Utils.print(findErrorNums(nums));// [2,5]

		int[] nums1 = {1,2,2,4};
		Utils.print(findErrorNums(nums1));// [2,3]

		int[] nums2 = {2,2};
		Utils.print(findErrorNums(nums2));// [2,1]

	}
}
