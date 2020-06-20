package org.problems.statistics;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/summary-ranges/
 * 
 * Given a sorted integer array without duplicates, return the summary of its
 * ranges.
 * 
 * Example 1:
 * 
 * Input: [0,1,2,4,5,7] Output: ["0->2","4->5","7"] Explanation: 0,1,2 form a
 * continuous range; 4,5 form a continuous range. 
 * 
 * Example 2:
 * 
 * Input: [0,2,3,4,6,8,9] Output: ["0","2->4","6","8->9"] Explanation: 2,3,4
 * form a continuous range; 8,9 form a continuous range.
 * 
 * 
 * 
 */
public class SummaryRanges {

	public static List<String> summaryRanges(int[] nums) {
		int n = nums.length;
		int left = 0;
		int right = -1;
		List<String> res = new ArrayList<>();
		if (n == 0) {
			return res;
		}
        if (n == 1) {
            res.add(""+nums[0]);
			return res;
		}
		left = nums[0];
		for (int i = 1; i < n; i++) {
			if (Math.abs(nums[i] - nums[i-1]) > 1) {
				right = nums[i-1];
				if (left != right) {
					res.add(String.format("%d->%d", left, right));
				}else {
					res.add(String.format("%d", left));
				}
				left = nums[i];
				right = -1;
			}
		}
		System.out.println(left+":" +right);
		if (right == -1) {
			right = nums[n-1];
			System.out.println(left+":" +right);
			if (left != right) {
				res.add(String.format("%d->%d", left, right));
			}else {
				res.add(String.format("%d", left));
			}
		}
		
		return res;

	}

	public static void main(String[] arg) {

		int[] nums = {0,1,2,4,5,7};
		System.out.println(summaryRanges(nums));

		int[] nums1 = {0,2,3,4,6,8,9};
		System.out.println(summaryRanges(nums1));
		
		int[] nums2 = {0,1};
		System.out.println(summaryRanges(nums2));


	}

}
