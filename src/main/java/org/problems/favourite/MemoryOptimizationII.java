package org.problems.favourite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Memory optimization II
 * 
 * Give a computer with total K memory space, and an array of foreground tasks
 * and background tasks the computer needs to do. Write an algorithm to find a
 * pair of tasks from each array to maximize the memory usage. Notice the tasks
 * could be done without origin order.
 * 
 * Input The input to the function/method consists of three arguments :
 * foregroundTask, an array representing the memory usage of the foreground
 * tasks, backgroundTask, an array representing the memory usage of the
 * background tasks, K, the total memory space of the computer.
 * 
 * Output Return a list of pairs of the task IDs.
 * 
 * Examples 1 
 * Input: 
 * foregroundTasks = [1, 7, 2, 4, 5, 6] 
 * backgroundTasks = [3, 1, 2] 
 * K = 6
 * 
 * Output: [(3, 2), (4, 1), (5,-1)]
 * 
 * 
 */
public class MemoryOptimizationII {
	
	static class PairsHolder {
		public int sum;
		public List<List<Integer>> pairs = new ArrayList<>();
		
		public PairsHolder(int sum) {
			this.sum = sum;
		}
		
		public void add(int idf, int first,  int idb, int second) {
			this.sum = first + second;
			this.pairs.add(Arrays.asList(idf, idb));
		}
		
	}
	
	static void addSingleTask(int pos, int target, int[] lst, List<List<Integer>> collected) {
		for (int i = 0; i < lst.length; i++) {
			if (lst[i] == target) {
				collected.add(pos == 0 ? Arrays.asList(i, -1) :  Arrays.asList(-1, i));
			}
		}
	}

	public static List<List<Integer>> memoryOptimizor(int[] foregroundTasks, int[] backgroundTasks, int k) {
		Map<Integer, PairsHolder> map = new HashMap<>();// key is sum , value is list of ids from a and b.

		for (int i = 0; i < foregroundTasks.length; i++) {
			for (int j = 0; j < backgroundTasks.length; j++) {
				int sum = foregroundTasks[i] + backgroundTasks[j];
				if (!map.containsKey(sum)) {
					map.put(sum, new PairsHolder(sum));
				}
				map.get(sum).add(i, foregroundTasks[i], j, backgroundTasks[j]);
			}
		}

		List<Integer> allSums = new ArrayList<>();
		for (Integer i : map.keySet()) {
			if (i < k) {
				allSums.add(i);
			} else if (i == k) {
				List<List<Integer>> pairs = map.get(i).pairs;
				addSingleTask(0, k, foregroundTasks, pairs);
				addSingleTask(1, k, backgroundTasks, pairs);
				return pairs;
			}
		}
		if (allSums.size() == 0) {
			return new ArrayList<>();// every possible sums > k
		}
		List<List<Integer>> pairs = map.get(Collections.max(allSums)).pairs;
		addSingleTask(0, k, foregroundTasks, pairs);
		addSingleTask(1, k, backgroundTasks, pairs);
		return pairs;
	}


	public static void main(String[] arg) {
		System.out.println(memoryOptimizor(new int[] {1, 7, 2, 4, 5, 6}, new int[] {3, 1, 2}, 6));
	}

}
