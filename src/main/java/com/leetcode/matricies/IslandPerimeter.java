package com.leetcode.matricies;

/**
 * https://leetcode.com/problems/island-perimeter/
 *
 * You are given a map in form of a two-dimensional integer grid where 1
 * represents land and 0 represents water.
 * 
 * Grid cells are connected horizontally/vertically (not diagonally). The grid
 * is completely surrounded by water, and there is exactly one island (i.e., one
 * or more connected land cells).
 * 
 * The island doesn't have "lakes" (water inside that isn't connected to the
 * water around the island). One cell is a square with side length 1. The grid
 * is rectangular, width and height don't exceed 100. Determine the perimeter of
 * the island.
 * 
 * 
 * 
 * Example:
 * 
 * Input: 
 * [
 * [0,1,0,0], 
 * [1,1,1,0], 
 * [0,1,0,0], 
 * [1,1,0,0]
 * ]
 * 
 * Output: 16
 * 
 * 
 * 
 */
public class IslandPerimeter {
	

	public static int islandPerimeter(int[][] grid) {
		int per = 0;
		
		int rows = grid.length;
		int cols = 0;
		if (rows > 0) {
			cols = grid[0].length;
		}

		for (int row = 0; row < rows; row++) {
			if (cols > 1) {
				for (int col = 0; col < cols-1; col++) {
					int state = grid[row][col];
					int nextState = grid[row][col+1];
					per += (state ^ nextState);
				}
			}
		}
		for (int col = 0; col < cols; col++) {
			if (rows > 1) {
				for (int row = 0; row < rows-1; row++) {
					int state = grid[row][col];
					int nextState = grid[row+1][col];
					per += (state ^ nextState);
				}
			}
		}
		
		
		for (int row = 0; row < rows; row++) {
			if (grid[row][0] == 1) {
				per ++;
			}
			if (grid[row][cols-1] == 1) {
				per ++;
			}
		}
		for (int col = 0; col < cols; col++) {
			if (grid[0][col] == 1) {
				per ++;
			}
			if (grid[rows-1][col] == 1) {
				per ++;
			}
		}
		
		return per;
	}

	public static void main(String[] arg) {
		
		int[][] grid = {
			{0,1,0,0}, 
			{1,1,1,0}, 
			{0,1,0,0}, 
			{1,1,0,0}
		};
		System.out.println(islandPerimeter(grid));

		int[][] grid1 = {
				{1,1,0,0}, 
				{1,1,0,0}, 
				{0,0,0,0}, 
				{1,1,0,1}
		};
		System.out.println(islandPerimeter(grid1));

		int[][] grid2 = {
				{0,0}, 
				{1,0}, 
				{0,0}
		};
		System.out.println(islandPerimeter(grid2));

	}
}
