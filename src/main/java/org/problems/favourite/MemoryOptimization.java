package org.problems.favourite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Memory Optimization
 * 
 * Given 2 lists a and b. Each element is a pair of integers where the first
 * integer represents the unique id and the second integer represents a value.
 * 
 * Your task is to find an element from a and an element form b such that the
 * sum of their values is less or equal to target and as close to target as
 * possible. Return a list of ids of selected elements. If no pair is possible,
 * return an empty list
 * 
 * 
 */
public class MemoryOptimization {
	
	static class PairsHolder {
		public int sum;
		public List<List<Integer>> pairs = new ArrayList<>();
		
		public PairsHolder(int sum) {
			this.sum = sum;
		}
		
		public void add(int[] first, int[] second) {
			this.sum = first[1] + second[1];
			this.pairs.add(Arrays.asList(first[0], second[0]));
		}
		
	}

	public static List<List<Integer>> solution(int[][] a, int[][] b, int target) {
		Map<Integer, PairsHolder> map = new HashMap<>();// key is sum , value is list of ids from a and b.

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				int sum = a[i][1] + b[j][1];
				if (!map.containsKey(sum)) {
					map.put(sum, new PairsHolder(sum));
				}
				map.get(sum).add(a[i], b[j]);
			}
		}

		List<Integer> allSums = new ArrayList<>();
		for (Integer i : map.keySet()) {
			if (i < target) {
				allSums.add(i);
			} else if (i == target) {
				return map.get(i).pairs;
			}
		}
		if (allSums.size() == 0) {
			return new ArrayList<>();// target is less than every possible sums.
		}
		return map.get(Collections.max(allSums)).pairs;
	}

	public static void main(String[] arg) {
		
		int[][] a = {
				{1, 2}, {2, 4}, {3, 6}
		};
		
		int[][] b = {
				{1, 2}
		};

		System.out.println(solution(a, b, 8));
		System.out.println(solution(a, b, 7));

		int[][] a1 = {
				{1, 3}, {2, 5}, {3, 7}, {4, 10}
		};
		
		int[][] b1 = {
				{1, 2}, {2, 3}, {3, 4}, {4, 5}
		};

		System.out.println(solution(a1, b1, 10));
		
		int[][] a2 = {
				{1, 8}, {2, 7}, {3, 14}
		};
		
		int[][] b2 = {
				{1, 5}, {2, 10}, {3, 14}
		};

		
		System.out.println(solution(a2, b2, 20));

	}

}
