package com.leetcode.magicsquares;

/**
 * https://leetcode.com/problems/magic-squares-in-grid/
 * 
 * A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9
 * such that each row, column, and both diagonals all have the same sum.
 * 
 * Given an grid of integers, how many 3 x 3 "magic square" subgrids are there?
 * (Each subgrid is contiguous).
 * 
 * Example 1:
 * 
 * Input: 
 * [
 * [4,3,8,4], 
 * [9,5,1,9], 
 * [2,7,6,2]
 * ] 
 * Output: 1 
 * 
 * Explanation: The following subgrid is a 3 x 3 magic square: 
 * 438 
 * 951 
 * 276
 * 
 * while this one is not: 
 * 
 * 384 
 * 519 
 * 762
 * 
 * In total, there is only one magic square inside the given grid. Note:
 * 
 * 1 <= grid.length <= 10 
 * 1 <= grid[0].length <= 10 
 * 0 <= grid[i][j] <= 15
 */
public class MagicSquares {
	
	static int getSum(int[] arr, int offset) {
		if (offset == 0) {
			return arr[2];
		}
		return arr[2+offset]-arr[offset-1];
	}
	
	static boolean isMagic(int[][] rowSum, int[][] colSum, int n, int xoffset, int yoffset, int[][] grid) {
		// rows
		int row1 = getSum(rowSum[xoffset], yoffset);
		int row2 = getSum(rowSum[xoffset + 1], yoffset);
		int row3 = getSum(rowSum[xoffset + 2], yoffset);
		if (row1 != row2 || row2 != row3) {
			return false;
		}
		// columns
		int col1 = getSum(colSum[yoffset], xoffset);
		int col2 = getSum(colSum[yoffset + 1], xoffset);
		int col3 = getSum(colSum[yoffset + 2], xoffset);
		if (col1 != col2 || col2 != col3) {
			return false;
		}
		// diag
		if ((grid[xoffset][yoffset] + grid[xoffset+1][yoffset+1] + grid[xoffset+2][yoffset+2])
				!= (grid[xoffset+2][yoffset] + grid[xoffset+1][yoffset+1] + grid[xoffset][yoffset+2])) {
			return false;
		}
		boolean[] added = new boolean[9];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int num = grid[xoffset+i][yoffset+j];
				if (num < 1 || num > 9) {
					return false;
				}
				if (added[num-1]) {
					return false;
				}
				added[num-1] = true;
			}
		}
		return true;
	}
	
	public static int numMagicSquaresInside(int[][] grid) {
		int n = grid.length;
		int m = 0;
		if (n > 0) {
			m = grid[0].length;
		}
		int[][] rowSum = new int[n][m];
		int[][] colSum = new int[m][n];
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = 0; j < m; j++) {
				sum += grid[i][j];
				rowSum[i][j] = sum;
			}			
		}
		for (int j = 0; j < m; j++) {
			int sum = 0;
			for (int i = 0; i < n; i++) {
				sum += grid[i][j];
				colSum[j][i] = sum;
			}			
		}
		int counter = 0;
		for (int i = 0; i+2 < n; i++) {
			for (int j = 0; j+2 < m; j++) {
				if (isMagic(rowSum, colSum, 3, i, j, grid)) {
					counter ++;
				}
			}		
		}		
		
		return counter;
        
    }

	public static void main(String[] arg) {

		int[][] grid = {
				{4,3,8,4},
				{9,5,1,9},
				{2,7,6,2}
		};
		System.out.println(numMagicSquaresInside(grid));

		int[][] grid1 = {
				{4,2,8},
				{9,5,1},
				{2,7,6}
		};
		System.out.println(numMagicSquaresInside(grid1));

		int[][] grid2 = {
				{5,5,5},
				{5,5,5},
				{5,5,5}
		};
		System.out.println(numMagicSquaresInside(grid2));

	}

}
