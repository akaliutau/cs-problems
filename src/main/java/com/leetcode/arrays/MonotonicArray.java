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
 * 
 * 
 * Example 1:
 * 
 * Input: [1,2,2,3] Output: true
 * 
 */
public class MonotonicArray {

	public static boolean isMonotonic(int[] a) {
        int n = a.length;
        if (n <= 1) {
        	return true;
        }
        int diff = 0;
        for (int i = 0; i < n-1; i++) {
        	if (a[i] < a[i+1]) {// inc
        		if (diff < 0) {
        			return false;
        		}else {
        			diff = 1;
        		}
        	}else if (a[i] > a[i+1]){//dec
        		if (diff > 0) {
        			return false;
        		}else {
        			diff = -1;
        		}
        	}else {// neutral
        		
        	}
        }
        return true;
    }

	public static void main(String[] arg) {

		int[] a = {1,2,2,3};
		System.out.println(isMonotonic(a));

		int[] a1 = {1,1,1};
		System.out.println(isMonotonic(a1));

		int[] a2 = {3,2,2,1};
		System.out.println(isMonotonic(a2));

		int[] a3 = {3,2,2,3};
		System.out.println(isMonotonic(a3));

		int[] a4 = {3,2};
		System.out.println(isMonotonic(a4));

	}

}
