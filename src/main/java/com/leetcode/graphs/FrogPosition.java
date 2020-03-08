package com.leetcode.graphs;

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
 * The frog can not jump back to a visited vertex. In case the frog can jump to
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
 */
public class FrogPosition {

	static class Node {
		public int id;
		public double p = 0.0d;
		public boolean visited = false;
		public List<Node> ties = new ArrayList<>();

		public Node(int id) {
			this.id = id;
		}

		public double prob() {
			int n = 0;
			for (Node node : ties) {
				if (!node.visited) {
					n++;
				}
			}
			return n == 0 ? 1.0d : (double) (1.0d /n);
		}

		@Override
		public String toString() {
			return String.format("[id=%d,p=%f,ties=%d,visited=%s]", id, p, ties.size(),visited);
		}
	}

	public static void calc(Node n, int target, double probability, int step, int limit) {
		if (step > limit) {
			return;
		}
		if (n.id == target || n.visited) {
			n.visited = true;
			return;
		}
		n.visited = true;
		double cProb = probability*n.prob();
		for (Node c : n.ties) {
			c.p = c.p < cProb ? cProb : c.p;
			calc(c, target,cProb, step+1, limit);
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
		calc(root, target, 1.0d,0,t);
		System.out.println(map);

		Node tgt = map.get(target);
		System.out.println("target:"+tgt);
		if (tgt == null) {
			return 0.0;
		}

		return tgt.visited ? tgt.p : 0.0;

	}

	public static void main(String[] arg) {

		int[][] arr = { { 1, 2 }, { 1, 3 }, { 1, 7 }, { 2, 4 }, { 2, 6 }, { 3, 5 } };
		System.out.println(frogPosition(7, arr, 2, 4));//0.16666

		int[][] arr1 = { { 2, 1 }, { 3, 2 }, { 4, 1 }, { 5, 1 }, { 6, 4 }, { 7, 1 }, { 8, 7 } };
		System.out.println(frogPosition(8, arr1, 7, 7));//0 ?? - add steps limit
		
		int[][] arr2 = { { 2, 1 }, { 3, 2 } };
		System.out.println(frogPosition(3, arr2, 1, 2));//1

		int[][] arr3 = { { 1, 2 }, { 1, 3 }, { 1, 7 }, { 2, 4 }, { 2, 6 }, { 3, 5 } };
		System.out.println(frogPosition(3, arr3, 1, 7));//0.33333


	}

}
