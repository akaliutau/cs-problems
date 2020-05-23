package org.problems.active;

/**
 * https://leetcode.com/problems/longest-harmonious-subsequence/
 * 
 * We define a harmonious array as an array where the difference between its
 * maximum value and its minimum value is exactly 1.
 * 
 * Now, given an integer array, you need to find the length of its longest
 * contiguous harmonious subsequence among all its possible subsequences.
 * 
 * Example 1:
 * 
 * Input: [1,3,2,2,5,2,3,7] Output: 5 
 * Explanation: The longest harmonious subsequence is [3,2,2,2,3].
 * 
 * 
 * Note: The length of the input array will not exceed 20,000
 * 
 * 
 */
public class LongestHarmoniousSubsequence {
	

	public static int findLHS(int[] nums) {
		int n = nums.length;
		if (n < 2) {// 0 or 1
			return n;
		}
		int longest = 0;
		// build spectrum - need 2 lagest subsets with diff = 1
		
		return longest;

	}

	public static void main(String[] arg) {

		int[] nums = {1,3,2,2,5,2,3,7};
		System.out.println(findLHS(nums));

	}

}
