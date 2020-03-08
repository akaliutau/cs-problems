package com.leetcode.topology;

import com.leetcode.utils.Utils;

/**
 * https://leetcode.com/problems/bulb-switcher-iii/
 * 
 * There is a room with n bulbs, numbered from 1 to n, arranged in a row from
 * left to right. Initially, all the bulbs are turned off.
 * 
 * At moment k (for k from 0 to n - 1), we turn on the light[k] bulb. A bulb
 * change color to blue only if it is on and all the previous bulbs (to the
 * left) are turned on too.
 * 
 * Return the number of moments in which all turned on bulbs are blue.
 * 
 * 
 * 
 */
public class BulbSwitcherIII {

	public static int numTimesAllBlue(int[] light) {
		int n = light.length;
		int[] state = new int[n];
		int counter = 0;
		int left = -1;
		int right = -1;
		for (int i = 0; i < n; i++) {
			int k = light[i] - 1;
			state[k] = 1;
			right = right < k ? k : right;
			boolean all = true;
			for (int j = right; j > left; j--) {
				if (state[j] == 0) {
					all = false;
					break;
				}
			}
			Utils.print(state);
			if (all) {
				left = k;
				counter++;
			}
		}
		return counter;
	}

	public static void main(String[] arg) {

		int[] arr = { 2, 1, 3, 5, 4 };
		System.out.println(numTimesAllBlue(arr));

		int[] arr1 = { 3, 2, 4, 1, 5 };
		System.out.println(numTimesAllBlue(arr1));

		int[] arr2 = { 4, 1, 2, 3 };
		System.out.println(numTimesAllBlue(arr2));

		int[] arr3 = { 2, 1, 4, 3, 6, 5 };
		System.out.println(numTimesAllBlue(arr3));

		int[] arr4 = { 1, 2, 3, 4, 5, 6 };
		System.out.println(numTimesAllBlue(arr4));

	}

}
