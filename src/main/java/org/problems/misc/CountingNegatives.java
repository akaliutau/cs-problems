package org.problems.misc;

/**
 * https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
 *
 *
 *
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Count
 * Negative Numbers in a Sorted Matrix. Memory Usage: 46.6 MB, less than 100.00%
 * of Java online submissions for Count Negative Numbers in a Sorted Matrix.
 */
public class CountingNegatives {

	public static int countNegatives(int[][] grid) {
		int counter = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				if (grid[i][j] < 0) {
					counter += (grid.length - j);
					break;
				}
			}
		}
		return counter;
	}

	public static void main(String[] arg) {

		int[][] mat = { { 1, 1, 0, 0, -1 }, { 1, 1, 1, -2, -1 }, { 1, 0, 0, 0, 0 }, { 1, 1, 0, 0, -1 },
				{ 1, 1, 1, 1, -3 } };

		System.out.println(countNegatives(mat));

	}

}
