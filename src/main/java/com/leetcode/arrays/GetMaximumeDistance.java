package com.leetcode.arrays;

/**
 * https://leetcode.com/problems/maximize-distance-to-closest-person/
 * 
 * In a row of seats, 1 represents a person sitting in that seat, and 0
 * represents that the seat is empty.
 * 
 * There is at least one empty seat, and at least one person sitting.
 * 
 * Alex wants to sit in the seat such that the distance between him and the
 * closest person to him is maximized.
 * 
 * Return that maximum distance to closest person.
 * 
 * Example 1:
 * 
 * Input: [1,0,0,0,1,0,1] Output: 2 Explanation: If Alex sits in the second open
 * seat (seats[2]), then the closest person has distance 2. If Alex sits in any
 * other open seat, the closest person has distance 1. Thus, the maximum
 * distance to the closest person is 2.
 * 
 * Example 2:
 * 
 * Input: [1,0,0,0] Output: 3 Explanation: If Alex sits in the last seat, the
 * closest person is 3 seats away. This is the maximum distance possible, so the
 * answer is 3. Note:
 * 
 * 1 <= seats.length <= 20000 seats contains only 0s or 1s, at least one 0, and
 * at least one 1
 * 
 * 
 */
public class GetMaximumeDistance {

	public static int right(int[] seats) {
		int n = seats.length;
		for (int i = n-1; i > -1; i--) {
			if (seats[i] == 1) {
				return n - 1 - i;
			}
		}
		return n;
	}
	
	public static int left(int[] seats) {
		int n = seats.length;
		for (int i = 0; i < n; i++) {
			if (seats[i] == 1) {
				return i;
			}
		}
		return n;
	}
	
	public static int center(int[] seats) {
		int n = seats.length;
		int len = 0;
		int maxDist = 0;
		int maxStart = 0;
		int start = 0;
		for (int i = 0; i < n; i++) {
			if (seats[i] == 1) {
				if (maxDist < len) {
					maxDist = len;
					maxStart = start;
				}
				len = 0;
				start = i + 1;
			} else {
				len++;
			}
		}
		if (maxDist < len) {
			maxDist = len;
			maxStart = start;
		}
		if (maxStart == 0 || maxStart + maxDist == n) {
			return maxDist;
		}

		return maxDist % 2 == 0 ? maxDist / 2 : maxDist / 2 + 1;
	}



	public static int maxDistToClosest(int[] seats) {
		return Math.max(center(seats),Math.max(left(seats), right(seats)));
	}

	public static void main(String[] arg) {

		int[] seats = { 1, 0, 0, 0, 1, 0, 1 };
		System.out.println(maxDistToClosest(seats));

		int[] seats1 = { 1, 0, 0, 0 };
		System.out.println(maxDistToClosest(seats1));

		int[] seats2 = { 0, 0, 0, 0, 1, 0, 0, 0 };
		System.out.println(maxDistToClosest(seats2));

		int[] seats3 = { 0, 1, 1, 1, 0, 0, 1, 0, 0 };
		System.out.println(maxDistToClosest(seats3));// 2

		int[] seats4 = { 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0 };
		System.out.println(maxDistToClosest(seats4));// 3

		int[] seats5 = {0,0,0,1,0,0,0,1,0,0,0,0,1,1,0,0,0,1};
		System.out.println(maxDistToClosest(seats5));// 3

	}

}
