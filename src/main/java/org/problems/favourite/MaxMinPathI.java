package org.problems.favourite;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import org.problems.utils.Utils;

/**
 * Maximal Minimum Value Path I
 * 
 * Given a two 2D integer array, find the max score of a path from the upper
 * left cell to bottom right cell. The score of a path is the minimum value in
 * that path.
 * 
 * Notice: the path can only right and down.
 * 
 * For example:
 * 
 * Input:
 * 
 * [7,5,3] 
 * [2,0,9] 
 * [4,5,9]
 * 
 * Here are some paths from [0,0] to [2,2] and the minimum value on each path:
 * 
 * path: 7->2->4->5->9, minimum value on this path: 2
 * path: 7->2->0->9->9, minimum value on this path: 0
 * path: 7->2->0->5->9, minimum value on this path: 0
 * 
 * In the end the max score(the min value) of all the paths is 3.
 * 
 * Output: 3
 */
public class MaxMinPathI {
	
	public static int maxMin(int[][] data) {
		int n = data.length;
		int m = 0;
		if (n > 0) {
			m = data[0].length;
		}
		int[][] dp = new int[n][m];
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], Integer.MIN_VALUE);
		}

		dp[0][0] = data[0][0];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0, 0});
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			int max = dp[x][y];
			if (x + 1 < n) {
				int minD = Math.min(max, data[x + 1][y]);

				q.add(new int[] {x + 1, y});
				dp[x + 1][y] = Math.max(dp[x + 1][y], minD);
			}
			if (y + 1 < m) {
				int minR = Math.min(max, data[x][y + 1]);

				q.add(new int[] {x, y + 1});
				dp[x][y + 1] = Math.max(dp[x][y + 1], minR);
			}
		}
		Utils.print(dp);
		return dp[n - 1][m - 1];
		
	}

	public static void main(String[] arg) {
		
		int[][] data = {
				{7,5,3}, 
				{2,0,9}, 
				{4,5,9}
		};
		System.out.println(maxMin(data));
	}

}
