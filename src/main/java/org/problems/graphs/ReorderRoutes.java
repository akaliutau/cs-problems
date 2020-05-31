package org.problems.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/
 * 
 * There are n cities numbered from 0 to n-1 and n-1 roads such that there is
 * only one way to travel between two different cities (this network form a
 * tree). Last year, The ministry of transport decided to orient the roads in
 * one direction because they are too narrow.
 * 
 * Roads are represented by connections where connections[i] = [a, b] represents
 * a road from city a to b.
 * 
 * This year, there will be a big event in the capital (city 0), and many people
 * want to travel to this city.
 * 
 * Your task consists of reorienting some roads such that each city can visit
 * the city 0. Return the minimum number of edges changed.
 * 
 * It's guaranteed that each city can reach the city 0 after reorder.
 * 
 */
public class ReorderRoutes {

	static class Node {
		public int town;
		public List<Node> nodes = new ArrayList<>();
		public boolean visited = false;
		public Set<Integer> orig = new HashSet<>();

		public Node(int town) {
			this.town = town;
		}

		@Override
		public String toString() {
			return "Node [town=" + town + "]";
		}

	}

	public static int minReorder(int n, int[][] connections) {
		Node[] nodes = new Node[n];
		for (int[] conn : connections) {
			if (nodes[conn[0]] == null) {
				nodes[conn[0]] = new Node(conn[0]);
			}
			if (nodes[conn[1]] == null) {
				nodes[conn[1]] = new Node(conn[1]);
			}
			nodes[conn[0]].nodes.add(nodes[conn[1]]);
			nodes[conn[0]].orig.add(conn[1]);
			nodes[conn[1]].nodes.add(nodes[conn[0]]);
		}
		Queue<Node> q = new LinkedList<>();
		q.add(nodes[0]);
		int reorders = 0;
		while (!q.isEmpty()) {
			Node cur = q.poll();
			for (Node ref : cur.nodes) {
				if (!ref.visited) {
					q.add(ref);
					if (cur.orig.contains(ref.town)) {
						reorders++;
					}
				}
			}
			cur.visited = true;
		}
		return reorders;
	}

	public static void main(String[] arg) {

		int[][] connections = { { 0, 1 }, { 1, 3 }, { 2, 3 }, { 4, 0 }, { 4, 5 } };

		System.out.println(minReorder(6, connections));

		int[][] connections1 = { { 1, 0 }, { 1, 2 }, { 3, 2 }, { 3, 4 } };

		System.out.println(minReorder(5, connections1));

		int[][] connections2 = { { 1, 0 }, { 2, 0 } };

		System.out.println(minReorder(3, connections2));

	}

}
