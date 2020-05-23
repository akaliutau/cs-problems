package org.problems.topology;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/merge-intervals/
 * 
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * Example 1:
 * 
 * Input: [[1,3],[2,6],[8,10],[15,18]] Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 * 
 * Input: [[1,4],[4,5]] Output: [[1,5]] 
 * Explanation: Intervals [1,4] and [4,5]
 * are considered overlapping.
 * 
 */
public class MergeIntervals {
	
	static class Interval {
		public int[] points;
		
		public Interval(int[] points) {
			this.points = points;
		}

		@Override
		public String toString() {
			return "Interval "+ Arrays.toString(points);
		}
		
		public boolean isOverlapping(Interval intv) {// for sorted intervals only
			return intv.points[0] <= points[1];
		}
		
		public void merge(Interval intv) {
			points[1] = Math.max(intv.points[1],points[1]);
		}
		
	}

	public static int[][] merge(int[][] intervals) {
		int n = intervals.length;
		if (n == 0) {
			return new int[0][0];
		}
		List<Interval> all = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			all.add(new Interval(intervals[i]));
		}
        Comparator<Interval> byStart = (o,p) -> Integer.compare(o.points[0], p.points[0]);
        all.sort(byStart);
        System.out.println(all);
        List<Interval> merged = new ArrayList<>();
        Interval cur = all.get(0);
        int i = 1;
        while (i < n) {
			if (cur.isOverlapping(all.get(i))) {
				cur.merge(all.get(i));
			}else {
				merged.add(cur);
				cur = all.get(i);// non-overlapping interval
			}
			i++;
		} 
		merged.add(cur);// merged or last separate
		int[][] res = new int[merged.size()][2];
		int idx = 0;
		for (Interval intv : merged) {
			res[idx++] = intv.points;
		}
		return res;
    }

	public static void main(String[] arg) {
		
		int[][] inter = {
				{1,3},{2,6},{8,10},{15,18}
		};
		Utils.print(merge(inter));

		int[][] inter1 = {
				{1,4},{4,5}
		};
		Utils.print(merge(inter1));

		int[][] inter2 = {
				{1,4},{2,3}
		};
		Utils.print(merge(inter2));

		
	}

}
