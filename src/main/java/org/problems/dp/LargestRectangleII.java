package org.problems.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 * 
 * Given n non-negative integers representing the histogram's bar height where
 * the width of each bar is 1, find the area of largest rectangle in the
 * histogram.
 * 
 * Example:
 * 
 * Input: [2,1,5,6,2,3] Output: 10
 * 
 * Runtime: 697 ms, faster than 13.10% of Java online submissions for Largest Rectangle in Histogram.
 * Memory Usage: 40.9 MB, less than 57.24% of Java online submissions for Largest Rectangle in Histogram
 */
public class LargestRectangleII {
	
	static class Maximum {
		public int pos;
		public int nextLevel;
		
		public Maximum(int pos, int nextLevel) {
			this.pos = pos;
			this.nextLevel = nextLevel;
		}

		@Override
		public String toString() {
			return "Maximum [pos=" + pos + ", nextLevel=" + nextLevel + "]";
		}
	}
	
	static class Stat {
		public int area = 0;
		public int n;
		public int[] h;
		public int[] weight;
	}
	
	static void calc(Stat stat) {
		int n = stat.n;
		int[] h = stat.h;
		int[] weight = stat.weight;
		int idx = 0;
		// reduce
		for (int i = 1; i < n; i++) {
			if (h[i] == h[i - 1]) {
				weight[idx] += weight[i];
			}else {
				++idx;
				h[idx] = h[i];
				weight[idx] = weight[i];
			}
		}
		idx++;

		
		if (idx == 1) {
			int area = h[0] * weight[0];
			stat.area = Math.max(stat.area, area);
			stat.n = 0;
			return;
		}
		
		List<Maximum> maxs = new ArrayList<>();// all maximus
		// Boundary conditions 
		if (h[0] > h[1]) {
			maxs.add(new Maximum(0, h[1]));
		}
		if (idx > 1 && h[idx - 2] < h[idx - 1]) {
			maxs.add(new Maximum(idx - 1, h[idx - 2]));
		}
		// find all maximums
		for (int i = 1; i < idx - 1; i ++) {
			if (h[i - 1] < h[i] && h[i] > h[i + 1]) {
				maxs.add(new Maximum(i, Math.max(h[i - 1], h[i + 1])));
			}
		}

		// calc max rect
		for (Maximum m : maxs) {
			int area = h[m.pos] * weight[m.pos];
			stat.area = Math.max(stat.area, area);
			h[m.pos] = m.nextLevel;
		}
		stat.n = idx;
	}
	
	public static int largestRectangleArea(int[] heights) {
		Stat stat = new Stat();
		int n = heights.length;
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return heights[0];
		}
		int[] initialWidth = new int[n];
		Arrays.fill(initialWidth, 1);
		
		stat.weight = initialWidth;
		stat.h = heights;
		stat.n = n;

		while (stat.n != 0) {
			calc(stat);
		}
		return stat.area;
        
    }

	public static void main(String[] arg) {
		int[] heights = {2,1,5,6,2,3};
		System.out.println(largestRectangleArea(heights));

		int[] heights1 = {4,2,8,9,5,1};
		System.out.println(largestRectangleArea(heights1));
}

}
