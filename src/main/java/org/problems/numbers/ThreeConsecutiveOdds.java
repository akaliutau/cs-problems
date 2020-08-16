package org.problems.numbers;

/**
 * https://leetcode.com/problems/three-consecutive-odds/
 * 
 * Given an integer array arr, return true if there are three consecutive odd
 * numbers in the array. Otherwise, return false.
 * 
 * 
 * Example 1:
 * 
 * Input: arr = [2,6,4,1] Output: false 
 * Explanation: There are no three
 * consecutive odds
 * 
 */
public class ThreeConsecutiveOdds {

	public boolean threeConsecutiveOdds(int[] arr) {
		int n = arr.length;
		int counter = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] % 2 == 1) {
				counter++;
				if (counter >= 3) {
					return true;
				}
			} else {
				counter = 0;
			}
		}
		return false;
	}

	public static void main(String[] arg) {
		System.out.println(true);
	}

}
