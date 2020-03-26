package com.leetcode.arrays;

/**
 * https://leetcode.com/problems/find-the-duplicate-number/
 *
 * Given an array nums containing n + 1 integers where each integer is between 1
 * and n (inclusive), prove that at least one duplicate number must exist.
 * Assume that there is only one duplicate number, find the duplicate one.
 * 
 * Example 1:
 * 
 * Input: [1,3,4,2,2] Output: 2 Example 2:
 * 
 * Input: [3,1,3,4,2] Output: 3 Note:
 * 
 * You must not modify the array (assume the array is read only). You must use
 * only constant, O(1) extra space. Your runtime complexity should be less than
 * O(n^2). There is only one duplicate number in the array, but it could be
 * repeated more than once.
 * 
 * 
 */
public class FindDuplicate {
	
	public static int findDuplicate(int[] nums) {
        int firstPtr = nums[0];
        int secondPtr = nums[0];
    	firstPtr = nums[firstPtr];
    	secondPtr = nums[nums[secondPtr]];
    	while (firstPtr != secondPtr) {
        	firstPtr = nums[firstPtr];
        	secondPtr = nums[nums[secondPtr]];
        } 

        int ptr1 = nums[0];
        int ptr2 = firstPtr;
        while (ptr1 != ptr2) {
        	ptr1 = nums[ptr1];
        	ptr2 = nums[ptr2];
        }

        return ptr1;
        
    }

	public static void main(String[] arg) {

		int[] nums = {1, 3, 4, 2, 2};
		System.out.println(findDuplicate(nums));

		int[] nums1 = {1, 2, 4, 3, 2};
		System.out.println(findDuplicate(nums1));

		int[] nums2 = {1, 2, 1, 3, 1};
		System.out.println(findDuplicate(nums2));

	}
}
