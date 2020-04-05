package com.leetcode.minmax;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/reducing-dishes/
 * 
 * A chef has collected data on the satisfaction level of his n dishes. Chef can
 * cook any dish in 1 unit of time.
 * 
 * Like-time coefficient of a dish is defined as the time taken to cook that
 * dish including previous dishes multiplied by its satisfaction level i.e.
 * time[i]*satisfaction[i]
 * 
 * Return the maximum sum of Like-time coefficient that the chef can obtain
 * after dishes preparation.
 * 
 * Dishes can be prepared in any order and the chef can discard some dishes to
 * get this maximum value
 * 
 * 
 */
public class ReducingDishes {

	static int getVector(int[] sat, int from) {
		int sum = 0;
		for (int i = from; i < sat.length; i++) {
			sum += (i + 1 - from) * sat[i];
		}
		return sum;
	}

	public static int maxSatisfaction(int[] satisfaction) {
		if (satisfaction.length == 0) {
			return 0;
		}
		Arrays.sort(satisfaction);
		int maxSat = getVector(satisfaction, 0);
		int positive = 0;
		boolean isNegative = satisfaction[satisfaction.length - 1] < 0;
		boolean isPositive = satisfaction[0] > 0;
		if (isNegative) {
			return 0;
		}
		if (isPositive) {
			return maxSat;
		}

		for (int i = 0; i < satisfaction.length; i++) {
			if (satisfaction[i] > 0) {
				positive = i;
				break;
			}
		}
		System.out.println(maxSat);
		for (int i = 1; i < positive; i++) {
			int sat = getVector(satisfaction, i);
			maxSat = maxSat < sat ? sat : maxSat;
		}
		return maxSat;
	}

	public static void main(String[] arg) {

		int[] sat = { -1, -8, 0, 5, -9 };
		System.out.println(maxSatisfaction(sat));

		int[] sat1 = { 4, 3, 2 };
		System.out.println(maxSatisfaction(sat1));

		int[] sat2 = { -1, -4, -5 };
		System.out.println(maxSatisfaction(sat2));

		int[] sat3 = { -2, 5, -1, 0, 3, -3 };
		System.out.println(maxSatisfaction(sat3));

	}

}
