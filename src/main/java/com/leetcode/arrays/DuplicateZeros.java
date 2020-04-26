package com.leetcode.arrays;

import com.leetcode.utils.Utils;

/**
 * https://leetcode.com/problems/duplicate-zeros/
 * 
 * Given a fixed length array arr of integers, duplicate each occurrence of
 * zero, shifting the remaining elements to the right.
 * 
 * Note that elements beyond the length of the original array are not written.
 * 
 * Do the above modifications to the input array in place, do not return
 * anything from your function.
 * 
 * Example 1:
 * 
 * Input: [1,0,2,3,0,4,5,0]
 * Explanation: After calling your
 * function, the input array is modified to: [1,0,0,2,3,0,0,4] 
 * 
 * Example 2:
 * 
 * Input: [1,2,3] 
 * Explanation: After calling your function, the
 * input array is modified to: [1,2,3]
 * 
 * Note:
 * 
 * 1 <= arr.length <= 10000 
 * 0 <= arr[i] <= 9
 * 
 * Runtime: 1 ms, faster than 91.34% of Java online submissions for Duplicate Zeros.
 * Memory Usage: 39.2 MB, less than 100.00% of Java online submissions for Duplicate Zeros.
 */
public class DuplicateZeros {

	public static void duplicateZeros(int[] arr) {
		// first calc number of zero and nonzero digits in final array
		int zeros = 0;
		int nonzeros = 0;
		int n = arr.length;
		int i = 0;
		while (i <= n - zeros - 1) {
			if (arr[i] == 0) {
				zeros ++;
			}else {
				nonzeros ++;
			}
			i++;
		}

		if (zeros == 0) {
			return;
		}
		
		int right = n - zeros - 1;
		int idx = n-1;
		int start = -1;
		// special case: process last digit
		if ((nonzeros+2*zeros) > n) {
			if (arr[right+1] == 0) {
				arr[idx] = 0;
			}
			idx --;
		}
		
		for (int j = right; j > start; j--) {
			if (arr[j] == 0) {
				arr[idx--] = 0;
				arr[idx--] = 0;
				zeros --;
			}else {
				arr[idx--] = arr[j];
			}
			if (zeros == 0) {
				return;
			}
		}

	}

	public static void main(String[] arg) {

		int[] arr = {1,0,2,3,0,4,5,0};
		duplicateZeros(arr);
		Utils.print(arr);

		int[] arr1 = {1,2,3};
		duplicateZeros(arr1);
		Utils.print(arr1);

		int[] arr2 = {8,5,0,9,0,3,4,7};
		duplicateZeros(arr2);
		Utils.print(arr2);
		
		int[] arr3 = {9,9,9,4,8,0,0,3,7,2,0,0,0,0,9,1,0,0,1,1,0,5,6,3,1,6,0,0,2,3,4,7,0,3,9,3,6,5,8,9,1,1,3,2,0,0,7,3,3,0,5,7,0,8,1,9,6,3,0,8,8,8,8,0,0,5,0,0,0,3,7,7,7,7,5,1,0,0,8,0,0};
		duplicateZeros(arr3);
		Utils.print(arr3);

		int[] arr4 = {8,4,5,0,0,1,0,7};
		duplicateZeros(arr4);
		Utils.print(arr4);

		int[] arr5 = {8,4,0,5,0,0,1,0,7};
		duplicateZeros(arr5);
		Utils.print(arr5);

		int[] arr6 = {0,1,2,3};
		duplicateZeros(arr6);
		Utils.print(arr6);

		int[] arr7 = {0,1,2,0,3};
		duplicateZeros(arr7);
		Utils.print(arr7);

	}

}
