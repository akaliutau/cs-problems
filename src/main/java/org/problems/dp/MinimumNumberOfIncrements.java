package org.problems.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/
 * 
 * Given an array of positive integers target and an array initial of same size
 * with all zeros.
 * 
 * Return the minimum number of operations to form a target array from initial
 * if you are allowed to do the following operation:
 * 
 * Choose any subarray from initial and increment each value by one. The answer
 * is guaranteed to fit within the range of a 32-bit signed integer.
 * 
 * 
 * Example 1:
 * 
 * Input: target = [1,2,3,2,1] Output: 3 
 * 
 * Explanation: We need at least 3
 * operations to form the target array from the initial array. 
 * [0,0,0,0,0] increment 1 from index 0 to 4 (inclusive). 
 * [1,1,1,1,1] increment 1 from index 1 to 3 (inclusive). 
 * [1,2,2,2,1] increment 1 at index 2. 
 * [1,2,3,2,1] target array is formed.
 * 
 * 
 * 
 */
public class MinimumNumberOfIncrements {

	// describes extr
	// special conditions are on the boundaries
	static class Point {
		public boolean min;
		public int h;
		public int pos;

		public Point(boolean min, int h, int pos) {
			this.min = min;
			this.h = h;
			this.pos = pos;
		}

		@Override
		public String toString() {
			return "Point [min=" + min + ", h=" + h + ", pos=" + pos + "]";
		}

	}
	
	static int max(List<Point> a, int left, int right) {
		int l = left < 0 ? Integer.MIN_VALUE : a.get(left).h;
		int r = right > a.size() - 1 ? Integer.MIN_VALUE : a.get(right).h;
		return Math.max(l, r);
	}
	
	static class Stat {
		public int ops;
		public int[] next;
		public boolean done;
	}

	public static void minNumberOperations(int[] target, Stat stat) {
		int n = target.length;
		int[] arr = new int[n];// compressed landscape - all values are different
		arr[0] = target[0];
		int size = 1;
		for (int i = 1; i < n; i++) {
			if (target[i - 1] != target[i]) {
				arr[size++] = target[i];
			}
		}
		// norm arr [0,size]
		if (size == 1) {
			stat.ops += arr[0];
			stat.next = null;
			stat.done = true;
			return;
		}

		Point p = null;

		// boundary conditions
		if (arr[1] > arr[0]) {
			p = new Point(true, arr[0], 0);// start with min
		} else {
			p = new Point(false, arr[0], 0);// start with max
		}
		List<Point> extr = new ArrayList<>();
		extr.add(p);

		for (int i = 1; i < size - 1; i++) {
			if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {// local max
				extr.add(new Point(false, arr[i], i));
			}
			if (arr[i - 1] > arr[i] && arr[i] < arr[i + 1]) {// local min
				extr.add(new Point(true, arr[i], i));
			}
		}

		// boundary conditions
		if (arr[size - 2] > arr[size - 1]) {
			extr.add(new Point(true, arr[size - 1], size - 1));// finish with min
		} else {
			extr.add(new Point(false, arr[size - 1], size - 1));// finish with max
		}
		// array extr now contains only extremal values
		
		// min number of operations = 
		// # of max + # of non-concided mins
		int[] nextTgt = new int[extr.size()];
		for (int i = 0; i < extr.size(); i++) {
			Point point = extr.get(i);
			if (!point.min) {
				int hmax = max(extr, i - 1, i + 1);
				stat.ops += point.h - hmax;
				point.h = hmax;// smooth max peak
			}
			nextTgt[i] = point.h;
		}
		stat.next = nextTgt;
	}
	
	public static int minNumberOperations(int[] target) {
		Stat stat = new Stat();
		while (!stat.done) {
			minNumberOperations(target, stat);
			target = stat.next;
		}
		return stat.ops;
	}

	public static void main(String[] arg) {
		
		int[] target = {1,2,3,2,1};
		System.out.println(minNumberOperations(target));

		int[] target1 = {1,3,2,4,1,2};
		System.out.println(minNumberOperations(target1));

		int[] target2 = {1,2,3};
		System.out.println(minNumberOperations(target2));
}

}
