package org.problems.active;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/heaters/
 * 
 * Winter is coming! Your first job during the contest is to design a standard
 * heater with fixed warm radius to warm all the houses.
 * 
 * Now, you are given positions of houses and heaters on a horizontal line, find
 * out minimum radius of heaters so that all houses could be covered by those
 * heaters.
 * 
 * So, your input will be the positions of houses and heaters seperately, and
 * your expected output will be the minimum radius standard of heaters.
 * 
 * Note:
 * 
 * Numbers of houses and heaters you are given are non-negative and will not
 * exceed 25000. Positions of houses and heaters you are given are non-negative
 * and will not exceed 10^9. As long as a house is in the heaters' warm radius
 * range, it can be warmed. All the heaters follow your radius standard and the
 * warm radius will the same.
 * 
 * 
 * Example 1:
 * 
 * Input: [1,2,3],[2] Output: 1 
 * 
 * Explanation: The only heater was placed in the
 * position 2, and if we use the radius 1 standard, then all the houses can be
 * warmed.
 * 
 * 
 * Example 2:
 * 
 * Input: [1,2,3,4],[1,4] Output: 1 
 * 
 * Explanation: The two heater was placed in
 * the position 1 and 4. We need to use radius 1 standard, then all the houses
 * can be warmed
 * 
 * 
 */
public class sol124 {
	
	enum Type {HOUSE, HEATER}
	
	/**
	 * Heats everything in [left-minRadius,right+minRadius]
	 *
	 */
	static class HeaterZone {
		public HeaterZone(int pos) {
			this.pos = pos;
		}
		public int pos;
		@Override
		public String toString() {
			return "HeaterZone [pos=" + pos + "]";
		}
	}
	
	static class Point {
		public int pos;
		public HeaterZone heater; 
		public Type type;
		public boolean visited = false;
		public int neededRadius = Integer.MAX_VALUE;

		public Point(int pos,Type type, HeaterZone heater) {
			this.pos = pos;
			this.type = type;
			this.heater = heater;
		}

		@Override
		public String toString() {
			return "Point [pos=" + pos + ", heater=" + heater + ", type=" + type + ", visited=" + visited
					+ ", neededRadius=" + neededRadius + "]";
		}
	}
	
	static void updateHouse(Point house, Point heat) {
		if (house.type == Type.HOUSE) {
			int radius = Math.abs(heat.heater.pos - house.pos);
			if (house.neededRadius > radius) {
				house.heater = heat.heater;// choose closer
				house.neededRadius = radius;
			}
			house.heater = heat.heater;// copy heater only for house
		}
//		house.visited = true;
	}

	public static int findRadius(int[] houses, int[] heaters) {
		
		int n = houses.length;
		int m = heaters.length;
		Point[] points = new Point[n+m];
		int idx = 0;

		for (int i = 0; i < n; i++) {
			points[idx++] = new Point(houses[i], Type.HOUSE, null);
		}
		for (int i = 0; i < m; i++) {
			HeaterZone heater = new HeaterZone(heaters[i]);
			points[idx++] = new Point(heaters[i], Type.HEATER, heater);
		}
		Comparator<Point> byPos = (o,p) -> Integer.compare(o.pos, p.pos);
		Arrays.sort(points, byPos);
		
		// collect points of heat
		List<Integer> heat = new ArrayList<>();
		int len = points.length;
		for (int i = 0; i < len; i++) {
			if (points[i].type == Type.HEATER) {
				heat.add(i);
			}
		}
		// propagate heat
		Queue<Integer> queue = new LinkedList<>();
		queue.addAll(heat);
		while (!queue.isEmpty()) {
			int pos = queue.poll();
			Point p = points[pos];
			p.visited = true;
			if (pos - 1 >= 0) {//check left
				Point toHeatL = points[pos-1];
				if (!toHeatL.visited) {
					updateHouse(toHeatL,p);
					queue.add(pos-1);
				}
			}
			if (pos + 1 < len) {//check right
				Point toHeatR = points[pos+1];
				if (!toHeatR.visited) {
					updateHouse(toHeatR,p);
					queue.add(pos+1);
				}
			}
		}
		int minRadius = 0;
		for (int i = 0; i < len; i++) {
			if (points[i].type == Type.HOUSE) {
				minRadius = Math.max(minRadius, points[i].neededRadius);
				System.out.println(points[i]);
			}
		}

		
		return minRadius;

	}

	public static void main(String[] arg) {
		
		int[] houses = {1,2,3};
		int[] heaters = {2};

		System.out.println(findRadius(houses, heaters));

		int[] houses1 = {1,2,3,4};
		int[] heaters1 = {1,4};

		System.out.println(findRadius(houses1, heaters1));

		int[] houses2 = {1,2,3,5,15};
		int[] heaters2 = {2,30};

		System.out.println(findRadius(houses2, heaters2));

	}

}
