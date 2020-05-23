package org.problems.minmax;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/coin-change/
 *
 * You are given coins of different denominations and a total amount of money
 * amount. Write a function to compute the fewest number of coins that you need
 * to make up that amount. If that amount of money cannot be made up by any
 * combination of the coins, return -1.
 * 
 * Example 1:
 * 
 * Input: coins = [1, 2, 5], amount = 11 Output: 3
 * 
 * Explanation: 11 = 5 + 5 + 1
 * 
 * Example 2:
 * 
 * Input: coins = [2], amount = 3 Output: -1
 * 
 */
public class CoinChangeIII {
	
	public static int coinChange(int[] coins, int amount) {

		// table[i] will be storing the number of solutions
		// for value i.
		int[] table = new int[amount + 1];

		Arrays.fill(table, 0); // O(n)

		table[0] = 1;

		for (int i = 0; i < coins.length; i++) {
			for (int j = coins[i]; j <= amount; j++) {
				table[j] += table[j - coins[i]];
				if (table[j] == amount) {
					return i+1;
				}
			}
		}

		return -1;
	}

	public static void main(String[] arg) {
		
		int[] coins = {1, 2, 5};
		System.out.println(coinChange(coins, 11));

		int[] coins1 = {2};
		System.out.println(coinChange(coins1, 3));

	}

}
