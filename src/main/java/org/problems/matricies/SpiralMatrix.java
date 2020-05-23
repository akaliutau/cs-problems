package org.problems.matricies;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/spiral-matrix/
 * 
 * Given a matrix of m x n elements (m rows, n columns), return all elements of
 * the matrix in spiral order.
 * 
 * Example 1:
 * 
 * Input: 
 * [ 
 * [ 1, 2, 3 ], 
 * [ 4, 5, 6 ], 
 * [ 7, 8, 9 ] 
 * ]
 * 
 * Output: [1,2,3,6,9,8,7,4,5]
 * 
 */
public class SpiralMatrix {
	
	static void addCircle(int[][] matrix, int offset, int m, int n, List<Integer> collector) {
		if (m == 1) {
			for (int i = offset; i < n-offset; i++) {//[1,1]
				collector.add(matrix[offset][i]);
			}
			return;
		}
		if (n == 1) {
			for (int i = offset; i < m-offset; i++) {//[1,1]
				collector.add(matrix[i][n-offset-1]);
			}
			return;
		}
		boolean oneColumn =  n-2*offset-1 == 0;
		boolean oneRow =  m-2*offset-1 == 0;
		if (!oneRow) {
			for (int i = offset; i < n-offset-1; i++) {//[1,1]
				collector.add(matrix[offset][i]);
			}
		}else {
			for (int i = offset; i < n-offset; i++) {//[1,1]
				collector.add(matrix[offset][i]);
			}
			
		}
		if (!oneColumn) {
			for (int i = offset; i < m-offset-1; i++) {//[1,1]
				collector.add(matrix[i][n-offset-1]);
			}
		}else {
			for (int i = offset; i < m-offset; i++) {//[1,1]
				collector.add(matrix[i][n-offset-1]);
			}
		}
		
		if (!oneRow) {
			for (int i = n-offset-1; i > offset; i--) {//[1,1]
				collector.add(matrix[m-offset-1][i]);
			}
		}
		if (!oneColumn) {
			for (int i = m-offset-1; i > offset; i--) {//[1,1]
				collector.add(matrix[i][offset]);
			}
		}
	}

	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<>();
		if (matrix.length == 0) {
			return res;
		}
		int m = matrix.length;
		if (matrix[0].length == 0) {
			return res;
		}
		int n = matrix[0].length;
		if (n == 1 && m == 1 && m == n) {
			res.add(matrix[n/2][n/2]);
			return res;
		}
		
		
		int dim = Math.min(m, n);
		int nCirc =  (dim+1)/2;
		if (n %2 == 1 && m % 2 == 1 && m == n) {
			nCirc --;
		}		
		
		for (int offset = 0; offset < nCirc; offset++) {
			addCircle(matrix, offset, m, n, res);
		}
		if (n %2 == 1 && m % 2 == 1 && m == n) {
			res.add(matrix[n/2][n/2]);
		}
		return res;
        
    }

	public static void main(String[] arg) {
		
		int[][] matrix = new int[][] {
			{ 1, 2, 3 }, 
			{ 4, 5, 6 }, 
			{ 7, 8, 9 }
		};
		System.out.println(spiralOrder(matrix));

		int[][] matrix1 = new int[][] {
			{ 1, 2, 3, 4}, 
			{ 5, 6, 7, 8}, 
			{ 9,10,11,12}, 
			{13,14,15,16}, 
		};
		System.out.println(spiralOrder(matrix1));

		int[][] matrix2 = new int[][] {
			{ 1, 2, 3, 4}, 
			{ 5, 6, 7, 8}, 
			{ 9,10,11,12} 
		};
		System.out.println(spiralOrder(matrix2));

		int[][] matrix3 = new int[][] {
			{ 1, 2, 3, 4} 
		};
		System.out.println(spiralOrder(matrix3));

		int[][] matrix4 = new int[][] {
			{ 1}, 
			{ 2},
			{ 3},
			{ 4} 
		};
		System.out.println(spiralOrder(matrix4));
		
		int[][] matrix5 = new int[][] {
			{ 4} 
		};
		System.out.println(spiralOrder(matrix5));

		int[][] matrix6 = new int[][] {
			{ 1, 2, 3 }, 
			{ 4, 5, 6 }, 
			{ 7, 8, 9 },
			{10,11,12 },
			{13,14,15 }
		};
		System.out.println(spiralOrder(matrix6));
		
		int[][] matrix7 = new int[][] {
			{ 1, 2, 3 , 4 }, 
			{ 5, 6, 7 , 8 } 
		};
		System.out.println(spiralOrder(matrix7));


	}
}
