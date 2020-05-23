package org.problems.combinatorics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * https://leetcode.com/problems/combination-sum/
 *
 * Given a set of candidate numbers (candidates) (without duplicates) and a
 * target number (target), find all unique combinations in candidates where the
 * candidate numbers sums to target.
 * 
 * The same repeated number may be chosen from candidates unlimited number of
 * times.
 * 
 * Note:
 * 
 * All numbers (including target) will be positive integers. The solution set
 * must not contain duplicate combinations.
 * 
 * Example 1:
 * 
 * Input: candidates = [2,3,6,7], target = 7,
 * 
 * 
 * A solution set is: [ [7], [2,2,3] ]
 * 
 * Example 2:
 * 
 * Input: candidates = [2,3,5], target = 8,
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
 * A solution set is: [ [2,2,2,2], [2,3,3], [3,5] ]
 * 
 * 004 021 110
 * 
 */
public class CombinatioSumI {

	public static void combination(int[] candidates, int idx, int target, Stack<Integer> result,
		Set<List<Integer>> results) {
		if (target == 0) {
			results.add(new ArrayList<>(result));
			return;
		}
		if (target < 0 || idx > candidates.length - 1) {
			return;
		}
		for (int i = 0; i < target / candidates[idx] + 1; i++) {
			result.add(i);
			combination(candidates, idx + 1, target - i * candidates[idx], result, results);
			result.pop();
		}
	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		Set<List<Integer>> results = new HashSet<>();
		Stack<Integer> result = new Stack<>();
		Arrays.sort(candidates);
		combination(candidates, 0, target, result, results);
		
		List<List<Integer>> finalRes =  new ArrayList<>();
		for (List<Integer> vector : results) {
			List<Integer> res = new ArrayList<>();
			int idx = 0;
			for (Integer times : vector) {
				for (int i = 0; i < times; i++) {
					res.add(candidates[idx]);
				}
				idx++;
			}
			finalRes.add(res);
		}
		
		return finalRes;

	}

	public static void main(String[] arg) {

		int[] arr1 = { 2, 3, 6, 7 };

		System.out.println(combinationSum(arr1, 7));

		int[] arr2 = { 2, 3, 5 };

		System.out.println(combinationSum(arr2, 8));

		int[] arr3 = { 2, 3, 5 };

		System.out.println(combinationSum(arr3, 1));

		int[] arr4 = { };

		System.out.println(combinationSum(arr4, 8));

		int[] arr5 = { 3 };

		System.out.println(combinationSum(arr5, 3));

		int[] arr6 = { 1, 2};

		System.out.println(combinationSum(arr6, 3));

	}

}
