package org.problems.geometry;

/**
 * https://leetcode.com/problems/path-crossing/
 * 
 * Given a string path, where path[i] = 'N', 'S', 'E' or 'W', each representing
 * moving one unit north, south, east, or west, respectively. You start at the
 * origin (0, 0) on a 2D plane and walk on the path specified by path.
 * 
 * Return True if the path crosses itself at any point, that is, if at any time
 * you are on a location you've previously visited. Return False otherwise.
 * 
 */
public class PathCrossing {

	public boolean isPathCrossing(String path) {
		int n = path.length();
		int x = 0;
		int y = 0;
		for (int i = 0; i < n; i++) {
			if (path.charAt(i) == 'N') {
				y++;
			} else if (path.charAt(i) == 'S') {
				y--;
			} else if (path.charAt(i) == 'E') {
				x++;
			} else if (path.charAt(i) == 'W') {
				x--;
			}
			if (x == 0 && y == 0) {
				return true;
			}
		}
		return false;

	}

	public static void main(String[] arg) {
		System.out.println(true);
	}

}
