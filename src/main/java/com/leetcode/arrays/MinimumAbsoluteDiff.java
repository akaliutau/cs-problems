package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/minimum-absolute-difference/
 * 
 * Given an array of distinct integers arr, find all pairs of elements with the
 * minimum absolute difference of any two elements.
 * 
 * Return a list of pairs in ascending order(with respect to pairs), each pair
 * [a, b] follows
 * 
 * a, b are from arr a < b b - a equals to the minimum absolute difference of
 * any two elements in arr
 * 
 * 
 * Example 1:
 * 
 * Input: arr = [4,2,1,3] Output: [[1,2],[2,3],[3,4]] Explanation: The minimum
 * absolute difference is 1. List all pairs with difference equal to 1 in
 * ascending order. 
 * 
 * Example 2:
 * 
 * Input: arr = [1,3,6,10,15] Output: [[1,3]] 
 * 
 * Example 3:
 * 
 * Input: arr = [3,8,-10,23,19,-4,-14,27] Output: [[-14,-10],[19,23],[23,27]]
 * 
 * 
 * Constraints:
 * 
 * 2 <= arr.length <= 10^5 
 * -10^6 <= arr[i] <= 10^6
 * 
 */
public class MinimumAbsoluteDiff {
	
	public static List<List<Integer>> minimumAbsDifference(int[] arr) {
		int n = arr.length;
		Arrays.sort(arr);
		// find the min dist between consequentive elems
		int minDist = Integer.MAX_VALUE;
		for (int i = 0; i < n - 1; i++) {
			minDist = Math.min(minDist, arr[i+1] - arr[i]);
			if (minDist == 1) {
				break;
			}
		}
		List<List<Integer>> res = new ArrayList<>();
		for (int i = 0; i < n - 1; i++) {
			if (arr[i+1] - arr[i] == minDist) {//pair
				res.add(Arrays.asList(arr[i],arr[i+1]));
			}
		}		
		return res;
        
    }

	public static void main(String[] arg) {

		int[] arr = {4,2,1,3};
		System.out.println(minimumAbsDifference(arr));
		int[] arr1 = {1,3,6,10,15};
		System.out.println(minimumAbsDifference(arr1));
		int[] arr2 = {3,8,-10,23,19,-4,-14,27};
		System.out.println(minimumAbsDifference(arr2));
		int[] arr3 = {2,1,3};
		System.out.println(minimumAbsDifference(arr3));
		int[] arr4 = {4,3};
		System.out.println(minimumAbsDifference(arr4));

	}

}
