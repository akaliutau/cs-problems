package org.problems.favourite;

import java.util.HashSet;
import java.util.Set;

/**
 * Unique Pairs
 * 
 * Given an int array nums and an int target, find how many unique pairs in the
 * array such that their sum is equal to target. Return the number of pairs.
 * 
 * Example 1:
 * 
 * Input: nums = [1, 1, 2, 45, 46, 46], target = 47 Output: 2 
 * Explanation: 
 * 1 + 46 = 47 
 * 2 + 45 = 47
 * 
 * 
 */
public class UniquePairs {

	public static int uniquePairs(int[] nums, int target) {
		Set<Integer> set = new HashSet<>();
		Set<Integer> have = new HashSet<>();
		int count = 0;
		for (int num : nums) {
			if (set.contains(target - num) && !have.contains(num)) {
				count++;
				have.add(target - num);
				have.add(num);
			} else if (!set.contains(num)) {
				set.add(num);
			}
		}

		return count;
	}

	public static void main(String[] arg) {

		System.out.println("D");

	}

}
