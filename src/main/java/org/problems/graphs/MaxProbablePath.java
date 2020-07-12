package org.problems.graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * https://leetcode.com/problems/path-with-maximum-probability/
 * 
 * You are given an undirected weighted graph of n nodes (0-indexed),
 * represented by an edge list where edges[i] = [a, b] is an undirected edge
 * connecting the nodes a and b with a probability of success of traversing that
 * edge succProb[i].
 * 
 * Given two nodes start and end, find the path with the maximum probability of
 * success to go from start to end and return its success probability.
 * 
 * If there is no path from start to end, return 0. Your answer will be accepted
 * if it differs from the correct answer by at most 1e-5
 * 
 * Input: n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.2], start =
 * 0, end = 2 Output: 0.25000 
 * Explanation: There are two paths from start to
 * end, one having a probability of success = 0.2 and the other has 0.5 * 0.5 =
 * 0.25.
 * 
 * 
 * 
 */
public class MaxProbablePath {

	static class Node {
		public Node(int id) {
			super();
			this.id = id;
		}

		public int id;
		public boolean processed = false;
		public Map<Node, Double> paths = new HashMap<>();

		public double best = 0.0d;

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + id;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (id != other.id)
				return false;
			return true;
		}
	}

	public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
		Node[] map = new Node[n];
		for (int i = 0; i < n; i++) {
			map[i] = new Node(i);
		}
		for (int i = 0; i < edges.length; i++) {
			int[] edge = edges[i];
			map[edge[0]].paths.put(map[edge[1]], succProb[i]);
			map[edge[1]].paths.put(map[edge[0]], succProb[i]);
		}
		Queue<Node> q = new LinkedList<>();
		q.add(map[start]);
		map[start].best = 1.0d;
		while (!q.isEmpty()) {
			Node e = q.poll();
			e.processed = true;
			for (Node next : e.paths.keySet()) {
				// important:
				// add to queue only the most probable paths
				// overwise we'd block potentially best path due to processed flag 
				double d = e.best * e.paths.get(next);
				if (d > next.best) {
					q.add(next);
					next.best = d;
				}
			}
		}
		return map[end].best;
	}

	public static void main(String[] arg) {
		System.out.println(true);
	}

}
