package com.leetcode.matricies;

import com.leetcode.utils.Utils;

/**
 * https://leetcode.com/problems/maximal-square/
 * 
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square
 * containing only 1's and return its area.
 * 
 * Example:
 * 
 * Input:
 * *  1 2 3 4 5
 * 
 * 1  1 0 1 0 0
 * 2  1 0 1 1 1
 * 3  1 1 1 1 1 
 * 4  1 0 0 1 0
 * 
 * 1
 * 
 * 12
 * 22
 * 
 * 123
 * 223
 * 333
 * 
 * dp[i,j] = min(dp[i-1,j],dp[i,j-1],dp[i-1,j-1]) + 1 orElse 0
 * 
 * Output: 4
 * 
 */
public class MaximalSquare {
	
	static int dp(int[][] dp, int i, int j) {
		if (i >= 0 && j >=0 ) {
			return dp[i][j];
		}
		return 0;
	}

	public static int maximalSquare(char[][] matrix) {
		int rows = matrix.length;
		int cols = 0;
		if (rows > 0) {
			cols = matrix[0].length;
		}
		int[][] dp = new int[rows][cols];
		int size = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				dp[i][j] = matrix[i][j] - '0';
				if (dp[i][j] > 0) {
					dp[i][j] = Math.min(dp(dp,i-1,j), Math.min(dp(dp,i,j-1), dp(dp,i-1,j-1))) + 1;
					size = Math.max(size, dp[i][j]);
				}
			}
		}
		Utils.print(dp);
		return size * size;

	}

	public static void main(String[] arg) {
		
		char[][] matrix = {
				{'1', '0', '1', '0', '0'},
				{'1', '0', '1', '1', '1'},
				{'1', '1', '1', '1', '1'},
				{'1', '0', '0', '1', '0'}
		};
		System.out.println(maximalSquare(matrix));

		char[][] matrix1 = {
				{'1', '0', '1', '0', '0', '0'},
				{'1', '0', '1', '1', '1', '1'},
				{'1', '1', '1', '1', '1', '1'},
				{'1', '0', '0', '1', '1', '1'}
		};
		System.out.println(maximalSquare(matrix1));


	}

}
