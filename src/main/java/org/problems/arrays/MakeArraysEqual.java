package org.problems.arrays;

import org.problems.model.TreeNode;

/**
 * https://leetcode.com/problems/make-two-arrays-equal-by-reversing-sub-arrays/
 * 
 * Given two integer arrays of equal length target and arr.
 * 
 * In one step, you can select any non-empty sub-array of arr and reverse it.
 * You are allowed to make any number of steps.
 * 
 * Return True if you can make arr equal to target, or False otherwise.
 * 
 */
public class MakeArraysEqual {

	public static boolean canBeEqual(int[] target, int[] arr) {
		int n = arr.length;
		int[] distr = new int[1000];
		for (int i = 0; i < n; i++) {
			distr[target[i]]++;
		}
		for (int i = 0; i < n; i++) {
			distr[arr[i]]--;
		}
		for (int i = 0; i < 1000; i++) {
			if (distr[i] != 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] arg) {

		int[] target = { 1, 2, 3, 4 };
		int[] arr = { 2, 4, 1, 3 };
		System.out.println(canBeEqual(target, arr));

		int[] target1 = { 3, 7, 9 };
		int[] arr1 = { 3, 7, 11 };
		System.out.println(canBeEqual(target1, arr1));

	}

}
