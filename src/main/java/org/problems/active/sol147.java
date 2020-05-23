package org.problems.active;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/maximum-width-ramp/
 * 
 * Given an array A of integers, a ramp is a tuple (i, j) for which i < j and
 * A[i] <= A[j]. The width of such a ramp is j - i.
 * 
 * Find the maximum width of a ramp in A. If one doesn't exist, return 0.
 * 
 * Example 1:
 * 
 * Input: [6,0,8,2,1,5] Output: 4 
 * Explanation: The maximum width ramp is
 * achieved at (i, j) = (1, 5): A[1] = 0 and A[5] = 5. Example 2:
 * 
 * Input: [9,8,1,0,1,9,4,0,4,1] Output: 7 
 * Explanation: The maximum width ramp is
 * achieved at (i, j) = (2, 9): A[2] = 1 and A[9] = 1.
 * 
 * 
 * Note:
 * 2 <= A.length <= 50000 
 * 0 <= A[i] <= 50000
 */
public class sol147 {
	
	static class Interval {
		public int left;
		public int right;
		public int max;
		public int min;
		
		public Interval(int left, int right) {
			this.left = left;
			this.right = right;
		}
		
		public int size() {
			return right - left;
		}
		
		public void update(int[] a) {
			max = max(a, left, right);
			min = min(a, left, right);
		}

		@Override
		public String toString() {
			return "[" + left + "," + right + "] max=" + max + ", min=" + min ;
		}
		
	}
	
	public static int max(int[] a, int left, int right) {
		int maxval = a[left];
		for (int i = left; i < right; i++) {
			maxval = Math.max(maxval, a[i]);
		}
		return maxval;
	}

	public static int min(int[] a, int left, int right) {
		int maxval = a[left];
		for (int i = left; i < right; i++) {
			maxval = Math.min(maxval, a[i]);
		}
		return maxval;
	}

	public static boolean isPair(Interval left, Interval right) {
		return !(left.min >= right.max);
	}
	
	public static List<Interval> split(int[] a, Interval intr){
		List<Interval> lst = new ArrayList<>();
		int center = (intr.left + intr.right) / 2;
		Interval l = new Interval(intr.left,center);
		l.update(a);
		Interval r = new Interval(center, intr.right);
		r.update(a);
		lst.add(l);
		lst.add(r);
		return lst;
	}
	
	public static int diff(int[] a, Interval l, Interval r) {
		
		System.out.println("left="+l);
		System.out.println("right="+r);
		if (l.size() == 1 && r.size() == 1) {
			if (l.min < r.max) {
				return r.left - l.left;
			}else {
				return 0;
			}
		}
		List<Interval> leftInt = new ArrayList<>();
		if (l.size() > 1) {
			leftInt.addAll(split(a,l));
		}else {
			leftInt.add(l);
		}
		List<Interval> rightInt = new ArrayList<>();
		if (r.size() > 1) {
			rightInt.addAll(split(a,r));
		}else {
			rightInt.add(r);
		}
		int maxDiff = 0;
		for (Interval left : leftInt) {
			for (Interval right : rightInt) {
				if (isPair(left, right)) {
					int diff = diff(a, left, right);
					if (diff >= maxDiff) {
						maxDiff = diff;
						System.out.println("best pair:"+ left + "-"+ right);
					}
				}
			}
		}
		return maxDiff;
		
	}


	public static int maxWidthRamp(int[] a) {
		int n = a.length;
		Interval l = new Interval(0,n);
		l.update(a);
		List<Interval> lst = split(a,l);
		return diff(a, lst.get(0), lst.get(1));
	}

	public static void main(String[] arg) {

		int[] a = {6,0,8,2,1,5};
		System.out.println(maxWidthRamp(a));//4

		int[] a1 = {9,8,1,0,1,9,4,0,4,1};
		System.out.println(maxWidthRamp(a1));//7

	}

}
