package org.problems.numbers;

/**
 * https://leetcode.com/problems/closest-divisors/
 *
 *
 * Given an integer n, find the closest two integers in absolute difference
 * whose product equals n + 1 or n + 2.
 * 
 * Return the two integers in any order.
 */
public class ClosestDivisors {

	static int[] findDiv(int num, int i) {
		int[] res = new int[2];
		while (i-- > 1) {
			if (num % i == 0) {
				res[0] = i;
				res[1] = num / i;
				break;
			}
		}
		return res;
	}

	public static int[] closestDivisors(int num) {

		int[] res1 = findDiv(num + 1, (int) Math.sqrt(num + 1) + 1);
		int diff1 = Math.abs(res1[0] - res1[1]);

		int[] res2 = findDiv(num + 2, (int) Math.sqrt(num + 2) + 1);
		int diff2 = Math.abs(res2[0] - res2[1]);

		return diff1 > diff2 ? res2 : res1;
	}

	public static void main(String[] arg) {

		int[] arr = closestDivisors(8);
		System.out.println(arr[0] + " " + arr[1]);

		arr = closestDivisors(123);
		System.out.println(arr[0] + " " + arr[1]);

		arr = closestDivisors(999);
		System.out.println(arr[0] + " " + arr[1]);

		arr = closestDivisors(1);
		System.out.println(arr[0] + " " + arr[1]);
	}

}
