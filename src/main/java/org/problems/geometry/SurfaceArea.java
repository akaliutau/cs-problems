package org.problems.geometry;

/**
 * https://leetcode.com/problems/surface-area-of-3d-shapes/
 * 
 * On a N * N grid, we place some 1 * 1 * 1 cubes.
 * 
 * Each value v = grid[i][j] represents a tower of v cubes placed on top of grid
 * cell (i, j).
 * 
 * Return the total surface area of the resulting shapes.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: [[2]] Output: 10
 * 
 * Example 2:
 * 
 * Input: [[1,2],[3,4]] Output: 34
 * 
 * Example 3:
 * 
 * Input: [[1,0],[0,2]] Output: 16
 * 
 * Example 4:
 * 
 * Input: [[1,1,1],[1,0,1],[1,1,1]] Output: 32
 * 
 * Example 5:
 * 
 * Input: [[2,2,2],[2,1,2],[2,2,2]] Output: 46
 * 
 * 
 * Note:
 * 
 * 1 <= N <= 50 0 <= grid[i][j] <= 50
 * 
 * 
 */
public class SurfaceArea {

	static boolean isValid(int i, int j, int n, int m) {
		return i >= 0 && j >= 0 && i < n && j < m;
	}

	static int[] directions = { 0, -1, 0, 1, -1, 0, 1, 0 };

	public static int surfaceArea(int[][] grid) {
		int n = grid.length;
		int m = 0;
		if (n > 0) {
			m = grid[0].length;
		}
		boolean[][] processed = new boolean[n][m];
		int totalArea = 0;
		int counter = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				counter += grid[i][j];
			}
		}
		totalArea = counter * 6;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int d = 0; d < 8; d += 2) {
					int x = i + directions[d];
					int y = j + directions[d + 1];
					if (isValid(x, y, n, m) && !processed[x][y]) {
						totalArea -= (2 * Math.min(grid[i][j], grid[x][y]));
					}
				}
				processed[i][j] = true;
				if (grid[i][j] > 1) {
					totalArea -= (2 * (grid[i][j] - 1));
				}
			}
		}
		
		return totalArea;// -= 2 * n * m;

	}

	public static void main(String[] arg) {

		int[][] grid = { { 2 } };
		System.out.println(surfaceArea(grid));

		int[][] grid1 = { { 1, 2 }, { 3, 4 } };
		System.out.println(surfaceArea(grid1));

		int[][] grid2 = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
		System.out.println(surfaceArea(grid2));

		int[][] grid3 = { { 2, 2, 2 }, { 2, 1, 2 }, { 2, 2, 2 }, };
		System.out.println(surfaceArea(grid3));

	}

}
