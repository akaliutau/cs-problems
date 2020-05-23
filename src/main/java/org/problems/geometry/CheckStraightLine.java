package org.problems.geometry;

/**
 *	https://leetcode.com/problems/check-if-it-is-a-straight-line/
 *
 * You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.
 * 
 * Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * Output: true
 * 
 */
public class CheckStraightLine {
	
	public static boolean checkStraightLine(int[][] coordinates) {
		int points = coordinates.length;
		if (points < 3) {
			return true;
		}
		int[] point1 = coordinates[0];
		int[] point2 = coordinates[1];
		for (int i = 2; i < points; i++) {
			int[] point = coordinates[i];
			int p1 = (point2[0]-point1[0])*(point[1]-point1[1]);
			int p2 = (point[0]-point1[0])*(point2[1]-point1[1]);
			if (p1 != p2) {
				return false;
			}
		}
		return true;
        
    }

	public static void main(String[] arg) {
		int[][] coords = {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}};
		
		System.out.println(checkStraightLine(coords));

	}

}
