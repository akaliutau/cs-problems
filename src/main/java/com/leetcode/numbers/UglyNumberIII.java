package com.leetcode.numbers;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/ugly-number-iii/
 * 
 * Write a program to find the n-th ugly number.
 * 
 * Ugly numbers are positive integers which are divisible by a or b or c.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 3, a = 2, b = 3, c = 5 Output: 4 Explanation: The ugly numbers are
 * 2, 3, 4, 5, 6, 8, 9, 10... The 3rd is 4.
 * 
 * Example 2:
 * 
 * Input: n = 4, a = 2, b = 3, c = 4 Output: 6 Explanation: The ugly numbers are
 * 2, 3, 4, 6, 8, 9, 10, 12... The 4th is 6. 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,
 * 1 1 1 1 1 1 --> 2 1 1 1 1 --> 3 -2 1 1 1 --> 4
 * 
 * 12/2 + 12/3 + 12/4 - 12/2*3 - 12/2*4 - 12/3*4 - 12/2*3*4 = 9 12/2 + 12/3 -
 * 12/2*3 - 12/3*4
 * 
 * 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 1 1 1 1 1 1 --> 2 1 1 1 --> 4 -2 1 1 -->
 * 5
 * 
 * 
 * 
 * Example 3:
 * 
 * Input: n = 5, a = 2, b = 11, c = 13 Output: 10 Explanation: The ugly numbers
 * are 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 1 1 1 1 1 1 1 1 1
 * 
 * 14/2 + 14/11 + 14/13 - 14/2*11 - 14/2*13 - 14/11*13 - 14/2*11*13 = 9
 * 
 * 1 2 3 4 5 6 7 8 9 10
 * 
 * The 5th is 10.
 * 
 * Example 4:
 * 
 * Input: n = 1000000000, a = 2, b = 217983653, c = 336916467 Output: 1999999984
 * 
 * 
 * Constraints:
 * 
 * 1 <= n, a, b, c <= 10^9 1 <= a * b * c <= 10^18 It's guaranteed that the
 * result will be in range [1, 2 * 10^9]
 * 
 */
public class UglyNumberIII {

	public static long lcm(long a, long b) {
		return (a * b) / gcd(a, b);
	}

	static long gcd(long n1, long n2) {
		if (n2 == 0) {
			return n1;
		}
		return gcd(n2, n1 % n2);
	}

	static long calcNumberOfUglies(long n, long a, long b) {
		long total = n / a + n / b;
		if (b % a != 0) {
			total -= n / lcm(a, b);
		} else {
			total -= n / b;
		}
		return total;
	}

	static long calcNumberOfUglies(long n, long a, long b, long c) {
		if (a == b && a == c) {
			return n / a;
		}
		if (c == b) {
			return calcNumberOfUglies(n, a, b);
		}
		if (a == b) {
			return calcNumberOfUglies(n, a, c);
		}
		if (a == c) {
			return calcNumberOfUglies(n, a, b);
		}

		long total = n / a + n / b + n / c;
		boolean bRemoved = false;
		if (b % a != 0) {
			total -= n / lcm(a, b);
		} else {
			total -= n / b;
			bRemoved = true;
		}
		if (c % a != 0) {
			total -= n / lcm(a, c);
		} else {
			total -= n / c;
			return total;// exit here
		}
		if (bRemoved) {
			return total;
		}
		if (c % b != 0) {
			total -= n / lcm(b, c);
		} else {
			total -= n / c;
		}

		return total;
	}

	public static int nthUglyNumber(int n, int a, int b, int c) {
		if (n == 1) {
			return 1;
		}

		int[] divs = new int[3];
		divs[0] = a;
		divs[1] = b;
		divs[2] = c;
		Arrays.sort(divs);
		long left = 1;
		long right = 2100000000;
		long nUgly = 0;
		long mid = 0;
		while (true) {
			mid = (left + right) / 2;
			nUgly = calcNumberOfUglies(mid, divs[0], divs[1], divs[2]);
			if (nUgly > n && nUgly - n <= 1) {
				break;
			}
			if (nUgly > n) {
				right = mid;
			} else {
				left = mid;
			}
		}
		boolean found = false;
		while (!found) {
			long next = calcNumberOfUglies(mid - 1, divs[0], divs[1], divs[2]);
			if (next < n) {
				return (int) mid;
			}
			mid--;
		}
		return -1;

	}

	public static void main(String[] arg) {

		System.out.println(nthUglyNumber(3, 2, 3, 5));// 4
		System.out.println(nthUglyNumber(4, 2, 3, 4));// 6
		System.out.println(nthUglyNumber(5, 2, 11, 13));// 10
		System.out.println(nthUglyNumber(5, 2, 3, 3));// 8
		System.out.println(nthUglyNumber(10, 7, 6, 8));// 28
		System.out.println(nthUglyNumber(1000000000, 2, 217983653, 336916467));// 1999999984

	}

}
