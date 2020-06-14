package org.problems.cellularauto;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/matrix-cells-in-distance-order/
 * 
 * We are given a matrix with R rows and C columns has cells with integer
 * coordinates (r, c), where 0 <= r < R and 0 <= c < C.
 * 
 * Additionally, we are given a cell in that matrix with coordinates (r0, c0).
 * 
 * Return the coordinates of all cells in the matrix, sorted by their distance
 * from (r0, c0) from smallest distance to largest distance. Here, the distance
 * between two cells (r1, c1) and (r2, c2) is the Manhattan distance, |r1 - r2|
 * + |c1 - c2|. (You may return the answer in any order that satisfies this
 * condition.)
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: R = 1, C = 2, r0 = 0, c0 = 0 Output: [[0,0],[0,1]] 
 * Explanation: The
 * distances from (r0, c0) to other cells are: [0,1] 
 * 
 * Example 2:
 * 
 * Input: R = 2, C = 2, r0 = 0, c0 = 1 Output: [[0,1],[0,0],[1,1],[1,0]]
 * Explanation: The distances from (r0, c0) to other cells are: [0,1,1,2] The
 * answer [[0,1],[1,1],[0,0],[1,0]] would also be accepted as correct. 
 * 
 * Example 3:
 * 
 * Input: R = 2, C = 3, r0 = 1, c0 = 2 Output:
 * [[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]] 
 * Explanation: The distances from (r0, c0) to other cells are: [0,1,1,2,2,3] 
 * There are other answers that would also
 * be accepted as correct, such as [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]].
 * 
 * 
 * Note:
 * 
 * 1 <= R <= 100 
 * 1 <= C <= 100 
 * 0 <= r0 < R 
 * 0 <= c0 < C
 */
public class MatrixCells {
	
	static int dist(int[] src, int[] dst) {
		return Math.abs(src[0] - dst[0]) + Math.abs(src[1] - dst[1]);
	}
	

	public static int[][] allCellsDistOrder(int r, int c, int r0, int c0) {
		
		int n = r * c;
		int[][] res = new int[n][2];
		int[] src = {r0, c0};
		Comparator<int[]> byDist = (o,p) -> Integer.compare(dist(o,src), dist(p,src));
		
		int idx = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				res[idx][0] = i;
				res[idx][1] = j;
				idx ++;
			}
		}
		Arrays.parallelSort(res, byDist);
		return res;

	}

	public static void main(String[] arg) {

		allCellsDistOrder(2, 2, 0 , 1);
		allCellsDistOrder(2, 3, 1 , 2);

	}

}
