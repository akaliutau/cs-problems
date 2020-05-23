package org.problems.topology;

import java.util.ArrayList;
import java.util.List;

import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/flower-planting-with-no-adjacent/
 * 
 * You have N gardens, labeled 1 to N. In each garden, you want to plant one of
 * 4 types of flowers.
 * 
 * paths[i] = [x, y] describes the existence of a bidirectional path from garden
 * x to garden y.
 * 
 * Also, there is no garden that has more than 3 paths coming into or leaving
 * it.
 * 
 * Your task is to choose a flower type for each garden such that, for any two
 * gardens connected by a path, they have different types of flowers.
 * 
 * Return any such a choice as an array answer, where answer[i] is the type of
 * flower planted in the (i+1)-th garden. The flower types are denoted 1, 2, 3,
 * or 4. It is guaranteed an answer exists.
 * 
 * Example 1: Input: N = 3, paths = [[1,2],[2,3],[3,1]] Output: [1,2,3]
 * 
 * Example 2: Input: N = 4, paths = [[1,2],[3,4]] Output: [1,2,1,2]
 * 
 * Example 3: Input: N = 4, paths = [[1,2],[2,3],[3,4],[4,1],[1,3],[2,4]]
 * Output: [1,2,3,4]
 * 
 * Note:
 * 
 * 1 <= N <= 10000 0 <= paths.size <= 20000 No garden has 4 or more paths coming
 * into or leaving it. It is guaranteed an answer exists
 * 
 * Similar to 4-colors problem
 * 
 * Runtime: 13 ms, faster than 87.75% of Java online submissions for Flower Planting With No Adjacent.
 * Memory Usage: 48.8 MB, less than 100.00% of Java online submissions for Flower Planting With No Adjacent
 */
public class FlowerPlanting {

	static class Garden {
		public boolean[] forbidden = new boolean[4];
		public int flowers = 0;// initial value
		public List<Garden> ties = new ArrayList<>();
		public int pos;
		
		public Garden(int pos){
			this.pos = pos;
			
		}
	}

	public static int[] gardenNoAdj(int n, int[][] paths) {

		Garden[] gardens = new Garden[n];
		for (int i = 0; i < n; i++) {
			gardens[i] = new Garden(i);
		}
		
		for (int[] path : paths) {// set bidirectional tie
			gardens[path[1] - 1].ties.add(gardens[path[0] - 1]);
			gardens[path[0] - 1].ties.add(gardens[path[1] - 1]);
		}

		int[] result = new int[n];

		for (int i = 0; i < n; i++) {
			boolean[] flowers = new boolean[5];
			for (Garden neighbour : gardens[i].ties) {
				flowers[result[neighbour.pos]] = true;
			}

			for (int flower = 1; flower <= 4; flower++) {
				if (!flowers[flower]) {
					// available flower
					result[i] = flower;
				}
			}
		}

		return result;

	}

	public static void main(String[] arg) {

		int[][] paths = { { 1, 2 }, { 2, 3 }, { 3, 1 } };
		Utils.print(gardenNoAdj(3, paths));

		int[][] paths1 = { { 1, 2 }, { 3, 4 } };
		Utils.print(gardenNoAdj(4, paths1));

		int[][] paths2 = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 1 }, { 1, 3 }, { 2, 4 } };
		Utils.print(gardenNoAdj(4, paths2));

	}

}
