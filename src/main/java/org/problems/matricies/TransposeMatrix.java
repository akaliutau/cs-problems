package org.problems.matricies;

import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/transpose-matrix/
 * 
 * Given a matrix A, return the transpose of A.
 * 
 * The transpose of a matrix is the matrix flipped over it's main diagonal,
 * switching the row and column indices of the matrix.
 * 
 * Example 1:
 * 
 * Input: [[1,2,3],[4,5,6],[7,8,9]] Output: [[1,4,7],[2,5,8],[3,6,9]] 
 * 
 * Example 2:
 * 
 * Input: [
 * [1,2,3],
 * [4,5,6]
 * ] 
 * Output: 
 * [
 * [1,4],
 * [2,5],
 * [3,6]
 * ]
 * 
 * 
 * Note:
 * 
 * 1 <= A.length <= 1000 
 * 1 <= A[0].length <= 1000
 * 
 */
public class TransposeMatrix {

	public static int[][] transpose(int[][] a) {
		int r = a.length;
		int c = 0;
		if (r > 0) {
			c = a[0].length;
		}
		int[][] res = new int[c][r];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				res[j][i] = a[i][j];
			}
		}
		
		return res;

	}

	public static void main(String[] arg) {
		int[][] a = {
				{1,2,3},
				{4,5,6}
		};

		Utils.print(transpose(a));

	}

}
