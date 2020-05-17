package com.leetcode.matricies;

import java.util.List;

import com.leetcode.utils.Utils;

/**
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 * 
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * 
 * Integers in each row are sorted in ascending from left to right. Integers in
 * each column are sorted in ascending from top to bottom. Example:
 * 
 * Consider the following matrix:
 * 
 * 1,  4,  7,  11, 15, 
 * 2,  5,  8,  12, 19, 
 * 3,  6,  9,  16, 22, 
 * 10, 13, 14, 17, 24, 
 * 18, 21, 23, 26, 30 

 * Given target = 5, return true.
 * 
 * Given target = 20, return false.
 * 
 */
public class Search2DMatrixII {
	
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

	public static boolean searchMatrix(int[][] matrix, int target) {
		
		int rows = matrix.length;
		int cols = 0;
		if (rows > 0) {
			cols = matrix[0].length;
		}
        if (rows == 0 || cols == 0){
            return false;
        }
		int[] rect = new int[4];
		rect[0] = 0;
		rect[1] = 0;
		rect[2] = rows-1;
		rect[3] = cols-1;
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
		
		int[][] matrix = {
				{1,  4,  7,  11, 15}, 
				{2,  5,  8,  12, 19}, 
				{3,  6,  9,  16, 22}, 
				{10, 13, 14, 17, 24}, 
				{18, 21, 23, 26, 30}
		};

		System.out.println(searchMatrix(matrix, 14));
		System.out.println(searchMatrix(matrix, 20));
		System.out.println(searchMatrix(matrix, 29));
		System.out.println(searchMatrix(matrix, 32));
		System.out.println(searchMatrix(matrix, 23));
		System.out.println(searchMatrix(matrix, 22));
		System.out.println(searchMatrix(matrix, 1));

		int[][] matrix1 = {
				{1,  4,  7,  11, 15}, 
				{2,  5,  8,  12, 19}, 
				{3,  6,  13, 16, 22}, 
				{10, 13, 13, 17, 24}, 
				{18, 21, 23, 26, 30}
		};

		System.out.println(searchMatrix(matrix1, 14));

		int[][] matrix2 = {
				{1,  4,  7,  11, 15}, 
				{2,  5,  8,  12, 19}, 
				{3,  6,  11, 16, 22}, 
				{10, 14, 15, 17, 24}, 
				{18, 21, 23, 26, 30}
		};

		System.out.println(searchMatrix(matrix2, 14));

	}

}
