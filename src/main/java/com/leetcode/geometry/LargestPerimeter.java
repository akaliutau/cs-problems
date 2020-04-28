package com.leetcode.geometry;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/largest-perimeter-triangle/
 * 
 * Given an array A of positive lengths, return the largest perimeter of a
 * triangle with non-zero area, formed from 3 of these lengths.
 * 
 * If it is impossible to form any triangle of non-zero area, return 0.
 * 
 * Example 1:
 * Input: [2,1,2] Output: 5 
 * 
 * Example 2:
 * Input: [1,2,1] Output: 0 
 * 
 * Example 3:
 * Input: [3,2,3,4] Output: 10 
 * 
 * Example 4:
 * Input: [3,6,2,3] Output: 8
 * 
 * Note:
 * 3 <= A.length <= 10000 
 * 1 <= A[i] <= 10^6
 */
public class LargestPerimeter {
	
	static boolean isValid(int a, int b, int c) {
		return a + b > c;
	}

	public static int largestPerimeter(int[] a) {
		Arrays.sort(a);
		int n = a.length;
		int smaller = n-3;
		while (smaller >= 0) {
			if (isValid(a[smaller], a[smaller+1], a[smaller+2])) {
				return a[smaller] + a[smaller+1] + a[smaller+2];
			}
			smaller --;
		}
		return 0;

	}

	public static void main(String[] arg) {

		int[] a = {2,1,2};
		System.out.println(largestPerimeter(a));

		int[] a1 = {1,2,1};
		System.out.println(largestPerimeter(a1));

		int[] a2 = {3,2,3,4};
		System.out.println(largestPerimeter(a2));

		int[] a3 = {3,6,2,3};
		System.out.println(largestPerimeter(a3));

	}

}
