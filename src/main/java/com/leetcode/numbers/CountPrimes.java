package com.leetcode.numbers;

/**
 * https://leetcode.com/problems/count-primes/
 * 
 * Count the number of prime numbers less than a non-negative number, n.
 * 
 * Example:
 * 
 * Input: 10 Output: 4 
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7
 */
public class CountPrimes {
	
	static boolean isPrime(int n) {
		if (n == 0 || n == 1) {
			return false;
		}
		if (n == 2) {
			return true;
		}
		if (n % 2 == 0) {
			return false;
		}
		for (int i = 3; i < Math.sqrt(n)+1; i+=2) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static int countPrimes(int n) {
		int counter = 0;
		for (int i = 2; i < n; i++) {
			if (isPrime(i)) {
				counter ++;
			}
		}
		return counter;

	}

	public static void main(String[] arg) {

		System.out.println(countPrimes(10));
		System.out.println(countPrimes(14));

	}

}
