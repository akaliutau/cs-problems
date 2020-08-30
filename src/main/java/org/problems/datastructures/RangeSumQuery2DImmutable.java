package org.problems.datastructures;

/**
 * https://leetcode.com/problems/range-sum-query-2d-immutable/
 * 
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner
 * 
 * 
 */
public class RangeSumQuery2DImmutable {

	static class NumMatrix {
		private int n;
		private int m;
		private int[][] sums;


	    public NumMatrix(int[][] matrix) {
		     n = matrix.length;
	         m = 0;
	         if (n > 0){
	             m = matrix[0].length;
	         }
		     sums = new int[n][m];
		     for (int j = 0; j < n; j++) {
		        for (int i = 0; i < m; i++) {
		      	    sums[j][i] = i - 1 >= 0 ? sums[j][i - 1] + matrix[j][i] : matrix[j][i];
		        }
	         }
	    }
	    
	    public int sumRegion(int row1, int col1, int row2, int col2) {
	       if (n == 0 || m == 0) {
		   		return 0;
		   }
	       int sum = 0;
	       for (int j = row1; j <= row2; j++){
	           sum += (col1 - 1 >= 0 ? sums[j][col2] - sums[j][col1 - 1] : sums[j][col2]);
	       }
		   return sum;

	    }
	}

	
	public static void main(String[] arg) {
		System.out.println(true);
	}

}
