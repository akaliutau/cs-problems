package org.problems.statistics;

/**
 * https://leetcode.com/problems/unique-number-of-occurrences/
 * 
 * Given an array of integers arr, write a function that returns true if and
 * only if the number of occurrences of each value in the array is unique.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: arr = [1,2,2,1,1,3] Output: true Explanation: The value 1 has 3
 * occurrences, 2 has 2 and 3 has 1. No two values have the same number of
 * occurrences. 
 * 
 * Example 2:
 * 
 * Input: arr = [1,2] Output: false 
 * 
 * Example 3:
 * 
 * Input: arr = [-3,0,1,-3,1,1,1,-3,10,0] Output: true
 * 
 * 
 * Constraints:
 * 
 * 1 <= arr.length <= 1000 
 * -1000 <= arr[i] <= 1000
 */
public class UniqueNumberOfOccurrences {

	public static boolean uniqueOccurrences(int[] arr) {
		int n = arr.length;
		if (n <= 1) {
			return true;
		}
		int[] state = new int[2001];
		for (int i = 0; i < n; i++) {
			state[arr[i] + 1000] ++;
		}
		boolean[] freq = new boolean[1001];
		for (int i = 0; i < 2001; i++) {
			if (state[i] > 0) {
				if (freq[state[i]]) {
					return false;
				}
				freq[state[i]] = true;
			}
		}
		return true;

	}

	public static void main(String[] arg) {
		int[] arr = {1,2,2,1,1,3};
		System.out.println(uniqueOccurrences(arr));

		int[] arr1 = {1,2};
		System.out.println(uniqueOccurrences(arr1));

		int[] arr2 = {-3,0,1,-3,1,1,1,-3,10,0};
		System.out.println(uniqueOccurrences(arr2));

	}

}
