package org.problems.lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/interval-list-intersections/
 * 
 * Given two lists of closed intervals, each list of intervals is pairwise
 * disjoint and in sorted order.
 * 
 * Return the intersection of these two interval lists.
 * 
 * (Formally, a closed interval [a, b] (with a <= b) denotes the set of real
 * numbers x with a <= x <= b. The intersection of two closed intervals is a set
 * of real numbers that is either empty, or can be represented as a closed
 * interval. For example, the intersection of [1, 3] and [2, 4] is [2, 3].)
 * 
 * Exmaple:
 * Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
 * Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 * 
 * 
 * Note:
 * 
 * 0 <= A.length < 1000 
 * 0 <= B.length < 1000 
 * 0 <= A[i].start, A[i].end,
 * B[i].start, B[i].end < 10^9
 * 
 * 
 */
public class IntervalListIntersection {

	public static int[][] intervalIntersection(int[][] a, int[][] b) {
		int len1 = a.length;
		int len2 = b.length;
		
		int idx1 = 0;
		int idx2 = 0;
		List<int[]> results = new ArrayList<>();
		if (len1 > 0 && len2 > 0) {
			List<Integer> sortedPoints = new ArrayList<>();
			for (int i = 0; i < len1; i++) {
				sortedPoints.add(a[i][0]);
				sortedPoints.add(a[i][1]);
			}
			for (int i = 0; i < len2; i++) {
				sortedPoints.add(b[i][0]);
				sortedPoints.add(b[i][1]);
			}
			Collections.sort(sortedPoints);
			int[] first = null;
			int[] second = null;
			int[] inter = new int[2];
			int idx = 0;
			for (int point : sortedPoints) {

				if (idx1 < len1) {
					int[] intrv = a[idx1];
					if (intrv[0] <= point && intrv[1] >= point) {
						first = intrv;
					}else {
						first = null;
					}
					if (intrv[1] <= point) {// if and only if point coincides with end edge
						idx1 ++;
					}
				}else{
					first = null;
				}
				if (idx2 < len2) {
					int[] intrv = b[idx2];
					if (intrv[0] <= point && intrv[1] >= point) {
						second = intrv;
					}else {
						second = null;
					}
					if (intrv[1] <= point) {
						idx2 ++;
					}
				}else{
					second = null;
				}
				if (first != null && second != null) {// the only interesting case

					if ((first[0] == point || second[0] == point) && idx == 0) {
						inter[idx++] = point;
					}
					if (first[1] == point || second[1] == point) {
						inter[idx++] = point;
					}
					if (idx > 1) {
						idx = 0;
						results.add(inter);

						inter = new int[2];
					}
				}
				
			}
		}
		
		
		
		int[][] res = new int[results.size()][2];
		for (int i = 0; i < results.size(); i++) {
			res[i] = results.get(i);
		}
		
		return res;

	}

	public static void main(String[] arg) {
		
		int[][] a = {{0,2},{5,10},{13,23},{24,25}};
		int[][] b = {{1,5},{8,12},{15,24},{25,26}};

		Utils.print(intervalIntersection(a, b));

		int[][] a1 = {{0,25}};
		int[][] b1 = {{1,5}};

		Utils.print(intervalIntersection(a1, b1));

		int[][] a2 = {{25,25}};
		int[][] b2 = {{5,5}};

		Utils.print(intervalIntersection(a2, b2));

		int[][] a3 = {{0,25}, {26,26}, {27, 27}};
		int[][] b3 = {{1,5}, {26, 27}};

		Utils.print(intervalIntersection(a3, b3));


		int[][] a4 = {{5,25}};
		int[][] b4 = {{5,25}};
		Utils.print(intervalIntersection(a4, b4));

	}

}
