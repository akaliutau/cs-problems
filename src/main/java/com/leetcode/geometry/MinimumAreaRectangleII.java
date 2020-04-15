package com.leetcode.geometry;

/**
 * https://leetcode.com/problems/minimum-area-rectangle-ii/
 *
 * Given a set of points in the xy-plane, determine the minimum area of any
 * rectangle formed from these points, with sides not necessarily parallel to
 * the x and y axes.
 * 
 * If there isn't any rectangle, return 0.
 * 
 * Example 1:
 * 
 * Input: [[1,2],[2,1],[1,0],[0,1]] Output: 2.00000 
 * 
 * Explanation: The minimum
 * area rectangle occurs at [1,2],[2,1],[1,0],[0,1], with an area of 2
 * 
 * Example 2:
 * 
 * Input: [[0,1],[2,1],[1,1],[1,0],[2,0]] Output: 1.00000 
 * 
 * Explanation: The
 * minimum area rectangle occurs at [1,0],[1,1],[2,1],[2,0], with an area of 1.
 * 
 * Example 3:
 * 
 * Input: [[0,3],[1,2],[3,1],[1,3],[2,1]] Output: 0 
 * 
 * Explanation: There is no possible rectangle to form from these points.
 * 
 * Note:
 * 
 * 1 <= points.length <= 50 
 * 0 <= points[i][0] <= 40000 
 * 0 <= points[i][1] <= 40000 
 * 
 * All points are distinct. Answers within 10^-5 of the actual value will
 * be accepted as correct.
 */
public class MinimumAreaRectangleII {
	
	static int scalarProduct(int x1, int y1, int x2, int y2) {
		return x1 * x2 + y1 * y2;
	}
	
	static long mod(int x1, int y1) {
		return (x1 * x1 + y1 * y1);
	}
	


	public static double minAreaFreeRect(int[][] points) {
		double area = 10000000000.0d;
		int n = points.length;
		
		for (int i = 0; i < n; i++) {
			int x0 = points[i][0];
			int y0 = points[i][1];
			for (int j = 0; j < n; j++) {
				if (i == j) {
					continue;
				}
				int x1 = points[j][0];
				int y1 = points[j][1];
				for (int k = 0; k < n; k++) {
					if (i == k || j == k) {
						continue;
					}
					int x2 = points[k][0];
					int y2 = points[k][1];
					if (scalarProduct(x1-x0, y1-y0, x2-x0, y2-y0) != 0) {
						continue;
					}
					for (int l = 0; l < n; l++) {
						if (i == l || j == l || k == l) {
							continue;
						}
						int x3 = points[l][0];
						int y3 = points[l][1];
						if (scalarProduct(x3-x2, y3-y2, x2-x0, y2-y0) != 0) {
							continue;
						}
						if (mod(x3-x1,y3-y1) != mod(x2-x0, y2-y0) || mod(x1-x0,y1-y0) != mod(x3-x2,y3-y2) ) {
							continue;
						}
						double a = Math.sqrt(mod(x1-x0, y1-y0) *  mod(x2-x0, y2-y0));
						area = area > a ? a : area;
					}
				}
			}
		}
		return area == 10000000000.0d ? 0 : area;
	}

	public static void main(String[] arg) {

		int[][] points = {{1,2},{2,1},{1,0},{0,1}};
		System.out.println(minAreaFreeRect(points));

		int[][] points1 = {{1,2},{2,1},{1,1},{1,0},{2,0}};
		System.out.println(minAreaFreeRect(points1));

		int[][] points2 = {{0,3},{1,2},{3,1},{1,3},{2,1}};
		System.out.println(minAreaFreeRect(points2));

		int[][] points3 = {{3,1},{1,1},{0,1},{2,1},{3,3},{3,2},{0,2},{2,3}};
		System.out.println(minAreaFreeRect(points3));


	}

}
