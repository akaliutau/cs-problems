package org.problems.combinatorics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * https://leetcode.com/problems/combination-sum-iii/
 *
 * Find all possible combinations of k numbers that add up to a number n, given
 * that only numbers from 1 to 9 can be used and each combination should be a
 * unique set of numbers.
 * 
 * Note:
 * 
 * All numbers will be positive integers. The solution set must not contain
 * duplicate combinations.
 * 
 * Example 1: Input: k = 3, n = 7 Output: [[1,2,4]]
 * 
 * Example 2: Input: k = 3, n = 9 Output: [[1,2,6], [1,3,5], [2,3,4]]
 * 
 * 
 */
public class CombinationSumIII {

	public static void combination(int idx, int target, int k, Stack<Integer> result, Set<List<Integer>> results) {
		if (target == 0 && result.size() == k) {
			results.add(new ArrayList<>(result));
			return;
		}
		if (target < 0 || result.size() > k) {
			return;
		}
		for (int i = idx; i < 10; i++) {
			result.add(i);
			combination(i + 1, target - i, k, result, results);
			result.pop();
		}
	}

	public static List<List<Integer>> combinationSum3(int k, int n) {

		Set<List<Integer>> results = new HashSet<>();
		Stack<Integer> result = new Stack<>();
		combination(1, n, k, result, results);

	
		return new ArrayList<>(results);
	}

	public static void main(String[] arg) {

		System.out.println(combinationSum3(3, 7));
		System.out.println(combinationSum3(3, 9));

	}

}
