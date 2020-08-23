package org.problems.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/
 * 
 * Given a directed acyclic graph, with n vertices numbered from 0 to n-1, and
 * an array edges where edges[i] = [fromi, toi] represents a directed edge from
 * node fromi to node toi.
 * 
 * Find the smallest set of vertices from which all nodes in the graph are
 * reachable. It's guaranteed that a unique solution exists.
 * 
 * Notice that you can return the vertices in any order.
 * 
 * 
 * Input: n = 6, edges = [[0,1],[0,2],[2,5],[3,4],[4,2]] Output: [0,3]
 * Explanation: It's not possible to reach all the nodes from a single vertex.
 * From 0 we can reach [0,1,2,5]. From 3 we can reach [3,4,2,5]. So we output
 * [0,3].
 */
public class VerticesReachAllNodes {

	public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
		Set<Integer> srcs = new HashSet<>();
		Set<Integer> ref = new HashSet<>();
		for (List<Integer> edge : edges) {
			ref.add(edge.get(1));
			srcs.add(edge.get(0));
		}
		List<Integer> ans = new ArrayList<>();
		for (Integer source : srcs) {
			if (!ref.contains(source)) {
				ans.add(source);
			}
		}
		return ans;
	}

	public static void main(String[] arg) {
		System.out.println(true);
	}

}
