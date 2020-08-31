package org.problems.favourite;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Number of Isolated Islands
 * 
 */
public class IsolatedIslands {
	
	static class Cell {
		public boolean visited = false;
		public char ch;
		public int c;
		public int r;
		
		public Cell(char ch, int r, int c) {
			this.ch = ch;
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Cell [visited=" + visited + ", ch=" + ch + ", c=" + c + ", r=" + r + "]";
		}
	}
	
   	public static Cell getNextIsland(int row, int col, int rows, int cols, Cell[][] grid) {
		for (int i = row; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (!grid[i][j].visited && grid[i][j].ch == '1') {
					grid[i][j].visited = true;
					return grid[i][j];
				}
				grid[i][j].visited = true;
			}
		}
		return null;
	}
	
	public static void addIslandCells(int row, int col, int rows, int cols, Cell[][] grid, Queue<Cell> queue) {
		if (row-1 >= 0) {
			if (grid[row-1][col].ch == '1' && !grid[row-1][col].visited) {
				queue.add(grid[row-1][col]);
			}
			grid[row-1][col].visited = true;
		}
		if (row+1 < rows) {
			if (grid[row+1][col].ch == '1' && !grid[row+1][col].visited) {
				queue.add(grid[row+1][col]);
			}
			grid[row+1][col].visited = true;
		}
		if (col-1 >= 0) {
			if (grid[row][col-1].ch == '1' && !grid[row][col-1].visited) {
				queue.add(grid[row][col-1]);
			}
			grid[row][col-1].visited = true;
		}
		if (col+1 < cols) {
			if (grid[row][col+1].ch == '1' && !grid[row][col+1].visited) {
				queue.add(grid[row][col+1]);
			}
			grid[row][col+1].visited = true;
		}
	}
	
	
	public int numIslands(char[][] grid) {
		
		int rows = grid.length;
		int cols = 0;
		if (rows > 0) {
			cols = grid[0].length;
		}
		Cell[][] cells = new Cell[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				cells[i][j] = new Cell(grid[i][j], i, j);
			}			
		}
		
		int counter = 0;
		Cell next = getNextIsland(0, 0, rows, cols, cells);
		while (next != null) {
			counter ++;
			// cover island using BFS
			Queue<Cell> queue = new LinkedList<>();
			queue.add(next);
			while (!queue.isEmpty()) {
				Cell cell = queue.poll();
				addIslandCells(cell.r, cell.c, rows, cols, cells, queue);
			}
			next = getNextIsland(next.r, next.c, rows, cols, cells);
		}
		return counter;
	        
	}


	public static void main(String[] arg) {

		System.out.println("D");

	}

}
