package com.leetcode.geometry;

/**
 * https://leetcode.com/problems/circle-and-rectangle-overlapping/
 * 
 * Given a circle represented as (radius, x_center, y_center) and an
 * axis-aligned rectangle represented as (x1, y1, x2, y2), where (x1, y1) are
 * the coordinates of the bottom-left corner, and (x2, y2) are the coordinates
 * of the top-right corner of the rectangle.
 * 
 * Return True if the circle and rectangle are overlapped otherwise return
 * False.
 * 
 * In other words, check if there are any point (xi, yi) such that belongs to
 * the circle and the rectangle at the same time.
 * 
 * 
 */
public class CircleAndRectangleOverlap {

	static int clamp(int val, int min, int max) {
		return Math.max(min, Math.min(max, val));
	}

	public static boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {

		int closestX = clamp(x_center, x1, x2);
		int closestY = clamp(y_center, y1, y2);

		int distanceX = x_center - closestX;
		int distanceY = y_center - closestY;

		int distanceSquared = (distanceX * distanceX) + (distanceY * distanceY);
		return distanceSquared <= (radius * radius);
	}

	public static void main(String[] arg) {

		System.out.println(checkOverlap(1, 0, 0, 1, -1, 3, 1));
		System.out.println(checkOverlap(1, 0, 0, -1, 0, 0, 1));
		System.out.println(checkOverlap(1, 1, 1, -3, -3, 3, 3));
		System.out.println(checkOverlap(1, 1, 1, 1, -3, 2, -1));

	}

}
