package com.leetcode.matricies;

/**
 * https://leetcode.com/problems/search-a-2d-matrix/
 * 
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * 
 * Integers in each row are sorted from left to right. The first integer of each
 * row is greater than the last integer of the previous row. Example 1:
 * 
 * Input:
 * 
 * matrix = 
 * [ 
 * [1, 3, 5, 7], 
 * [10, 11, 16, 20], 
 * [23, 30, 34, 50] 
 * ]
 * 
 * target = 3 Output: true
 * 
 * 
 * 
 */
public class Search2DMatrix {

	public static boolean searchMatrix(int[][] matrix, int target) {
		
		int m = matrix.length;
		int n = 0;
		if (m > 0) {
			n = matrix[0].length;
		}
		
		if (n == 0 || m == 0) {
			return false;
		}

		if (n == 1 &&  m == 1) {
			return matrix[0][0] == target;
		}

		// find the row i  such that matrix[i][0] <= target && matrix[i+1][0] > target 
		int top = 0;
		int bottom = m-1;
		int i = 0;
		if (matrix[top][0] > target || matrix[bottom][n-1] < target) {
			return false;
		}else if (matrix[bottom][0] <= target) {//the target is on last line 
			i = bottom;
		}else {//the target is on i-th line
			boolean found = false;
			while (!found) {
				i = (bottom + top)/2;// always < bottom
				if (matrix[i][0] <= target && matrix[i+1][0] > target) {
					found = true;
				}
				if (matrix[i][0] > target) {
					bottom = i;
				}else {
					top = i;
				}
			}
		}

		if (matrix[i][n-1] < target) {
			return false;
		}
		
		boolean found = false;
		int left = 0;
		int right = n-1;
		int j = 0;
		
		if (matrix[i][n-1] == target) {
			return true;
		}
		
		while (!found) {
			j = (left + right)/2;// always < right
			if (matrix[i][j] <= target && target < matrix[i][j+1]) {
				found = true;
			}
			if (matrix[i][j] > target) {
				right = j;
			}else {
				left = j;
			}
		}
		
		return matrix[i][j] == target;
        
    }

	public static void main(String[] arg) {
		
		int[][] matrix = {
				{1,   3,  5,  7},
				{10, 11, 16, 20},
				{23, 30, 34, 50}
		};

		System.out.println(searchMatrix(matrix,0));
		System.out.println(searchMatrix(matrix,3));
		System.out.println(searchMatrix(matrix,8));
		System.out.println(searchMatrix(matrix,56));
		System.out.println(searchMatrix(matrix,20));
		
		int[][] matrix2 = {
				{1,  },
				{10, },
				{23, }
		};

		System.out.println(searchMatrix(matrix2,0));
		System.out.println(searchMatrix(matrix2,10));
		System.out.println(searchMatrix(matrix2,8));


	}
}
