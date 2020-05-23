package org.problems.combinatorics;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/number-of-equivalent-domino-pairs/
 * 
 * Given a list of dominoes, dominoes[i] = [a, b] is equivalent to dominoes[j] =
 * [c, d] if and only if either (a==c and b==d), or (a==d and b==c) - that is,
 * one domino can be rotated to be equal to another domino.
 * 
 * Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length, and
 * dominoes[i] is equivalent to dominoes[j].
 * 
 * Example 1: Input: dominoes = [{1,2},{2,1},{3,4},{5,6}] Output: 1
 * 
 * Constraints:
 * 
 * 1 <= dominoes.length <= 40000 1 <= dominoes[i][j] <= 9
 */
public class EquivalentDomino {

	static boolean isEquivalent(int[] dominoOne, int[] dominoTwo) {
		return (dominoOne[0] == dominoTwo[0] && dominoOne[1] == dominoTwo[1])
				|| (dominoOne[0] == dominoTwo[1] && dominoOne[1] == dominoTwo[0]);
	}

	static int hashCode(int[] domino, boolean reverse) {
		int a, b;
		if (reverse) {
			a = domino[1];
			b = domino[0];
		} else {
			a = domino[0];
			b = domino[1];
		}
		return a * 10 + b;
	}

	static class Pair {
		public int total = 0;

		public int getTotal() {
			if (total == 0) {
				return 0;
			}
			return (int) binomial(total+1,2);
		}

		private static long binomial(int n, int k) {
			if (k > n - k) {
				k = n - k;
			}

			long b = 1;
			for (int i = 1, m = n; i <= k; i++, m--) {
				b = b * m / i;
			}
			return b;
		}
	}

	public static int numEquivDominoPairs(int[][] dominoes) {

		int counter = 0;
		Map<Integer, Pair> set = new HashMap<>();
		for (int i = 0; i < dominoes.length; i++) {
			int code = hashCode(dominoes[i], false);
			if (set.containsKey(code)) {
				set.get(code).total++;
				continue;
			} else {
				code = hashCode(dominoes[i], true);
				if (set.containsKey(code)) {
					set.get(code).total++;
					continue;
				}
			}
			set.put(code, new Pair());// new code
		}
		for (Pair pair : set.values()) {
			counter += pair.getTotal();
		}
		return counter;

	}

	public static void main(String[] arg) {

		int[][] dominoes = { { 1, 2 }, { 2, 1 }, { 3, 4 }, { 5, 6 } };
		System.out.println(numEquivDominoPairs(dominoes));

		int[][] dominoes1 = {{1,2},{1,2},{1,1},{1,2},{2,2}};
		System.out.println(numEquivDominoPairs(dominoes1));

	}

}
