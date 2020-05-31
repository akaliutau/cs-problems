package org.problems.minmax;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/
 * 
 * Given a rectangular cake with height h and width w, and two arrays of
 * integers horizontalCuts and verticalCuts where horizontalCuts[i] is the
 * distance from the top of the rectangular cake to the ith horizontal cut and
 * similarly, verticalCuts[j] is the distance from the left of the rectangular
 * cake to the jth vertical cut.
 * 
 * Return the maximum area of a piece of cake after you cut at each horizontal
 * and vertical position provided in the arrays horizontalCuts and verticalCuts.
 * Since the answer can be a huge number, return this modulo 10^9 + 7.
 * 
 * 
 */
public class MaximumArea {

	public static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
		int hCuts = horizontalCuts.length;
		int vCuts = verticalCuts.length;
		long[] hInt = new long[hCuts + 1];
		Arrays.sort(horizontalCuts);
		hInt[0] = horizontalCuts[0];
		for (int i = 1; i < hCuts; i++) {
			hInt[i] = horizontalCuts[i] - horizontalCuts[i - 1];
		}
		hInt[hCuts] = h - horizontalCuts[hCuts - 1];
		long[] vInt = new long[vCuts + 1];
		Arrays.sort(verticalCuts);
		vInt[0] = verticalCuts[0];
		for (int i = 1; i < vCuts; i++) {
			vInt[i] = verticalCuts[i] - verticalCuts[i - 1];
		}
		vInt[vCuts] = w - verticalCuts[vCuts - 1];

		long maxh = 0;
		for (int i = 0; i <= hCuts; i++) {
			maxh = Math.max(maxh, hInt[i]);
		}

		long maxv = 0;
		for (int i = 0; i <= vCuts; i++) {
			maxv = Math.max(maxv, vInt[i]);
		}
		long area = (long) (maxh * maxv) % 1000000007;
		return (int) area;
	}

	public static void main(String[] arg) {

		int[] horizontalCuts = { 1, 2, 4 };
		int[] verticalCuts = { 1, 3 };

		System.out.println(maxArea(5, 4, horizontalCuts, verticalCuts));

		int[] horizontalCuts1 = { 3, 1 };
		int[] verticalCuts1 = { 1 };

		System.out.println(maxArea(5, 4, horizontalCuts1, verticalCuts1));

		int[] horizontalCuts2 = { 591276872 };
		int[] verticalCuts2 = { 1 };

		System.out.println(maxArea(1000000000, 1000000000, horizontalCuts2, verticalCuts2));

		int[] horizontalCuts3 = { 3 };
		int[] verticalCuts3 = { 3 };

		System.out.println(maxArea(5, 4, horizontalCuts3, verticalCuts3));

	}

}
