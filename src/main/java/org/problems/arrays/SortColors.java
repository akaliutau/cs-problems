package org.problems.arrays;

import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/sort-colors/
 * 
 * Given an array with n objects colored red, white or blue, sort them in-place
 * so that objects of the same color are adjacent, with the colors in the order
 * red, white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white,
 * and blue respectively.
 * 
 * Note: You are not suppose to use the library's sort function for this
 * problem.
 * 
 * Example:
 * 
 * Input: [2,0,2,1,1,0]
 * 
 * Output: [0,0,1,1,2,2]
 * 
 * 
 */
public class SortColors {
	
	static void swap (int i, int j, int[] nums) {
		int c = nums[i];
		nums[i] = nums[j];
		nums[j] = c;
	}
	
	public static void sortColors(int[] nums) {
		int pos = 0;
        for (int i = 0; i < nums.length; i++) {
        	if (nums[i] == 0) {
        		swap(pos,i,nums);
        		pos++;
        	}
        }
        for (int i = 0; i < nums.length; i++) {
        	if (nums[i] == 1) {
        		swap(pos,i,nums);
        		pos++;
        	}
        }
        for (int i = 0; i < nums.length; i++) {
        	if (nums[i] == 2) {
        		swap(pos,i,nums);
        		pos++;
        	}
        }
    }



	public static void main(String[] arg) {
		
		int[] nums = {2,0,2,1,1,0};
		sortColors(nums);
		Utils.print(nums);

		int[] nums1 = {2,0,1};
		sortColors(nums1);
		Utils.print(nums1);

		int[] nums2 = {0,1,2};
		sortColors(nums2);
		Utils.print(nums2);

		int[] nums3 = {1,2,0};
		sortColors(nums3);
		Utils.print(nums3);

		int[] nums4 = {2,0,1,1};
		sortColors(nums4);
		Utils.print(nums4);

		int[] nums5 = {2,2,2,1,1,1,0,0,1,1,1,1,1,2,2,2,2,2,2,0,0,1,1};
		sortColors(nums5);
		Utils.print(nums5);

	}
}
