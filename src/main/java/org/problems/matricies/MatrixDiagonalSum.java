package org.problems.matricies;

/**
 * https://leetcode.com/problems/matrix-diagonal-sum/
 * 
 * Given a square matrix mat, return the sum of the matrix diagonals.
 * 
 * Only include the sum of all the elements on the primary diagonal and all the
 * elements on the secondary diagonal that are not part of the primary diagonal.
 * 
 */
public class MatrixDiagonalSum {

	public int diagonalSum(int[][] mat) {
		int n = mat.length;
		if (n == 0) {
			return 0;
		}
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += mat[i][i];
			sum += mat[n - i - 1][i];
		}
		return sum;
	}

	public static void main(String[] arg) {
		System.out.println(true);
	}

}
