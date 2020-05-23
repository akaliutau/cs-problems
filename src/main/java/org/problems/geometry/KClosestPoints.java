package org.problems.geometry;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/k-closest-points-to-origin/
 *
 * We have a list of points on the plane. Find the K closest points to the
 * origin (0, 0).
 * 
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 * 
 * You may return the answer in any order. The answer is guaranteed to be unique
 * (except for the order that it is in.)
 * 
 * Example 1:
 * 
 * Input: points = [[1,3],[-2,2]], K = 1 Output: [[-2,2]] 
 * 
 * Explanation: The
 * distance between (1, 3) and the origin is sqrt(10). 
 * The distance between (-2, 2) and the origin is sqrt(8). Since sqrt(8) < sqrt(10),
 * (-2, 2) is closer to the origin. We only want the closest K = 1 points from the origin, 
 * so the answer is just [[-2,2]]. Example 2:
 * 
 * Input: points = [[3,3],[5,-1],[-2,4]], K = 2 Output: [[3,3],[-2,4]] 
 * (The answer [[-2,4],[3,3]] would also be accepted.)
 * 
 * 
 * Note:
 * 1 <= K <= points.length <= 10000 
 * -10000 < points[i][0] < 10000 
 * -10000 < points[i][1] < 10000
 */
public class KClosestPoints {
	
	static class Point {
		public int[] p;
		public int dist;
		
		public Point(int[] p) {
			this.p = p;
			this.dist = p[0] * p[0] + p[1] * p[1];
		}
	}

	public static int[][] kClosest(int[][] points, int k) {
		List<Point> pointLi = new ArrayList<>();
		Comparator<Point> byDist = (o,p) -> Integer.compare(o.dist, p.dist);
		for (int[] p : points) {
			pointLi.add(new Point(p));
		}
		pointLi.sort(byDist);
		int[][] res = new int[k][2];
		for (int i = 0; i < k; i++) {
			res[i] = pointLi.get(i).p;
		}
		return res;
	}

	public static void main(String[] arg) {
		
		int[][] points = {
				{1,3},
				{-2,2}
		};
		Utils.print(kClosest(points, 1));

		int[][] points1 = {
				{3,3},
				{5,-1},
				{-2,4}
		};
		Utils.print(kClosest(points1, 2));

	}
}
