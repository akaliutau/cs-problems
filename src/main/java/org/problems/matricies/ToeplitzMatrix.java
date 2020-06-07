package org.problems.matricies;

/**
 * https://leetcode.com/problems/toeplitz-matrix/
 * 
 * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the
 * same element.
 * 
 * Now given an M x N matrix, return True if and only if the matrix is Toeplitz.
 * 
 * 
 * Example 1:
 * 
 * Input: matrix = 
 * [ 
 * [1,2,3,4], 
 * [5,1,2,3], 
 * [9,5,1,2] 
 * ] 
 * 
 * Output: True Explanation:
 * In the above grid, the diagonals are: "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2,
 * 2]", "[3, 3]", "[4]". In each diagonal all elements are the same, so the
 * answer is True. 
 * 
 * Example 2:
 * 
 * Input: matrix = 
 * [ 
 * [1,2], 
 * [2,2] 
 * ] Output: False 
 * 
 * Explanation: The diagonal "[1, 2]" has different elements.
 * 
 * Note:
 * 
 * matrix will be a 2D array of integers. matrix will have a number of rows and
 * columns in range [1, 20]. 
 * matrix[i][j] will be integers in range [0, 99].
 * 
 * Runtime: 1 ms, faster than 90.78% of Java online submissions for Toeplitz Matrix.
 * Memory Usage: 39.3 MB, less than 89.30% of Java online submissions for Toeplitz Matrix.
 * 
 */
public class ToeplitzMatrix {

	public static boolean isToeplitzMatrix(int[][] matrix) {
		int m = matrix.length;
		int n = 0;
		if (m > 0) {
			n = matrix[0].length;
		}
		for (int j = 0; j < n; j++) {
			int i = 0;
			int l = j;
			int elem = matrix[i][l];
			while (i < m && l < n) {
				if (matrix[i][l] != elem) {
					return false;
				}
				i ++;
				l ++;
			}
		}
		for (int i = 0; i < m; i++) {
			int l = i;
			int j = 0;
			int elem = matrix[l][j];
			while (l < m && j < n) {
				if (matrix[l][j] != elem) {
					return false;
				}
				l ++;
				j ++;
			}
		}
		
		return true;

	}

	public static void main(String[] arg) {
		
		int[][] matrix = {
				{1,2,3,4}, 
				{5,1,2,3}, 
				{9,5,1,2}
		};

		System.out.println(isToeplitzMatrix(matrix));

		int[][] matrix1 = {
				{1,2},
				{2,2}
		};

		System.out.println(isToeplitzMatrix(matrix1));

		int[][] matrix2 = {
				{11,74,0,93},
				{40,11,74,7}
		};

		System.out.println(isToeplitzMatrix(matrix2));//false

	}

}
