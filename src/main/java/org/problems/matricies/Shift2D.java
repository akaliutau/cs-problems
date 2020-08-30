package org.problems.matricies;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/shift-2d-grid/
 * 
 * Given a 2D grid of size m x n and an integer k. You need to shift the grid k
 * times.
 * 
 * In one shift operation:
 * 
 * Element at grid[i][j] moves to grid[i][j + 1]. Element at grid[i][n - 1]
 * moves to grid[i + 1][0]. Element at grid[m - 1][n - 1] moves to grid[0][0].
 * Return the 2D grid after applying shift operation k times.
 * 
 * Example 1
 * 
 * Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1 Output:
 * [[9,1,2],[3,4,5],[6,7,8]]
 */
public class Shift2D {
	
	public List<List<Integer>> shiftGrid(int[][] grid, int k) {
		int n = grid.length;
		int m = 0;
		if (n > 0) {
			m = grid[0].length;
		}
		int s = n * m;
		int[] elems = new int[s];
		int idx = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				elems[idx++] = grid[i][j];
			}
		}
		List<List<Integer>> res = new ArrayList<>();
        k = k % s;
		idx = s - k;
		for (int i = 0; i < n; i++) {
			List<Integer> line = new ArrayList<>(); 
			for (int j = 0; j < m; j++) {
				idx = idx % s;
				line.add(elems[idx++]);
			}
			res.add(line);
		}
		
		return res;
        
    }

	public static void main(String[] arg) {

		System.out.println("D");

	}

}
