package org.problems.topology;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/number-of-students-doing-homework-at-a-given-time/
 * 
 * Given two integer arrays startTime and endTime and given an integer
 * queryTime.
 * 
 * The ith student started doing their homework at the time startTime[i] and
 * finished it at time endTime[i].
 * 
 * Return the number of students doing their homework at time queryTime. More
 * formally, return the number of students where queryTime lays in the interval
 * [startTime[i], endTime[i]] inclusive.
 * 
 */
public class NumberOfStudentsDoingHomework {

	static class Interval {
		int point;
		int change;

		public Interval(int point, int change) {
			this.point = point;
			this.change = change;
		}

		@Override
		public String toString() {
			return String.format("[%d,%d]", point, change);
		}

	}

	public static int busyStudent(int[] startTime, int[] endTime, int queryTime) {

		List<Interval> lst = new ArrayList<>();
		int n = startTime.length;
		for (int i = 0; i < n; i++) {
			lst.add(new Interval(startTime[i], 1));
			lst.add(new Interval(endTime[i] + 1, -1));
		}
		Comparator<Interval> byPoint = (o, p) -> Integer.compare(o.point, p.point);
		Collections.sort(lst, byPoint);
		int[] max = new int[1002];
		Arrays.fill(max, -1);
		int overlaps = 0;
		for (Interval interval : lst) {
			overlaps += interval.change;
			max[interval.point] = overlaps;
		}
		int over = max[0];
		for (int i = 0; i < 1000; i++) {
			if (max[i] < 0) {
				max[i] = over;
			} else {
				over = max[i];
			}
		}

		return max[queryTime] == -1 ? 0 : max[queryTime];

	}

	public static void main(String[] arg) {

		int[] startTime = { 1, 2, 3 };
		int[] endTime = { 3, 2, 7 };

		System.out.println(busyStudent(startTime, endTime, 4));

		int[] startTime1 = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		int[] endTime1 = { 10, 10, 10, 10, 10, 10, 10, 10, 10 };

		System.out.println(busyStudent(startTime1, endTime1, 5));

		int[] startTime2 = { 4 };
		int[] endTime2 = { 4 };

		System.out.println(busyStudent(startTime2, endTime2, 4));

		int[] startTime3 = { 4 };
		int[] endTime3 = { 4 };

		System.out.println(busyStudent(startTime3, endTime3, 5));

		int[] startTime4 = { 64, 80 };
		int[] endTime4 = { 86, 93 };

		System.out.println(busyStudent(startTime4, endTime4, 42));

	}

}
