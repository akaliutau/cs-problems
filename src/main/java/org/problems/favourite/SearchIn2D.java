package org.problems.favourite;

/**
 * Search a 2D Matrix
 * 
 * Find an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * 
 * Integers in each row are sorted in ascending from left to right. Integers in
 * each column are sorted in ascending from top to bottom
 * 
 * 
 * 
 */
public class SearchIn2D {
	
   	static class Result {
		public final int target;
		public boolean searchRows = true;
		public boolean searchCols = true;

		public Result(int target) {
			this.target = target;
		}

		@Override
		public String toString() {
			return "Result [target=" + target + ", searchRows=" + searchRows + ", searchCols=" + searchCols +"]";
		}
	}
	
	
	static void searchRows(int[][] matrix, int[] rect, Result result, int rows) {
		int row = rect[0];
		int min = rect[2];
		int max = row;
		boolean found = false;
		while (row <= rect[2]) {
			int[] r = matrix[row];
			if (r[rect[1]] <= result.target && r[rect[3]] >= result.target) {
				min = Math.min(min, row);
				max = Math.max(max, row);
				found = true;
			}
			row++;
		}
		if (!found) {
			result.searchRows = false;// target located somewhere on rows between [min,max]
			return;
		}
		if (rect[0] == min && rect[2] == max) {
			result.searchRows = false;// target located somewhere on rows between [min,max]
		}
		rect[0] = min;
		rect[2] = max;
	}

	static void searchColumns(int[][] matrix, int[] rect, Result result, int cols) {
		int col = rect[1];
		int min = rect[3];
		int max = col;
		boolean found = false;
		while (col <= rect[3]) {
			if (matrix[rect[0]][col] <= result.target && matrix[rect[2]][col] >= result.target) {
				min = Math.min(min, col);
				max = Math.max(max, col);
				found = true;
			}
			col++;
		}
		if (!found) {
			result.searchCols = false;// target located somewhere on rows between [min,max]
			return;
		}
		if (rect[1] == min && rect[3] == max) {
			result.searchCols = false;// target located somewhere on cols between [min,max]
		}
		rect[1] = min;
		rect[3] = max;
	}

	public boolean searchMatrix(int[][] matrix, int target) {
		
		int rows = matrix.length;
		int cols = 0;
		if (rows > 0) {
			cols = matrix[0].length;
		}
        if (rows == 0 || cols == 0){
            return false;
        }
		int[] rect = {0, 0, rows-1, cols-1};
		Result result = new Result(target);
		while(true) {
			if (result.searchRows) {
				searchRows(matrix, rect, result, rows);
			}
			if (result.searchCols) {
				searchColumns(matrix, rect, result, cols);
			}
			if (!result.searchCols && !result.searchRows) {
				break;
			}
		}
		for (int i = rect[0]; i <= rect[2]; i++) {
			for (int j = rect[1]; j <= rect[3]; j++) {
				if (result.target == matrix[i][j]) {
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
