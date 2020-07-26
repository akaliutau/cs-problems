package org.problems.arrays;

/**
 * https://leetcode.com/problems/remove-element
 * 
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 * 
 * 
 */
public class RemoveElem {

	public static int removeElement(int[] nums, int val) {
        int n = nums.length;
        int write = 0;
        for (int i = 0; i < n; i++){
            if (nums[i] != val){
                nums[write++] = nums[i];
            }
        }
        return write;
    }
	
	public static void main(String[] arg) {
		int[] nums = {3,2,2,4};
		System.out.println(removeElement(nums, 2));
	}

}
