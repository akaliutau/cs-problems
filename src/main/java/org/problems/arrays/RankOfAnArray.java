package org.problems.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/rank-transform-of-an-array/
 * 
 * Given an array of integers arr, replace each element with its rank.
 * 
 * The rank represents how large the element is. The rank has the following
 * rules:
 * 
 * Rank is an integer starting from 1. The larger the element, the larger the
 * rank. If two elements are equal, their rank must be the same. Rank should be
 * as small as possible.
 * 
 * 
 * Example 1:
 * 
 * Input: arr = [40,10,20,30] Output: [4,1,2,3] Explanation: 40 is the largest
 * element. 10 is the smallest. 20 is the second smallest. 30 is the third
 * smallest.
 * 
 * Runtime: 25 ms, faster than 80.47% of Java online submissions for Rank
 * Transform of an Array. Memory Usage: 57 MB, less than 61.16% of Java online
 * submissions for Rank Transform of an Array.
 * 
 */
public class RankOfAnArray {

	public static int[] arrayRankTransform(int[] a) {
		int[] arr = a.clone();
		int n = arr.length;
		int rank = 1;
		Map<Integer, Integer> ranks = new HashMap<>();
		Arrays.parallelSort(arr);

		for (int i = 0; i < n; i++) {
			if (!ranks.containsKey(arr[i])) {
				ranks.put(arr[i], rank++);
			}
		}
		int[] res = new int[n];
		for (int i = 0; i < n; i++) {
			res[i] = ranks.get(a[i]);
		}

		return res;

	}

	public static void main(String[] arg) {

		int[] arr = { 40, 10, 20, 30 };

		Utils.print(arrayRankTransform(arr));

	}

}
