package org.problems.minmax;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/play-with-chips/
 *
 * There are some chips, and the i-th chip is at position chips[i].
 * 
 * You can perform any of the two following types of moves any number of times
 * (possibly zero) on any chip:
 * 
 * Move the i-th chip by 2 units to the left or to the right with a cost of 0.
 * Move the i-th chip by 1 unit to the left or to the right with a cost of 1.
 * There can be two or more chips at the same position initially.
 * 
 * Return the minimum cost needed to move all the chips to the same position
 * (any position).
 * 
 * Example 1:
 * Input: chips = [1,2,3] Output: 1 
 * 
 * Explanation: Second chip will be moved to
 * positon 3 with cost 1. First chip will be moved to position 3 with cost 0.
 * Total cost is 1. 
 * 
 * Example 2:
 * Input: chips = [2,2,2,3,3] Output: 2 
 * Explanation: Both fourth and fifth chip
 * will be moved to position two with cost 1. Total minimum cost will be 2.
 * 
 * 
 * Constraints:
 * 1 <= chips.length <= 100 
 * 1 <= chips[i] <= 10^9
 */
public class PlayWithChips {
	
	static int cost(int[] chips, int pos) {
		int total = 0;
		for (int i = 0; i < chips.length; i++) {
			int d = Math.abs(pos - chips[i]);
			if (d > 2) {
				total += (d % 2);
			}
			if (d == 1) {
				total += 1;
			}
		}
		return total;
	}
	
	public static int minCostToMoveChips(int[] chips) {
		int n = chips.length;
		Set<Integer> positions = new HashSet<>();
		for (int i = 0; i < n; i++) {
			positions.add(chips[i]);
			positions.add(chips[i] - 1);
			positions.add(chips[i] + 1);
			positions.add(chips[i] - 2);
			positions.add(chips[i] + 2);
		}
		int cost = Integer.MAX_VALUE;
		for (Integer pos : positions) {
			cost = Math.min(cost, cost(chips, pos));
		}
		return cost;
		
		
	}

	public static void main(String[] arg) {
		
		int[] chips = {1,2,3};
		System.out.println(minCostToMoveChips(chips));//1

		int[] chips1 = {2,2,2,3,3};
		System.out.println(minCostToMoveChips(chips1));//2
		
		int[] chips2 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
		System.out.println(minCostToMoveChips(chips2));//2
		

	}

}
