package org.problems.arrays;

/**
 * Find the number of sub-arrays of fixed length with avg >= threshold
 */
public class Subarrays {

	public static int numOfSubarrays(int[] arr, int k, int threshold) {
		int numOfSubArr = 0;
		int lastSum = 0;

		for (int i = 0; i < k - 1 && i < arr.length; i++) {
			lastSum += arr[i];
		}
		for (int i = 0; i < arr.length - k + 1; i++) {
			lastSum += arr[i + k - 1];
			if (lastSum / k >= threshold) {
				numOfSubArr++;
			}
			lastSum -= arr[i];
		}

		return numOfSubArr;
	}

	public static void main(String[] arg) {

		int k = 3;
		int[] arr = { 2, 2, 2, 2, 5, 5, 5, 8 };
		int threshold = 4;

		int k1 = 1;
		int[] arr1 = { 1, 1, 1, 1, 1 };
		int threshold1 = 0;

		int k2 = 3;
		int[] arr2 = { 11, 13, 17, 23, 29, 31, 7, 5, 2, 3 };
		int threshold2 = 5;

		int k3 = 7;
		int[] arr3 = { 7, 7, 7, 7, 7, 7, 7 };
		int threshold3 = 7;

		int k4 = 4;
		int[] arr4 = { 4, 4, 4, 4 };
		int threshold4 = 1;

		int res = numOfSubarrays(arr4, k4, threshold4);
		System.out.print(res);

	}

}
