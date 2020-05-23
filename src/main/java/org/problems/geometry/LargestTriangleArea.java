package org.problems.geometry;

/**
 * https://leetcode.com/problems/largest-triangle-area/
 * 
 * You have a list of points in the plane. Return the area of the largest
 * triangle that can be formed by any 3 of the points.
 * 
 * Example: Input: points = [[0,0],[0,1],[1,0],[0,2],[2,0]] Output: 2
 * Explanation: The five points are show in the figure below. The red triangle
 * is the largest
 * 
 * Notes:
 * 
 * 3 <= points.length <= 50. No points will be duplicated. 
 * -50 <= points[i][j] <= 50. 
 * Answers within 10^-6 of the true value will be accepted as correct
 */
public class LargestTriangleArea {
	
	static class Point {
		public int id;
		public int x;
		public int y;

		public Point(int id, int x, int y) {
			this.id = id;
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + id;
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
			if (id != other.id)
				return false;
			return true;
		}
	}
	
	static double sqr(double num) {
		return num * num;
	}
	
	static double dist(Point p1, Point p2) {
		return Math.sqrt(sqr(p1.x - p2.x) + sqr(p1.y - p2.y));
	}
	
	static double area(Point p1, Point p2, Point p3) {
		double a = dist(p1, p2);
		double b = dist(p2, p3);
		double c = dist(p1, p3);
		double p = (a + b + c) / 2;
		return p * (p - a) * (p - b) * (p - c);
	}

	public static double largestTriangleArea(int[][] points) {
		int n = points.length;
		Point[] all = new Point[n];
		for (int i = 0; i < n; i++) {
			all[i] = new Point(i, points[i][0], points[i][1]);
		}
		Point left = all[0];
		Point right = all[1];
		for (int i = 0; i < n; i++) {
			Point cur = all[i];
			if (cur.x < left.x) {
				left = cur;
			}
			if (cur.x > right.x) {
				right = cur;
			}
		}
		
		double maxArea = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				for (int k = j+1; k < n; k++) {
					double curArea = area(all[i], all[j], all[k]);
						if (curArea > maxArea) {
							maxArea = curArea;
						}
				}
			}
		}
		
		return Math.sqrt(maxArea);

	}

	public static void main(String[] arg) {
		
		int[][] points = {
				{0,0},
				{0,1},
				{1,0},
				{0,2},
				{2,0}
		};
		System.out.println(largestTriangleArea(points));//2


		int[][] points1 = {
				{0,0},
				{1,4},
				{2,7}
		};
		System.out.println(largestTriangleArea(points1));//5
}

}
