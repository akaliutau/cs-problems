package org.problems.chess;

/**
 * https://leetcode.com/problems/unique-paths-ii/
 * 
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
 * the diagram below).
 * 
 * Now consider if some obstacles are added to the grids. How many unique paths
 * would there be?
 * 
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * 
 * Note: m and n will be at most 100.
 * 
 * Example 1:
 * 
 * Input: 
 * [ 
 * [0,0,0], 
 * [0,1,0], 
 * [0,0,0] 
 * ] 
 * 
 * Output: 2
 * 
 * Explanation: There is one obstacle in the middle of the 3x3 grid above. There
 * are two ways to reach the bottom-right corner: 1. Right -> Right -> Down ->
 * Down 2. Down -> Down -> Right -> Right
 */
public class UniquePathsII {
	
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		
		int n =  obstacleGrid.length;
		int m =  obstacleGrid[0].length;
		
		if (m == 0 || n == 0) {
			return 0;
		}

		int[][] dt = new int[n][m];
		boolean obstacle = false;
		for (int i = 0; i < m; i++) {
			obstacle = obstacle || obstacleGrid[0][i] == 1;
			dt[0][i] = obstacle ? 0 : 1;
		}
		obstacle = false;
		for (int i = 0; i < n; i++) {
			obstacle = obstacle || obstacleGrid[i][0] == 1;
			dt[i][0] = obstacle ? 0 : 1;
		}
		for (int row = 1; row < n; row++) {
			for (int col = 1; col < m; col++) {
				int left = obstacleGrid[row][col-1] == 1 ? 0 : dt[row][col - 1];  
				int up = obstacleGrid[row - 1][col] == 1 ? 0 : dt[row - 1][col];  
				if (obstacleGrid[row][col] == 0) {
					dt[row][col] = left + up;
				}
			}
		}

		return dt[n - 1][m - 1];
		
		
    }


	public static void main(String[] arg) {
		
		int[][] grid = {
			{0,0,0}, 
			{0,1,0}, 
			{0,0,0}
		};

		System.out.println(uniquePathsWithObstacles(grid));

		int[][] grid1 = {
				{0,1,0} 
		};
		
		System.out.println(uniquePathsWithObstacles(grid1));

		int[][] grid2 = {
				{0}, 
				{1}, 
				{0}
		};

		System.out.println(uniquePathsWithObstacles(grid2));


	}
}
