package org.problems.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/
 * 
 * Given an array of integers arr and an integer target.
 * 
 * You have to find two non-overlapping sub-arrays of arr each with sum equal
 * target. There can be multiple answers so you have to find an answer where the
 * sum of the lengths of the two sub-arrays is minimum.
 * 
 * Return the minimum sum of the lengths of the two required sub-arrays, or
 * return -1 if you cannot find such two sub-arrays.
 * 
 * 
 */
public class OverlappingSubarrays {

	public static int minSumOfLengths(int[] arr, int target) {

		int n = arr.length;
		long[] sum = new long[n];
		sum[0] = arr[0];
		List<int[]> intrv = new ArrayList<>();
		int left = -1;
		long summa = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] <= target) {
				left = i;
				break;
			}
		}
		if (left == -1) {
			return -1;
		}
		if (arr[left] == target) {
			int[] int1 = { left, left };
			intrv.add(int1);
		}
		for (int right = left + 1; right < n; right++) {
			sum[right] = sum[right - 1] + arr[right];
			if ((sum[right] - summa) == target) {
				int[] int1 = { left, right };
				intrv.add(int1);
			} else if ((sum[right] - summa) > target) {
				while ((sum[right] - summa) > target && sum[right] - summa > 0) {
					summa = sum[left];
					left++;
				}
				if ((sum[right] - summa) == target) {
					int[] int1 = { left, right };
					intrv.add(int1);
				}
			}
		}
		if ((sum[n - 1] - summa) == target) {
			int[] int1 = { left, n - 1 };
			intrv.add(int1);
		}
		if (intrv.size() < 2) {
			return -1;
		}

		Comparator<int[]> bylen = (o, p) -> Integer.compare(o[1] - o[0], p[1] - p[0]);
		Collections.sort(intrv, bylen);
		int size = intrv.size();

		int minLen = Integer.MAX_VALUE;
		for (int i = 0; i < Math.min(3, size); i++) {
			int[] int1 = intrv.get(i);
			for (int j = i + 1; j < size; j++) {
				int[] int2 = intrv.get(j);
				if (int2[0] > int1[1] || int2[1] < int1[0]) {
					minLen = Math.min(minLen, int2[1] - int2[0] + 2 + int1[1] - int1[0]);
					break;
				}
			}
		}

		return minLen == Integer.MAX_VALUE ? -1 : minLen;

	}

	public static void main(String[] arg) {

		int[] arr = { 3, 2, 2, 4, 3 };
		System.out.println(minSumOfLengths(arr, 3));

		int[] arr1 = { 7, 3, 4, 7 };
		System.out.println(minSumOfLengths(arr1, 7));

		int[] arr2 = { 4, 3, 2, 6, 2, 3, 4 };
		System.out.println(minSumOfLengths(arr2, 6));

		int[] arr3 = { 5, 5, 4, 4, 5 };
		System.out.println(minSumOfLengths(arr3, 3));

		int[] arr4 = { 3, 1, 1, 1, 5, 1, 2, 1 };
		System.out.println(minSumOfLengths(arr4, 3));

		int[] arr5 = { 1, 6, 1 };
		System.out.println(minSumOfLengths(arr5, 7));

		int[] arr6 = { 1, 2, 2, 3, 2, 6, 7, 2, 1, 4, 8 };
		System.out.println(minSumOfLengths(arr6, 5));

		int[] arr7 = { 31, 1, 1, 18, 15, 3, 15, 14 };
		System.out.println(minSumOfLengths(arr7, 33));

	}

}
