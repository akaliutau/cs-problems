package org.problems.matricies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/largest-plus-sign/
 * 
 * In a 2D grid from (0, 0) to (N-1, N-1), every cell contains a 1, except those
 * cells in the given list mines which are 0. What is the largest axis-aligned
 * plus sign of 1s contained in the grid? Return the order of the plus sign. If
 * there is none, return 0.
 * 
 * An "axis-aligned plus sign of 1s of order k" has some center grid[x][y] = 1
 * along with 4 arms of length k-1 going up, down, left, and right, and made of
 * 1s. This is demonstrated in the diagrams below. Note that there could be 0s
 * or 1s beyond the arms of the plus sign, only the relevant area of the plus
 * sign is checked for 1s.
 * 
 * Examples of Axis-Aligned Plus Signs of Order k:
 * 
 * Order 1: 
 * 000 
 * 010 
 * 000
 * 
 * Order 2: 
 * 00000 
 * 00100 
 * 01110 
 * 00100 
 * 00000
 * 
 * Order 3: 
 * 0000000 
 * 0001000 
 * 0001000 
 * 0111110 
 * 0001000 
 * 0001000 
 * 0000000 
 * 
 * Example 1:
 * 
 * Input: N = 5, mines = [[4, 2]] Output: 2 
 * Explanation: 
 * 11111 
 * 11111 
 * 11111 
 * 11111
 * 11011 
 * 
 * In the above grid, the largest plus sign can only be order 2. One of
 * them is marked in bold. 
 * 
 * Example 2:
 * 
 * Input: N = 2, mines = [] Output: 1 
 * Explanation: There is no plus sign of
 * order 2, but there is of order 1. 
 * 
 * Example 3:
 * 
 * Input: N = 1, mines = [[0, 0]] Output: 0 
 * Explanation: There is no plus sign,
 * so return 0. Note:
 * 
 * N will be an integer in the range [1, 500]. 
 * mines will have length at most 5000. 
 * mines[i] will be length 2 and consist of integers in the range [0, N-1].
 * 
 * Runtime: 25 ms, faster than 99.30% of Java online submissions for Largest Plus Sign.
 * Memory Usage: 47.8 MB, less than 56.78% of Java online submissions for Largest Plus Sign
 * 
 */
public class LargestPlusSign {
	
	private static void fillLine(int i, int j, int k, int[][] m) {
		for (int l = j + 1; l < k; l ++) {
			m[i][l] = Math.min(l - j, k - l);
		}
	}

	private static void fillCol(int i, int j, int k, int[][] m) {
		for (int l = j + 1; l < k; l ++) {
			m[l][i] = Math.min(l - j, k - l);
		}
	}


	public static int orderOfLargestPlusSign(int n, int[][] mines) {
		int[][] hor = new int[n][n];
		int[][] ver = new int[n][n];
		
		Map<Integer,List<int[]>> lines = new HashMap<>();
		Map<Integer,List<int[]>> cols = new HashMap<>();
		for (int[] mine : mines) {
			if (!lines.containsKey(mine[0])) {
				lines.put(mine[0], new ArrayList<int[]>());
			}
			lines.get(mine[0]).add(mine);
			if (!cols.containsKey(mine[1])) {
				cols.put(mine[1], new ArrayList<int[]>());
			}
			cols.get(mine[1]).add(mine);
		}
		
		for (Integer line : lines.keySet()) {
			Collections.sort(lines.get(line), (o,p) -> Integer.compare(o[1], p[1]));
		}
		for (Integer col : cols.keySet()) {
			Collections.sort(cols.get(col), (o,p) -> Integer.compare(o[0], p[0]));
		}
		
		
		for (int i = 0; i < n; i++) {
			if (lines.containsKey(i)) {
				List<int[]> dots = lines.get(i);
				for (int j = 0; j < dots.size() - 1; j++) {
					fillLine(i, dots.get(j)[1], dots.get(j + 1)[1], hor);
				}
				fillLine(i, -1, dots.get(0)[1], hor);
				fillLine(i, dots.get(dots.size() - 1)[1], n, hor);
			}else {
				fillLine(i, -1, n, hor);
			}
		}
		for (int i = 0; i < n; i++) {
			if (cols.containsKey(i)) {
				List<int[]> dots = cols.get(i);
				for (int j = 0; j < dots.size() - 1; j++) {
					fillCol(i, dots.get(j)[0], dots.get(j + 1)[0], ver);
				}
				fillCol(i, -1, dots.get(0)[0], ver);
				fillCol(i, dots.get(dots.size() - 1)[0], n, ver);
			}else {
				fillCol(i, -1, n, ver);
			}
		}

		int sz = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sz = Math.max(sz, Math.min(hor[i][j], ver[i][j]));
			}
		}

		return sz;

	}


	public static void main(String[] arg) {
		
		int[][] mines = {
				{4, 2}
		};
		System.out.println(orderOfLargestPlusSign(5, mines));

		int[][] mines1 = {
		};
		System.out.println(orderOfLargestPlusSign(2, mines1));

		int[][] mines2 = {
				{0, 0}
		};
		System.out.println(orderOfLargestPlusSign(1, mines2));

	}

}
