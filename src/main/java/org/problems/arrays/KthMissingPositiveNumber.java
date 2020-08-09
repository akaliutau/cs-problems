package org.problems.arrays;

/**
 * https://leetcode.com/problems/kth-missing-positive-number/
 * 
 * Given an array arr of positive integers sorted in a strictly increasing
 * order, and an integer k.
 * 
 * Find the kth positive integer that is missing from this array.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: arr = [2,3,4,7,11], k = 5 Output: 9 Explanation: The missing positive
 * integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9
 * 
 * 
 */
public class KthMissingPositiveNumber {

	public int findKthPositive(int[] arr, int k) {
		int n = arr.length;
		int cur = 1;
		for (int i = 0; i < n; i++) {
			while (arr[i] != cur) {
				k--;
				if (k == 0) {
					return cur;
				}
				cur++;
			}
			cur++;
		}
		cur += k - 1;
		return cur;
	}

	public static void main(String[] arg) {
		System.out.println(true);
	}

}
