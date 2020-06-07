package org.problems.minmax;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/the-k-strongest-values-in-an-array/
 * 
 * Given an array of integers arr and an integer k.
 * 
 * A value arr[i] is said to be stronger than a value arr[j] if |arr[i] - m| >
 * |arr[j] - m| where m is the median of the array. If |arr[i] - m| == |arr[j] -
 * m|, then arr[i] is said to be stronger than arr[j] if arr[i] > arr[j].
 * 
 * Return a list of the strongest k values in the array. return the answer in
 * any arbitrary order.
 * 
 * Median is the middle value in an ordered integer list. More formally, if the
 * length of the list is n, the median is the element in position ((n - 1) / 2)
 * in the sorted list (0-indexed).
 * 
 * For arr = [6, -3, 7, 2, 11], n = 5 and the median is obtained by sorting the
 * array arr = [-3, 2, 6, 7, 11] and the median is arr[m] where m = ((5 - 1) /
 * 2) = 2. The median is 6. 
 * For arr = [-7, 22, 17, 3], n = 4 and the median is
 * obtained by sorting the array arr = [-7, 3, 17, 22] and the median is arr[m]
 * where m = ((4 - 1) / 2) = 1. The median is 3.
 * 
 * 
 */
public class KStrongestValues {

	static class Elem {
		public int m;
		public int num;
		public int diff;

		public Elem(int num, int m) {
			this.num = num;
			this.m = m;
			this.diff = Math.abs(num - m);
		}

	}

	public static int[] getStrongest(int[] arr, int k) {
		int n = arr.length;
		List<Elem> elems = new ArrayList<>();
		Arrays.parallelSort(arr);
		int mid = (n - 1) / 2;
		int m = arr[mid];
		for (int i = 0; i < n; i++) {
			elems.add(new Elem(arr[i], m));
		}
		Comparator<Elem> byDiff = (o, p) -> Integer.compare(p.diff, o.diff);
		Comparator<Elem> byNum = (o, p) -> Integer.compare(p.num, o.num);
		PriorityQueue<Elem> queue = new PriorityQueue<>(byDiff.thenComparing(byNum));
		queue.addAll(elems);
		int[] res = new int[k];
		for (int i = 0; i < k; i++) {
			res[i] = queue.poll().num;
		}

		return res;
	}

	public static void main(String[] arg) {

		int[] a = { 1, 2, 3, 4, 5 };
		Utils.print(getStrongest(a, 2));

		int[] a1 = { 1, 1, 3, 5, 5 };
		Utils.print(getStrongest(a1, 2));

		int[] a2 = { 6, 7, 11, 7, 6, 8 };
		Utils.print(getStrongest(a2, 5));

		int[] a3 = { 6, -3, 7, 2, 11 };
		Utils.print(getStrongest(a3, 3));

		int[] a4 = { -7, 22, 17, 3 };
		Utils.print(getStrongest(a4, 2));

	}

}
