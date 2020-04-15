package com.leetcode.numbers;

/**
 * https://leetcode.com/problems/count-largest-group/
 * 
 * Given an integer n. Each number from 1 to n is grouped according to the sum
 * of its digits.
 * 
 * Return how many groups have the largest size.
 * 
 * Example 1:
 * 
 * Input: n = 13 Output: 4 
 * 
 * Explanation: There are 9 groups in total, they are
 * grouped according sum of its digits of numbers from 1 to 13: 
 * [1,10], [2,11], [3,12], [4,13], [5], [6], [7], [8], [9]. 
 * There are 4 groups with largest size
 */
public class CountLargestGroup {

	static int getSum(int n) {
		int sum = 0;
		while (n > 0) {
			int d = n % 10;
			sum += d;
			n -= d;
			n /= 10;
		}
		return sum;
	}

	public static int countLargestGroup(int n) {
		int[] groups = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			groups[getSum(i)]++;
		}
		// find max
		int maxSize = 0;
		for (int i = 0; i < groups.length; i++) {
			maxSize = groups[i] > maxSize ? groups[i] : maxSize;
		}
		int count = 0;
		for (int i = 0; i < groups.length; i++) {
			if (groups[i] == maxSize) {
				count++;
			}
		}
		return count;

	}

	public static void main(String[] arg) {

		System.out.println(countLargestGroup(13));
		System.out.println(countLargestGroup(2));
		System.out.println(countLargestGroup(15));
		System.out.println(countLargestGroup(24));
		System.out.println(countLargestGroup(1));

	}

}
