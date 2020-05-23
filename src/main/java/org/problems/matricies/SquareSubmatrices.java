package org.problems.matricies;

/**
 * https://leetcode.com/problems/count-square-submatrices-with-all-ones/
 * 
 * Given a m * n matrix of ones and zeros, return how many square submatrices
 * have all ones.
 * 
 * Example 1:
 * 
 * Input: matrix = [ [0,1,1,1], [1,1,1,1], [0,1,1,1] ] Output: 15 Explanation:
 * There are 10 squares of side 1. There are 4 squares of side 2. There is 1
 * square of side 3. Total number of squares = 10 + 4 + 1 = 15.
 * 
 * Example 2:
 * 
 * Input: matrix = [ [1,0,1], [1,1,0], [1,1,0] ] Output: 7 Explanation: There
 * are 6 squares of side 1. There is 1 square of side 2. Total number of squares
 * = 6 + 1 = 7
 * 
 * 1 <= arr.length <= 300 1 <= arr[0].length <= 300 0 <= arr[i][j] <= 1
 */
public class SquareSubmatrices {


	public int countSquares(int[][] matrix) {
		int total = 0;
		// find max squares
		// starting from 2x2
		int m = matrix.length;
		int n = 0;
		if (m > 0) {
			n = matrix[0].length;
		}

		int[][] dp = new int[m][n];
		for (int i = 0; i < n; i++) {
			if (matrix[0][i] == 1) {
				dp[0][i] = 1;
				total++;
			}
		}

		for (int i = 1; i < m; i++) {
			if (matrix[i][0] == 1) {
				dp[i][0] = 1;
				total++;
			}
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] == 1) {
					total++;
					dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
					if (dp[i][j] > 1) {
						total += (dp[i][j] - 1);
					}
				}
			}
		}

		return total;
	}

	public static void main(String[] arg) {

		System.out.println(true);

	}

}
