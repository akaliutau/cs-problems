package com.leetcode.combinatorics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * https://leetcode.com/problems/combination-sum-ii/
 *
 *
 * Given a collection of candidate numbers (candidates) and a target number
 * (target), find all unique combinations in candidates where the candidate
 * numbers sums to target.
 * 
 * Each number in candidates may only be used once in the combination.
 * 
 * Note:
 * 
 * All numbers (including target) will be positive integers. The solution set
 * must not contain duplicate combinations. Example 1:
 * 
 * Input: candidates = [10,1,2,7,6,1,5], target = 8, 
 * 
 * A solution set is: [ [1, 7], [1, 2, 5], [2, 6], [1, 1, 6] ] 
 * 
 * Example 2:
 * 
 * Input: candidates = [2,5,2,1,2], target = 5, 
 * 
 * A solution set is: [ [1,2,2], [5] ]
 * 
 * tgt = a1*n[0]+a2*n[1]+a3*n[2] where a1..3= 0..max
 * 
 * for (a3 = 0; a3 < tgt/5){
 *  	for (a2 = 0; a2 < tgt/5){ 
 *  		for (a1 = 0; a1 < tgt/5){
 * 
 * 			}
 * 		} 
 * }
 * 
 */

public class CombinatioSumII {

	public static void combination(int[] candidates, int idx, int target, Stack<Boolean> result,
		Set<List<Boolean>> results) {
		if (target == 0) {
			results.add(new ArrayList<>(result));
			return;
		}
		if (target < 0 || idx > candidates.length - 1) {
			return;
		}
		for (int i = 0; i < 2; i++) {
			result.add(i != 0);
			combination(candidates, idx + 1, target - i * candidates[idx], result, results);
			result.pop();
		}
	}

	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Set<List<Boolean>> results = new HashSet<>();
		Stack<Boolean> result = new Stack<>();
		combination(candidates, 0, target, result, results);
		
		Set<List<Integer>> finalRes =  new HashSet<>();
		for (List<Boolean> vector : results) {
			List<Integer> res = new ArrayList<>();
			int idx = 0;
			for (Boolean flag : vector) {
				if (flag) {
					res.add(candidates[idx]);
				}
				idx++;
			}
			Collections.sort(res);
			finalRes.add(res);
		}
		
		return new ArrayList<>(finalRes);

	}

	public static void main(String[] arg) {

		int[] arr1 = { 2, 3, 6, 7 };
		System.out.println(combinationSum2(arr1, 7));

		int[] arr2 = { 2, 3, 5 };
		System.out.println(combinationSum2(arr2, 8));

		int[] arr3 = { 2, 3, 5 };
		System.out.println(combinationSum2(arr3, 1));

		int[] arr4 = { };
		System.out.println(combinationSum2(arr4, 8));

		int[] arr5 = { 3 };
		System.out.println(combinationSum2(arr5, 3));

		int[] arr6 = { 1, 2};
		System.out.println(combinationSum2(arr6, 3));

		int[] arr7 = { 10,1,2,7,6,1,5};
		System.out.println(combinationSum2(arr7, 8));

		int[] arr8 = { 2,5,2,1,2};
		System.out.println(combinationSum2(arr8, 5));

	}

}
