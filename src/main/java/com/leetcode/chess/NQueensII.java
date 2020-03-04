package com.leetcode.chess;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/n-queens-ii/
 * 
 * Runtime: 5 ms, faster than 22.68% of Java online submissions for N-Queens II.
 * Memory Usage: 36.3 MB, less than 8.70% of Java online submissions for
 * N-Queens II.
 */
public class NQueensII {

	private static boolean isValid(List<Integer> positions, int col, int row) {
		for (int r = 0; r < positions.size(); r++) {
			if (positions.get(r) == col) {
				return false;
			}
			if (Math.abs(positions.get(r) - col) == Math.abs(r - row)) {
				return false;
			}
		}
		return true;
	}

	private static boolean[] getLine(Integer pos, int n) {
		boolean[] chars = new boolean[n];
		chars[pos] = true;
		return chars;
	}

	public static void find(int n, int row, List<Integer> positions, List<List<boolean[]>> results) {
		if (row == n) {
			List<boolean[]> found = new ArrayList<>();
			for (Integer i : positions) {
				found.add(getLine(i, n));
			}
			results.add(found);
		} else {
			// check all possible positions on the row with index=row
			for (int col = 0; col < n; col++) {
				if (isValid(positions, col, row)) {
					positions.add(col);
					find(n, row + 1, positions, results);
					positions.remove(row);
				}
			}
		}

	}

	public static int totalNQueens(int n) {
		List<Integer> positions = new ArrayList<>();
		List<List<boolean[]>> results = new ArrayList<>();
		find(n, 0, positions, results);
		Set<List<boolean[]>> set = new HashSet<>(results);
		return set.size();
	}

	public static void main(String[] arg) {
		int total = totalNQueens(4);
		System.out.println(total);

	}
}
