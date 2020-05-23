package org.problems.minmax;

import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/daily-temperatures/
 * 
 * Given a list of daily temperatures T, return a list such that, for each day
 * in the input, tells you how many days you would have to wait until a warmer
 * temperature. If there is no future day for which this is possible, put 0
 * instead.
 * 
 * For example, given the list of temperatures 
 * T = [73, 74, 75, 71, 69, 72, 76, 73], 
 * your output should be 
 *     [1,  1,  4,  2,  1,  1,  0,  0]
 * 
 * Note: The length of temperatures will be in the range [1, 30000]. Each
 * temperature will be an integer in the range [30, 100]
 * 
 */
public class DailyTemperatures {
	
	static class Temperature {
		public int day;
		public int t;
		
		public Temperature(int day, int t) {
			this.day = day;
			this.t = t;
		}
		
	}

	public static int[] dailyTemperatures(int[] t) {
		int n = t.length;
		int[] res = new int[n];
		for (int j = 0; j < n; j++) {
			int warmer = 0;
			int day = j;
			while (++day < n) {
				if (t[day] > t[j]) {
					warmer = day-j;
					break;
				}
			}
			res[j] = warmer;
		}
		return res;
		
	}	

	public static void main(String[] arg) {

		int[] t = {73, 74, 75, 71, 69, 72, 76, 73};
		Utils.print(dailyTemperatures(t));

		int[] t1 = {76, 76, 73};
		Utils.print(dailyTemperatures(t1));

	}

}
