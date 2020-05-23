package org.problems.active;

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
 * Note: You may assume that you have an infinite number of each kind of coin.
 * 
 * .
 */
public class CoinChangeII {
	
	public static int coinChange(int[] coins, int amount) {
		
		if (amount == 0) {
			return 0;
		}
		int coin = coins.length-1;
		if (coin < 0) {
			return -1;
		}
		Arrays.sort(coins);
		int counter = 0;
		while (amount > 0 && coin >= 0) {
			while (coins[coin] <= amount) {
				amount -= coins[coin];
				System.out.println(amount);
				counter ++;
			}
			coin --;// next coin
		}

		return amount == 0 ? counter : -1;
	}

	public static void main(String[] arg) {
		
		int[] coins = {1, 2, 5};
		System.out.println(coinChange(coins, 11));

		int[] coins1 = {2};
		System.out.println(coinChange(coins1, 3));

		int[] coins2 = {3,3,2};
		System.out.println(coinChange(coins2, 7));

		int[] coins3 = {186,419,83,408};
		System.out.println(coinChange(coins3, 6249));

	}

}
