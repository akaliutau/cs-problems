package com.leetcode.chess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/n-queens/
 * 
 * Runtime: 5 ms, faster than 50.46% of Java online submissions for N-Queens.
 * Memory Usage: 41.4 MB, less than 5.41% of Java online submissions for
 * N-Queens.
 */
public class NQueens {

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

	private static String getLine(Integer pos, int n) {
		char[] chars = new char[n];
		Arrays.fill(chars, '.');
		chars[pos] = 'Q';
		return String.valueOf(chars);
	}

	public static void find(int n, int row, List<Integer> positions, List<List<String>> results) {
		if (row == n) {
			List<String> found = new ArrayList<>();
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

	public static List<List<String>> solveNQueens(int n) {
		List<Integer> positions = new ArrayList<>();
		List<List<String>> results = new ArrayList<>();
		find(n, 0, positions, results);
		return results;
	}

	public static void main(String[] arg) {

		System.out.println(solveNQueens(4));

	}
}
