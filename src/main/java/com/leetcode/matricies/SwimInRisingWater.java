package com.leetcode.matricies;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/swim-in-rising-water/
 * 
 * On an N x N grid, each square grid[i][j] represents the elevation at that
 * point (i,j).
 * 
 * Now rain starts to fall. At time t, the depth of the water everywhere is t.
 * You can swim from a square to another 4-directionally adjacent square if and
 * only if the elevation of both squares individually are at most t. You can
 * swim infinite distance in zero time. Of course, you must stay within the
 * boundaries of the grid during your swim.
 * 
 * You start at the top left square (0, 0). What is the least time until you can
 * reach the bottom right square (N-1, N-1)?
 * 
 * Example 1:
 * 
 * Input: [[0,2],[1,3]] Output: 3 Explanation: At time 0, you are in grid
 * location (0, 0). You cannot go anywhere else because 4-directionally adjacent
 * neighbors have a higher elevation than t = 0.
 * 
 * You cannot reach point (1, 1) until time 3. When the depth of water is 3, we
 * can swim anywhere inside the grid. Example 2:
 * 
 * Input: 
 * [ 
 * [0, 1, 2, 3, 4 ], 
 * [24,23,22,21,5 ], 
 * [12,13,14,15,16],
 * [11,17,18,19,20], 
 * [10,9, 8, 7, 6 ] ] 
 * Output: 16 
 * We need to wait until time 16
 * so that (0, 0) and (4, 4) are connected. Note:
 * 
 * 2 <= N <= 50. grid[i][j] is a permutation of [0, ..., N*N - 1]
 * 
 */
public class SwimInRisingWater {

	static class Cell {
		public final int i;
		public final int j;
		public int level;
		public boolean completed = false;

		public Cell(int level, int i, int j) {
			this.level = level;
			this.i = i;
			this.j = j;
		}

		@Override
		public String toString() {
			return "Cell [i=" + i + ", j=" + j + ", level=" + level + ", completed=" + completed + "]";
		}

	}

	static int[] directions = { -1, 0, 1, 0, 0, -1, 0, 1 };

	static boolean isValid(int i, int j, int n, int m) {
		return i >= 0 && i < n && j >= 0 && j < m;
	}

	public static int swimInWater(int[][] grid) {
		int n = grid.length;
		int m = 0;
		if (n > 0) {
			m = grid[0].length;
		}

		Cell[][] cells = new Cell[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				cells[i][j] = new Cell(grid[i][j], i, j);
			}
		}
		Cell start = cells[0][0];
		Cell end = cells[n - 1][m - 1];
		int it = 0;

		Comparator<Cell> byLevel = (o, p) -> Integer.compare(o.level, p.level);
		PriorityQueue<Cell> queue = new PriorityQueue<>(byLevel);
		queue.add(end);
		int min = 0;

		while (!queue.isEmpty()) {
			Cell cell = queue.poll();
			if (cell.completed) {
				continue;
			}
			cell.completed = true;
			if (cell == start) {
				return Math.max(min, cell.level);
			} else {
				min = Math.max(min, cell.level);
			}
			for (int k = 0; k < 8; k += 2) {
				int dx = cell.i + directions[k];
				int dy = cell.j + directions[k + 1];
				if (isValid(dx, dy, n, m)) {
					queue.add(cells[dx][dy]);
				}
			}
		}
		return min;

	}

	public static void main(String[] arg) {

		int[][] grid = { { 0, 1, 2, 3, 4 }, { 24, 23, 22, 21, 5 }, { 12, 13, 14, 15, 16 }, { 11, 17, 18, 19, 20 },
				{ 10, 9, 8, 7, 6 } };

		System.out.println(swimInWater(grid));

	}

}
