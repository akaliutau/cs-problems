package org.problems.games;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/divisor-game/
 * 
 * Alice and Bob take turns playing a game, with Alice starting first.
 * 
 * Initially, there is a number N on the chalkboard. On each player's turn, that
 * player makes a move consisting of:
 * 
 * Choosing any x with 0 < x < N and N % x == 0. Replacing the number N on the
 * chalkboard with N - x. Also, if a player cannot make a move, they lose the
 * game.
 * 
 * Return True if and only if Alice wins the game, assuming both players play
 * optimally.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: 2 Output: true 
 * Explanation: Alice chooses 1, and Bob has no more
 * moves. 
 * 
 * Example 2:
 * 
 * Input: 3 Output: false Explanation: Alice chooses 1, Bob chooses 1, and Alice
 * has no more moves.
 * 
 * 
 * Note:
 * 
 * 1 <= N <= 1000
 * 
 */
public class DivisorGame {

	public static boolean divisorGame(int n) {
        if (n < 2){
            return false;
        }

		boolean[] dp = new boolean[n+1];
		dp[0] = false;
		dp[1] = false;
		dp[2] = true;
		if (n < 3) {
			return dp[n];
		}
		for (int i = 3; i <= n; i++) {
			if (!dp[i-1]){// optimization
				dp[i] = true;
				continue;
			}
			// get all divisors
			List<Integer> divisors = new ArrayList<>();
			for (int j = 2; j <= i/2; j++) {
				if (i % j == 0) {
					divisors.add(j);
				}
			}
			boolean canWin = false;
			for (Integer x : divisors) {
				if (!dp[i-x]) {
					canWin = true;
					break;
				}
			}
			dp[i] = canWin;
		}
		
		
		return dp[n];

	}

	public static void main(String[] arg) {

		System.out.println(divisorGame(2));
		System.out.println(divisorGame(3));
		System.out.println(divisorGame(4));
		System.out.println(divisorGame(5));
		System.out.println(divisorGame(6));
		System.out.println(divisorGame(7));
		System.out.println(divisorGame(8));
		System.out.println(divisorGame(9));

		System.out.println(divisorGame(100));

		System.out.println(divisorGame(1000));

	}

}
