package org.problems.graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/minimum-path-sum/
 * 
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 * 
 * Example:
 * 
 * Input: 
 * [ 
 * [1,3,1], 
 * [1,5,1], 
 * [4,2,1] 
 * ] 
 * Output: 7 
 * Explanation: Because the path
 * 1->3->1->1->1 minimizes the sum
 * 
 */
public class MinimumPathSum {

	public static int minPathSum(int[][] grid) {
		int n = grid.length;
		int m = 0;
		if (n > 0) {
			m = grid[0].length;
		}
		if (n == 0 || m == 0) {
			return 0;
		}
		int[][] sum = new int[n][m];
		boolean[][] processed = new boolean[n][m];
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		q.add(0);
		sum[0][0] = grid[0][0];
		while (!q.isEmpty()) {
			int r = q.poll();
			int c = q.poll();

			if (c + 1 < m) {
				int sum1 = sum[r][c] +	grid[r][c + 1];
				sum[r][c + 1] = sum[r][c + 1] == 0 ? sum1 : Math.min(sum[r][c + 1], sum1);
				if (!processed[r][c + 1]) {
				q.add(r);
				q.add(c + 1);
				processed[r][c + 1] = true;
				}
			}
			if (r + 1 < n) {
				int sum1 = sum[r][c] + 	grid[r + 1][c];
				sum[r + 1][c] = sum[r + 1][c] == 0 ? sum1 : Math.min(sum[r + 1][c], sum1);
				if (!processed[r + 1][c]) {
				q.add(r + 1);
				q.add(c);
				processed[r + 1][c] = true;
				}
			}
		}
		
		return sum[n - 1][m - 1];

	}

	public static void main(String[] arg) {

		int[][] grid = {
				{1,3,1},
				{1,5,1},
				{4,2,1}
		};
		System.out.println(minPathSum(grid));
		
		int[][] grid2 = {
				{7,1,3,5,8,9,9,2,1,9,0,8,3,1,6,6,9,5},
				{9,5,9,4,0,4,8,8,9,5,7,3,6,6,6,9,1,6},
				{8,2,9,1,3,1,9,7,2,5,3,1,2,4,8,2,8,8},
				{6,7,9,8,4,8,3,0,4,0,9,6,6,0,0,5,1,4},
				{7,1,3,1,8,8,3,1,2,1,5,0,2,1,9,1,1,4},
				{9,5,4,3,5,6,1,3,6,4,9,7,0,8,0,3,9,9},
				{1,4,2,5,8,7,7,0,0,7,1,2,1,2,7,7,7,4},
				{3,9,7,9,5,8,9,5,6,9,8,8,0,1,4,2,8,2},
				{1,5,2,2,2,5,6,3,9,3,1,7,9,6,8,6,8,3},
				{5,7,8,3,8,8,3,9,9,8,1,9,2,5,4,7,7,7},
				{2,3,2,4,8,5,1,7,2,9,5,2,4,2,9,2,8,7},
				{0,1,6,1,1,0,0,6,5,4,3,4,3,7,9,6,1,9}
		};
		
		System.out.println(minPathSum(grid2));
		
		int[][] grid3 = {
				{1,2},
				{1,1}
		};
		System.out.println(minPathSum(grid3));



	}

}
