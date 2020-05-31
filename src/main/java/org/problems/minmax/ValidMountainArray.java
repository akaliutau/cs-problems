package org.problems.minmax;

/**
 * https://leetcode.com/problems/valid-mountain-array/
 * 
 * Given an array A of integers, return true if and only if it is a valid
 * mountain array.
 * 
 * Recall that A is a mountain array if and only if:
 * 
 * A.length >= 3 
 * There exists some i with 0 < i < A.length - 1 such that: 
 * A[0] < A[1] < ... A[i-1] < A[i] 
 * A[i] > A[i+1] > ... > A[A.length - 1]
 * 
 * Example 1:
 * 
 * Input: [2,1] Output: false 
 * 
 * Example 2:
 * 
 * Input: [3,5,5] Output: false 
 * 
 * Example 3:
 * 
 * Input: [0,3,2,1] Output: true
 * 
 * 
 * Note:
 * 
 * 0 <= A.length <= 10000 
 * 0 <= A[i] <= 10000
 * 
 */
public class ValidMountainArray {
	
	public static boolean validMountainArray(int[] a) {
		int n = a.length;
		
		if ( n < 3) {
			return false;
		}
		int prev = a[0];
		for (int i = 1; i < n; i++) {
			if (a[i] == prev) {
				return false;
			}
			if (a[i] < prev) {// peak
				if (i == 1) {
					return false;
				}
				for (int j = i; j < n; j++) {
					if (a[j] >= prev) {
						return false;
					}
					prev = a[j];
				}
				return true;
			}
			prev = a[i];
		}
		return false;
        
    }

	public static void main(String[] arg) {
		
		int[] a = {3,5,5};

		System.out.println(validMountainArray(a));

		int[] a1 = {0,3,2,1};

		System.out.println(validMountainArray(a1));
		
		int[] a2 = {9,8,7,6,5,4,3,2,1,0};
		System.out.println(validMountainArray(a2));

	}

}
