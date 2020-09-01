package org.problems.favourite;

import java.util.LinkedList;
import java.util.Queue;

/**
 * MOVE OBSTACLE
 * 
 * Write an algorithm to determine the minimum distance required for the
 * demolition robot to remove the obstacle.
 * 
 * Assumptions: 
 * • The lot is flat, except the trenches and can be represented by a 2D grid. 
 * • The demolition robot must start at the top left corner of the
 * lot, which is always flat, and can move on block up, down, right, left 
 * • The demolition robot cannot enter trenches and cannot leave the lot. 
 * • The flat areas are indicated by 1, areas with trenches are indicated by 0, and the
 * obstacle is indicated by 9
 * 
 * Input The input of the function has 3 arguments: numRows – number of rows
 * numColumns – number of columns lot – 2d grid of integers
 * 
 * Output Return an integer that indicated the minimum distance traversed to
 * remove the obstacle else return -1
 * 
 * Constraints 
 * 
 * 1<= numRows, numColumns <= 1000
 * 
 * Example1
 * 
 * Input: 
 * numRows = 3 
 * numColumns = 3 
 * lot = 
 * [ 
 * [1, 0, 0], 
 * [1, 0, 0], 
 * [1, 9, 1]]
 * 
 * Output: 3
 * 
 */
public class MoveObstacle {
	
	static int[] dr = new int[] { -1, 0, 1, 0 };
	static int[] dc = new int[] { 0, -1, 0, 1 };
	
	public static int minDistance(int[][] map) {

		int n = map.length;
		if (n == 0) {
			return -1;
		}
		int m = map[0].length;
		if (map[0][0] == 9) {
			return 0;
		}
		boolean[][] processed = new boolean[n][m];
		int[][] steps = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				steps[i][j] = Integer.MAX_VALUE;
			}			
		}
		steps[0][0] = 0;
		Queue<int[]> queue = new LinkedList<>(); 
		queue.add(new int[] {0, 0});
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int step = steps[cur[0]][cur[1]];
			processed[cur[0]][cur[1]] = true;
			for (int i = 0; i < 4; i++) {
				int x = cur[0] + dr[i];
				int y = cur[1] + dc[i];
				if (x >= 0 && x < n && y >= 0 && y < m && !processed[x][y]) {
					steps[x][y] = Math.min(steps[x][y], step + 1);
					if (map[x][y] == 1) {
						queue.add(new int[] {x, y});
					}else if (map[x][y] == 9) {
						return steps[x][y];
					}
				}
			}
		}
		
		return -1;
	}

	public static void main(String[] arg) {
		
		int[][] map = {
				{1, 0, 0}, 
				{1, 0, 0}, 
				{1, 9, 1}
		};
		System.out.println(minDistance(map));

		int[][] map1 = {
				{1, 1, 0}, 
				{1, 0, 9}, 
				{1, 1, 1}
		};
		System.out.println(minDistance(map1));

		int[][] map2 = {
				{1, 1, 1, 1}, 
				{1, 1, 0, 9}, 
				{1, 0, 1, 1},
				{1, 1, 1, 0},
		};
		System.out.println(minDistance(map2));

	}

}
