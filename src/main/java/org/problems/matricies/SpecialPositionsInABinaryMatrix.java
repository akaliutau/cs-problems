package org.problems.matricies;

/**
 * https://leetcode.com/problems/special-positions-in-a-binary-matrix/
 * 
 * Given a rows x cols matrix mat, where mat[i][j] is either 0 or 1, return the
 * number of special positions in mat.
 * 
 * A position (i,j) is called special if mat[i][j] == 1 and all other elements
 * in row i and column j are 0 (rows and columns are 0-indexed).
 * 
 * Example 1:
 * 
 * Input: mat = 
 * [
 * [1,0,0], 
 * [0,0,1], 
 * [1,0,0]
 * ] 
 * Output: 1 
 * Explanation: (1,2) is a
 * special position because mat[1][2] == 1 and all other elements in row 1 and
 * column 2 are 0.
 * 
 */
public class SpecialPositionsInABinaryMatrix {

	public int numSpecial(int[][] mat) {
		int n = mat.length;
		int m = 0;
		if (n > 0) {
			m = mat[0].length;
		}
		int[] rows = new int[n];
		int[] cols = new int[m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				rows[i] += mat[i][j];
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				cols[i] += mat[j][i];
			}
		}
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (rows[i] == 1) {
				for (int j = 0; j < m; j++) {
					if (cols[j] == 1) {
						if (mat[i][j] == 1) count ++;
					}
				}
			}
		}
		return count;

	}

	public static void main(String[] arg) {
			System.out.println(true);
	}

}
