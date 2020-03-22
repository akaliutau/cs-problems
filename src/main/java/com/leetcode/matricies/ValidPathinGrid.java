package com.leetcode.matricies;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/check-if-there-is-a-valid-path-in-a-grid/
 * 
 * Given a m x n grid. Each cell of the grid represents a street. The street of
 * grid[i][j] can be: 1 which means a street connecting the left cell and the
 * right cell. 2 which means a street connecting the upper cell and the lower
 * cell. 3 which means a street connecting the left cell and the lower cell. 4
 * which means a street connecting the right cell and the lower cell. 5 which
 * means a street connecting the left cell and the upper cell. 6 which means a
 * street connecting the right cell and the upper cell.
 * 
 * You will initially start at the street of the upper-left cell (0,0). A valid
 * path in the grid is a path which starts from the upper left cell (0,0) and
 * ends at the bottom-right cell (m - 1, n - 1). The path should only follow the
 * streets.
 * 
 * Notice that you are not allowed to change any street.
 * 
 * Return true if there is a valid path in the grid or false otherwise.
 * 
 * 
 * Runtime: 178 ms, faster than 33.33% of Java online submissions for Check if There is a Valid Path in a Grid.
 * Memory Usage: 118.2 MB, less than 100.00% of Java online submissions for Check if There is a Valid Path in a Grid.
 */
public class ValidPathinGrid {

	static class Cell {
		public int row;
		public int col;
		public int type;
		public boolean[] conn = new boolean[4];
		public List<Cell> next = new ArrayList<>();
		
		public Cell(int row, int col, int type) {
			this.row = row;
			this.col = col;
			this.type = type;
			if (type == 1) {
				conn[1] = true;
				conn[3] = true;
			}else if (type == 2) {
				conn[0] = true;
				conn[2] = true;
			}else if (type == 3) {
				conn[2] = true;
				conn[3] = true;
			}else if (type == 4) {
				conn[1] = true;
				conn[2] = true;
			}else if (type == 5) {
				conn[0] = true;
				conn[3] = true;
			}else if (type == 6) {
				conn[1] = true;
				conn[0] = true;
			}
		}

		@Override
		public String toString() {
			return "Cell [row=" + row + ", col=" + col + ", type=" + type + ", next=" + next.size() + "]";
		}
		
	}

	public static boolean hasValidPath(int[][] grid) {
		int m = grid.length;
		int n = 0;
		if (m > 0) {
			n = grid[0].length;
		}
		int tgt = n * m;
		if (tgt == 1) {
			return true;
		}
		Cell[][] cells = new Cell[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				Cell c = new Cell(i,j,grid[i][j]);
				cells[i][j] = c;
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				Cell c = cells[i][j];
				if (c.type == 1) {
					if (j-1 >=0 && cells[i][j-1].conn[1]) {
						c.next.add(cells[i][j-1]);
					}
					if (j+1 < n && cells[i][j+1].conn[3]) {
						c.next.add(cells[i][j+1]);
					}
				}
				if (c.type == 2) {
					if (i-1 >=0 && cells[i-1][j].conn[2]) {
						c.next.add(cells[i-1][j]);
					}
					if (i+1 < m && cells[i+1][j].conn[0]) {
						c.next.add(cells[i+1][j]);
					}
				}
				if (c.type == 3) {
					if (j-1 >=0 && cells[i][j-1].conn[1]) {
						c.next.add(cells[i][j-1]);
					}
					if (i+1 < m && cells[i+1][j].conn[0]) {
						c.next.add(cells[i+1][j]);
					}
				}
				if (c.type == 4) {
					if (j+1 < n && cells[i][j+1].conn[3]) {
						c.next.add(cells[i][j+1]);
					}
					if (i+1 < m && cells[i+1][j].conn[0]) {
						c.next.add(cells[i+1][j]);
					}
				}
				if (c.type == 5) {
					if (j-1 >= 0 && cells[i][j-1].conn[1]) {
						c.next.add(cells[i][j-1]);
					}
					if (i-1 >= 0 && cells[i-1][j].conn[2]) {
						c.next.add(cells[i-1][j]);
					}
				}
				if (c.type == 6) {
					if (i-1 >= 0 && cells[i-1][j].conn[2]) {
						c.next.add(cells[i-1][j]);
					}
					if (j+1 < n && cells[i][j+1].conn[3]) {
						c.next.add(cells[i][j+1]);
					}
				}
			}
		}
		
		Queue<Cell> queue = new LinkedList<>();
		queue.add(cells[0][0]);
		
		boolean[][] map = new boolean[m][n];
		int i,j;
		while (!queue.isEmpty()) {
			Cell c = queue.poll();
			i = c.row;
			j = c.col;
			map[i][j] = true;
			for (Cell cell : c.next) {
				if (!map[cell.row][cell.col]) {
					queue.add(cell);
				}
			}
			if (i == m-1 && j == n-1) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] arg) {
		int[][] grid = { { 2, 4, 3 }, { 6, 5, 2 } };
		System.out.println(hasValidPath(grid));

		int[][] grid1 = { { 1, 2, 1 }, { 1, 2, 1 } };
		System.out.println(hasValidPath(grid1));

		int[][] grid2 = { { 1, 1, 1, 1, 1, 1, 3 } };
		System.out.println(hasValidPath(grid2));

		int[][] grid3 = { { 2 }, { 2 }, { 2 }, { 2 }, { 2 }, { 2 }, { 6 } };
		System.out.println(hasValidPath(grid3));

		int[][] grid4 = { { 4, 1 }, { 6, 1 } };
		System.out.println(hasValidPath(grid4));

		int[][] grid5 = { {1, 1, 2 } };
		System.out.println(hasValidPath(grid5));

	}

}
