package org.problems.matricies;

import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/diagonal-traverse/
 * 
 * Given a matrix of M x N elements (M rows, N columns), return all elements of
 * the matrix in diagonal order as shown in the below image.
 * 
 * 
 * 
 * Example:
 * 
 * Input: 
 * j=0  1  2    i
 * [ 1, 2, 3 ], 0 
 * [ 4, 5, 6 ], 1
 * [ 7, 8, 9 ]  2
 * ]
 * 
 * Output: [1,2,4,7,5,3,6,8,9]
 * 
 */
public class DiagonalTraverse {
	
	static class Result {
		public int[] arr;
		public int idx = 0;
		
		public Result(int[] arr) {
			this.arr = arr;
		}
		
		public void add(int n) {
			arr[idx++] = n;
		}
	}
	
	static void diag(int[][] matrix, Result res, int sum, int m, int n, boolean reverse) {
		if (!reverse) {
			for (int j = 0; j < n; j++) {
				int i = sum - j;
				if (i < 0 || i >= m) {
					continue;
				} else {
					res.add(matrix[i][j]);
				}
			}
		}else {
			for (int i = 0; i < m; i++) {
				int j = sum - i;
				if (j < 0 || j >= n) {
					continue;
				} else {
					res.add(matrix[i][j]);
				}
			}
			
		}
	}

	static void reverseDiagv() {
		
	}

	public static int[] findDiagonalOrder(int[][] matrix) {
		int m = matrix.length;
		int n = 0;
		if (m > 0) {
			n = matrix[0].length;
		}
		int[] res = new int[n * m];
		Result r = new Result(res);
		boolean reverse = false;
		for (int s = 0; s < n + m - 1; s++) {
			diag(matrix, r, s, m, n, reverse);
			reverse = !reverse;
		}
		
		return r.arr;

	}

	public static void main(String[] arg) {
		
		int[][] matrix = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};

		Utils.print(findDiagonalOrder(matrix));

	}

}
