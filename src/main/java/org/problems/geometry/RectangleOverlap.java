package org.problems.geometry;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/rectangle-overlap/
 * 
 * A rectangle is represented as a list [x1, y1, x2, y2], where (x1, y1) are the
 * coordinates of its bottom-left corner, and (x2, y2) are the coordinates of
 * its top-right corner.
 * 
 * Two rectangles overlap if the area of their intersection is positive. To be
 * clear, two rectangles that only touch at the corner or edges do not overlap.
 * 
 * Given two (axis-aligned) rectangles, return whether they overlap.
 * 
 * Example 1:
 * 
 * Input: rec1 = [0,0,2,2], rec2 = [1,1,3,3] Output: true 
 * 
 * Example 2:
 * 
 * Input: rec1 = [0,0,1,1], rec2 = [1,0,2,1] Output: false 
 * 
 * Notes:
 * 
 * Both rectangles rec1 and rec2 are lists of 4 integers. All coordinates in
 * rectangles will be between -10^9 and 10^9
 * 
 */
public class RectangleOverlap {

	static Comparator<Point> byVal = (o,p) -> Integer.compare(o.val,p.val);
	static Comparator<Point> byRecAsc = (o,p) -> Integer.compare(o.rec,p.rec);
	static Comparator<Point> byRecDesc = (o,p) -> Integer.compare(p.rec,o.rec);

	static class Point {
		public int val;
		public int rec;

		public Point(int val, int rec) {
			this.val = val;
			this.rec = rec;
		}

		@Override
		public String toString() {
			return "Point [val=" + val + ", rec=" + rec + "]";
		}
	}
	
	static boolean isInside(int[] rec, int x, int y) {
		return x > rec[0] && x < rec[2] && y > rec[1] && y < rec[3];
	}

	public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
		// check points inside area
		if (isInside(rec1, rec2[0], rec2[1])) {
			return true;
		}
		if (isInside(rec1, rec2[2], rec2[3])) {
			return true;
		}
		if (isInside(rec1, rec2[0], rec2[3])) {
			return true;
		}
		if (isInside(rec1, rec2[2], rec2[1])) {
			return true;
		}
		// check range intersection
		Point[] xrange = new Point[4];
		xrange[0] = new Point(rec1[0],0);
		xrange[1] = new Point(rec2[0],1);
		xrange[2] = new Point(rec1[2],0);
		xrange[3] = new Point(rec2[2],1);
		if (rec1[0] < rec2[0]) {
			Arrays.sort(xrange,byVal.thenComparing(byRecAsc));
		}else {
			Arrays.sort(xrange,byVal.thenComparing(byRecDesc));
		}
		if (xrange[0].rec != xrange[1].rec) {
			Point[] yrange = new Point[4];
			yrange[0] = new Point(rec1[1],0);
			yrange[1] = new Point(rec2[1],1);
			yrange[2] = new Point(rec1[3],0);
			yrange[3] = new Point(rec2[3],1);
			if (rec1[1] < rec2[1]) {
				Arrays.sort(yrange,byVal.thenComparing(byRecAsc));
			}else {
				Arrays.sort(yrange,byVal.thenComparing(byRecDesc));
			}
			if (yrange[0].rec != yrange[1].rec) {
				return true;
			}
		}
		
		return false;
        
    }

	public static void main(String[] arg) {

		int[] rec1 = {0,0,2,2};
		int[] rec2 = {1,1,3,3};
		System.out.println(isRectangleOverlap(rec1, rec2));

		int[] rec1a = {0,0,1,1};
		int[] rec2a = {1,0,2,1};
		System.out.println(isRectangleOverlap(rec1a, rec2a));//false

		int[] rec1b = {7,8,13,15};
		int[] rec2b = {10,8,12,20};
		System.out.println(isRectangleOverlap(rec1b, rec2b));

		int[] rec1c = {4,0,6,6};
		int[] rec2c = {-5,-3,4,2};
		System.out.println(isRectangleOverlap(rec1c, rec2c));

	}

}
