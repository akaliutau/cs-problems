package org.problems.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/frog-position-after-t-seconds/
 * 
 * Given an undirected tree consisting of n vertices numbered from 1 to n. A
 * frog starts jumping from the vertex 1. In one second, the frog jumps from its
 * current vertex to another unvisited vertex if they are directly connected.
 * The frog can not jump back to a completed vertex. In case the frog can jump to
 * several vertices it jumps randomly to one of them with the same probability,
 * otherwise, when the frog can not jump to any unvisited vertex it jumps
 * forever on the same vertex.
 * 
 * The edges of the undirected tree are given in the array edges, where edges[i]
 * = [fromi, toi] means that exists an edge connecting directly the vertices
 * fromi and toi.
 * 
 * Return the probability that after t seconds the frog is on the vertex target.
 * 
 * Runtime: 14 ms, faster than 33.33% of Java online submissions for Frog Position After T Seconds.
 * Memory Usage: 46.4 MB, less than 100.00% of Java online submissions for Frog Position After T Seconds.
 * 
 */
public class FrogPosition {

	static class Node {
		public int id;
		public double p = 0.0d;
		public boolean visited = false;
		public int time = 0;
		public List<Node> ties = new ArrayList<>();

		public Node(int id) {
			this.id = id;
		}

		public double prob() {
			int n = unvisitedNodes();
			return n == 0 ? 1.0d : (double) (1.0d / n);
		}

		public int unvisitedNodes() {
			int n = 0;
			for (Node node : ties) {
				if (!node.visited) {
					n++;
				}
			}
			return n;
		}

		@Override
		public String toString() {
			return String.format("[id=%d,p=%f,ties=%d,completed=%s, time =%d]", id, p, ties.size(), visited, time);
		}
	}

	public static void calc(Node n, int target, double probability, int step, int limit) {
//		System.out.println("visiting:" + n.id +" at "+step);
		if (step > limit) {
			n.time = step;
			return;
		}
		if (n.id == target || n.visited) {
			n.visited = true;
			n.time = step;
			return;
		}
		n.visited = true;
		n.time = step;
		double cProb = probability * n.prob();
		for (Node c : n.ties) {
			c.p = c.p < cProb ? cProb : c.p;
			calc(c, target, cProb, step + 1, limit);
			c.visited = true;
		}
	}

	public static double frogPosition(int n, int[][] edges, int t, int target) {

		Node root = new Node(1);
		Map<Integer, Node> map = new HashMap<>();
		map.put(1, root);
		for (int[] edge : edges) {
			if (!map.containsKey(edge[0])) {
				map.put(edge[0], new Node(edge[0]));
			}
			if (!map.containsKey(edge[1])) {
				map.put(edge[1], new Node(edge[1]));
			}
			map.get(edge[0]).ties.add(map.get(edge[1]));
			map.get(edge[1]).ties.add(map.get(edge[0]));
		}
		calc(root, target, 1.0d, 0, t);
		System.out.println(map);

		Node tgt = map.get(target);
		System.out.println("target:" + tgt);
		if (tgt == null) {
			return 0.0;
		}
		double result = 0.0d;
		if (tgt.visited) {
			if (tgt.time == t) {
				result = tgt.p;
			} else if (tgt.time < t && tgt.unvisitedNodes() == 0) {
				result = tgt.p;
			}

		}
		if (map.size() == 1) {
			if (tgt.visited) {
				result = 1.0;
			}
		}

		return result;

	}

	public static void main(String[] arg) {

		int[][] arr = { { 1, 2 }, { 1, 3 }, { 1, 7 }, { 2, 4 }, { 2, 6 }, { 3, 5 } };
		System.out.println(frogPosition(7, arr, 2, 4));// 0.16666

		int[][] arr1 = { { 2, 1 }, { 3, 2 }, { 4, 1 }, { 5, 1 }, { 6, 4 }, { 7, 1 }, { 8, 7 } };
		System.out.println(frogPosition(8, arr1, 7, 7));// 0 ?? - add steps limit

		int[][] arr2 = { { 2, 1 }, { 3, 2 } };
		System.out.println(frogPosition(3, arr2, 1, 2));// 1

		int[][] arr3 = { { 1, 2 }, { 1, 3 }, { 1, 7 }, { 2, 4 }, { 2, 6 }, { 3, 5 } };
		System.out.println(frogPosition(3, arr3, 1, 7));// 0.33333

		int[][] arr4 = {};
		System.out.println(frogPosition(1, arr4, 1, 1));// 1

		int[][] arr5 = { { 2, 1 }, { 3, 2 }, { 4, 2 }, { 5, 1 }, { 6, 2 }, { 7, 2 }, { 8, 3 }, { 9, 8 }, { 10, 6 },
				{ 11, 10 }, { 12, 1 }, { 13, 1 }, { 14, 12 }, { 15, 8 }, { 16, 3 }, { 17, 15 }, { 18, 16 }, { 19, 17 },
				{ 20, 7 }, { 21, 9 }, { 22, 9 }, { 23, 20 }, { 24, 5 }, { 25, 10 }, { 26, 4 }, { 27, 11 }, { 28, 8 },
				{ 29, 11 }, { 30, 11 }, { 31, 7 }, { 32, 25 }, { 33, 8 }, { 34, 27 }, { 35, 14 }, { 36, 27 }, { 37, 9 },
				{ 38, 33 }, { 39, 35 }, { 40, 6 }, { 41, 25 }, { 42, 2 }, { 43, 25 }, { 44, 9 }, { 45, 26 }, { 46, 23 },
				{ 47, 40 }, { 48, 34 }, { 49, 26 }, { 50, 39 }, { 51, 10 }, { 52, 47 }, { 53, 43 }, { 54, 6 },
				{ 55, 49 }, { 56, 44 }, { 57, 34 }, { 58, 15 }, { 59, 49 }, { 60, 13 }, { 61, 32 }, { 62, 31 },
				{ 63, 25 }, { 64, 50 }, { 65, 41 }, { 66, 33 }, { 67, 2 }, { 68, 34 }, { 69, 4 }, { 70, 49 },
				{ 71, 67 }, { 72, 51 }, { 73, 19 }, { 74, 22 }, { 75, 34 }, { 76, 13 }, { 77, 53 }, { 78, 15 },
				{ 79, 62 }, { 80, 52 }, { 81, 7 }, { 82, 63 } };
		System.out.println(frogPosition(82, arr5, 6, 73));// 1

	}

}
