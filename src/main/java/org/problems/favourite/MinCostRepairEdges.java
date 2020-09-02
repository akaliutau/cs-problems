package org.problems.favourite;

import java.util.Arrays;

/**
 * Min Cost to Repair Edges
 * 
 * There's an undirected connected graph with n nodes labeled 1..n. But some of
 * the edges has been broken disconnecting the graph. Find the minimum cost to
 * repair the edges so that all the nodes are once again accessible from each
 * other.
 * 
 * Input: n, an int representing the total number of nodes. edges, a list of
 * integer pair representing the nodes connected by an edge. edgesToRepair, a
 * list where each element is a triplet representing the pair of nodes between
 * which an edge is currently broken and the cost of repearing that edge,
 * respectively (e.g. [1, 2, 12] means to repear an edge between nodes 1 and 2,
 * the cost would be 12).
 * 
 * Example 1: Input: n = 5, edges = [[1, 2], [2, 3], [3, 4], [4, 5], [1, 5]],
 * edgesToRepair = [[1, 2, 12], [3, 4, 30], [1, 5, 8]] Output: 20
 * 
 * Explanation: There are 3 connected components due to broken edges: [1], [2,
 * 3] and [4, 5]. We can connect these components into a single component by
 * repearing the edges between nodes 1 and 2, and nodes 1 and 5 at a minimum
 * cost 12 + 8 = 20.
 * 
 * Example 2: Input: n = 6, edges = [[1, 2], [2, 3], [4, 5], [3, 5], [1, 6], [2,
 * 4]], edgesToRepair = [[1, 6, 410], [2, 4, 800]] Output: 410
 * 
 * Example 3: Input: n = 6, edges = [[1, 2], [2, 3], [4, 5], [5, 6], [1, 5], [2,
 * 4], [3, 4]], edgesToRepair = [[1, 5, 110], [2, 4, 84], [3, 4, 79]] Output: 79
 * 
 * 
 * 
 */
public class MinCostRepairEdges {

	static class Union {
		int[] parents;

		public Union(int n) {
			parents = new int[n + 1];
			Arrays.fill(parents, -1);
		}

		public int findParent(int child) {
			int parent = child;
			while (parents[parent] >= 0) {
				parent = parents[parent];
			}
			return parent;
		}

		public void updateParent(int c1, int c2) {
			int p1 = findParent(c1);
			int p2 = findParent(c2);

			parents[p1] = p2;
		}

	}

	public static boolean isBrokenEdge(int[] edge, int[][] edgesToRepair) {
		for (int i = 0; i < edgesToRepair.length; i++) {
			if (edge[0] == edgesToRepair[i][0] && edge[1] == edgesToRepair[i][1])
				return true;
		}
		return false;
	}

	public static int minCostToRepair(int n, int[][] edges, int[][] edgesToRepair) {

		Union u = new Union(n);
		Arrays.sort(edgesToRepair, (o, p) -> o[2] - p[2]);

		// Union Connected edges first
		for (int[] edge : edges) {
			if (!isBrokenEdge(edge, edgesToRepair)) {
				if (u.findParent(edge[0]) != u.findParent(edge[1])) {
					u.updateParent(edge[0], edge[1]);
				}
			}
		}

		int minCost = 0;
		// Union broken edges
		for (int[] repair : edgesToRepair) {
			if (u.findParent(repair[0]) != u.findParent(repair[1])) {
				minCost += repair[2];
				u.updateParent(repair[0], repair[1]);
			}
		}

		return minCost;
	}

	public static void main(String[] args) {
		int[][] edges = new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 1, 5 } };
		int[][] edgesToRepair = new int[][] { { 1, 2, 12 }, { 3, 4, 30 }, { 1, 5, 8 } };
		System.out.println(minCostToRepair(5, edges, edgesToRepair));

		edges = new int[][] { { 1, 2 }, { 2, 3 }, { 4, 5 }, { 3, 5 }, { 1, 6 }, { 2, 4 } };
		edgesToRepair = new int[][] { { 1, 6, 410 }, { 2, 4, 800 } };
		System.out.println(minCostToRepair(6, edges, edgesToRepair));

		edges = new int[][] { { 1, 2 }, { 2, 3 }, { 4, 5 }, { 5, 6 }, { 1, 5 }, { 2, 4 }, { 3, 4 } };
		edgesToRepair = new int[][] { { 1, 5, 110 }, { 2, 4, 84 }, { 3, 4, 79 } };
		System.out.println(minCostToRepair(6, edges, edgesToRepair));

	}

}
