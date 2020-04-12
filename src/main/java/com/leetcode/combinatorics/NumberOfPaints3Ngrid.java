package com.leetcode.combinatorics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/number-of-ways-to-paint-n-3-grid/
 * 
 * You have a grid of size n x 3 and you want to paint each cell of the grid
 * with exactly one of the three colours: Red, Yellow or Green while making sure
 * that no two adjacent cells have the same colour (i.e no two cells that share
 * vertical or horizontal sides have the same colour).
 * 
 * You are given n the number of rows of the grid.
 * 
 * Return the number of ways you can paint this grid. As the answer may grow
 * large, the answer must be computed modulo 10^9 + 7
 * 
 * 
 */
public class NumberOfPaints3Ngrid {

	public static class Triad {
		int a, b, c;

		public Triad(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}

		public boolean isValid(Triad other) {
			return other.a != a && b != other.b && c != other.c;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + a;
			result = prime * result + b;
			result = prime * result + c;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Triad other = (Triad) obj;
			if (a != other.a)
				return false;
			if (b != other.b)
				return false;
			if (c != other.c)
				return false;
			return true;
		}
	}

	public static List<Triad> generateAll() {
		List<Triad> ans = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i != j) {
					for (int k = 0; k < 3; k++) {
						if (k != j) {
							ans.add(new Triad(i, j, k));
						}
					}
				}
			}
		}
		return ans;
	}

	public static int numOfWays(int n) {
		Map<Triad, Integer> odd = new HashMap<>();
		Map<Triad, Integer> even = new HashMap<>();
		List<Triad> all = generateAll();
		int j = 0;
		for (Triad triplet : all) {
			even.put(triplet, 1);
		}
		Map<Triad, Integer> curMapping = null;
		for (int i = 2; i <= n; i++) {
			j = (j + 1) % 2;
			Map<Triad, Integer> cur = (j+1) % 2 == 0 ? even : odd;
			Map<Triad, Integer> next = j % 2 == 0 ? even : odd;
			for (Triad current : all) {
				int sum = 0;
				for (Triad prev : all) {
					if (current.isValid(prev)) {
						sum = (sum + cur.get(prev)) % 1000000007;
					}
				}
				next.put(current, sum);
			}
		}
		int sum = 0;
		curMapping =  (n + 1) % 2 == 0 ? even : odd;
		for (Integer trp : curMapping.values()) {
			sum = (sum + trp) % 1000000007;
		}
		return sum;
	}


	public static void main(String[] arg) {

		System.out.println(numOfWays(1));// 12
		System.out.println(numOfWays(2));// 54
		System.out.println(numOfWays(3));// 246
		System.out.println(numOfWays(7));// 106494
		System.out.println(numOfWays(5000));// 106494

	}

}
