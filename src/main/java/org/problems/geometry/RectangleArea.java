package org.problems.geometry;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/rectangle-area/
 * 
 * Find the total area covered by two rectangles in a 2D plane.
 * 
 * Each rectangle is defined by its bottom left corner and top right corner as
 * shown in the figure.
 * 
 * xample:
 * 
 * Input: A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H = 2 Output: 45
 * Note:
 * 
 * Assume that the total area is never beyond the maximum possible value of int
 * 
 * 
 */
public class RectangleArea {
	
	static class Edge {

		public int pos;
		public int id;
		
		public Edge(int pos, int id) {
			this.pos = pos;
			this.id = id;
		}

		@Override
		public String toString() {
			return "Edge [pos=" + pos + ", id=" + id + "]";
		}
	}

	public static int computeArea(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
		int area = 0;
		Edge[] xrange = new Edge[4];
		if (x1 < x3) {
			xrange[0] = new Edge(x1, 0);
			xrange[1] = new Edge(x2, 0);
			xrange[2] = new Edge(x3, 1);
			xrange[3] = new Edge(x4, 1);
		}else {
			xrange[0] = new Edge(x1, 1);
			xrange[1] = new Edge(x2, 1);
			xrange[2] = new Edge(x3, 0);
			xrange[3] = new Edge(x4, 0);
		}
		
		Comparator<Edge> byPos = (o,p) -> Integer.compare(o.pos, p.pos);
		Comparator<Edge> byId = (o,p) -> Integer.compare(o.id, p.id);
		Arrays.sort(xrange, byPos.thenComparing(byId));
		int intersectionX = xrange[2].pos - xrange[1].pos;
		int shared = 0;
		if (intersectionX > 0) {
			Edge[] yrange = new Edge[4];
			if (y1 < y3) {
				yrange[0] = new Edge(y1, 0);
				yrange[1] = new Edge(y2, 0);
				yrange[2] = new Edge(y3, 1);
				yrange[3] = new Edge(y4, 1);
			}else {
				yrange[0] = new Edge(y1, 1);
				yrange[1] = new Edge(y2, 1);
				yrange[2] = new Edge(y3, 0);
				yrange[3] = new Edge(y4, 0);
			}
			boolean isXOverlap = xrange[2].id == 0 || (xrange[2].id == 1 && xrange[1].id == 1);
			Arrays.sort(yrange, byPos.thenComparing(byId));
			int intersectionY = yrange[2].pos - yrange[1].pos;

			if (intersectionY > 0 && (yrange[2].id == 0)) {
				shared =  isXOverlap ? intersectionX * intersectionY : 0;
			}else if (intersectionY > 0 && yrange[2].id == 1 && yrange[1].id == 1) {
				shared =  isXOverlap ? intersectionX * intersectionY : 0;
			}
			
		}
		
		
		return Math.abs(x2 - x1) * Math.abs(y2 - y1) + Math.abs(x4 - x3) * Math.abs(y4 - y3) - shared;

	}

	public static void main(String[] arg) {

		System.out.println(computeArea(-3,  0, 3, 4, 0, -1, 9, 2));
		System.out.println(computeArea(-2,  -2, 2, 2, 3, 3, 4, 4));
		System.out.println(computeArea(-2,  -2, 2, 2, 1, 1, 1, 1));
		System.out.println(computeArea(-2,  -2, 2, 2, -2, -2, 2, 2));
		System.out.println(computeArea(-5,  -5, -4, 0, -3, -3, 3, 3));
		System.out.println(computeArea(-2,  -2, 2, 2, -1, -1, 1, 1));

	}

}
