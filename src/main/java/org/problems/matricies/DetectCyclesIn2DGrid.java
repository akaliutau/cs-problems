package org.problems.matricies;

/**
 * https://leetcode.com/problems/detect-cycles-in-2d-grid/
 * 
 * Given a 2D array of characters grid of size m x n, you need to find if there
 * exists any cycle consisting of the same value in grid.
 * 
 * A cycle is a path of length 4 or more in the grid that starts and ends at the
 * same cell. From a given cell, you can move to one of the cells adjacent to it
 * - in one of the four directions (up, down, left, or right), if it has the
 * same value of the current cell.
 * 
 * Also, you cannot move to the cell that you visited in your last move. For
 * example, the cycle (1, 1) -> (1, 2) -> (1, 1) is invalid because from (1, 2)
 * we visited (1, 1) which was the last visited cell.
 * 
 * Return true if any cycle of the same value exists in grid, otherwise, return
 * false
 * 
 * 
 * 
 * 
 */
public class DetectCyclesIn2DGrid {

	static int dirX[] = new int[] {-1, 0, 1,  0 };
	static int dirY[] = new int[] { 0, 1, 0, -1 };

	static boolean isValid(int x, int y, int n, int m) {
		return x < n && x >= 0 && y < m && y >= 0;
	}

	static boolean isCycle(int x, int y, int n, int m, char arr[][], boolean visited[][], int parentX, int parentY) {

		visited[x][y] = true;

		for (int k = 0; k < 4; k++) {
			int nextX = x + dirX[k];
			int nextY = y + dirY[k];

			if (isValid(nextX, nextY, n, m) && arr[nextX][nextY] == arr[x][y] && !(parentX == nextX && parentY == nextY)) {

				if (visited[nextX][nextY]) {
					return true;
				} else {
					boolean check = isCycle(nextX, nextY, n, m, arr, visited, x, y);
					if (check) {
						return true;
					}
				}
			}
		}

		return false;
	}

	public boolean containsCycle(char[][] grid) {
		int n = grid.length;
		int m = 0;
		if (grid[0].length > 0) {
			m = grid[0].length;
		}

		boolean[][] visited = new boolean[n][m];

		boolean cycle = false;

		for (int i = 0; i < n; i++) {
			if (cycle) {
				return true;
			}
			for (int j = 0; j < m; j++) {
				if (!visited[i][j]) {
					cycle = isCycle(i, j, n, m, grid, visited, -1, -1);
				}

				if (cycle) {
					return true;
				}
			}
		}

		return false;

	}

	public static void main(String[] arg) {
		System.out.println(true);
	}

}
