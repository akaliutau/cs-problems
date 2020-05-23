package org.problems.arrays;

/**
 * https://leetcode.com/problems/maximum-average-subarray-i/
 * 
 * Given an array consisting of n integers, find the contiguous subarray of
 * given length k that has the maximum average value. And you need to output the
 * maximum average value.
 * 
 * Example 1:
 * 
 * Input: [1,12,-5,-6,50,3], k = 4 Output: 12.75 
 * Explanation: Maximum average is
 * (12-5-6+50)/4 = 51/4 = 12.75
 * 
 * 1 13 8 2 52 55
 * 
 * 
 * Note:
 * 
 * 1 <= k <= n <= 30,000. Elements of the given array will be in the range
 * [-10,000, 10,000]
 * 
 * 
 */
public class MaximumAverageSubarrayI {

	public static double findMaxAverage(int[] nums, int k) {
		int n = nums.length;
		if (n == 0) {
			return 0.0d;
		}
		if (n == 1) {
			return nums[0];
		}

		int[] sum = new int[n];
		sum[0] = nums[0];
		for (int i = 1; i < n; i++) {
			sum[i] = nums[i] + sum[i-1];
		}
		double max = -Double.MAX_VALUE;
		for (int i = 0; i < n-k+1; i++) {
			double avg = sum[i + k - 1];
			if (i > 0) {
				avg -= sum[i-1];
			}
			avg = avg / k;
			max = Math.max(avg, max);
		}
		
		return max;

	}

	public static void main(String[] arg) {
		
		int[] nums = {1,12,-5,-6,50,3};
		System.out.println(findMaxAverage(nums,4));

		int[] nums1 = {-1};
		System.out.println(findMaxAverage(nums1,1));

		int[] nums2 = {-1,2};
		System.out.println(findMaxAverage(nums2,1));
		
		int[] nums3 =  {8860,-853,6534,4477,-4589,8646,-6155,-5577,-1656,-5779,-2619,-8604,-1358,-8009,4983,7063,3104,-1560,4080,2763,5616,-2375,2848,1394,-7173,-5225,-8244,-809,8025,-4072,-4391,-9579,1407,6700,2421,-6685,5481,-1732,-8892,-6645,3077,3287,-4149,8701,-4393,-9070,-1777,2237,-3253,-506,-4931,-7366,-8132,5406,-6300,-275,-1908,67,3569,1433,-7262,-437,8303,4498,-379,3054,-6285,4203,6908,4433,3077,2288,9733,-8067,3007,9725,9669,1362,-2561,-4225,5442,-9006,-429,160,-9234,-4444,3586,-5711,-9506,-79,-4418,-4348,-5891};
		System.out.println(findMaxAverage(nums3,93));

	}

}
