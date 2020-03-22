package com.leetcode.numbers;

/**
 * https://leetcode.com/contest/weekly-contest-181/problems/four-divisors/
 * 
 * Given an integer array nums, return the sum of divisors of the integers in
 * that array that have exactly four divisors.
 * 
 * If there is no such integer in the array, return 0.
 * 
 * 
 */
public class FourDivisors {

	public static int sum(int num) {
		int sum = 0;
		int counter = 0;

		for (int i = 1; i * i <= num; i++) {
			if (num % i == 0) {
				sum += i;
				counter++;
				System.out.println("i=" + i);
				if (counter > 4) {
					return 0;
				}
			}
			if (num % i == 0 && num / i != i) {
				sum += num / i;
				System.out.println("i=" + num / i);
				counter++;
				if (counter > 4) {
					return 0;
				}
			}
		}
		if (counter == 4) {
			return sum;
		}
		return 0;
	}

	public static int sumFourDivisors(int[] nums) {
		int sum = 0;
		for (int n : nums) {
			sum += sum(n);
		}
		return sum;
	}

	public static void main(String[] arg) {

		int[] nums = { 21, 4, 7 };
		System.out.println(sumFourDivisors(nums));

		int[] nums0 = { 7 };
		System.out.println(sumFourDivisors(nums0));

		int[] nums1 = {};
		System.out.println(sumFourDivisors(nums1));

		int[] nums2 = { 1, 2, 3, 4, 5 };
		System.out.println(sumFourDivisors(nums2));

	}

}
