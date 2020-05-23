package org.problems.active;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/form-largest-integer-with-digits-that-add-up-to-target/
 * 
 * Given an array of integers cost and an integer target. Return the maximum
 * integer you can paint under the following rules:
 * 
 * The cost of painting a digit (i+1) is given by cost[i] (0 indexed). The total
 * cost used must be equal to target. Integer does not have digits 0. Since the
 * answer may be too large, return it as string.
 * 
 * If there is no way to paint any integer given the condition, return "0".
 * 
 * Formally:
 * 
 * totalCost = d1 * c1 + d2 * c2 + ... + d9 * c9 
 * 
 */
public class sol192 {

	static class Digit {
		public int cost;
		public int n;

		public Digit(int cost, int n) {
			this.cost = cost;
			this.n = n;
		}

		@Override
		public String toString() {
			return "Digit [cost=" + cost + ", n=" + n + "]";
		}

	}

	public static String largestNumber(int[] cost, int target) {

		Digit[] digits = new Digit[9];
		for (int i = 0; i < 9; i++) {
			digits[i] = new Digit(cost[i], i + 1);
		}
		Comparator<Digit> byCost = (o, p) -> Integer.compare(o.cost, p.cost);
		Comparator<Digit> byNumber = (o, p) -> Integer.compare(p.n, o.n);
		Arrays.sort(digits, byCost.thenComparing(byNumber));

		System.out.println(Arrays.toString(digits));
		
		if (digits[0].cost > target) {
			return "0";
		}
		
		boolean[][] dp = new boolean[9][target+1];
		int curCost = digits[0].cost;
		for (int i = 0; i <= target; i+=curCost) {
			dp[0][i] = true;
		}
		// prune digits from excessive digits
		
		// fill out table line by line
		for (int i = 1; i < 9; i++) {
			dp[i][0] = true;
			curCost = digits[i].cost;
			for (int j = 0; j <= target; i++) {
				if (dp[i-1][j]) {
					dp[i][j] = true;
					continue;
				}
				dp[i][j] = j % curCost == 0;
			}
		}
		// find coefficients
		
		
		StringBuilder sb = new StringBuilder();
		int idx = 0;
		while (target > 0 && idx < 9) {
			int num = target / digits[idx].cost;
			target -= num * digits[idx].cost;
			for (int i = 0; i < num; i++) {
				sb.append("" + digits[idx].n);
			}
			idx++;
		}
		return sb.toString();

	}

	public static void main(String[] arg) {

		int[] cost = { 4, 3, 2, 5, 6, 7, 2, 5, 5 };
		System.out.println(largestNumber(cost, 9));

	}

}
