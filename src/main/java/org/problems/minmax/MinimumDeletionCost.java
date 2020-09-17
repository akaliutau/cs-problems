package org.problems.minmax;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-deletion-cost-to-avoid-repeating-letters/
 * 
 * Given a string s and an array of integers cost where cost[i] is the cost of
 * deleting the character i in s.
 * 
 * Return the minimum cost of deletions such that there are no two identical
 * letters next to each other.
 * 
 * Notice that you will delete the chosen characters at the same time, in other
 * words, after deleting a character, the costs of deleting other characters
 * will not change.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "abaac", cost = [1,2,3,4,5] Output: 3 Explanation: Delete the
 * letter "a" with cost 3 to get "abac" (String without two identical letters
 * next to each other).
 * 
 * 
 */
public class MinimumDeletionCost {

	static class Block {
		public Block(char c) {
			this.c = c;
		}

		char c;
		List<Integer> costs = new ArrayList<>();

		@Override
		public String toString() {
			return "Block [c=" + c + ", costs=" + costs + "]";
		}
	}

	public static int minCost(String s, int[] cost) {

		int ans = 0;
		char[] str = s.toCharArray();
		int n = str.length;

		boolean[] added = new boolean[n];
		List<Block> bls = new ArrayList<>();
		for (int i = 0; i < n - 1; i++) {

			if (str[i] == str[i + 1]) {
				int code = str[i];
				Block b = new Block(str[i]);
				b.costs.add(cost[i]);
				b.costs.add(cost[i + 1]);
				added[i] = true;
				added[i + 1] = true;
				while (i < n && code == str[i]) {
					if (!added[i]) {
						b.costs.add(cost[i]);
						added[i] = true;
					}
					i++;
				}
				i--;
				bls.add(b);
			}
		}

		for (Block ch : bls) {
			List<Integer> cs = ch.costs;
			Collections.sort(cs);
			for (int i = 0; i < cs.size() - 1; i++) {
				ans += cs.get(i);
			}
		}

		return ans;

	}

	public static void main(String[] arg) {
		int[] cost = { 4, 9, 3, 8, 8, 9 };

		System.out.println(minCost("bbbaaa", cost));
	}

}
