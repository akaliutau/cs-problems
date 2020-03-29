package com.leetcode.datastructures;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/design-underground-system
 *
 * Implement the class UndergroundSystem that supports three methods:
 * 
 * 1. checkIn(int id, string stationName, int t)
 * 
 * A customer with id card equal to id, gets in the station stationName at time
 * t. A customer can only be checked into one place at a time. 2. checkOut(int
 * id, string stationName, int t)
 * 
 * A customer with id card equal to id, gets out from the station stationName at
 * time t. 3. getAverageTime(string startStation, string endStation)
 * 
 * Returns the average time to travel between the startStation and the
 * endStation. The average time is computed from all the previous traveling from
 * startStation to endStation that happened directly. Call to getAverageTime is
 * always valid. You can assume all calls to checkIn and checkOut methods are
 * consistent. That is, if a customer gets in at time t1 at some station, then
 * it gets out at time t2 with t2 > t1. All events happen in chronological
 * order.
 * 
 * 
 */
public class DesignUndergroundSystem {

	static class Route {
		public int count;
		public double totalTime = 0.0d;

		public double getTime() {
			return (count == 0) ? 0 : (double) totalTime / count;
		}
	}

	static class UndergroundSystem {

		private Map<Integer, String> inMap = new HashMap<>();
		private Map<Integer, Integer> inTime = new HashMap<>();
		private Map<String, Route> routes = new HashMap<>();

		public UndergroundSystem() {

		}

		public void checkIn(int id, String stationName, int t) {
			inMap.put(id, stationName);
			inTime.put(id, t);
		}

		public void checkOut(int id, String stationName, int t) {
			String key = String.format("%s:%s", inMap.remove(id), stationName);
			if (!routes.containsKey(key)) {
				routes.put(key, new Route());
			}
			routes.get(key).count++;
			routes.get(key).totalTime += (t - inTime.remove(id));
		}

		public double getAverageTime(String startStation, String endStation) {
			String key = String.format("%s:%s", startStation, endStation);
			if (routes.containsKey(key)) {
				return routes.get(key).getTime();
			}
			return 0.0d;
		}
	}

	public static void main(String[] arg) {

		System.out.println(true);

	}

}
