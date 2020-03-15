package com.leetcode.matricies;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/as-far-from-land-as-possible/
 * 
 * Given an N x N grid containing only values 0 and 1, where 0 represents water
 * and 1 represents land, find a water cell such that its distance to the
 * nearest land cell is maximized and return the distance.
 * 
 * The distance used in this problem is the Manhattan distance: the distance
 * between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.
 * 
 * If no land or water exists in the grid, return -1.
 * 
 * Input: [ [1,0,1], [0,0,0], [1,0,1] ]
 * 
 * Output: 2
 * 
 * Explanation: The cell (1, 1) is as far as possible from all the land with
 * distance 2.
 * 
 * 
 */
public class FarFromLandOpt {

	static int dist(int x0, int y0, int x1, int y1) {
		return Math.abs(x0 - x1) + Math.abs(y0 - y1);
	}

	static boolean valid(boolean[][] checked, int rows, int cols, int row, int col) {
		return row >= 0 && row < rows && col >= 0 && col < cols && !checked[row][col];
	}

	static void addNearest(boolean[][] checked, Queue<Integer> queue, int rows, int cols, int row, int col,
			int generation) {
		for (int j = col - generation; j <= col + generation; j++) {
			if (valid(checked, rows, cols, row + generation, j)) {
				checked[row + generation][j] = true;
				queue.add(row + generation);
				queue.add(j);
			}
			if (valid(checked, rows, cols, row - generation, j)) {
				checked[row - generation][j] = true;
				queue.add(row - generation);
				queue.add(j);
			}
		}
		for (int i = row - generation; i < row + generation; i++) {
			if (valid(checked, rows, cols, i, col + generation)) {
				checked[i][col + generation] = true;
				queue.add(i);
				queue.add(col + generation);
			}
			if (valid(checked, rows, cols, i, col - generation)) {
				checked[i][col - generation] = true;
				queue.add(i);
				queue.add(col - generation);
			}
		}
	}

	/**
	 * Returns the distance from the point (row,col) to the nearest land
	 * 
	 * @param bMap
	 * @param rows
	 * @param cols
	 * @param row
	 * @param col
	 * @return
	 */
	static int getMinDist(boolean[][] bMap, int rows, int cols, int row, int col) {
		int d = Integer.MAX_VALUE;
		boolean[][] checked = new boolean[rows][cols];
		checked[row][col] = true;
		Queue<Integer> queue = new LinkedList<>();

		boolean done = false;
		int generation = 1;
		while (!done) {
			boolean found = false;
			addNearest(checked, queue, rows, cols, row, col, generation);
			if (queue.isEmpty()) {
				break;
			}
			while (!queue.isEmpty()) {
				// (i,j) is a potential land
				int i = queue.poll();
				int j = queue.poll();

				if (bMap[i][j]) {// is land
					int newDist = dist(i, j, row, col);
					if (newDist <= d) {
						d = newDist;
						if (d == 1) {
							return d;
						}
						found = true;
					}
				}
			}
			if (found) {
				return d;
			}
			generation ++;
		}
		return d;
	}

	public static int maxDistance(int[][] grid) {
		int rows = grid.length;
		int cols = 0;
		if (rows > 0) {
			cols = grid[0].length;
		}

		int maxD = -1;

		boolean[][] bMap = new boolean[rows][cols];
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (grid[row][col] == 1) {
					bMap[row][col] = true;
				}
			}
		}

		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (grid[row][col] == 1) {
					continue;
				}
				int d = getMinDist(bMap, rows, cols, row, col);
				if (d > maxD) {
					maxD = d;
				}
			}

		}
		if (maxD == -1 || maxD == Integer.MAX_VALUE) {
			return -1;
		}
		return maxD;

	}

	public static void main(String[] arg) {

		int[][] mtx = { { 1, 0, 1 }, { 0, 0, 0 }, { 1, 0, 1 } };
		System.out.println(maxDistance(mtx));

		int[][] mtx1 = { { 1, 0, 1, 0, 0 }, { 0, 0, 0, 1, 0 }, { 1, 0, 1, 0, 0 }, { 1, 0, 0, 0, 0 },
				{ 1, 0, 1, 0, 0 }, };
		System.out.println(maxDistance(mtx1));

		int[][] mtx2 = { { 1, 1, 1 }, { 1, 1, 1 } };
		System.out.println(maxDistance(mtx2));

		int[][] mtx3 = { { 0, 0 }, { 0, 0 } };
		System.out.println(maxDistance(mtx3));

		int[][] mtx4 = { { 1, 0, 1, 0, 0 }, { 0, 0, 0, 1, 0 }, { 1, 0, 0, 0, 0 }, { 1, 0, 0, 0, 0 },
				{ 1, 0, 0, 0, 0 }, };
		System.out.println(maxDistance(mtx4));// 4

		int[][] mtx8 = 
				{{1,0,0,0,0,1,0,0,0,1},
				{1,1,0,1,1,1,0,1,1,0},
				{0,1,1,0,1,0,0,1,0,0},
				{1,0,1,0,1,0,0,0,0,0},
				{0,1,0,0,0,1,1,0,1,1},
				{0,0,1,0,0,1,0,1,0,1},
				{0,0,0,1,1,1,1,0,0,1},
				{0,1,0,0,1,0,0,1,0,0},
				{0,0,0,0,0,1,1,1,0,0},
				{1,1,0,1,1,1,1,1,0,0}};
		
		System.out.println(maxDistance(mtx8));// 2

		
	}

}
