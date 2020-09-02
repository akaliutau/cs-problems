package org.problems.favourite;

import java.util.Arrays;
import java.util.List;

/**
 * Min Cost To Add Paths
 * 
 * There are N nodes numbered from 1 to N.
 * 
 * You are given connections, where each connections[i] = [node1, node2, cost]
 * represents the cost to connect node1 and node2 together. (A connection is
 * bidirectional: connecting node1 and node2 is the same as connecting node2 and
 * node1.)
 * 
 * Return the minimum cost so that for every pair of nodes, there exists a path
 * of connections (possibly of length 1) that connects those two nodes
 * together. The cost is the sum of the connection costs used. If the task is
 * impossible, return -1.
 * 
 * Example 1
 * 
 * Input: N = 3, connections = [[1,2,5],[1,3,6],[2,3,1]] 
 * Output: 6 
 * Explanation:
 * Choosing any 2 edges will connect all nodes so we choose the minimum 2.
 * 
 * Example 2:
 * 
 * Input: N = 4, connections = [[1,2,3],[3,4,4]] 
 * Output: -1 
 * Explanation: There is no way to connect all nodes even if all edges are used. 
 * 
 * Note:
 * 
 * 1 <= N <= 10000 
 * 1 <= connections.length <= 10000 
 * 1 <= connections[i][0], connections[i][1] <= N 
 * 0 <= connections[i][2] <= 10^5 
 * connections[i][0] != connections[i][1]
 * 
 * 
 * Solution: Try to connect nodes with minimum cost, then find small cost edge
 * first, if two nodes connected by the edge do no have same ancestor, then
 * union them. When number of unions equal to 1, all nodes are connected.
 * 
 * 
 */
public class MinCostToAddPaths {
	
	static class Graph {
		int[] nodes;
		
		public Graph (int n) {
	        nodes = new int[n+1];
	        for(int i = 0; i <= n; i++) {
	            nodes[i] = i;
	        }
		}
		
		public boolean union(int n1, int n2) {
	        int parent1 = find(n1);
	        int parent2 = find(n2);
	        if(parent1 != parent2) {
	            nodes[parent2] = parent1;
	            return true;
	        }
	        return false;
	    }
	    
		public int find(int id) {
	        if(nodes[id] != id) {
	            nodes[id] = find(nodes[id]);
	        }
	        return nodes[id];
	    }

	}
	
	
    public static int minCostToConnect(int n, int[][] edges, int[][] newEdges) {
        int connected = n;
        int minCost = 0;
        
        Graph g = new Graph(n);

        for(int[] edge : edges) {
            if(g.union(edge[0], edge[1])) {
                connected --;
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
		
	
		int[][] edges1 = {
				{1,2,5},{1,3,6},{2,3,1}
		};
		
		int[][] newEdges1 = {
				{1, 2, 5}, {1, 3, 10}, {1, 6, 2}, {5, 6, 5}
		};
		System.out.println(minCostToConnect(6, edges1, newEdges1));

		int[][] edges2 = {
				{1, 4}, {4, 5}, {2, 3}
		};
		
		int[][] newEdges2 = {
				{1, 2, 5}, {1, 3, 10}, {1, 6, 2}, {5, 6, 5}
		};
		System.out.println(minCostToConnect(6, edges2, newEdges2));
}

}
