package org.problems.datastructures;

/**
 * https://leetcode.com/problems/range-sum-query-immutable/
 * 
 * Given an integer array nums, find the sum of the elements between indices i
 * and j (i ≤ j), inclusive.
 * 
 * Example:
 * 
 * Given nums = [-2, 0, 3, -5, 2, -1]
 * 
 * sumRange(0, 2) -> 1 sumRange(2, 5) -> -1 sumRange(0, 5) -> -3
 * 
 */
public class RangeSumQueryImmutable {
	
	static class NumArray {
		private int n;
		private int[] sums;

	    public NumArray(int[] nums) {
	        n = nums.length;
	        sums = new int[n];
	        for (int i = 0; i < n; i++) {
	        	sums[i] = i - 1 >= 0 ? sums[i - 1] + nums[i] : nums[i];
	        }
	    }
	    
	    public int sumRange(int i, int j) {
	    	if (n == 0) {
	    		return 0;
	    	}
	        return i - 1 >= 0 ? sums[j] - sums[i - 1] : sums[j];
	    }
	}

	public static void main(String[] arg) {
		System.out.println(true);
	}

}
