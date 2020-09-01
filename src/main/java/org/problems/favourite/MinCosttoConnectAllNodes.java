package org.problems.favourite;

import java.util.Arrays;

/**
 * Min Cost to Connect All Nodes
 * 
 * Given an undirected graph with n nodes labeled 1..n. Some of the nodes are
 * already connected. The i-th edge connects nodes edges[i][0] and edges[i][1]
 * together. Your task is to augment this set of edges with additional edges to
 * connect all the nodes. Find the minimum cost to add new edges between the
 * nodes such that all the nodes are accessible from each other.
 * 
 * Input:
 * 
 * n, an int representing the total number of nodes. 
 * 
 * edges, a list of integer pair representing the nodes already connected by an edge. 
 * 
 * newEdges, a list where each element is a triplet representing the pair of nodes between which
 * an edge can be added and the cost of addition, respectively (e.g. [1, 2, 5]
 * means to add an edge between node 1 and 2, the cost would be 5).
 * 
 * Example 1
 * 
 * Input: n = 6, edges = [[1, 4], [4, 5], [2, 3]], newEdges = [[1, 2, 5], [1, 3,
 * 10], [1, 6, 2], [5, 6, 5]] Output: 7 
 * 
 * Explanation: There are 3 connected
 * components [1, 4, 5], [2, 3] and [6]. We can connect these components into a
 * single component by connecting node 1 to node 2 and node 1 to node 6 at a
 * minimum cost of 5 + 2 = 7.
 * 
 */
public class MinCosttoConnectAllNodes {

	static class Graph {
		int[] nodes;

		public Graph(int n) {
			nodes = new int[n + 1];
			for (int i = 0; i <= n; i++) {
				nodes[i] = i;
			}
		}

		public boolean union(int n1, int n2) {
			int parent1 = find(n1);
			int parent2 = find(n2);
			if (parent1 != parent2) {
				nodes[parent2] = parent1;
				return true;
			}
			return false;
		}

		public int find(int id) {
			if (nodes[id] != id) {
				nodes[id] = find(nodes[id]);
			}
			return nodes[id];
		}

	}

	public static int minCostToConnect(int n, int[][] edges, int[][] newEdges) {
		int connected = n;
		int minCost = 0;

		Graph g = new Graph(n);

		for (int[] edge : edges) {
			if (g.union(edge[0], edge[1])) {
				connected--;
			}
		}
		Arrays.sort(newEdges, (arr1, arr2) -> arr1[2] - arr2[2]);
		for (int[] newEdge : newEdges) {
			if (g.union(newEdge[0], newEdge[1])) {
				minCost += newEdge[2];
				connected--;
			}
			if (connected == 1) {
				return minCost;
			}
		}
		return connected == 1 ? connected : -1;
	}

	public static void main(String[] arg) {
		
		int[][] edges = {
				{1, 4}, {4, 5}, {2, 3}
		};
		
		int[][] newEdges = {
				{1, 2, 5}, {1, 3, 10}, {1, 6, 2}, {5, 6, 5}
		};
		System.out.println(minCostToConnect(6, edges, newEdges));

	
}

}
