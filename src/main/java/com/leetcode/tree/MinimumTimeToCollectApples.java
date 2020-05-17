package com.leetcode.tree;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree
 * 
 * Given an undirected tree consisting of n vertices numbered from 0 to n-1,
 * which has some apples in their vertices. You spend 1 second to walk over one
 * edge of the tree. Return the minimum time in seconds you have to spend in
 * order to collect all apples in the tree starting at vertex 0 and coming back
 * to this vertex.
 * 
 * The edges of the undirected tree are given in the array edges, where edges[i]
 * = [fromi, toi] means that exists an edge connecting the vertices fromi and
 * toi. Additionally, there is a boolean array hasApple, where hasApple[i] =
 * true means that vertex i has an apple, otherwise, it does not have any apple.
 * 
 * Runtime: 31 ms, faster than 100.00% of Java online submissions for Minimum
 * Time to Collect All Apples in a Tree. 
 * Memory Usage: 73.6 MB, less than
 * 100.00% of Java online submissions for Minimum Time to Collect All Apples in
 * a Tree
 */
public class MinimumTimeToCollectApples {

	static int getTime(int[][] edges, List<Boolean> hasApple, int edge, int[] walkmap, int curtime, boolean[] nodes) {
		if (walkmap[edge] == -1) {
			if (hasApple.get(edge)) {
				nodes[edge] = true;
				return edge == 0 ? curtime : curtime + 2;
			}
			return curtime;
		} else {
			int idx = walkmap[edge];
			int initTime = curtime;
			while (idx < edges.length) {
				int[] node = edges[idx];
				if (node[0] != edge) {
					break;
				}
				curtime = getTime(edges, hasApple, node[1], walkmap, curtime, nodes);
				idx++;
			}
			if (curtime != initTime || (hasApple.get(edge) && edge != 0)) {
				if (!nodes[edge]) {
					curtime += 2;
				}
			}
			nodes[edge] = true;

			return curtime;
		}
	}

	public static int minTime(int n, int[][] edges, List<Boolean> hasApple) {
		int total = hasApple.size();
		int[] walkmap = new int[total];// ref to edges array, -1 means leaf
		boolean[] nodes = new boolean[total];
		nodes[0] = true;
		Arrays.fill(walkmap, -1);
		Comparator<int[]> byFirstIdx = (a1, a2) -> Integer.compare(a1[0], a2[0]);
		Arrays.sort(edges, byFirstIdx);
		for (int i = 0; i < edges.length; i++) {
			int[] edge = edges[i];
			if (walkmap[edge[0]] == -1) {
				walkmap[edge[0]] = i;// first time seen
			}
		}
		int time = getTime(edges, hasApple, 0, walkmap, 0, nodes);
		return time == 0 ? 0 : time;
	}

	public static void main(String[] arg) {

		int[][] edges = { { 0, 1 }, { 0, 2 }, { 1, 4 }, { 1, 5 }, { 2, 3 }, { 2, 6 } };
		List<Boolean> hasApple = Arrays.asList(false, false, true, false, true, true, false);
		System.out.println(minTime(7, edges, hasApple));

		int[][] edges2 = { { 0, 1 }, { 0, 2 }, { 1, 4 }, { 1, 5 }, { 2, 3 }, { 2, 6 } };
		List<Boolean> hasApple2 = Arrays.asList(false, false, true, false, false, true, false);
		System.out.println(minTime(7, edges2, hasApple2));

		int[][] edges3 = { { 0, 1 }, { 0, 2 }, { 1, 4 }, { 1, 5 }, { 2, 3 }, { 2, 6 } };
		List<Boolean> hasApple3 = Arrays.asList(false, false, false, false, false, false, false);
		System.out.println(minTime(7, edges3, hasApple3));

		int[][] edges4 = { { 0, 1 }, { 0, 2 }, { 1, 4 }, { 1, 5 }, { 2, 3 }, { 2, 6 } };
		List<Boolean> hasApple4 = Arrays.asList(false, false, true, false, false, false, false);
		System.out.println(minTime(7, edges4, hasApple4));

		int[][] edges5 = { { 0, 1 }, { 1, 2 }, { 0, 3 } };
		List<Boolean> hasApple5 = Arrays.asList(true, true, false, true);
		System.out.println(minTime(4, edges5, hasApple5));

	}

}
