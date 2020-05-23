package org.problems.matricies;

import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/image-smoother/
 * 
 * Given a 2D integer matrix M representing the gray scale of an image, you need
 * to design a smoother to make the gray scale of each cell becomes the average
 * gray scale (rounding down) of all the 8 surrounding cells and itself. If a
 * cell has less than 8 surrounding cells, then use as many as you can.
 * 
 * Example 1: 
 * Input: [[1,1,1], [1,0,1], [1,1,1]] 
 * Output: [[0, 0, 0], [0, 0, 0], [0, 0, 0]] 
 * 
 * Explanation: 
 * For the point (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0 
 * For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0 
 * For the point (1,1): floor(8/9) = floor(0.88888889) = 0
 * 
 * Note: The value in the given matrix is in the range of [0, 255]. 
 * The length and width of the given matrix are in the range of [1, 150]
 * 
 */
public class ImageSmoother {
	
	public static int[] shifts = {-1,-1, -1,0, -1,1, 0,-1, 0,0, 0,1, 1,-1, 1,0, 1,1};
	
	public static boolean isValid(int i, int j, int n, int m) {
		return i >= 0 && i < n && j >=0 && j < m;
	}

	public static int[][] imageSmoother(int[][] m) {
		int rows = m.length;
		int cols = 0;
		if (rows > 0) {
			cols = m[0].length;
		}
		int[][] res = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				int total = 0;
				int sum = 0;
				for (int c = 0; c < 18; c += 2) {
					int x = i + shifts[c];
					int y = j + shifts[c+1];
					if (isValid(x, y, rows, cols)) {
						total ++;
						sum += m[x][y];
					}
				}
               if (total > 0)
	  				 res[i][j] = sum / total;
			}
		}
		
		return res;

	}

	public static void main(String[] arg) {

		int[][] m = {
				{1,1,1}, 
				{1,0,1}, 
				{1,1,1}
		};
		
		Utils.print(imageSmoother(m));

	}

}
