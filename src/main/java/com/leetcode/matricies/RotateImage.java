package com.leetcode.matricies;

import com.leetcode.utils.Utils;

/**
 * https://leetcode.com/problems/rotate-image/
 *
 *
 * You are given an n x n 2D matrix representing an image.
 * 
 * Rotate the image by 90 degrees (clockwise).
 * 
 * Note:
 * 
 * You have to rotate the image in-place, which means you have to modify the
 * input 2D matrix directly. DO NOT allocate another 2D matrix and do the
 * rotation.
 * 
 * Example 1:
 * 
 * Given input matrix = 
 * [ 
 * [1,2,3], 
 * [4,5,6], 
 * [7,8,9] 
 * ],
 * 
 * rotate the input matrix in-place such that it becomes: 
 * [ 
 * [7,4,1], 
 * [8,5,2],
 * [9,6,3] 
 * ]
 * 
 */
public class RotateImage {
	
	public static void moveCircle(int[][] matrix, int left, int right) {
		for (int i = left; i < right; i++) {
			int c = matrix[left][i];
			matrix[left][i] = matrix[right-i+left][left];
			matrix[right-i+left][left] = matrix[right][right-i+left];
			matrix[right][right-i+left] = matrix[i][right];
			matrix[i][right] = c;
		}
		
	}

	public static void rotate(int[][] matrix) {
		int n = matrix.length;
		if (n == 1) {
			return;
		}
		int center = n % 2 == 0 ? n/2 : n/2 +1;
		System.out.println(center);
		for (int i = 0; i < center; i++) {
			moveCircle(matrix,i,n-1-i);
		}
	}

	public static void main(String[] arg) {

		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		rotate(arr);
		Utils.print(arr);

		int[][] arr1 = { { 1, 2, 3, 4}, { 5, 6, 7, 8 }, { 9,10,11,12 }, { 13,14,15,16 } };
		rotate(arr1);
		Utils.print(arr1);
}

}
