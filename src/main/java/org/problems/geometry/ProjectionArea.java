package org.problems.geometry;

import java.util.List;

/**
 * https://leetcode.com/problems/projection-area-of-3d-shapes/
 * 
 * On a N * N grid, we place some 1 * 1 * 1 cubes that are axis-aligned with the
 * x, y, and z axes.
 * 
 * Each value v = grid[i][j] represents a tower of v cubes placed on top of grid
 * cell (i, j).
 * 
 * Now we view the projection of these cubes onto the xy, yz, and zx planes.
 * 
 * A projection is like a shadow, that maps our 3 dimensional figure to a 2
 * dimensional plane.
 * 
 * Here, we are viewing the "shadow" when looking at the cubes from the top, the
 * front, and the side.
 * 
 * Return the total area of all three projections.
 * 
 * Example 1:
 * 
 * Input: [[2]] Output: 5 
 * 
 * Example 2:
 * 
 * Input: [[1,2],[3,4]] Output: 17 
 * Explanation: Here are the three projections
 * ("shadows") of the shape made with each axis-aligned plane.
 * 
 */
public class ProjectionArea {

	public static int projectionArea(int[][] grid) {
		int n = grid.length;
		int m = 0;
		if (n > 0) {
			m = grid[0].length;
		}
		int z = 0;
		for (int i = 0; i < n; i ++) {
			for (int j = 0; j < m; j ++) {
				if (grid[i][j] > 0) {
					z ++;
				}
			}
		}

		int total = z;
		for (int i = 0; i < n; i ++) {
			int sum = 0;
			for (int j = 0; j < m; j ++) {
				sum = Math.max(sum, grid[i][j]);
			}
			total += sum;
		}
		for (int i = 0; i < m; i ++) {
			int sum = 0;
			for (int j = 0; j < n; j ++) {
				sum = Math.max(sum, grid[j][i]);
			}
			total += sum;
		}
		
		return total;
        
    }

	public static void main(String[] arg) {

		int[][] grid = {
				{2}
		};
		System.out.println(projectionArea(grid));

		int[][] grid1 = {
				{1,2},
				{3,4}
		};
		System.out.println(projectionArea(grid1));

	}

}
