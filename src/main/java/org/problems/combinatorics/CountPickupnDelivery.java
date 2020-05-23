package org.problems.combinatorics;

/**
 * https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options
 *
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Count All
 * Valid Pickup and Delivery Options. Memory Usage: 36 MB, less than 100.00% of
 * Java online submissions for Count All Valid Pickup and Delivery Options.
 */
public class CountPickupnDelivery {

	public static long base = 1000000007;

	public static int countOrders(int n) {
		long res = 1;
		int powCounter = n;
		for (int i = 1; i < 2 * n + 1; i++) {
			res = res * i;
			if (powCounter > 0 && i % 2 == 0) {
				res /= 2;
				powCounter--;
			}
			res = res % base;
		}

		return (int) res;

	}

	public static void main(String[] arg) {

		System.out.println(countOrders(2));// 6
		System.out.println(countOrders(3));// 90
		System.out.println(countOrders(4));// 2520

	}

}
