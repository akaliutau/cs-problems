package com.leetcode.games;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/last-stone-weight/
 * 
 * We have a collection of stones, each stone has a positive integer weight.
 * 
 * Each turn, we choose the two heaviest stones and smash them together. Suppose
 * the stones have weights x and y with x <= y. The result of this smash is:
 * 
 * If x == y, both stones are totally destroyed; If x != y, the stone of weight
 * x is totally destroyed, and the stone of weight y has new weight y-x. At the
 * end, there is at most 1 stone left. Return the weight of this stone (or 0 if
 * there are no stones left.)
 * 
 * Example 1:
 * 
 * Input: [2,7,4,1,8,1] Output: 1 
 * 
 * Explanation: We combine 7 and 8 to get 1 so
 * the array converts to [2,4,1,1,1] then, we combine 2 and 4 to get 2 so the
 * array converts to [2,1,1,1] then, we combine 2 and 1 to get 1 so the array
 * converts to [1,1,1] then, we combine 1 and 1 to get 0 so the array converts
 * to [1] then that's the value of last stone.
 * 
 * Note:
 * 1 <= stones.length <= 30 
 * 1 <= stones[i] <= 1000
 */
public class LastStoneWeight {

	public static int lastStoneWeight(int[] stones) {
		int n = stones.length;
		int[] current = new int[n];
		for (int i = 0; i < n; i++) {
			current[i] = stones[i];
		}
		while (current.length > 1) {
			int len = current.length;
			Arrays.sort(current);
			int stone1 = current[len-2];
			int stone2 = current[len-1];
			int[] next;
			if (stone1 == stone2) {
				next = new int[len-2];
				for (int i = 0; i < len-2; i++) {
					next[i] = current[i];
				}
			}else if (stone1 > stone2){
				next = new int[len-1];
				for (int i = 0; i < len-2; i++) {
					next[i] = current[i];
				}
				next[len-2] = stone1 - stone2;
			}else {
				next = new int[len-1];
				for (int i = 0; i < len-2; i++) {
					next[i] = current[i];
				}
				next[len-2] = stone2 - stone1;
			}
			current = next;
		}
		return current.length == 0 ? 0 : current[0];

	}

	public static void main(String[] arg) {
		
		int[] stones = {2,7,4,1,8,1};

		System.out.println(lastStoneWeight(stones));

	}

}
