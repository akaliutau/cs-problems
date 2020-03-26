package com.leetcode.matricies;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/max-area-of-island/
 *
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's
 * (representing land) connected 4-directionally (horizontal or vertical.) You
 * may assume all four edges of the grid are surrounded by water.
 * 
 * Find the maximum area of an island in the given 2D array. (If there is no
 * island, the maximum area is 0.)
 * 
 * Example 1:
 * 
 * [
 * [0,0,1,0,0,0,0,1,0,0,0,0,0], 
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,1,1,0,1,0,0,0,0,0,0,0,0], 
 * [0,1,0,0,1,1,0,0,1,0,1,0,0],
 * [0,1,0,0,1,1,0,0,1,1,1,0,0], 
 * [0,0,0,0,0,0,0,0,0,0,1,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0], 
 * [0,0,0,0,0,0,0,1,1,0,0,0,0]
 * ] 
 * 
 * Given the above grid, return 6. Note the answer is not 11, because the island must be
 * connected 4-directionally. 
 * 
 * Example 2:
 * 
 * [[0,0,0,0,0,0,0,0]] 
 * 
 * Given the above grid, return 0. Note: The length of each
 * dimension in the given grid does not exceed 50.
 * 
 */
public class MaxAreaofIsland {
	
	public static void getNextIsland(int row, int col, int rows, int cols, int[][] grid, boolean[][] visited, int[] island) {
		island[0] = -1;
		for (int i = row; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (!visited[i][j] && grid[i][j] == 1) {
					island[0] = i;
					island[1] = j;
					visited[i][j] = true;
					return;
				}
				visited[i][j] = true;
			}
		}
	}
	
	public static void addIslandCells(int row, int col, int rows, int cols, int[][] grid, boolean[][] visited, Queue<Integer> queue) {
		if (row-1 >= 0) {
			if (grid[row-1][col] == 1 && !visited[row-1][col]) {
				queue.add(row-1);
				queue.add(col);
			}
			visited[row-1][col] = true;
		}
		if (row+1 < rows) {
			if (grid[row+1][col] == 1 && !visited[row+1][col]) {
				queue.add(row+1);
				queue.add(col);
			}
			visited[row+1][col] = true;
		}
		if (col-1 >= 0) {
			if (grid[row][col-1] == 1 && !visited[row][col-1]) {
				queue.add(row);
				queue.add(col-1);
			}
			visited[row][col-1] = true;
		}
		if (col+1 < cols) {
			if (grid[row][col+1] == 1 && !visited[row][col+1]) {
				queue.add(row);
				queue.add(col+1);
			}
			visited[row][col+1] = true;
		}
	}
	
	


	public static int maxAreaOfIsland(int[][] grid) {
		int area = 0;
		int rows = grid.length;
		int cols = 0;
		if (rows > 0) {
			cols = grid[0].length;
		}
		
		boolean[][] visited = new boolean[rows][cols];
		
		int[] island = new int[2];
		int row = 0;
		int col = 0;
		getNextIsland(row, col, rows, cols, grid, visited, island);
		while (island[0] != -1) {
			row = island[0];
			col = island[1];
			int currArea = 0;
			
			// cover island using BFS
			Queue<Integer> queue = new LinkedList<Integer>();
			queue.add(row);
			queue.add(col);
			while (!queue.isEmpty()) {
				int i = queue.poll();
				int j = queue.poll();
				addIslandCells(i, j, rows, cols, grid, visited, queue);
				currArea ++;
			}
			area = area < currArea ? currArea : area;
			getNextIsland(row, col, rows, cols, grid, visited, island);
		}
		return area;

	}

	public static void main(String[] arg) {
		
		int[][] map = {
			{0,0,1,0,0,0,0,1,0,0,0,0,0}, 
		    {0,0,0,0,0,0,0,1,1,1,0,0,0},
		    {0,1,1,0,1,0,0,0,0,0,0,0,0}, 
		    {0,1,0,0,1,1,0,0,1,0,1,0,0},
		    {0,1,0,0,1,1,0,0,1,1,1,0,0}, 
		    {0,0,0,0,0,0,0,0,0,0,1,0,0},
		    {0,0,0,0,0,0,0,1,1,1,0,0,0}, 
		    {0,0,0,0,0,0,0,1,1,0,0,0,0}
		};
		System.out.println(maxAreaOfIsland(map));//6
		
		int[][] map1 = {
				{0,1,1}
		};
		System.out.println(maxAreaOfIsland(map1));//2

		int[][] map2 = {
				{0,0,0}
		};
		System.out.println(maxAreaOfIsland(map2));//0

	}
}
