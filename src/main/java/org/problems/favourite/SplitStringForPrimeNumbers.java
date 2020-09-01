package org.problems.favourite;

import java.util.Arrays;

/**
 * Split string for prime numbers
 * 
 * Given a string of length n consisting of digits [0-9], count the number of
 * ways the given string can be split into prime numbers, each of which is in
 * the range 2 to 100 inclusive. Since the answer can be large, return the
 * answer modulo 10^9 + 7. 
 * Note: A partition that contains numbers with leading
 * zeroes will be invalid and the initial string does not contain leading
 * zeroes. 
 * 
 * Example1 11373, 
 * Output 6 
 * (11, 37, 3), (113, 7, 3), (11, 3, 73), (11, 37, 3), (113, 73) and (11, 373) 
 * 
 * Example2 3175
 * 
 * Output 3 
 * Explanation The 3 ways to split this string into prime numbers are
 * (31, 7,5), (3, 17, 5), (317,5)
 * 
 * 
 */
public class SplitStringForPrimeNumbers {

	static boolean[] getPrimes(int n) {
		boolean[] primes = new boolean[n + 1];
		Arrays.fill(primes, true);
		primes[0] = primes[1] = false;
		for (int i = 2; i <= n; i++) {
			if (!primes[i]) {
				continue;
			}
			for (int j = i * i; j <= n; j += i) {
				primes[j] = false;
			}
		}

		return primes;
	}

	static final int mod = 1000000000 + 7;
	
	static int fromString(String s) {
		if (s == null || s.isEmpty()) {
			return 0;
		}
		return Integer.valueOf(s);
	}

	public static int solve(String str) {
		int n = str.length();
		// dp[k] - number of ways to split string till k-th digit
		int[] dp = new int[n + 1]; 
		
		dp[0] = 1;

		boolean[] primes = getPrimes(1000);

		for (int i = 1; i <= n; i++) {

			// test for 1-9 without lead 0
			if (str.charAt(i - 1) != '0' && primes[fromString(str.substring(i - 1, i))]) {
				dp[i] = dp[i - 1];
			}

			if (i - 2 >= 0 && str.charAt(i - 2) != '0' && primes[fromString(str.substring(i - 2, i))]) {// test for 10-99
				dp[i] = (dp[i] + dp[i - 2]) % mod;
			}

			if (i - 3 >= 0 && str.charAt(i - 3) != '0' && primes[fromString(str.substring(i - 3, i))]) {// test for 100-999
				dp[i] = (dp[i] + dp[i - 3]) % mod;
			}

		}
		return dp[n];
	}

	public static void main(String[] arg) {

		System.out.println(solve("11373"));
		System.out.println(solve("3175"));
		System.out.println(solve("113"));
		System.out.println(solve("113731137311373"));
		System.out.println(solve("113435311717151727131137311373"));

	}

}
