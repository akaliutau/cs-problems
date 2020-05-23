package org.problems.matricies;

import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/count-servers-that-communicate/
 * 
 * You are given a map of a server center, represented as a m * n integer matrix
 * grid, where 1 means that on that cell there is a server and 0 means that it
 * is no server. Two servers are said to communicate if they are on the same row
 * or on the same column.
 * 
 * Return the number of servers that communicate with any other server.
 * 
 * Input: grid = 
 * [
 * [1,0],
 * [0,1]
 * ] 
 * Output: 0 
 * Explanation: No servers can communicate with others
 * 
 * Input: grid = 
 * [
 * [1,1,0,0],
 * [0,0,1,0],
 * [0,0,1,0],
 * [0,0,0,1]
 * ] 
 * Output: 4
 * 
 * Constraints:
 * 
 * m == grid.length n == grid[i].length 
 * 1 <= m <= 250 
 * 1 <= n <= 250 
 * grid[i][j] == 0 or 1
 * 
 */
public class CountCommunicapableServers {

	public static int countServers(int[][] grid) {
		int n = grid.length;
		int m = 0;
		if (n > 0) {
			m = grid[0].length;
		}
		int[] rows = new int[n];
		int[] cols = new int[m];
		
		int[][] counted = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 1) {
					rows[i] ++;
					counted[i][j] = 1;
				}
			}
		}
		for (int j = 0; j < m; j++) {
			for (int i = 0; i < n; i++) {
				if (grid[i][j] == 1) {
					cols[j] ++;
				}
			}
		}
		int total = 0;
		for (int i = 0; i < n; i++) {
			if (rows[i] > 1) {
				total += rows[i];
			}
		}
		for (int j = 0; j < m; j++) {
			if (cols[j] > 1) {
				total += cols[j];
			}
		}
		Utils.print(counted);
		Utils.print(rows);
		Utils.print(cols);
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 1 && rows[i] > 1 && cols[j] > 1) {
					total--;
				}
			}
		}
		
		return total;

	}

	public static void main(String[] arg) {
		
		int[][] grid = {
				{1,1,0,0},
				{0,0,1,0},
				{0,0,1,0},
				{0,0,0,1}
		};

		System.out.println(countServers(grid));

		int[][] grid1 = {
				{1,0},
				{0,1}
		};

		System.out.println(countServers(grid1));

	}

}
