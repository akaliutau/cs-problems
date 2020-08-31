package org.problems.minmax;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-k-th-smallest-pair-distance/
 * 
 * Given an integer array, return the k-th smallest distance among all the
 * pairs. The distance of a pair (A, B) is defined as the absolute difference
 * between A and B.
 * 
 * Example 1: Input: nums = [1,3,1] k = 1 Output: 0 Explanation: Here are all
 * the pairs: 
 * (1,3) -> 2 
 * (1,1) -> 0 
 * (3,1) -> 2
 * 
 * Then the 1st smallest distance pair is (1,1), and its distance is 0.
 * 
 * Note: 2 <= len(nums) <= 10000. 
 * 0 <= nums[i] < 1000000. 
 * 1 <= k <= len(nums) * (len(nums) - 1) / 2.
 * 
 * Runtime: 5 ms, faster than 63.32% of Java online submissions for Find K-th Smallest Pair Distance.
 * Memory Usage: 39.8 MB, less than 68.90% of Java online submissions for Find K-th Smallest Pair Distance.
 */
public class FindKthSmallestPairDist {

	public int smallestDistancePair(int[] nums, int k) {
		
		int n = nums.length;
		Arrays.sort(nums);

		int l = 0;
		int r = nums[n - 1] - nums[0];
		while (l < r) {
			int mid = (l + r) / 2;
			int count = 0;
			int left = 0;
			for (int right = 0; right < n; right++) {
				while (nums[right] - nums[left] > mid) {
					left++;
				}
				count += right - left;
			}
			if (count >= k) {
				r = mid;
			}else {
				l = mid + 1;
			}
		}
		return l;
	}

	public static void main(String[] arg) {
		System.out.println(true);
	}

}
