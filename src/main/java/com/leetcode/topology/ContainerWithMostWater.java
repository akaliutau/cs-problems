package com.leetcode.topology;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/container-with-most-water/
 * 
 * Given n non-negative integers a1, a2, ..., an , where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with
 * x-axis forms a container, such that the container contains the most water.
 * 
 * Note: You may not slant the container and n is at least 2.
 * 
 * 
 * Runtime: 305 ms, faster than 13.51% of Java online submissions for Container
 * With Most Water. Memory Usage: 41.1 MB, less than 14.74% of Java online
 * submissions for Container With Most Water.
 */
public class ContainerWithMostWater {

	public static int maxArea(int[] height) {
		int maxArea = 0;
		Arrays.sort(height);
		for (int i = 0; i < height.length - 1; i++) {
			for (int j = i + 1; j < height.length; j++) {
				int area = (j - i) * Math.min(height[i], height[j]);
				if (maxArea < area) {
					maxArea = area;
				}
			}
		}

		return maxArea;

	}

	public static void main(String[] arg) {

		int[] height = new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 };

		System.out.println(maxArea(height));

		int[] height1 = new int[] { 1, 3, 3 };

		System.out.println(maxArea(height1));

		int[] height2 = new int[] { 2 };

		System.out.println(maxArea(height2));

		int[] height3 = new int[] { 2, 4 };

		System.out.println(maxArea(height3));

	}
}
