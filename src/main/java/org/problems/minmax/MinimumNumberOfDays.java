package org.problems.minmax;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
 * 
 * Given an integer array bloomDay, an integer m and an integer k.
 * 
 * We need to make m bouquets. To make a bouquet, you need to use k adjacent
 * flowers from the garden.
 * 
 * The garden consists of n flowers, the ith flower will bloom in the
 * bloomDay[i] and then can be used in exactly one bouquet.
 * 
 * Return the minimum number of days you need to wait to be able to make m
 * bouquets from the garden. If it is impossible to make m bouquets return -1.
 * 
 * 
 */
public class MinimumNumberOfDays {



	public static int minDays(int[] bloomDay, int m, int k) {
		int flowers = bloomDay.length;
		if (m * k > flowers) {
			return -1;
		}
		if (flowers == 0) {
			return -1;
		}
		int max = bloomDay[0];
		for (int i = 0; i < flowers; i++) {
			max = Math.max(max, bloomDay[i]);
		}
		Set<Integer> days = new HashSet<>();
		
		for (int i = 0; i < flowers; i++) {
			days.add(bloomDay[i]);
		}
		List<Integer> sorted = new ArrayList<>(days);
		Collections.sort(sorted, (o,p) -> Integer.compare(p, o));

		int minDay = sorted.get(0);
		for (int day : sorted) {
			int bouquet = m;
			int counter = k;
			for (int i = 0; i < flowers; i++) {
				if (bloomDay[i] > day) {
					counter = k;
				}else {
					counter --;
					if (counter == 0) {
						counter = k;
						bouquet --;
						if (bouquet == 0) {
							break;
						}
					}
				}
			}
			if (bouquet == 0) {
				minDay = day;
			}else {
				break;
			}
		}
		
		return minDay;

	}

	public static void main(String[] arg) {

		int[] bloomDay = { 1, 10, 3, 10, 2 };
		System.out.println(minDays(bloomDay, 3, 1));

		int[] bloomDay1 = { 1, 10, 3, 10, 2 };
		System.out.println(minDays(bloomDay1, 3, 2));

		int[] bloomDay2 = { 7, 7, 7, 7, 12, 7, 7 };
		System.out.println(minDays(bloomDay2, 2, 3));

		int[] bloomDay4 = { 1000, 1000 };
		System.out.println(minDays(bloomDay4, 1, 1));

		int[] bloomDay3 = { 1, 10, 2, 9, 3, 8, 4, 7, 5, 6 };
		System.out.println(minDays(bloomDay3, 4, 2));

		int[] bloomDay5 = 
			{ 1, 10, 9, 2, 3, 8, 4, 7, 5, 6, 8};
		//	  10 10 10 10 10 10 10 10 10 10 10
		//    9      9  9  9  9  9  9  9  9  9
		//    8         8  8  8  8  8  8  8  8 <- result
		//    7         7  7     7  7  7  7
		//    6         6  6     6     6  6
		//    5         5  5     5     5
		//    4         4  4     4 
		//    3         3  3
		//    2         2
		//    1
		System.out.println(minDays(bloomDay5, 4, 2));

	}

}
