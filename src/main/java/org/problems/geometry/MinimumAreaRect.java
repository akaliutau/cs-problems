package org.problems.geometry;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/minimum-area-rectangle/
 * 
 * Given a set of points in the xy-plane, determine the minimum area of a
 * rectangle formed from these points, with sides parallel to the x and y axes.
 * 
 * If there isn't any rectangle, return 0.
 * 
 * Example 1:
 * 
 * Input: [{1,1},{1,3},{3,1},{3,3},{2,2}] Output: 4 
 * 
 * Example 2:
 * 
 * Input: [{1,1},{1,3},{3,1},{3,3},{4,1},{4,3}] Output: 2
 * 
 * 
 * Note:
 * 
 * 1 <= points.length <= 500
 * 
 */
public class MinimumAreaRect {
	
	static class Point {
		public int[] p;

		public Point(int[] point) {
			this.p = point;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + Arrays.hashCode(p);
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (!Arrays.equals(p, other.p))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Point " + Arrays.toString(p) ;
		}
	}

	public static int minAreaRect(int[][] points) {
		Set<Point> pointSet = new HashSet<>();
		int n = points.length;
		Point[] all = new Point[n];
		int idx = 0;
		for (int[] point : points) {
			all[idx] = new Point(point);
			pointSet.add(all[idx]);
			idx++;
		}
		int aria = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			Point p1 = all[i];
			for (int j = 0; j < n; j++) {
				if (i == j) {
					continue;
				}
				Point p2 = all[j];
				int[] p3 = {p1.p[0], p2.p[1]};
				if (!pointSet.contains(new Point(p3))) {
					continue;
				}
				int[] p4 = {p2.p[0], p1.p[1]};
				if (!pointSet.contains(new Point(p4))) {
					continue;
				}
				int xdiff = p1.p[0] - p2.p[0];
				int ydiff = p1.p[1] - p2.p[1];
				int newAria = Math.abs(xdiff) * Math.abs(ydiff);
				if (newAria != 0) {
					aria = Math.min(aria, newAria);
				}
			}
		}
		return aria == Integer.MAX_VALUE ? 0 : aria;

	}

	public static void main(String[] arg) {
		
		int[][] points = {
				{1,1},{1,3},{3,1},{3,3},{2,2}
		};

		System.out.println(minAreaRect(points));

		int[][] points1 = {
				{1,1},{1,3},{3,1},{3,3},{4,1},{4,3}
		};

		System.out.println(minAreaRect(points1));

	}

}
