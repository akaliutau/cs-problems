package org.problems.geometry;

/**
 * https://leetcode.com/problems/valid-boomerang/
 * 
 * A boomerang is a set of 3 points that are all distinct and not in a straight
 * line.
 * 
 * Given a list of three points in the plane, return whether these points are a
 * boomerang.
 * 
 * Example 1:
 * 
 * Input: [[1,1],[2,3],[3,2]] Output: true 
 * 
 * Example 2:
 * 
 * Input: [[1,1],[2,2],[3,3]] Output: false
 * 
 * Note:
 * 
 * points.length == 3 
 * points[i].length == 2 
 * 0 <= points[i][j] <= 100
 */
public class ValidBoomerang {

	public static boolean isBoomerang(int[][] points) {
		return (points[0][0] - points[1][0]) * (points[1][1] - points[2][1]) != (points[1][0] - points[2][0]) * (points[0][1] - points[1][1]);
	}

	public static void main(String[] arg) {
		int[][] p1 = {
				{1, 1},
				{2, 3},
				{3, 2}
		};
		System.out.println(isBoomerang(p1));

		int[][] p2 = {
				{1, 1},
				{2, 2},
				{3, 3}
		};
		System.out.println(isBoomerang(p2));

	}

}
