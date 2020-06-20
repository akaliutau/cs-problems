package org.problems.dp;

import java.util.Arrays;

import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/coin-change/
 *
 * You are given coins of different denominations and a total amount of money
 * amount. 
 * Write a function to compute the NUMBER of possible WAYS to make up that amount. 
 * 
 * If that amount of money cannot be made up by any combination of the coins, return 0.
 * 
 * 
 */
public class CoinChangeIII {
	
	public static int coinChange(int[] coins, int amount) {
		
		if (amount == 0) {
			return 0;
		}
		int coin = coins.length;
		if (coin == 0) {
			return -1;
		}
		Arrays.sort(coins);
		
		int[][] combinations = new int[coin][amount + 1];
		for (int i = 0; i < coin; i++) {
			combinations[i][0] = 1;
		}

		for (int j = 1; j <= amount; j++) {
			combinations[0][j] = j % coins[0] == 0 ? 1 : 0;
		
			for (int i = 1; i < coin; i++) {
				combinations[i][j] = combinations[i-1][j];
				if (j-coins[i] >= 0) {
					combinations[i][j] += combinations[i][j-coins[i]];
				}
			}
		}
		Utils.print(combinations);
		return combinations[coin - 1][amount];

	}

	public static void main(String[] arg) {
		
		int[] coins = {1, 2, 5};
		System.out.println(coinChange(coins, 11));
		
		int[] coins0 = {3,4};
		System.out.println(coinChange(coins0, 7));


		int[] coins1 = {2};
		System.out.println(coinChange(coins1, 3));

		int[] coins2 = {3,3,2};
		System.out.println(coinChange(coins2, 7));

		int[] coins3 = {186,419,83,408};
		System.out.println(coinChange(coins3, 6249));

	}

}
