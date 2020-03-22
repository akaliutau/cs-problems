package com.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode.com/problems/find-the-distance-value-between-two-arrays/
 * 
 * Given two integer arrays arr1 and arr2, and the integer d, return the
 * distance value between the two arrays.
 * 
 * The distance value is defined as the number of elements arr1[i] such that
 * there is not any element arr2[j] where |arr1[i]-arr2[j]| <= d.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: arr1 = [4,5,8], arr2 = [10,9,1,8], d = 2 Output: 2
 * 
 * 
 */
public class DistanceBetweenArrays {

	public static boolean isDistant(int elem, int[] arr2, int d) {
		for (int j = 0; j < arr2.length; j++) {
			if (Math.abs(arr2[j] - elem) <= d) {
				return false;
			}
		}
		return true;
	}

	public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
		int counter = 0;
		for (int i = 0; i < arr1.length; i++) {
			if (isDistant(arr1[i], arr2, d)) {
				counter++;
			}
		}
		return counter;
	}

	public static void main(String[] arg) {

		System.out.println(true);

	}

}
