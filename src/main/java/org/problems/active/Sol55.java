package org.problems.active;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode.com/problems/can-i-win/
 * 
 * In the "100 game," two players take turns adding, to a running total, any
 * integer from 1..10. The player who first causes the running total to reach or
 * exceed 100 wins.
 * 
 * What if we change the game so that players cannot re-use integers?
 * 
 * For example, two players might take turns drawing from a common pool of
 * numbers of 1..15 without replacement until they reach a total >= 100.
 * 
 * Given an integer maxChoosableInteger and another integer desiredTotal,
 * determine if the first player to move can force a win, assuming both players
 * play optimally.
 * 
 * You can always assume that maxChoosableInteger will not be larger than 20 and
 * desiredTotal will not be larger than 300.
 * 
 * Example
 * 
 * Input: maxChoosableInteger = 10 desiredTotal = 11
 * 
 * Output: false
 * 
 * 
 */
public class Sol55 {
	
	public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
		
		return false;
    }

	public static void main(String[] arg) {

		System.out.println(true);

	}

}
