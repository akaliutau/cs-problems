package org.problems.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/single-number-ii/
 * 
 * Given a non-empty array of integers, every element appears three times except
 * for one, which appears exactly once. Find that single one.
 * 
 * Example 1:
 * 
 * Input: [2,2,3,2] Output: 3
 * 
 * Example 2:
 * 
 * Input: [0,1,0,1,0,1,99] Output: 99
 */
public class SingleNumberII {

	public static int singleNumber(int[] nums) {
		int n = nums.length;
		Set<Integer> doubleSet = new HashSet<>();
		Set<Integer> tripleSet = new HashSet<>();
		for (int i = 0; i < n; i++) {
			int num = nums[i];
			if (doubleSet.contains(num)) {
				tripleSet.add(num);
				doubleSet.remove(num);
			}else if (tripleSet.contains(num)) {
				tripleSet.remove(num);
			}else {
				doubleSet.add(num);
			}
		}
		for (Integer i : doubleSet) {
			return i;
		}
		return 0;
        
    }

	public static void main(String[] arg) {
		int[] nums = {2,2,3,2};
		System.out.println(singleNumber(nums));

		int[] nums1 = {0,1,0,1,0,1,99};
		System.out.println(singleNumber(nums1));

	}

}
