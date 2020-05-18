package com.leetcode.geometry;

import java.util.List;

/**
 * https://leetcode.com/problems/minimum-time-visiting-all-points/
 * 
 * On a plane there are n points with integer coordinates points[i] = [xi, yi].
 * Your task is to find the minimum time in seconds to visit all points.
 * 
 * You can move according to the next rules:
 * 
 * In one second always you can either move vertically, horizontally by one unit
 * or diagonally (it means to move one unit vertically and one unit horizontally
 * in one second). You have to visit the points in the same order as they appear
 * in the array.
 * 
 * Input: points = [[1,1],[3,4],[-1,0]] Output: 7 
 * Explanation: One optimal path
 * is [1,1] -> [2,2] -> [3,3] -> [3,4] -> [2,3] -> [1,2] -> [0,1] -> [-1,0] Time
 * from [1,1] to [3,4] = 3 seconds Time from [3,4] to [-1,0] = 4 seconds Total
 * time = 7 seconds
 * 
 * 
 */
public class VisitingAllPoints {
	
	static int dist(int[] a, int[] b) {
		int dx = Math.abs(a[0] - b[0]);
		int dy = Math.abs(a[1] - b[1]);
		return Math.max(dx, dy);
	}

	public static int minTimeToVisitAllPoints(int[][] points) {
        int time = 0;
        for (int i = 0; i < points.length - 1; i++) {
        	time += dist(points[i], points[i+1]);
        }
		return time;
    }

	public static void main(String[] arg) {

		int[][] points = {
				{1,1},
				{3,4},
				{-1,0}
		};
		System.out.println(minTimeToVisitAllPoints(points));

		int[][] points1 = {
				{3,2},
				{-2,2}
		};
		System.out.println(minTimeToVisitAllPoints(points1));

	}

}
