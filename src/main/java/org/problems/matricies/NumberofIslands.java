package org.problems.matricies;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/number-of-islands/
 *
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of
 * islands. An island is surrounded by water and is formed by connecting
 * adjacent lands horizontally or vertically. You may assume all four edges of
 * the grid are all surrounded by water.
 * 
 * Example 1:
 * 
 * Input: 
 *  11110 
 *  11010 
 *  11000 
 *  00000
 * 
 * Output: 1 
 * 
 * Example 2:
 * 
 * Input: 
 *  11000 
 *  11000 
 *  00100 
 *  00011
 * 
 * Output: 3
 *
 */
public class NumberofIslands {
	
	public static void getNextIsland(int row, int col, int rows, int cols, char[][] grid, boolean[][] visited, int[] island) {
		island[0] = -1;
		for (int i = row; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (!visited[i][j] && grid[i][j] == '1') {
					island[0] = i;
					island[1] = j;
					visited[i][j] = true;
					return;
				}
				visited[i][j] = true;
			}
		}
	}
	
	public static void addIslandCells(int row, int col, int rows, int cols, char[][] grid, boolean[][] visited, Queue<Integer> queue) {
		if (row-1 >= 0) {
			if (grid[row-1][col] == '1' && !visited[row-1][col]) {
				queue.add(row-1);
				queue.add(col);
			}
			visited[row-1][col] = true;
		}
		if (row+1 < rows) {
			if (grid[row+1][col] == '1' && !visited[row+1][col]) {
				queue.add(row+1);
				queue.add(col);
			}
			visited[row+1][col] = true;
		}
		if (col-1 >= 0) {
			if (grid[row][col-1] == '1' && !visited[row][col-1]) {
				queue.add(row);
				queue.add(col-1);
			}
			visited[row][col-1] = true;
		}
		if (col+1 < cols) {
			if (grid[row][col+1] == '1' && !visited[row][col+1]) {
				queue.add(row);
				queue.add(col+1);
			}
			visited[row][col+1] = true;
		}
	}
	
	
	public static int numIslands(char[][] grid) {
		
		int rows = grid.length;
		int cols = 0;
		if (rows > 0) {
			cols = grid[0].length;
		}
		
		boolean[][] visited = new boolean[rows][cols];
		
		int counter = 0;
		int[] island = new int[2];
		int row = 0;
		int col = 0;
		getNextIsland(row, col, rows, cols, grid, visited, island);
		while (island[0] != -1) {
			counter ++;
			row = island[0];
			col = island[1];
			// cover island using BFS
			Queue<Integer> queue = new LinkedList<Integer>();
			queue.add(row);
			queue.add(col);
			while (!queue.isEmpty()) {
				int i = queue.poll();
				int j = queue.poll();
				addIslandCells(i, j, rows, cols, grid, visited, queue);
			}
			getNextIsland(row, col, rows, cols, grid, visited, island);
		}
		
		return counter;
	        
	}

	public static void main(String[] arg) {

		char[][] grid = {
				{'1','1','1','1','0'},
				{'1','1','0','1','0'},
				{'1','1','0','0','0'},
				{'0','0','0','0','0'},
		};
		System.out.println(numIslands(grid));

		char[][] grid1 = {
				{'1','1','0','0','0'},
				{'1','1','0','0','0'},
				{'0','0','1','0','0'},
				{'0','0','0','1','1'},
		};
		System.out.println(numIslands(grid1));

		char[][] grid2 = {
				{'1','1','1','1','0'},
				{'1','1','0','1','0'},
				{'0','0','1','0','0'},
				{'1','0','0','1','1'},
		};
		System.out.println(numIslands(grid2));


		char[][] grid3 = {
				{'1','1'},
				{'1','1'},
		};
		System.out.println(numIslands(grid3));

		char[][] grid4 = {
				{'0','0'},
				{'0','0'},
		};
		System.out.println(numIslands(grid4));

	}
}
