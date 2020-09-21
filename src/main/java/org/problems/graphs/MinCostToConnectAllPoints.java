package org.problems.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/min-cost-to-connect-all-points/
 * 
 * You are given an array points representing integer coordinates of some points
 * on a 2D-plane, where points[i] = [xi, yi].
 * 
 * The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan
 * distance between them: |xi - xj| + |yi - yj|, where |val| denotes the
 * absolute value of val.
 * 
 * Return the minimum cost to make all points connected. All points are
 * connected if there is exactly one simple path between any two points.
 * 
 * Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]] Output: 20
 * 
 * Use Kruskal algorithm
 * 
 *   2
 *  / \
 * 1   3
 * 
 * p[3] -> p[2]
 * 
 * 
 *     2
 *    / 
 *   1
 *  /
 * 3
 * 
 * 
 */
public class MinCostToConnectAllPoints {
	
	static int dist(int[] p1, int[] p2) {
		return Math.abs(p1[0] - p2[0]) +  Math.abs(p1[1] - p2[1]);
	}
	
	static int find(int[] parents, int n1) {
		if (parents[n1] == n1) {
			return n1;
		}
		return find(parents, parents[n1]);
	}
	
	static void union(int[] parents, int p1, int p2) {
		parents[p1] = p2;
	}

	public int minCostConnectPoints(int[][] points) {
		// pair = [i,j]
		List<int[]> pairs = new ArrayList<>();
		int n = points.length;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				pairs.add(new int[] {i, j});// connection p_i -> p_j, [0,1]
			}			
		}
		Collections.sort(pairs, (o,p) -> Integer.compare(dist(points[o[0]], points[o[1]]), dist(points[p[0]], points[p[1]])));
		int[] parents = new int[n];
		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}
		int cost = 0;
		for (int[] pair : pairs) {
			int n1 = pair[0];
			int n2 = pair[1];
			int p1 = find(parents, n1);
			int p2 = find(parents, n2);
			if (p1 != p2) {
				union(parents, p1, p2);
				cost += dist(points[n1], points[n2]);
			}
		}
		
		return cost;

	}

	public static void main(String[] arg) {
		System.out.println(true);
	}

}
