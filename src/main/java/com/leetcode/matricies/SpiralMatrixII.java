package com.leetcode.matricies;

import com.leetcode.utils.Utils;

/**
 * https://leetcode.com/problems/spiral-matrix-ii/
 * 
 * Given a positive integer n, generate a square matrix filled with elements
 * from 1 to n2 in spiral order.
 * 
 * Example:
 * 
 * Input: 3 
 * Output: 
 * [ 
 * [ 1, 2, 3 ], 
 * [ 8, 9, 4 ], 
 * [ 7, 6, 5 ] 
 * ]
 * 
 */
public class SpiralMatrixII {

	public static int[][] generateMatrix(int n) {
		int dim = n*n;
		int[][] res = new int[n][n];
		 
		int c = 1;
		int i = 0;
		int j = 0;
		int rightOffset = n;
		int leftOffset = -1;
		int topOffset = 0;
		int bottomOffset = n;
		
		while (true) {
			while (i < rightOffset) {
				res[j][i] = c++;
				i++;
			}
			rightOffset--;
			i--;//n-1
			j++;//1
			if (c > dim) {
				break;
			}
			
			while (j < bottomOffset) {
				res[j][i] = c++;
				j++;
			}
			bottomOffset--;
			j--;
			i--;//
			if (c > dim) {
				break;
			}
			
			while (i > leftOffset) {
				res[j][i] = c++;
				i--;
			}
			leftOffset++;
			i++;
			j--;//
			if (c > dim) {
				break;
			}
			
			while (j > topOffset) {
				res[j][i] = c++;
				j--;
			}
			topOffset++;
			j++;
			i++;//
			if (c > dim) {
				break;
			}
		}
		
		return res;
    }

	public static void main(String[] arg) {

		Utils.print(generateMatrix(3));
		Utils.print(generateMatrix(4));
		Utils.print(generateMatrix(5));
	}
}
