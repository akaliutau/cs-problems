package org.problems.arrays;

/**
 * https://leetcode.com/problems/number-of-good-pairs/
 * 
 * Given an array of integers nums.
 * 
 * A pair (i,j) is called good if nums[i] == nums[j] and i < j.
 * 
 * Return the number of good pairs.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3,1,1,3] Output: 4 Explanation: There are 4 good pairs
 * (0,3), (0,4), (3,4), (2,5) 0-indexed
 * 
 */
public class NumberOfGoodPairs {

	public int numIdenticalPairs(int[] nums) {
		int n = nums.length;
		int counter = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (nums[i] == nums[j]) {
					counter++;
				}
			}
		}
		return counter;
	}

	public static void main(String[] arg) {
		System.out.println(true);
	}

}
