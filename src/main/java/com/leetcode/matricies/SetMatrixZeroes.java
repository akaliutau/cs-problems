package com.leetcode.matricies;

import com.leetcode.utils.Utils;

/**
 * https://leetcode.com/problems/set-matrix-zeroes/
 * 
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0.
 * Do it in-place.
 * 
 * Example 1:
 * 
 * Input: 
 * [ 
 * [1,1,1], 
 * [1,0,1], 
 * [1,1,1] 
 * ]
 * 
 * Output: 
 * [ 
 * [1,0,1], 
 * [0,0,0], 
 * [1,0,1] 
 * ]
 * 
 * 
 */
public class SetMatrixZeroes {

	public static void setZeroes(int[][] matrix) {
		int m =  matrix.length;
		int n = 0;
		if (m > 0) {
			n = matrix[0].length;
		}
		
		// check the 1st column first
		
       	// check all cells in column 0
		int firstColumn = 1;
      	for (int i = 0; i < m; i++) {// i - row
           	if (matrix[i][0] == 0) {// (0,1) (1,1) (2,1), ...
           		firstColumn = 0;// set the first elem of column j to 0
                break;
          	}
        }

		
        for (int i = 0; i < m; i++) {// i - row
        	// check all cells in row i
            for (int j = 0; j < n; j++) {// j - col
            	if (matrix[i][j] == 0) {
            		matrix[i][0] = 0;// set the first elem of row i to 0
            		break;
            	}
            }
        }


        for (int j = 1; j < n; j++) {// j - col
        	// check all cells in column j
        	for (int i = 0; i < m; i++) {// i - row
            	if (matrix[i][j] == 0) {// (0,1) (1,1) (2,1), ...
            		matrix[0][j] = 0;// set the first elem of column j to 0
                    break;
            	}
            }
        }
        
        
        for (int i = 1; i < m; i++) {// i - row
           	if (matrix[i][0] == 0) {
                for (int j = 0; j < n; j++) {// j - col
            		matrix[i][j] = 0;
            	}
          	}
        }
        for (int j = 1; j < n; j++) {// j - col
           	if (matrix[0][j] == 0) {
                for (int i = 0; i < m; i++) {//  i - row
            		matrix[i][j] = 0;
            	}
          	}
        }
        
       	if (matrix[0][0] == 0) {
            for (int j = 0; j < n; j++) {// j - col
        		matrix[0][j] = 0;
        	}
      	}
       	if (firstColumn == 0) {
            for (int i = 0; i < m; i++) {//  i - row
        		matrix[i][0] = 0;
        	}
      	}


    }

	public static void main(String[] arg) {

		int[][] matrix = {
				{1,   3,  5,  7},
				{10, 0, 16, 20},
				{23, 30, 34, 50}
		};

		setZeroes(matrix);
		Utils.print(matrix);

		int[][] matrix0 = {
				{0,1,2,0},
				{1,4,5,2},
				{1,3,1,5}
		};
		setZeroes(matrix0);
		Utils.print(matrix0);

		int[][] matrix2 = {{1}};
		setZeroes(matrix2);
		Utils.print(matrix2);
		


	}
}
