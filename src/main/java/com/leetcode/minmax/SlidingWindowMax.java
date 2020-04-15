package com.leetcode.minmax;

/**
 * https://leetcode.com/problems/sliding-window-maximum/
 *
 * Given an array nums, there is a sliding window of size k which is moving from
 * the very left of the array to the very right. You can only see the k numbers
 * in the window. Each time the sliding window moves right by one position.
 * Return the max sliding window.
 * 
 * Follow up: Could you solve it in linear time?
 * 
 * Example:
 * 
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3 Output: [3,3,5,5,6,7]
 * Explanation:
 * 
 * Window   position    Max 
 * ---------------      ----- 
 * [1 3 -1] -3 5 3 6 7  3 
 * 1 [3 -1 -3] 5 3 6 7  3 
 * 1 3 [-1 -3 5] 3 6 7  5 
 * 1 3 -1 [-3 5 3] 6 7  5 
 * 1 3 -1 -3 [5 3 6] 7  6 
 * 1 3 -1 -3 5  [3 6 7] 7
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 10^5 
 * -10^4 <= nums[i] <= 10^4 
 * 1 <= k <= nums.length
 * 
 */
public class SlidingWindowMax {
	
	static int getMaxOnRange(int[] nums, int left, int right) {
		int max = Integer.MIN_VALUE;
		// find the max element win window
		for (int j = left; j <= right; j++) {
			if (nums[j] > max) {
				max = nums[j];
			}
		}
		return max;
	}

	public int[] maxSlidingWindow(int[] nums, int k) {
		int n = nums.length;
		int max = getMaxOnRange(nums, 0, k-1);
		int left = 0;

		int res[] = new int[n - k + 1];
		res[0] = max;
		
		for (int i = k; i < n; i++) {
			if (nums[left] == max) {
				if (nums[i] > max) {
					max = nums[i];
				} else {
					max = getMaxOnRange(nums, left + 1, i);
				}
			} else {
				max = Math.max(max, nums[i]);
			}
			res[i - k + 1] = max;
			left++;
		}
		
		return res;
	}

	public static void main(String[] arg) {

		System.out.println(true);

	}
}
