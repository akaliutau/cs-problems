package org.problems.dp;

/**
 * https://leetcode.com/problems/maximal-rectangle/
 * 
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle
 * containing only 1's and return its area.
 * 
 * Example:
 * 
 * Input: 
 * [ 
 * ['1','0','1','0','0'], 
 * ['1','0','1','1','1'], 
 * ['1','1','1','1','1'],
 * ['1','0','0','1','0'] ]
 *
 * 
 * Output: 6
 * 
 *      dp        matrix
 *  1 0 1 0 0   1 0 1 0 0
 *  1 0 1 2 3   1 0 1 1 1
 *  1 2 3 4 5   1 1 1 1 1
 *  1 0 0 1 0   1 0 0 1 0
 *
 * 
 * O((nm)^2)
 * 
 */
public class MaximalRectangle {
	
	public static int maximalRectangle(char[][] matrix) {
		int n = matrix.length;
		int m = 0;
		if (n > 0) {
			m = matrix[0].length;
		}
		if (n == 0) {
			return 0;
		}
		int[][] dp = new int[n][m];
		int area = 0;
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < m; col++) {
				if (matrix[row][col] == '1') {
					dp[row][col] = col == 0 ? 1 : dp[row][col-1] + 1;
					int w = dp[row][col];
					for (int k = row ; k >= 0; k--) {
						w = Math.min(dp[k][col] , w);
						area = Math.max(area , w * (1 + row - k));
					}
				}
			}
		}
		return area;
	}


	public static void main(String[] arg) {

		char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
				{ '1', '0', '0', '1', '0' } };
		System.out.println(maximalRectangle(matrix));
	}

}
