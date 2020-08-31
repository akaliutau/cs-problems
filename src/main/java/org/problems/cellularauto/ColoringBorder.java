package org.problems.cellularauto;

import java.util.LinkedList;
import java.util.Queue;

import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/coloring-a-border/
 * 
 * Given a 2-dimensional grid of integers, each value in the grid represents the
 * color of the grid square at that location.
 * 
 * Two squares belong to the same connected relations if and only if they have
 * the same color and are next to each other in any of the 4 directions.
 * 
 * The border of a connected relations is all the squares in the connected
 * relations that are either 4-directionally adjacent to a square not in the
 * relations, or on the boundary of the grid (the first or last row or column).
 * 
 * Given a square at location (r0, c0) in the grid and a color, color the border
 * of the connected relations of that square with the given color, and return
 * the final grid.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: grid = [[1,1], [1,2]], r0 = 0, c0 = 0, color = 3 Output: [[3, 3], [3,
 * 2]]
 * 
 * Example 2:
 * 
 * Input: grid = [[1,2,2], [2,3,2]], r0 = 0, c0 = 1, color = 3 Output: [[1, 3,
 * 3], [2, 3, 3]]
 * 
 * Example 3:
 * 
 * Input: grid = [[1,1,1], [1,1,1], [1,1,1]], r0 = 1, c0 = 1, color = 2 Output:
 * [[2, 2, 2], [2, 1, 2], [2, 2, 2]]
 * 
 * 
 * Note:
 * 
 * 1 <= grid.length <= 50 1 <= grid[0].length <= 50 1 <= grid[i][j] <= 1000 0 <=
 * r0 < grid.length 0 <= c0 < grid[0].length 1 <= color <= 1000
 */
public class ColoringBorder {

	static int[] directions = { -1, 0, 1, 0, 0, -1, 0, 1 };

	static boolean isValid(int x, int y, int rows, int cols) {
		if (x < 0 || x > rows - 1 || y < 0 || y > cols - 1) {
			return false;
		}
		return true;
	}

	static boolean isBoundary(int x, int y, int rows, int cols) {
		return (x == 0 || x == rows - 1 || y == 0 || y == cols - 1);
	}
	
	static boolean isBorder(int[][] grid, int x, int y, int rows, int cols, int color) {
		if (isBoundary(x, y, rows, cols)) {
			return true;
		}

		for (int i = 0; i < 8; i += 2) {
			int r = x + directions[i];
			int c = y + directions[i + 1];
			if (isValid(r, c, rows, cols) && grid[r][c] != color) {
				return true;
			}
		}
		return false;
	}


	public static int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
		int rows = grid.length;
		int cols = 0;
		if (rows > 0) {
			cols = grid[0].length;
		}
		boolean[][] done = new boolean[rows][cols];
		boolean[][] change = new boolean[rows][cols];
		Queue<Integer> q = new LinkedList<>();
		q.add(r0);
		q.add(c0);
		int compColor = grid[r0][c0];
		while (!q.isEmpty()) {
			int r = q.poll();
			int c = q.poll();
			done[r][c] = true;
			for (int i = 0; i < 8; i += 2) {
				int x = r + directions[i];
				int y = c + directions[i + 1];
				if (isValid(x, y, rows, cols) && !done[x][y]) {
					if (grid[x][y] == compColor) {//connected
						if (isBorder(grid, x, y, rows, cols, compColor)) {
							change[x][y] = true;
						}
						q.add(x);
						q.add(y);
					}
				}
			}
		}
		if (isBorder(grid, r0, c0, rows, cols, compColor)) {
			grid[r0][c0] = color;
		}
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (change[i][j]) {
					grid[i][j] = color;
				}
			}			
		}
		return grid;

	}

	public static void main(String[] arg) {

		int[][] grid = { { 1, 2, 2 }, { 2, 3, 2 } };
		Utils.print(colorBorder(grid, 0, 1, 3));

		int[][] grid1 = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };
		Utils.print(colorBorder(grid1, 1, 1, 3));

		int[][] grid2 = 
			{ 
					{1,2,1,2,1,2},
					{2,2,2,2,1,2},
					{1,2,2,2,1,2} 
			};
		Utils.print(colorBorder(grid2, 1, 3, 1));

	}

}
