package org.problems.arrays;

import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * 
 * Given a sorted array nums, remove the duplicates in-place such that each
 * element appear only once and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this by modifying
 * the input array in-place with O(1) extra memory.
 * 
 * Example 1:
 * 
 * Given nums = [1,1,2],
 * 
 * Your function should return length = 2
 * 
 */
public class RemoveDuplicatesI {

	public static int removeDuplicates(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		
		int cur = nums[0];
		int len = 0;
		nums[len] = cur;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != cur) {
				len++;
				cur = nums[i];
				nums[len] = cur;
			}
		}
		
		return len+1;
        
    }

	public static void main(String[] arg) {
		
		int[] nums = new int[] {1,1,2};

		System.out.println(removeDuplicates(nums));
		Utils.print(nums);

		int[] nums2 = new int[] {1};

		System.out.println(removeDuplicates(nums2));
		Utils.print(nums2);

	}
}
