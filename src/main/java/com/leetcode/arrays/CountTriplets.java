package com.leetcode.arrays;

/**
 * https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/
 * 
 * Given an array of integers arr.
 * 
 * We want to select three indices i, j and k where (0 <= i < j <= k <
 * arr.length).
 * 
 * Let's define a and b as follows:
 * 
 * a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1] b = arr[j] ^ arr[j + 1] ^ ... ^
 * arr[k] Note that ^ denotes the bitwise-xor operation.
 * 
 * Return the number of triplets (i, j and k) Where a == b.
 * 
 * Example 1:
 * 
 * Input: arr = [2,3,1,6,7] Output: 4 
 * Explanation: The triplets are (0,1,2), (0,2,2), (2,3,4) and (2,4,4)
 */
public class CountTriplets {

	public static int countTriplets(int[] arr) {
		int n = arr.length;
		int[] intxor = new int[n];
		intxor[0] = arr[0];
		for (int i = 1; i < n; i++) {
			intxor[i] = intxor[i - 1] ^ arr[i];
		}
		int counter = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = j; k < n; k++) {
					int a = (i == 0) ? intxor[j - 1] : intxor[j - 1] ^ intxor[i - 1];
					int b = intxor[k] ^ intxor[j - 1];
					if (a == b) {
						counter++;
					}
				}
			}
		}
		return counter;
	}

	public static void main(String[] arg) {

		int[] arr = { 2, 3, 1, 6, 7 };
		System.out.println(countTriplets(arr));

		int[] arr1 = { 1, 1, 1, 1, 1 };
		System.out.println(countTriplets(arr1));

		int[] arr2 = { 2, 3 };
		System.out.println(countTriplets(arr2));

		int[] arr3 = { 1, 3, 5, 7, 9 };
		System.out.println(countTriplets(arr3));

		int[] arr4 = { 7, 11, 12, 9, 5, 2, 7, 17, 22 };
		System.out.println(countTriplets(arr4));

	}

}
