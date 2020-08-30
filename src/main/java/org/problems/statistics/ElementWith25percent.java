package org.problems.statistics;

/**
 * https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/
 * 
 * Given an integer array sorted in non-decreasing order, there is exactly one
 * integer in the array that occurs more than 25% of the time.
 * 
 * Return that integer.
 * 
 * Example 1:
 * 
 * Input: arr = [1,2,2,6,6,6,6,7,10] Output: 6
 * 
 */
public class ElementWith25percent {

	public int findSpecialInteger(int[] arr) {
		int n = arr.length;
		int left = 0, counter = 0;
		int limit = n / 4;
		if (n == 0) {
			return 0;
		}
		for (int i = 1; i < n; i++) {
			if (arr[i] == arr[i-1]) {
				counter ++;
			}else {
				counter = 1;
			}
			if (counter > limit) {
				return arr[i];
			}
		}
		return 0;

	}

	public static void main(String[] arg) {

	}

}
