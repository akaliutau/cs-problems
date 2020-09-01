package org.problems.favourite;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Water flooding
 * 
 * Given a 2D grid, each cell is either a water or a land. Water can flood
 * adjacent (up/down/left/right) land into flooded land every day. Find out how
 * many days does it take to flood all lands?
 * 
 * Input: matrix, a 2D integer array where a[i][j] = 1 represents a water on the
 * cell and a[i][j] = 0 represents a land on the cell.
 * 
 * Output: Return an integer represent how many days does it take. Return -1 if
 * no water.
 * 
 * Example : Input: [ [0, 1, 1, 0, 1], [0, 1, 0, 1, 0], [0, 0, 0, 0, 1}, [0, 1,
 * 0, 0, 0] ]
 * 
 * Output: 2
 * 
 */
public class WaterFlooding {

	static int[] dr = new int[] { -1, 0, 1, 0 };
	static int[] dc = new int[] { 0, -1, 0, 1 };
	
	public static int orangesRotting(int[][] grid) {
		int m = grid.length;

		if (m == 0) {
			return 0;
		}
		int n = grid[0].length;

		Queue<int[]> queue = new LinkedList<>();

		for (int r = 0; r < m; r++) {
			for (int c = 0; c < n; c++) {
				if (grid[r][c] == 1) {
					queue.add(new int[] {r, c});
				}
			}
		}
		
		boolean[][] processed = new boolean[m][n];
		int days = -1; // Result (similar to depth level in BFS)

		while (!queue.isEmpty()) {
			List<int[]> toAdd = new ArrayList<>();
			while (!queue.isEmpty()) {
				int[] cell = queue.poll();
				processed[cell[0]][cell[1]] = true;
				for (int k = 0; k < 4; k++) {
					int nr = cell[0] + dr[k];
					int nc = cell[1] + dc[k];

					if (0 <= nr && nr < m && 0 <= nc && nc < n && !processed[nr][nc] && grid[nr][nc] == 0) {
						grid[nr][nc] = 1;
						toAdd.add(new int[] {nr, nc});
					}
				}
			}
			queue.addAll(toAdd);
			days ++;
		}
		int total = 0;

		for (int[] row : grid) {
			for (int v : row) {
				total += v;
				if (v == 0) {
					return -1;
				}
			}
		}

		return total == 0 ? 0 : days;
	}

	public static void main(String[] arg) {
		
		int[][] grid = {
				{0, 1, 1, 0, 1}, {0, 1, 0, 1, 0}, {0, 0, 0, 0, 1}, {0, 1, 0, 0, 0}
		};
		System.out.println(orangesRotting(grid));//2
	}

}
