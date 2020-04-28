package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/k-diff-pairs-in-an-array/
 * 
 * Given an array of integers and an integer k, you need to find the number of
 * unique k-diff pairs in the array. Here a k-diff pair is defined as an integer
 * pair (i, j), where i and j are both numbers in the array and their absolute
 * difference is k.
 * 
 * Example 1: Input: [3, 1, 4, 1, 5], k = 2 
 * Output: 2 
 * Explanation: There are two
 * 2-diff pairs in the array, (1, 3) and (3, 5). Although we have two 1s in the
 * input, we should only return the number of unique pairs. 
 * 
 * Example 2: Input:[1, 2, 3, 4, 5], k = 1 
 * Output: 4 
 * Explanation: There are four 1-diff pairs in the
 * array, (1, 2), (2, 3), (3, 4) and (4, 5). 
 * 
 * Example 3: Input: [1, 3, 1, 5, 4],
 * k = 0 Output: 1 
 * Explanation: There is one 0-diff pair in the array, (1, 1).
 * Note: The pairs (i, j) and (j, i) count as the same pair. The length of the
 * array won't exceed 10,000. All the integers in the given input belong to the
 * range: [-1e7, 1e7]
 * 
 */
public class KdiffPairs {
	
	static class Level {
		public int count = 1;

		public Level() {
		}
	}
	
	public static int findPairs(int[] nums, int k) {
		
		Map<Integer,Level> levels = new HashMap<>();
		for (int num : nums) {
			if (!levels.containsKey(num)) {
				levels.put(num, new Level());
			}else {
				levels.get(num).count ++;
			}
		}
		int counter = 0;
		if (k == 0) {// just count the number of distinct keys with count > 1
			for (Level level : levels.values()) {
				if (level.count > 1) {
					counter ++;
				}
			}
			return counter;
		}
		List<Integer> vals = new ArrayList<>(levels.keySet());
		Collections.sort(vals);
		int next = 0;
		int n = vals.size();
		int idx = 0;
		for (Integer level : vals) {
			boolean found = false;
			next = idx;
			while (next < n) {
				if (vals.get(next)-level == k) {
					found = true;
					break;
				}
				next++;
			}
			if (found) {
				counter ++;
			}
			idx ++;
		}
		return counter;

	}

	public static void main(String[] arg) {
		
		int[] nums = {3, 1, 4, 1, 5};
		System.out.println(findPairs(nums,2));

		int[] nums1 = {1, 2, 3, 4, 5};
		System.out.println(findPairs(nums1,1));

		int[] nums2 = {3, 1, 4, 1, 5};
		System.out.println(findPairs(nums2,0));

		int[] nums3 = {6,2,9,3,9,6,7,7,6,4};
		System.out.println(findPairs(nums3,3));


	}

}
