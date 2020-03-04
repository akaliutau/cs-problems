package com.leetcode.combinatorics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/permutations-ii 
 * 
 * Runtime: 6 ms, faster than 7.54%
 * of Java online submissions for Permutations. Memory Usage: 42 MB, less than
 * 5.68% of Java online submissions for Permutations.
 */
public class PermutationsII {

	private static void perm(int[] array, int n, Set<List<Integer>> results) {
		if (n == 1) {
			results.add(Arrays.stream(array).boxed().collect(Collectors.toList()));
			return;
		}
		for (int i = 0; i < n; i++) {
			swap(array, i, n - 1);
			perm(array, n - 1, results);
			swap(array, i, n - 1);
		}
	}

	private static void swap(int[] a, int i, int j) {
		int c;
		c = a[i];
		a[i] = a[j];
		a[j] = c;
	}

	public static List<List<Integer>> permuteUnique(int[] nums) {
		Set<List<Integer>> results = new HashSet<>();
		perm(nums, nums.length, results);
		return new ArrayList<>(results);
	}

	public static void main(String[] arg) {

		int[] in = { 1, 1, 2 };

		List<List<Integer>> res = permuteUnique(in);

		System.out.print(res);
	}

}
