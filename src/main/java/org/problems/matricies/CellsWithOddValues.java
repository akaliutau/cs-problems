package org.problems.matricies;

/**
 * https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/
 * 
 * Given n and m which are the dimensions of a matrix initialized by zeros and
 * given an array indices where indices[i] = [ri, ci]. For each pair of [ri, ci]
 * you have to increment all cells in row ri and column ci by 1.
 * 
 * Return the number of cells with odd values in the matrix after applying the
 * increment to all indices
 * 
 * 
 */
public class CellsWithOddValues {
	
	static void inc(int[][] arr, int r, int c, int n, int m) {
		for (int i = 0; i < m; i++) {
			arr[r][i] ++;
		}
		for (int i = 0; i < n; i++) {
			arr[i][c] ++;
		}
	}
	
	public static int oddCells(int n, int m, int[][] indecies) {
		int[][] arr = new int[n][m];
		for (int[] cell : indecies) {
			inc(arr, cell[0], cell[1], n, m);
		}

		int counter = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
            	if (arr[i][j] % 2 == 1) {
            		counter ++;
            	}
            }        	
        }
        return counter;
    }

	public static void main(String[] arg) {
		
		int[][] indecies = {
				{0,1},
				{1,1}
		};

		System.out.println(oddCells(2, 3, indecies));

	}

}
