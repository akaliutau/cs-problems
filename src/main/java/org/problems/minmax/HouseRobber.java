package org.problems.minmax;

/**
 * https://leetcode.com/problems/house-robber/
 *
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed, the only constraint stopping you
 * from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent houses
 * were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 * 
 * Example 1:
 * 
 * Input: [1,2,3,1] Output: 4 
 * 
 * Explanation: Rob house 1 (money = 1) and then rob
 * house 3 (money = 3). Total amount you can rob = 1 + 3 = 4. Example 2:
 * 
 * Input: [2,7,9,3,1] Output: 12 
 * 
 * Explanation: Rob house 1 (money = 2), rob house
 * 3 (money = 9) and rob house 5 (money = 1). 
 * Total amount you can rob = 2 + 9 + 1 = 12.
 * 
 * Input: [22,2,7,20] Output: 42 
 * Input: [2,3,2] Output: 4 
 * Input: [3,2,3] Output: 6 
 * 
 */
public class HouseRobber {
	
	public static int rob(int[] nums) {
		int n = nums.length;
		
		if (n == 0) {
			return 0;
		}
        
        int[] cummulative = new int[n];
        int[] left = new int[n];
        // always start from the 1st house
        cummulative[0] = nums[0];
        left[0] = 0;
        
        for (int i = 1; i < n; i++) {
        	cummulative[i] = left[i - 1] + nums[i];
            left[i] = Math.max(cummulative[i - 1], left[i - 1]);
        }
        return Math.max(cummulative[n - 1], left[n - 1]);
        
    }


	public static void main(String[] arg) {

		int[] nums = {1,2,3,1};
		System.out.println(rob(nums));

		int[] nums1 = {2,7,9,3,1};
		System.out.println(rob(nums1));

		int[] nums2 = {22,2,7,20};
		System.out.println(rob(nums2));

		int[] nums3 = {2,3,2};
		System.out.println(rob(nums3));

	}
}
