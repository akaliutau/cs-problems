package org.problems.arrays;

/**
 * https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/
 * 
 * Given an array of integers arr of even length n and an integer k.
 * 
 * We want to divide the array into exactly n / 2 pairs such that the sum of
 * each pair is divisible by k.
 * 
 * Return True If you can find a way to do that or False otherwise.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: arr = [1,2,3,4,5,10,6,7,8,9], k = 5 Output: true 
 * Explanation: Pairs
 * are (1,9),(2,8),(3,7),(4,6) and (5,10).
 * 
 * 
 * 
 */
public class PairsDivisibleByK {

	public boolean canArrange(int[] arr, int k) {

		int n = arr.length;
		int[] mod = new int[n];
		for (int i = 0; i < n; i++) {
			int diff = arr[i] - k;
			if (Math.abs(diff) >= k) {
				diff = diff % k;
			}
			mod[i] = diff;
		}
		long sum = 0;
		for (int i = 0; i < n; i++) {
			sum += mod[i];
		}
		if (Math.abs(sum) >= k) {
			return sum % k == 0;
		}

		return sum == 0;

	}

	public static void main(String[] arg) {
		System.out.println(true);
	}

}
