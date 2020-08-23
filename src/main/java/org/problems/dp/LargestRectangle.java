package org.problems.dp;

import java.util.ArrayList;
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
 */
public class LargestRectangle {
	
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
	
	static class Bar {
		public int h;
		public int w;
		
		public Bar(int h, int w) {
			this.h = h;
			this.w = w;
		}
		
		public int getArea() {
			return h * w;
		}

		@Override
		public String toString() {
			return "Bar [h=" + h + ", w=" + w + "]";
		}
	}
	
	static class Stat {
		public int area = 0;
		public Bar[] hist;
	}
	
	static void calc(Stat stat) {
		Bar[] hist = stat.hist;
		int n = hist.length;
		int[] h = new int[n];
		int[] weight = new int[n];
		int idx = 0;
		// reduce
		h[0] = hist[0].h;
		weight[0] = hist[0].w;
		for (int i = 1; i < n; i++) {
			if (hist[i].h == hist[i - 1].h) {
				weight[idx] += hist[i].w;
			}else {
				++idx;
				h[idx] = hist[i].h;
				weight[idx] = hist[i].w;
			}
		}
		idx++;

		Bar[] nextHist = new Bar[idx];
		for (int i = 0; i < idx; i++) {
			nextHist[i] = new Bar(h[i], weight[i]);
		}
		
		if (idx == 1) {
			int area = nextHist[0].getArea();
			stat.area = Math.max(stat.area, area);
			stat.hist = null;
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
		// find all maximus
		for (int i = 1; i < idx - 1; i ++) {
			if (h[i - 1] < h[i] && h[i] > h[i + 1]) {
				maxs.add(new Maximum(i, Math.max(h[i - 1], h[i + 1])));
			}
		}

		// calc max rect
		for (Maximum m : maxs) {
			int area = nextHist[m.pos].getArea();
			stat.area = Math.max(stat.area, area);
			nextHist[m.pos].h = m.nextLevel;
		}
		stat.hist = nextHist;
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
		Bar[] initialHist = new Bar[n];
		for (int i = 0; i < n; i++) {
			initialHist[i] = new Bar(heights[i], 1);
		}

		stat.hist = initialHist;

		while (stat.hist != null) {
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
