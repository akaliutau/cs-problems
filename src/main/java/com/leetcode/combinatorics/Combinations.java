package com.leetcode.combinatorics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/combinations/
 * 
 * Given two integers n and k, return all possible combinations of k numbers out
 * of 1 ... n.
 * 
 * Example:
 * 
 * Input: n = 4, k = 2
 * 
 * Output: [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
 * 
 * 
 * [1, 2, 3, 4] ->
 * 
 * [1,2,3], [1,3,4], [1,2,4], [2,3,4] [
 * 
 * 
 */
public class Combinations {

	static void getCombinations(List<Integer> set, int size, Set<List<Integer>> results) {
		if (results.contains(set)) {
			return;
		}
		if (set.size() == size) {
			results.add(set);
		} else {
			for (int i = 0; i < set.size(); i++) {
				List<Integer> next = new ArrayList<>(set);
				next.remove(i);
				getCombinations(next, size, results);
				results.add(next);
			}
		}
	}

	public static List<List<Integer>> combine(int n, int k) {
		List<Integer> initSet = new ArrayList<>();
		for (int i = 1; i < n + 1; i++) {
			initSet.add(i);
		}
		Set<List<Integer>> results = new HashSet<>();
		getCombinations(initSet, k, results);
		
		List<List<Integer>> finalRes = new ArrayList<>();
		for (List<Integer> lst : results) {
			if (lst.size() == k) {
				finalRes.add(lst);
			}
		}

		return finalRes;

	}

	public static void main(String[] arg) {

		System.out.println(combine(4,2));
		System.out.println(combine(4,4));
		System.out.println(combine(4,3));
		System.out.println(combine(4,1));
		System.out.println(combine(1,0));

		System.out.println(combine(13,4));

	}
}
