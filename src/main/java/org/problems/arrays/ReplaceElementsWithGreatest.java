package org.problems.arrays;

import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/
 * 
 * Given an array arr, replace every element in that array with the greatest
 * element among the elements to its right, and replace the last element with
 * -1.
 * 
 * After doing so, return the array.
 * 
 * Example 1:
 * 
 * Input: arr = [17,18,5,4,6,1] Output: [18,6,6,6,1,-1]
 * 
 * Constraints:
 * 
 * 1 <= arr.length <= 10^4 
 * 1 <= arr[i] <= 10^5
 */
public class ReplaceElementsWithGreatest {

	public static int[] replaceElements(int[] arr) {
		int n = arr.length;
		int max = arr[n - 1];
		arr[n - 1] = -1;
		for (int i = n - 2; i > -1; i--) {
			int t = arr[i];
			arr[i] = max;
			max = Math.max(t, max);
		}

		return arr;

	}

	public static void main(String[] arg) {
		
		int[] arr = {17,18,5,4,6,1};

		Utils.print(replaceElements(arr));

	}

}
