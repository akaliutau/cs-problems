package com.leetcode.arrays;

/**
 * https://leetcode.com/problems/monotonic-array/
 * 
 * An array is monotonic if it is either monotone increasing or monotone
 * decreasing.
 * 
 * An array A is monotone increasing if for all i <= j, A[i] <= A[j]. An array A
 * is monotone decreasing if for all i <= j, A[i] >= A[j].
 * 
 * Return true if and only if the given array A is monotonic.
 * 
 * Example 1:
 * Input: [1,2,2,3] Output: true 
 * 
 * Example 2:
 * Input: [6,5,4,4] Output: true 
 * 
 * Example 3:
 * Input: [1,3,2] Output: false 
 * 
 * Example 4:
 * Input: [1,2,4,5] Output: true 
 * 
 * Example 5:
 * Input: [1,1,1] Output: true
 * 
 * 
 * Note:
 * 1 <= A.length <= 50000 
 * -100000 <= A[i] <= 100000
 */
public class MonotonicArray {
	
	public static boolean isMonotonic(int[] a) {
		
		int n = a.length;
		if (n == 1) {
			return true;
		}
		boolean increasing = true;
		for (int i = 1; i < n; i++) {
			if (a[i] < a[i-1]) {
				increasing = false;
				break;
			}
		}
		if (increasing) {
			return true;
		}
		boolean decreasing = true;
		for (int i = 1; i < n; i++) {
			if (a[i] > a[i-1]) {
				decreasing = false;
				break;
			}
		}
		if (decreasing) {
			return true;
		}
		
		return false;

	}

	public static void main(String[] arg) {
		
		int[] a = {1,2,2,3};
		System.out.println(isMonotonic(a));

		int[] a1 = {6,5,4,4};
		System.out.println(isMonotonic(a1));

		int[] a2 = {1,3,2};
		System.out.println(isMonotonic(a2));

		int[] a3 = {1,2,4,5};
		System.out.println(isMonotonic(a3));

		int[] a4 = {2,2,2};
		System.out.println(isMonotonic(a4));

	}

}
