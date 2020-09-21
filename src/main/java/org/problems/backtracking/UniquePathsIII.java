package org.problems.backtracking;

/**
 * https://leetcode.com/problems/unique-paths-iii/solution/
 * 
 * On a 2-dimensional grid, there are 4 types of squares:
 * 
 * 1 represents the starting square. There is exactly one starting square. 2
 * represents the ending square. There is exactly one ending square. 0
 * represents toDo squares we can walk over. -1 represents obstacles that we
 * cannot walk over. Return the number of 4-directional walks from the starting
 * square to the ending square, that walk over every non-obstacle square exactly
 * once.
 * 
 * 
 * 
 */
public class UniquePathsIII {
	static class Result {
		int path_count = 0;;
	}

	static void backtrack(int[][] grid, int row, int col, int toDo, int rows, int cols, Result res) {
		if (grid[row][col] == 2 && toDo == 1) {
			res.path_count ++;
			return;
		}

		int temp = grid[row][col];
		grid[row][col] = -4;
		toDo --; // eleminate 1 path

		int[] row_offsets = { 0, 0, 1, -1 };
		int[] col_offsets = { 1, -1, 0, 0 };
		for (int i = 0; i < 4; ++i) {
			int next_row = row + row_offsets[i];
			int next_col = col + col_offsets[i];

			if (0 <= next_row && next_row < rows && 0 <= next_col && next_col < cols && grid[next_row][next_col] >= 0) {
				backtrack(grid, next_row, next_col, toDo, rows, cols, res);
			}
		}

		grid[row][col] = temp;
	}

	public int uniquePathsIII(int[][] grid) {
		int toDo = 0, startRow = 0, startCol = 0;

		int rows = grid.length;
		int cols = 0;
		if (rows > 0) {
			cols = grid[0].length;
		}

		for (int row = 0; row < rows; row++)
			for (int col = 0; col < cols; col++) {
				int cell = grid[row][col];
				if (cell >= 0) {
					toDo ++;
				}
				if (cell == 1) {
					startRow = row;
					startCol = col;
				}
			}

		Result r = new Result();
		backtrack(grid, startRow, startCol, toDo, rows, cols, r);

		return r.path_count;
	}

	public static void main(String[] arg) {
		System.out.println(true);
	}

}
